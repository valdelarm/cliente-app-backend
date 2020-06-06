package br.com.martins.valdelar.clienteapp.config.security;

import br.com.martins.valdelar.clienteapp.respository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class CustomUserDetailsService implements UserDetailsService {

    @Autowired
    private UserRepository userRepository;

    @Override
    @Transactional
    public UserDetails loadUserByUsername(String userName) throws UsernameNotFoundException {
        return UserPrincipal.create(userRepository.findByUserName(userName)
                .orElseThrow(() ->
                new UsernameNotFoundException("Usuário não encontrado com o usuario: " + userName)));
    }

    @Transactional
    public UserDetails loadUserById(Long id) {
        return UserPrincipal.create(userRepository.findById(id)
                .orElseThrow(
                () -> new UsernameNotFoundException("Usuário não encontrado com o ID: " + id)
        ));
    }
}

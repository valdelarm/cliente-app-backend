package br.com.martins.valdelar.clienteapp.service;

import br.com.martins.valdelar.clienteapp.dto.ClienteDto;
import br.com.martins.valdelar.clienteapp.model.Cliente;
import br.com.martins.valdelar.clienteapp.respository.ClienteRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.persistence.NoResultException;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
@Slf4j
public class ClienteService {

    @Autowired
    private ClienteRepository clienteRepository;


    public Cliente saveCliente(ClienteDto dto) {
        log.info("Saving the cliente " + dto);
        return clienteRepository.save(dto.toModel());
    }

    public List<ClienteDto> getAllClientes() {
        log.info("Getting all clientes");
        return listEntityToDto(clienteRepository.findAll());
    }

    public Cliente updateCliente(ClienteDto dto, Long id) {
        Optional<Cliente> entity = clienteRepository.findById(id);

        if (entity.isPresent()) {
            log.info("Updating the cliente " + entity.get());
            Cliente cliente = dto.toModel();
            cliente.setId(entity.get().getId());

            return clienteRepository.save(cliente);
        }

        throw new NoResultException("Não foi encontrado cliente");
    }

    public void deleteClienteById(Long id) {
        log.info("Deleting the cliente id " + id);
        clienteRepository.deleteById(id);
    }

    private List<ClienteDto> listEntityToDto(List<Cliente> entities) {
        List<ClienteDto> dtoList = new ArrayList<>();
        for (Cliente e : entities) {
            dtoList.add(ClienteDto.toDto(e));
        }

        return dtoList;
    }
}

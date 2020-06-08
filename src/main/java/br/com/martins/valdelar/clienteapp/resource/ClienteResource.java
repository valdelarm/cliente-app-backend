package br.com.martins.valdelar.clienteapp.resource;

import br.com.martins.valdelar.clienteapp.dto.ApiResponse;
import br.com.martins.valdelar.clienteapp.dto.ClienteDto;
import br.com.martins.valdelar.clienteapp.model.Cliente;
import br.com.martins.valdelar.clienteapp.service.ClienteService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import javax.validation.Valid;
import java.net.URI;

@RestController
@RequestMapping("api/v1/clientes")
@Slf4j
public class ClienteResource {

    @Autowired
    private ClienteService clienteService;

    @GetMapping
    public ResponseEntity<?> getClients() {
       return ResponseEntity.ok().body(clienteService.getAllClientes());
    }

    @PostMapping
    @PreAuthorize("hasRole('ADMIN')")
    public ResponseEntity<?> addClient(@Valid @RequestBody ClienteDto request) {
        log.info("Request " + request);
        Cliente cliente = clienteService.saveCliente(request);

        URI location = ServletUriComponentsBuilder
                .fromCurrentRequest().path("/{id}")
                .buildAndExpand(cliente.getId()).toUri();

        return ResponseEntity.created(location).body(new ApiResponse(true, "Cliente criado com sucesso"));
    }

    @PutMapping("/{id}")
    @PreAuthorize("hasRole('ADMIN')")
    public ResponseEntity<?> updateClient(@PathVariable("id") Long id, @Valid @RequestBody ClienteDto request) {
        System.out.println("update ID " + id);

        try {
            clienteService.updateCliente(request, id);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(e);
        }

        return ResponseEntity.ok().build();
    }

    @DeleteMapping("/{id}")
    @PreAuthorize("hasRole('ADMIN')")
    public ResponseEntity<?> deleteClient(@PathVariable("id") Long id) {

        System.out.println("delete ID " + id);

        clienteService.deleteClienteById(id);
        return ResponseEntity.ok().build();
    }
}

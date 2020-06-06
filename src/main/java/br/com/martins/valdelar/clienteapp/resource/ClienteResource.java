package br.com.martins.valdelar.clienteapp.resource;

import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("api/v1/")
public class ClienteResource {

    @GetMapping
    public void getClients() {

    }

    @PostMapping
    public void addClient() {

    }

    @PutMapping("{id}")
    public void updateClient(@PathVariable("id") Long id) {
        System.out.println("update ID " + id);
    }

    @DeleteMapping("{id}")
    public void deleteClient(@PathVariable("id") Long id) {
        System.out.println("delete ID " + id);
    }
}

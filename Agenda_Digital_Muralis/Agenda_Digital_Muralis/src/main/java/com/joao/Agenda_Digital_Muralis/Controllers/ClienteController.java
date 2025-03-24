package com.joao.Agenda_Digital_Muralis.Controllers;

import com.joao.Agenda_Digital_Muralis.DTO.RegisterClienteDTO;
import com.joao.Agenda_Digital_Muralis.Domain.Cliente;
import com.joao.Agenda_Digital_Muralis.Repositories.ClienteRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.text.ParseException;
import java.util.Optional;

@RestController
@RequestMapping("/cliente")
public class ClienteController {

    @Autowired
    ClienteRepository clienteRepository;

    @PostMapping
    public ResponseEntity createCliente(@RequestBody RegisterClienteDTO dados) throws ParseException {
        Cliente newCliente = new Cliente(dados);
        clienteRepository.save(newCliente);
        return ResponseEntity.ok(dados);
    }

    @GetMapping
    public ResponseEntity getAllClientes() {
        var allClientes = clienteRepository.findAll();
        return ResponseEntity.ok(allClientes);
    }

    @DeleteMapping("/{id}")
    @Transactional
    public ResponseEntity deleteCliente(@PathVariable int id) {
        Optional<Cliente> optionalCliente = clienteRepository.findById(id);

        if (optionalCliente.isPresent()) {
            Cliente cliente = optionalCliente.get();
            clienteRepository.delete(cliente);

            return  ResponseEntity.noContent().build();
        }
        System.out.println("Cliente não encontrado");
        return  ResponseEntity.badRequest().body("Cliente não encontrado");
    }
}

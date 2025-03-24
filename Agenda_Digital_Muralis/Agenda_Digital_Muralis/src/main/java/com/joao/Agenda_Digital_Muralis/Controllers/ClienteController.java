package com.joao.Agenda_Digital_Muralis.Controllers;

import com.joao.Agenda_Digital_Muralis.DTO.ClienteDTO;
import com.joao.Agenda_Digital_Muralis.Domain.Cliente;
import com.joao.Agenda_Digital_Muralis.Repositories.ClienteRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Optional;

@RestController
@RequestMapping("/cliente")
public class ClienteController {

    @Autowired
    ClienteRepository clienteRepository;

    @PostMapping
    public ResponseEntity createCliente(@RequestBody ClienteDTO dados) throws ParseException {
        Cliente newCliente = new Cliente(dados);
        clienteRepository.save(newCliente);
        return ResponseEntity.ok(dados);
    }

    @GetMapping
    public ResponseEntity getAllClientes() {
        var allClientes = clienteRepository.findAll();
        return ResponseEntity.ok(allClientes);
    }

    @GetMapping("/{id}")
    @Transactional
    public ResponseEntity getONECliente(@PathVariable int id) {
        Optional<Cliente> optionalCliente = clienteRepository.findById(id);

        if (optionalCliente.isPresent()) {
            Cliente cliente = optionalCliente.get();

            return ResponseEntity.ok(cliente);
        }
        return ResponseEntity.badRequest().body("Cliente não encontrado");
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
        return  ResponseEntity.badRequest().body("Cliente não encontrado");
    }

    @PutMapping("/{id}")
    @Transactional
    public ResponseEntity updateCliente(@PathVariable int id, @RequestBody ClienteDTO dados) throws ParseException {
        Optional<Cliente> optionalCliente = clienteRepository.findById(id);

        if (optionalCliente.isPresent()) {
            Cliente cliente = optionalCliente.get();

            SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");

            cliente.setCpf(dados.cpf());
            cliente.setNome(dados.nome());
            cliente.setDt_nascimento(format.parse(dados.dt_nascimento()));

            clienteRepository.save(cliente);
            return ResponseEntity.ok(cliente);
        }
        return  ResponseEntity.badRequest().body("Cliente não encontrado");
    }
}

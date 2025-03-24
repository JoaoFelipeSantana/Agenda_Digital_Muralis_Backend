package com.joao.Agenda_Digital_Muralis.Controllers;

import com.joao.Agenda_Digital_Muralis.DTO.ClienteDTO;
import com.joao.Agenda_Digital_Muralis.Domain.Cliente;
import com.joao.Agenda_Digital_Muralis.Service.ClienteService;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/cliente")
public class ClienteController {

    @Autowired
    ClienteService clienteService;

    @PostMapping
    @Transactional
    public ResponseEntity<Cliente> createCliente(@RequestBody ClienteDTO dados) throws ParseException {
        return ResponseEntity.ok(clienteService.registrarCliente(dados));
    }

    @GetMapping
    public ResponseEntity<List<Cliente>> getAllClientes() {
        return ResponseEntity.ok(clienteService.listarTodos());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Cliente> getONECliente(@PathVariable int id) {
        return ResponseEntity.ok(clienteService.buscarPorId(id));
    }

    @GetMapping("/buscar")
    public ResponseEntity<Cliente> getByNomeIdCliente(@RequestParam(required = false) String nome,
                                                      @RequestParam(required = false) String cpf) {
        if (nome != null) {
            return ResponseEntity.ok(clienteService.buscarPorNome(nome));
        } else if (cpf != null) {
            return ResponseEntity.ok(clienteService.buscarPorCpf(cpf));
        }
        return ResponseEntity.badRequest().build();
    }

    @DeleteMapping("/{id}")
    @Transactional
    public ResponseEntity deleteCliente(@PathVariable int id) {
        clienteService.deletar(id);
        return ResponseEntity.ok().build();
    }

    @PutMapping("/{id}")
    @Transactional
    public ResponseEntity<Cliente> updateCliente(@PathVariable int id, @RequestBody ClienteDTO dados) throws ParseException {
        return  ResponseEntity.ok(clienteService.atualizarCliente(id, dados));
    }
}

package com.joao.Agenda_Digital_Muralis.Controllers;

import com.joao.Agenda_Digital_Muralis.DTO.RegisterClienteDTO;
import com.joao.Agenda_Digital_Muralis.Domain.Cliente;
import com.joao.Agenda_Digital_Muralis.Repositories.ClienteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.text.ParseException;

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
}

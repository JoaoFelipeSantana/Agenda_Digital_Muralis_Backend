package com.joao.Agenda_Digital_Muralis.Controllers;

import com.joao.Agenda_Digital_Muralis.DTO.ContatoDTO;
import com.joao.Agenda_Digital_Muralis.Domain.Contato;
import com.joao.Agenda_Digital_Muralis.Service.ContatoService;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/contato")
public class ContatoController {

    @Autowired
    ContatoService contatoService;

    @PostMapping
    @Transactional
    public ResponseEntity createContato(@RequestBody ContatoDTO contatoDTO){
        return ResponseEntity.ok(contatoService.registrarContato(contatoDTO));
    }

    @GetMapping("/{id}")
    public ResponseEntity<List<Contato>> getAllContatos(@PathVariable int id) {
        return ResponseEntity.ok(contatoService.listar(id));
    }

}

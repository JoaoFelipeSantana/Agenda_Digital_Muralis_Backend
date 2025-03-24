package com.joao.Agenda_Digital_Muralis.Repositories;

import com.joao.Agenda_Digital_Muralis.Domain.Cliente;
import com.joao.Agenda_Digital_Muralis.Domain.Contato;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ContatoRepository extends JpaRepository <Contato, Integer> {
    List<Contato> findByCliente(Cliente cliente);
}

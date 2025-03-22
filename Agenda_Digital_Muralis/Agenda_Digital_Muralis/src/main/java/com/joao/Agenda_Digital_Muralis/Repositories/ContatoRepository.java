package com.joao.Agenda_Digital_Muralis.Repositories;

import com.joao.Agenda_Digital_Muralis.Domain.Contato;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ContatoRepository extends JpaRepository <Contato, Integer> {
}

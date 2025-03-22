package com.joao.Agenda_Digital_Muralis.Repositories;

import com.joao.Agenda_Digital_Muralis.Domain.Endereco;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EnderecoRepository extends JpaRepository <Endereco, Integer> {
}

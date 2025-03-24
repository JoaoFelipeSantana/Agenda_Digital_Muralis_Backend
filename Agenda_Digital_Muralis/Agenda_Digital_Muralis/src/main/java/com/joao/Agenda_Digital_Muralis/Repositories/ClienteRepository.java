package com.joao.Agenda_Digital_Muralis.Repositories;

import com.joao.Agenda_Digital_Muralis.Domain.Cliente;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ClienteRepository extends JpaRepository<Cliente, Integer> {
    Cliente findByNome(String nome);
    Cliente findByCpf(String cpf);
}

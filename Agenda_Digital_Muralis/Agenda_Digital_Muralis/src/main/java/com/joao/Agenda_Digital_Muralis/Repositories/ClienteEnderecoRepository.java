package com.joao.Agenda_Digital_Muralis.Repositories;

import com.joao.Agenda_Digital_Muralis.Domain.Cliente;
import com.joao.Agenda_Digital_Muralis.Domain.ClienteEndereco;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface ClienteEnderecoRepository extends JpaRepository<ClienteEndereco, Integer> {
    Optional<ClienteEndereco> findByCliente(Cliente cliente);
}

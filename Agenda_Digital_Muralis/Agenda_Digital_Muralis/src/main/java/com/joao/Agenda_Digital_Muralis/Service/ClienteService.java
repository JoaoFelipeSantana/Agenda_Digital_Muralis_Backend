package com.joao.Agenda_Digital_Muralis.Service;

import com.joao.Agenda_Digital_Muralis.DTO.ClienteDTO;
import com.joao.Agenda_Digital_Muralis.Domain.Cliente;
import com.joao.Agenda_Digital_Muralis.Repositories.ClienteRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.List;

@Service
public class ClienteService {

    @Autowired
    ClienteRepository clienteRepository;

    public List<Cliente> listarTodos() {
        return clienteRepository.findAll();
    }

    public Cliente buscarPorId(int id_cliente) {
        return clienteRepository.findById(id_cliente)
                .orElseThrow(() -> new RuntimeException("Cliente não encontrado"));
    }

    @Transactional
    public Cliente registrarCliente(ClienteDTO clienteDTO) throws ParseException {
        Cliente newCliente = new Cliente(clienteDTO);

        return clienteRepository.save(newCliente);
    }

    @Transactional
    public Cliente atualizarCliente(int id_cliente, ClienteDTO clienteDTO) throws ParseException {
        Cliente cliente = buscarPorId(id_cliente);

        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");

        cliente.setNome(clienteDTO.nome());
        cliente.setCpf(clienteDTO.cpf());
        cliente.setDt_nascimento(format.parse(clienteDTO.dt_nascimento()));
        return clienteRepository.save(cliente);
    }

    @Transactional
    public void deletar(int id_cliente) {
        Cliente cliente = buscarPorId(id_cliente);
        clienteRepository.delete(cliente);
    }
}

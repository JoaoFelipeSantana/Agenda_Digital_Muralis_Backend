package com.joao.Agenda_Digital_Muralis.Service;

import com.joao.Agenda_Digital_Muralis.DTO.ContatoDTO;
import com.joao.Agenda_Digital_Muralis.Domain.Cliente;
import com.joao.Agenda_Digital_Muralis.Domain.Contato;
import com.joao.Agenda_Digital_Muralis.Repositories.ClienteRepository;
import com.joao.Agenda_Digital_Muralis.Repositories.ContatoRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ContatoService {

    @Autowired
    ContatoRepository contatoRepository;

    @Autowired
    ClienteService clienteService;

    @Transactional
    public Contato registrarContato(ContatoDTO contatoDTO) {
        Cliente cliente = clienteService.buscarPorId(contatoDTO.id_cliente());

        Contato contato = new Contato();
        contato.setCliente(cliente);
        contato.setTipo(contatoDTO.tipo());
        contato.setValor(contatoDTO.valor());
        contato.setObservacao(contatoDTO.observacao());

        return contatoRepository.save(contato);
    }

    public List<Contato> listar(int id_cliente) {
        Cliente cliente = clienteService.buscarPorId(id_cliente);

        return contatoRepository.findByCliente(cliente);
    }

    @Transactional
    public Contato editarContato(int id, ContatoDTO contatoDTO) {
        Contato contato = contatoRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Contato não encontrado"));

        Cliente cliente = clienteService.buscarPorId(contatoDTO.id_cliente());

        contato.setCliente(cliente);
        contato.setTipo(contatoDTO.tipo());
        contato.setValor(contatoDTO.valor());
        contato.setObservacao(contatoDTO.observacao());

        return contatoRepository.save(contato);
    }

    @Transactional
    public void deletarContato(int id) {
        Contato contato = contatoRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Contato não encontrado"));

        contatoRepository.delete(contato);
    }
}

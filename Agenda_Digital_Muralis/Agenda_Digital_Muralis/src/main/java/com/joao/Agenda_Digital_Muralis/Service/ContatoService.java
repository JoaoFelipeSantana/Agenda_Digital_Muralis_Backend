package com.joao.Agenda_Digital_Muralis.Service;

import com.joao.Agenda_Digital_Muralis.DTO.ContatoDTO;
import com.joao.Agenda_Digital_Muralis.Domain.Cliente;
import com.joao.Agenda_Digital_Muralis.Domain.Contato;
import com.joao.Agenda_Digital_Muralis.Repositories.ClienteRepository;
import com.joao.Agenda_Digital_Muralis.Repositories.ContatoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ContatoService {

    @Autowired
    ContatoRepository contatoRepository;

    @Autowired
    ClienteRepository clienteRepository;

    public Contato registrarContato(ContatoDTO contatoDTO) {
        Cliente cliente = clienteRepository.findById(contatoDTO.id_cliente())
                .orElseThrow(() -> new RuntimeException("Cliente não encontrado"));

        Contato contato = new Contato();
        contato.setCliente(cliente);
        contato.setTipo(contatoDTO.tipo());
        contato.setValor(contatoDTO.valor());
        contato.setObservacao(contatoDTO.observacao());

        return contatoRepository.save(contato);
    }
}

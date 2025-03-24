package com.joao.Agenda_Digital_Muralis.Service;

import com.joao.Agenda_Digital_Muralis.DTO.ClienteDTO;
import com.joao.Agenda_Digital_Muralis.DTO.ClienteRegisterDTO;
import com.joao.Agenda_Digital_Muralis.Domain.Cliente;
import com.joao.Agenda_Digital_Muralis.Domain.ClienteEndereco;
import com.joao.Agenda_Digital_Muralis.Domain.Endereco;
import com.joao.Agenda_Digital_Muralis.Repositories.ClienteEnderecoRepository;
import com.joao.Agenda_Digital_Muralis.Repositories.ClienteRepository;
import com.joao.Agenda_Digital_Muralis.Repositories.EnderecoRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

@Service
public class ClienteService {

    @Autowired
    ClienteRepository clienteRepository;

    @Autowired
    EnderecoRepository enderecoRepository;

    @Autowired
    ViaCepService viaCepService;

    @Autowired
    ClienteEnderecoRepository clienteEnderecoRepository;

    public List<Cliente> listarTodos() {
        return clienteRepository.findAll();
    }

    public Cliente buscarPorId(int id_cliente) {
        return clienteRepository.findById(id_cliente)
                .orElseThrow(() -> new RuntimeException("Cliente não encontrado"));
    }

    @Transactional
    public Cliente registrarCliente(ClienteRegisterDTO clienteRegisterDTO) throws ParseException {
        validarDataNascimento(clienteRegisterDTO.dt_nascimento());

        Cliente cliente = new Cliente();
        cliente.setNome(clienteRegisterDTO.nome());
        cliente.setCpf(clienteRegisterDTO.cpf());

        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
        cliente.setDt_nascimento(format.parse(clienteRegisterDTO.dt_nascimento()));

        clienteRepository.save(cliente);

        if (!clienteRegisterDTO.cep().isEmpty()) {
            Endereco endereco = enderecoRepository.findByCep(clienteRegisterDTO.cep())
                    .orElseGet(() -> {
                        Endereco novoEndereco = viaCepService.buscarEndereco(clienteRegisterDTO.cep());
                        return enderecoRepository.save(novoEndereco);
                    });

            ClienteEndereco relacao = new ClienteEndereco();
            relacao.setCliente(cliente);
            relacao.setEndereco(endereco);
            relacao.setNumero(clienteRegisterDTO.numeroResidencia());
            clienteEnderecoRepository.save(relacao);
        }
        return cliente;
    }

    @Transactional
    public Cliente atualizarCliente(int id_cliente, ClienteRegisterDTO clienteRegisterDTO) throws ParseException {
        Cliente cliente = buscarPorId(id_cliente);
        validarDataNascimento(clienteRegisterDTO.dt_nascimento());

        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");

        cliente.setNome(clienteRegisterDTO.nome());
        cliente.setCpf(clienteRegisterDTO.cpf());
        cliente.setDt_nascimento(format.parse(clienteRegisterDTO.dt_nascimento()));

        clienteRepository.save(cliente);

        if (!clienteRegisterDTO.cep().isEmpty()) {
            Endereco endereco = enderecoRepository.findByCep(clienteRegisterDTO.cep())
                    .orElseGet(() -> {
                        Endereco novoEndereco = viaCepService.buscarEndereco(clienteRegisterDTO.cep());
                        return enderecoRepository.save(novoEndereco);
                    });

            Optional<ClienteEndereco> relacao = clienteEnderecoRepository.findByCliente(cliente);

            if (relacao.isEmpty()) {
                ClienteEndereco novaRelacao = new ClienteEndereco();
                novaRelacao.setCliente(cliente);
                novaRelacao.setEndereco(endereco);
                novaRelacao.setNumero(clienteRegisterDTO.numeroResidencia());
                clienteEnderecoRepository.save(novaRelacao);
            }
            else {
                ClienteEndereco clienteEndereco = relacao.get();

                clienteEndereco.setEndereco(endereco);
                clienteEndereco.setNumero(clienteRegisterDTO.numeroResidencia());
                clienteEnderecoRepository.save(clienteEndereco);
            }
        }
        return cliente;
    }

    @Transactional
    public void deletar(int id_cliente) {
        Cliente cliente = buscarPorId(id_cliente);
        clienteRepository.delete(cliente);
    }

    public Cliente buscarPorNome(String nome) {
        return clienteRepository.findByNome(nome);
    }

    public Cliente buscarPorCpf(String cpf) {
        return clienteRepository.findByCpf(cpf);
    }

    private void validarDataNascimento(String dt_nascimento) {
        LocalDate dataNascimento = LocalDate.parse(dt_nascimento);

        LocalDate dataAtual = LocalDate.now();

        if(dataNascimento.isAfter(dataAtual)) {
            throw new RuntimeException("Data de Nascimento inválida");
        }
    }
}

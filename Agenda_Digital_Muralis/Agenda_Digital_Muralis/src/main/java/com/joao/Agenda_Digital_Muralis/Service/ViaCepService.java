package com.joao.Agenda_Digital_Muralis.Service;

import com.joao.Agenda_Digital_Muralis.DTO.ViaCepDTO;
import com.joao.Agenda_Digital_Muralis.Domain.Endereco;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class ViaCepService {

    public Endereco buscarEndereco(String cep) {
        RestTemplate restTemplate = new RestTemplate();
        String url = "https://viacep.com.br/ws/" + cep + "/json/";
        ViaCepDTO viaCepResponse = restTemplate.getForObject(url, ViaCepDTO.class);

        if (viaCepResponse == null || viaCepResponse.cep() == null) {
            throw new RuntimeException("CEP inválido");
        }

        System.out.println(viaCepResponse.logradouro());

        Endereco endereco = new Endereco();
        endereco.setCep(viaCepResponse.cep());
        endereco.setLogadouro(viaCepResponse.logradouro());
        endereco.setBairro(viaCepResponse.bairro());
        endereco.setCidade(viaCepResponse.localidade());
        endereco.setEstado(viaCepResponse.uf());

        return endereco;
    }
}

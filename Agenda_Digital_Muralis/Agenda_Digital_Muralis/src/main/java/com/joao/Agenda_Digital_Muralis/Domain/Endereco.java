package com.joao.Agenda_Digital_Muralis.Domain;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name="endereco")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Endereco {

    @Id
    private int idEndereco;
    private String cep;
    private String logadouro;
    private String bairro;
    private String cidade;
    private String estado;
    private String pais;
}

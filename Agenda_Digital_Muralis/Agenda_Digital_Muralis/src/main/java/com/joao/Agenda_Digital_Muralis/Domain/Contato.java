package com.joao.Agenda_Digital_Muralis.Domain;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name="contato")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor

public class Contato {

    @Id
    private int idContato;
    private int idCliente;
    private String tipo;
    private String valor;
    private String obervacao;
}

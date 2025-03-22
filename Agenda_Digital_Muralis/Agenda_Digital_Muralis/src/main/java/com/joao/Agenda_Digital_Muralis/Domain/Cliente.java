package com.joao.Agenda_Digital_Muralis.Domain;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Date;

@Table(name="cliente")
@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor

public class Cliente {

    @Id
    private int id;
    private String nome;
    private String cpf;
    private Date dt_nascimento;

}

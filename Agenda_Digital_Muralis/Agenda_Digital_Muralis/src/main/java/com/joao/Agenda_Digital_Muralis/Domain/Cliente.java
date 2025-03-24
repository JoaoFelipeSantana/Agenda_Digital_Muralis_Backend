package com.joao.Agenda_Digital_Muralis.Domain;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.joao.Agenda_Digital_Muralis.DTO.ClienteDTO;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

@Table(name="cliente")
@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor

public class Cliente {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="id_cliente")
    private int id_cliente;
    private String nome;
    private String cpf;

    @JsonFormat(pattern = "yyyy-MM-dd")
    private Date dt_nascimento;

    public Cliente(ClienteDTO data) throws ParseException {
        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");

        this.nome = data.nome();
        this.cpf = data.cpf();
        this.dt_nascimento = format.parse(data.dt_nascimento());
    }

}

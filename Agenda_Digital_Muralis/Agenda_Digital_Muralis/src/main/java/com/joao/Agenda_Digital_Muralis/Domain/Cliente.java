package com.joao.Agenda_Digital_Muralis.Domain;

import com.joao.Agenda_Digital_Muralis.DTO.RegisterClienteDTO;
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

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int idCliente;
    private String nome;
    private String cpf;
    private Date dt_nascimento;

    public Cliente(RegisterClienteDTO data) throws ParseException {
        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");

        this.nome = data.nome();
        this.cpf = data.cpf();
        this.dt_nascimento = format.parse(data.dt_nascimento());
    }

}

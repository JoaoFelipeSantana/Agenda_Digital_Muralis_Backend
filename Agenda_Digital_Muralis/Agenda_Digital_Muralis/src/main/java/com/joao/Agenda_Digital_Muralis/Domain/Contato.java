package com.joao.Agenda_Digital_Muralis.Domain;

import com.joao.Agenda_Digital_Muralis.DTO.ContatoDTO;
import jakarta.persistence.*;
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
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id_contato;

    @ManyToOne
    @JoinColumn(name = "id_cliente")
    private Cliente cliente;
    private String tipo;
    private String valor;

    @Column(nullable = true)
    private String observacao;

}

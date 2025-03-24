package com.joao.Agenda_Digital_Muralis.Domain;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name="cliente_endereco")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class ClienteEndereco {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="id_cliete_endereco")
    private int id_cliente_endereco;

    @ManyToOne
    @JoinColumn(name = "id_cliente")
    private Cliente cliente;

    @ManyToOne
    @JoinColumn(name = "id_endereco")
    private Endereco endereco;

    private int numero;
}

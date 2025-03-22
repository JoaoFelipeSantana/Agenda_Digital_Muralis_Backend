package com.joao.Agenda_Digital_Muralis.Domain;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
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
    private int idClienteEndereco;
    private int idCliente;
    private int idEndereco;
    private int numero;
}

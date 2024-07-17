package com.renato.santander.avaliacao.entity;



import lombok.Getter;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.math.BigDecimal;

@Entity
@Getter
@Setter
public class Funcionario {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String nome;
    private String cargo;
    private BigDecimal salario;
    private String telefone;
    private String endereco;
    private Integer numero;


    public Long getId() {
        return id;
    }

}
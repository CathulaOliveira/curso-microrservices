package br.com.msavaliadorcredito.model;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class Cliente {

    private Long id;
    private String cpf;
    private String nome;
    private Integer idade;
}

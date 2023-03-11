package br.com.msclientes.dto;

import br.com.msclientes.model.Cliente;
import lombok.Data;

@Data
public class ClienteDTO {

    private String cpf;
    private String nome;
    private Integer idade;

    public Cliente toModel() {
        return new Cliente(cpf, nome, idade);
    }
}

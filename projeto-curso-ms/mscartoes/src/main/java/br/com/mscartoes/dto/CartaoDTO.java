package br.com.mscartoes.dto;

import br.com.mscartoes.model.BandeiraCartao;
import br.com.mscartoes.model.Cartao;
import lombok.Data;

import java.math.BigDecimal;

@Data
public class CartaoDTO {

    private String nome;
    private BandeiraCartao bandeira;
    private BigDecimal renda;
    private BigDecimal limite;

    public Cartao toModel() {
        return new Cartao(nome, bandeira, renda, limite);
    }
}

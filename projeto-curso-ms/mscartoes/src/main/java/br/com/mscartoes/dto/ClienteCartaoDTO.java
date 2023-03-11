package br.com.mscartoes.dto;

import br.com.mscartoes.model.ClienteCartao;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ClienteCartaoDTO {

    private String nome;
    private String bandeira;
    private BigDecimal limiteLiberado;

    public static ClienteCartaoDTO fromModel(ClienteCartao model) {
        return new ClienteCartaoDTO(model.getCartao().getNome(),
                model.getCartao().getBandeira().toString(),
                model.getLimiteAprovado()
        );
    }
}

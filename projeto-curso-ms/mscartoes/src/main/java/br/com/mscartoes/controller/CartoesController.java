package br.com.mscartoes.controller;

import br.com.mscartoes.dto.CartaoDTO;
import br.com.mscartoes.dto.ClienteCartaoDTO;
import br.com.mscartoes.model.Cartao;
import br.com.mscartoes.model.ClienteCartao;
import br.com.mscartoes.service.CartaoService;
import br.com.mscartoes.service.ClienteCartaoService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("cartoes")
@RequiredArgsConstructor
public class CartoesController {

    private final CartaoService cartaoService;
    private final ClienteCartaoService clienteCartaoService;

    @GetMapping
    private String status() {
        return "ok";
    }

    @PostMapping
    public ResponseEntity save(@RequestBody CartaoDTO request) {
        Cartao cartao = request.toModel();
        cartaoService.save(cartao);
        return ResponseEntity.status(HttpStatus.CREATED).build();
    }

    @GetMapping(params = "renda")
    public ResponseEntity<List<Cartao>> getByRendaAte(@RequestParam("renda") Long renda) {
        List<Cartao> list = cartaoService.getByRendaAte(renda);
        return  ResponseEntity.ok(list);
    }

    @GetMapping(params = "cpf")
    public ResponseEntity<List<ClienteCartaoDTO>> getCartoesByCliente(
            @RequestParam("cpf") String cpf) {
        List<ClienteCartao> lista = clienteCartaoService.listarCartoesByCpf(cpf);
        List<ClienteCartaoDTO> resultList = lista.stream()
                .map(ClienteCartaoDTO::fromModel)
                .toList();
        return ResponseEntity.ok(resultList);
    }
}

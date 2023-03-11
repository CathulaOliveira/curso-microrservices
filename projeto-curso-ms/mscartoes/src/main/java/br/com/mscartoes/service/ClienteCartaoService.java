package br.com.mscartoes.service;

import br.com.mscartoes.model.ClienteCartao;
import br.com.mscartoes.repository.ClienteCartaoRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ClienteCartaoService {

    private final ClienteCartaoRepository repository;

    public List<ClienteCartao> listarCartoesByCpf(String cpf) {
        return repository.findByCpf(cpf);
    }
}

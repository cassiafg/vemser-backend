package br.com.dbc.vemser.pessoaapi.controller;

import br.com.dbc.vemser.pessoaapi.entity.ContatoEntity;
import br.com.dbc.vemser.pessoaapi.entity.EnderecoEntity;
import br.com.dbc.vemser.pessoaapi.repository.ContatoRepository;
import br.com.dbc.vemser.pessoaapi.repository.EnderecoRepository;

import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/paginacao")
@RequiredArgsConstructor
public class PaginacaoController {
    private final ContatoRepository contatoRepository;
    private final EnderecoRepository enderecoRepository;

    @GetMapping("/contato-descricao")
    public Page<ContatoEntity> findContatoEntity(Integer pagina,
                                                            Integer quantidadeRegistros){
        Pageable pageable = PageRequest.of(pagina, quantidadeRegistros, Sort.by("descricao"));
        return contatoRepository.findAll(pageable);
    }

    @GetMapping("/endereco-cep")
    public Page<EnderecoEntity> findEnderecoEntity(Integer pagina,
                                                   Integer quantidadeRegistros){
        Pageable pageable = PageRequest.of(pagina, quantidadeRegistros, Sort.by("cep"));
        return enderecoRepository.findAll(pageable);
    }

    @GetMapping("/endereco-pais")
    public Page<EnderecoEntity> enderecoBypais(Integer pagina,
                                               Integer quantidadeRegistros,
                                               String pais){
        Pageable pageable = PageRequest.of(pagina, quantidadeRegistros);
        return enderecoRepository.enderecoByPais(pageable, pais);
    }



}

package br.com.dbc.vemser.pessoaapi.service;

import br.com.dbc.vemser.pessoaapi.dto.RelatorioDTO;
import br.com.dbc.vemser.pessoaapi.repository.PessoaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RelatorioService {

    @Autowired
    private PessoaRepository pessoaRepository;

    public List<RelatorioDTO> relatorioPersonalizado(Integer id){
        return pessoaRepository.relatorioPersonalizadoDTO(id);
    }
}

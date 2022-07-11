package br.com.dbc.vemser.pessoaapi.service;

import br.com.dbc.vemser.pessoaapi.dto.PessoaCreateDTO;
import br.com.dbc.vemser.pessoaapi.dto.PessoaDTO;
import br.com.dbc.vemser.pessoaapi.entity.Pessoa;
import br.com.dbc.vemser.pessoaapi.exception.RegraDeNegocioException;
import br.com.dbc.vemser.pessoaapi.repository.PessoaRepository;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@Slf4j
public class PessoaService {

    @Autowired
    private PessoaRepository pessoaRepository;

    @Autowired
    private ObjectMapper objectMapper;


    public PessoaDTO create(PessoaCreateDTO pessoa){
        log.info("Criando a pessoa...");
        Pessoa pessoaEntity = objectMapper.convertValue(pessoa, Pessoa.class);
        Pessoa pessoaCriada = pessoaRepository.create(pessoaEntity);
        //-----------------------
        PessoaDTO pessoaDTO = new PessoaDTO();
        pessoaDTO = objectMapper.convertValue(pessoaCriada, PessoaDTO.class);
        log.warn(("Pessoa"+pessoaDTO.getNome()+"criada"));
        return pessoaDTO;
    }

    public List<Pessoa> list(){
        return pessoaRepository.list();
    }

    public PessoaDTO update(Integer id,
                         PessoaCreateDTO pessoaAtualizar) throws Exception {
        log.info("Buscando a pessoa...");
        Pessoa pessoaEntity = objectMapper.convertValue(pessoaAtualizar, Pessoa.class);
        Pessoa pessoaAtualizada = findById(id);
        //-----------------------
        PessoaDTO pessoaDTO = new PessoaDTO();
        pessoaDTO = objectMapper.convertValue(pessoaAtualizada, PessoaDTO.class);
        log.warn(("Pessoa"+pessoaDTO.getNome()+"criada"));
        pessoaDTO.setCpf(pessoaAtualizar.getCpf());
        pessoaDTO.setNome(pessoaAtualizar.getNome());
        pessoaDTO.setDataNascimento(pessoaAtualizar.getDataNascimento());
        return pessoaDTO;
    }

    public void delete(Integer id) throws Exception {
        pessoaRepository.list().remove(findById(id));
    }

    public List<Pessoa> listByName(String nome) {
        return pessoaRepository.list().stream()
                .filter(pessoa -> pessoa.getNome().toUpperCase().contains(nome.toUpperCase()))
                .collect(Collectors.toList());
    }

    public Pessoa findById(Integer id) throws Exception{
        Pessoa pessoaRecuperada = pessoaRepository.list().stream()
                .filter(pessoa -> pessoa.getIdPessoa().equals(id))
                .findFirst()
                .orElseThrow(() -> new RegraDeNegocioException("Pessoa não encontrada"));
                return pessoaRecuperada;
    }
}

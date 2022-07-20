package br.com.dbc.vemser.pessoaapi.service;

import br.com.dbc.vemser.pessoaapi.dto.PessoaCreateDTO;
import br.com.dbc.vemser.pessoaapi.dto.PessoaDTO;
import br.com.dbc.vemser.pessoaapi.entity.PessoaEntity;
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
    @Autowired
    private EmailService emailService;


    public PessoaDTO create(PessoaCreateDTO pessoa) {
        log.info("Criando a pessoa...");
        PessoaEntity pessoaEntity = objectMapper.convertValue(pessoa, PessoaEntity.class);
        PessoaEntity pessoaCriada = pessoaRepository.save(pessoaEntity);
        //-----------------------
        PessoaDTO pessoaDTO = new PessoaDTO();
        pessoaDTO = objectMapper.convertValue(pessoaCriada, PessoaDTO.class);
        log.warn(("Pessoa " + pessoaDTO.getNome() + " criada"));
        emailService.sendEmailCriarPessoa(pessoaDTO);
        return pessoaDTO;
    }


    public List<PessoaDTO> list() {
        log.info("Listando pessoas...");
        log.info("Pesssoas listadas com sucesso!");
        return pessoaRepository.findAll().stream()
                .map(pessoa -> objectMapper.convertValue(pessoa, PessoaDTO.class))
                .collect(Collectors.toList());
    }

    public PessoaDTO update(Integer id,
                            PessoaCreateDTO pessoaAtualizar) throws Exception {
        log.info("Buscando a pessoa...");
        PessoaEntity pessoaEntity = objectMapper.convertValue(pessoaAtualizar, PessoaEntity.class);
        PessoaEntity pessoaAtualizada = returnPessoaById(id);
        //-----------------------
        PessoaDTO pessoaDTO = new PessoaDTO();
        pessoaDTO = objectMapper.convertValue(pessoaAtualizada, PessoaDTO.class);
        log.warn(("Pessoa " + pessoaDTO.getNome() + " alterada"));
        pessoaDTO.setCpf(pessoaAtualizar.getCpf());
        pessoaDTO.setNome(pessoaAtualizar.getNome());
        pessoaDTO.setDataNascimento(pessoaAtualizar.getDataNascimento());
        emailService.sendEmailAlterarPessoa(pessoaDTO);
        return pessoaDTO;
    }

    public void delete(Integer id) throws Exception {
        pessoaRepository.findAll().remove(returnPessoaById(id));
        emailService.sendEmailExcluirPessoa(returnPessoaById(id));
    }

    public List<PessoaEntity> listByName(String nome) {
        return pessoaRepository.findAll().stream()
                .filter(pessoa -> pessoa.getNome().toUpperCase().contains(nome.toUpperCase()))
                .collect(Collectors.toList());
    }

    public PessoaEntity returnPessoaById(Integer id) throws Exception {
        return pessoaRepository.findById(id)
                .orElseThrow(() -> new RegraDeNegocioException("Pessoa não encontrada"));
    }

    public List<PessoaDTO> listPessoaWithEnderecos(Integer id) {
        if (id != null) {
            return pessoaRepository.findById(id).stream()
                    .filter(pessoa -> pessoa.getEnderecos() != null)
                    .map(pessoa -> objectMapper.convertValue(pessoa, PessoaDTO.class))
                    .collect(Collectors.toList());
        } else {
            return pessoaRepository.findAll().stream()
                    .filter(pessoa -> pessoa.getEnderecos() != null)
                    .map(pessoa -> objectMapper.convertValue(pessoa, PessoaDTO.class))
                    .collect(Collectors.toList());
        }
    }

    public List<PessoaDTO> listPessoaWithContatos(Integer id) {
        if (id != null) {
            return pessoaRepository.findById(id).stream()
                    .filter(pessoa -> pessoa.getContatos() != null)
                    .map(pessoa -> objectMapper.convertValue(pessoa, PessoaDTO.class))
                    .collect(Collectors.toList());
        } else {
            return pessoaRepository.findAll().stream()
                    .filter(pessoa -> pessoa.getContatos() != null)
                    .map(pessoa -> objectMapper.convertValue(pessoa, PessoaDTO.class))
                    .collect(Collectors.toList());
        }
    }

    public List<PessoaDTO> listPessoaWithPets(Integer id) {
        if (id != null) {
            return pessoaRepository.findById(id).stream()
                    .filter(pessoa -> pessoa.getPet() != null)
                    .map(pessoa -> objectMapper.convertValue(pessoa, PessoaDTO.class))
                    .collect(Collectors.toList());
        } else {
            return pessoaRepository.findAll().stream()
                    .filter(pessoa -> pessoa.getPet() != null)
                    .map(pessoa -> objectMapper.convertValue(pessoa, PessoaDTO.class))
                    .collect(Collectors.toList());
        }
    }
}

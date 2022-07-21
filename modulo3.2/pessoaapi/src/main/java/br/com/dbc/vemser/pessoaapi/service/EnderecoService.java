package br.com.dbc.vemser.pessoaapi.service;

import br.com.dbc.vemser.pessoaapi.dto.EnderecoCreateDTO;
import br.com.dbc.vemser.pessoaapi.dto.EnderecoDTO;
import br.com.dbc.vemser.pessoaapi.dto.PessoaDTO;
import br.com.dbc.vemser.pessoaapi.entity.EnderecoEntity;
import br.com.dbc.vemser.pessoaapi.entity.PessoaEntity;
import br.com.dbc.vemser.pessoaapi.exception.RegraDeNegocioException;
import br.com.dbc.vemser.pessoaapi.repository.EnderecoRepository;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;
@Service
@Slf4j
public class EnderecoService {
    @Autowired
    private EnderecoRepository enderecoRepository;
    @Autowired
    private PessoaService pessoaService;
    @Autowired
    private ObjectMapper objectMapper;
    @Autowired
    private EmailService emailService;

    public EnderecoDTO create (Integer id, EnderecoCreateDTO endereco) throws RegraDeNegocioException{
        log.info("Buscando pessoa pelo id...");
        EnderecoEntity enderecoEntity = objectMapper.convertValue(endereco, EnderecoEntity.class);
        PessoaEntity pessoaRecuperada = pessoaService.returnPessoaById(id);
        log.info("Pessoa encontrada!");
        enderecoEntity.setPessoas(Set.of(pessoaRecuperada));
        PessoaDTO pessoaDTO = objectMapper.convertValue(pessoaRecuperada, PessoaDTO.class);
        log.info("Criando endereço para a pessoa...");
        EnderecoEntity endrecoEntity = enderecoRepository.save(enderecoEntity);
        EnderecoDTO enderecoDTO = objectMapper.convertValue(enderecoEntity, EnderecoDTO.class);
        //--------------------------------------------------------------
        log.info("Endereço criado com sucesso!");
        return enderecoDTO;
    }

    public List<EnderecoDTO> list(){
        log.info("Listando endereços...");
        log.info("Endereços listados com sucesso!");
        return enderecoRepository.findAll().stream()
                .map(endereco -> objectMapper.convertValue(endereco, EnderecoDTO.class))
                .collect(Collectors.toList());
    }

    public List<EnderecoDTO> listById(Integer id) {
        log.info("Listando endereços por id...");
        return list().stream()
                .filter(endereco -> endereco.getIdEndereco().equals(id))
                .collect(Collectors.toList());
    }

    public List<EnderecoDTO> listByIdPessoa(Integer idPessoa) {
        log.info("Listando endereços por idPessoa...");
        return list().stream()
                .filter(x -> x.getIdPessoa().equals(idPessoa))
                .collect(Collectors.toList());
    }

    public EnderecoDTO update(Integer id,
                          EnderecoCreateDTO enderecoAtualizar) throws RegraDeNegocioException {
        PessoaEntity pessoaEntity = pessoaService.returnPessoaById(id);
        PessoaDTO pessoaDTO = objectMapper.convertValue(pessoaEntity, PessoaDTO.class);
        EnderecoEntity enderecoRecuperado = findEnderecoById(id);
        EnderecoEntity enderecoEntity = objectMapper.convertValue(enderecoAtualizar, EnderecoEntity.class);
        //-------------------------------------------------------------------------
        enderecoEntity.setPessoas(Set.of(pessoaEntity));
        EnderecoDTO enderecoRecuperadoDTO = objectMapper.convertValue(enderecoRepository.save(enderecoRecuperado), EnderecoDTO.class);
        enderecoRecuperadoDTO.setLogradouro(enderecoRecuperado.getLogradouro());
        enderecoRecuperadoDTO.setNumero(enderecoRecuperado.getNumero());
        enderecoRecuperadoDTO.setComplemento(enderecoRecuperado.getComplemento());
        enderecoRecuperadoDTO.setCep(enderecoRecuperado.getCep());
        enderecoRecuperadoDTO.setCidade(enderecoRecuperado.getCidade());
        enderecoRecuperadoDTO.setEstado(enderecoRecuperado.getEstado());
        enderecoRecuperadoDTO.setPais(enderecoRecuperado.getPais());
        log.warn("Endereço atualizado com sucesso!");
        return enderecoRecuperadoDTO;
    }

    public void delete(Integer id) throws RegraDeNegocioException {
        enderecoRepository.deleteById(id);
        log.info("Endereço deletado com sucesso!");
        emailService.sendEmailDeletarEndereco(pessoaService.returnPessoaById(id));
    }

    public EnderecoEntity findEnderecoById(Integer id) throws RegraDeNegocioException{
        log.info("Buscando endereço...");
        EnderecoEntity enderecoRecuperado = enderecoRepository.findAll().stream()
                .filter(x -> x.getIdEndereco().equals(id))
                .findFirst()
                .orElseThrow(() -> new RegraDeNegocioException("Contato não encontrado"));
        log.info("Endereço encontrado!");
        return enderecoRecuperado;
    }

}

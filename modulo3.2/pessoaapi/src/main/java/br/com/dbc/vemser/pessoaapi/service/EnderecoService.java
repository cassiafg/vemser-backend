package br.com.dbc.vemser.pessoaapi.service;

import br.com.dbc.vemser.pessoaapi.dto.EnderecoCreateDTO;
import br.com.dbc.vemser.pessoaapi.dto.EnderecoDTO;
import br.com.dbc.vemser.pessoaapi.entity.EnderecoEntity;
import br.com.dbc.vemser.pessoaapi.entity.PessoaEntity;
import br.com.dbc.vemser.pessoaapi.exception.RegraDeNegocioException;
import br.com.dbc.vemser.pessoaapi.repository.EnderecoRepository;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
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

    public EnderecoDTO create (Integer id, EnderecoCreateDTO endereco) throws Exception{
        log.info("Buscando pessoa pelo id...");
        PessoaEntity pessoaRecuperada = pessoaService.returnPessoaById(id);
        log.info("Pessoa encontrada!");
        endereco.setIdPessoa(pessoaRecuperada.getIdPessoa());
        log.info("Criando endereço para a pessoa...");
        EnderecoEntity enderecoEntity = objectMapper.convertValue(endereco, EnderecoEntity.class);
        EnderecoEntity novoEndereco = enderecoRepository.save(enderecoEntity);
        //--------------------------------------------------------------
        EnderecoDTO enderecoDTO = objectMapper.convertValue(novoEndereco, EnderecoDTO.class);
        log.info("Endereço criado com sucesso!");
        emailService.sendEmailCriarEndereco(pessoaService.returnPessoaById(id));
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
                          EnderecoCreateDTO endereco) throws Exception {
        EnderecoEntity enderecoEntity = objectMapper.convertValue(endereco, EnderecoEntity.class);
        //-------------------------------------------------------------------------
        EnderecoDTO enderecoDTO;
        enderecoDTO = objectMapper.convertValue(findEnderecoById(id), EnderecoDTO.class);
        enderecoDTO.setIdPessoa(endereco.getIdPessoa());
        enderecoDTO.setLogradouro(endereco.getLogradouro());
        enderecoDTO.setNumero(endereco.getNumero());
        enderecoDTO.setComplemento(endereco.getComplemento());
        enderecoDTO.setCep(endereco.getCep());
        enderecoDTO.setCidade(endereco.getCidade());
        enderecoDTO.setEstado(endereco.getEstado());
        enderecoDTO.setPais(endereco.getPais());
        log.warn("Endereço atualizado com sucesso!");
        emailService.sendEmailAlterarEndereco(pessoaService.returnPessoaById(id));
        return enderecoDTO;
    }

    public void delete(Integer id) throws Exception {
        enderecoRepository.findAll().remove(findEnderecoById(id));
        log.info("Endereço deletado com sucesso!");
        emailService.sendEmailDeletarEndereco(pessoaService.returnPessoaById(id));
    }

    public EnderecoEntity findEnderecoById(Integer id) throws Exception{
        log.info("Buscando endereço...");
        EnderecoEntity enderecoRecuperado = enderecoRepository.findAll().stream()
                .filter(x -> x.getIdEndereco() == id.longValue())
                .findFirst()
                .orElseThrow(() -> new RegraDeNegocioException("Contato não encontrado"));
        log.info("Endereço encontrado!");
        return enderecoRecuperado;
    }

}

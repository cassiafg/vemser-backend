package br.com.dbc.vemser.pessoaapi.service;

import br.com.dbc.vemser.pessoaapi.dto.ContatoCreateDTO;
import br.com.dbc.vemser.pessoaapi.dto.ContatoDTO;
import br.com.dbc.vemser.pessoaapi.entity.ContatoEntity;
import br.com.dbc.vemser.pessoaapi.entity.PessoaEntity;
import br.com.dbc.vemser.pessoaapi.exception.RegraDeNegocioException;
import br.com.dbc.vemser.pessoaapi.repository.ContatoRepository;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@Slf4j
public class ContatoService {

    @Autowired
    private ContatoRepository contatoRepository;

    @Autowired
    private PessoaService pessoaService;

    @Autowired
    private ObjectMapper objectMapper;


    public ContatoDTO create (Integer id, ContatoCreateDTO contato) throws Exception{
        PessoaEntity pessoaRecuperada = pessoaService.returnPessoaById(id);
        contato.setIdPessoa(pessoaRecuperada.getIdPessoa());
        log.info("Criando contato...");
        ContatoEntity contatoEntity = objectMapper.convertValue(contato, ContatoEntity.class);
        ContatoEntity contatoCriado = contatoRepository.save(contatoEntity);
        //----------------------------------------------------------------
        ContatoDTO contatoDTO = objectMapper.convertValue(contatoCriado, ContatoDTO.class);
        log.warn("Contato criado com sucesso!");
        return contatoDTO;
    }

    public List<ContatoDTO> list(){
        log.info("Listando contatos...");
        log.info("Contatos listados com sucesso!");
        return contatoRepository.findAll().stream()
                .map(contato -> objectMapper.convertValue(contato, ContatoDTO.class))
                .collect(Collectors.toList());
    }

    public ContatoDTO update(Integer id,
                         ContatoCreateDTO contatoAtualizar) throws Exception {
        ContatoEntity contatoEntity = objectMapper.convertValue(contatoAtualizar, ContatoEntity.class);
        //--------------------------------------
        log.info("Buscando o contato a atualizar...");
        ContatoDTO contatoDTO;
        contatoDTO = objectMapper.convertValue(returnContatoById(id), ContatoDTO.class);
        contatoDTO.setIdPessoa(contatoAtualizar.getIdPessoa());
        contatoDTO.setNumero(contatoAtualizar.getNumero());
        contatoDTO.setDescricao(contatoAtualizar.getDescricao());
        log.warn(("Contato atualizado com sucesso!"));
        return contatoDTO;
    }

    public void delete(Integer id) throws Exception {
        contatoRepository.deleteById(id);
        log.info("Contato deletado com sucesso!");
    }
    public List<ContatoDTO> listById(Integer id) {
        return list().stream()
                .filter(x -> x.getIdPessoa().equals(id))
                .collect(Collectors.toList());
    }

    public ContatoEntity returnContatoById(Integer id) throws Exception{
        log.info("Buscando contato...");
        log.info("Contato encontrado!");
        return contatoRepository.findById(id)
                .orElseThrow(() -> new RegraDeNegocioException("Contato não encontrado"));
    }
}

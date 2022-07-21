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


    public ContatoDTO create (Integer idPessoa, ContatoCreateDTO contato) throws RegraDeNegocioException{
        log.info("Criando contato...");
        ContatoEntity contatoEntity = objectMapper.convertValue(contato, ContatoEntity.class);
        contatoEntity.setPessoa(pessoaService.returnPessoaById(idPessoa));
        contatoRepository.save(contatoEntity);
        log.warn("Contato criado com sucesso!");
        return objectMapper.convertValue(contatoEntity, ContatoDTO.class);
    }

    public List<ContatoDTO> list(){
        log.info("Listando contatos...");
        log.info("Contatos listados com sucesso!");
        return contatoRepository.findAll().stream()
                .map(contato -> objectMapper.convertValue(contato, ContatoDTO.class))
                .collect(Collectors.toList());
    }

    public ContatoDTO update(Integer id,
                         ContatoCreateDTO contatoAtualizar) throws RegraDeNegocioException {
        pessoaService.returnPessoaById(contatoAtualizar.getIdPessoa());
        ContatoEntity contatoRecuperado = returnContatoById(id);
        objectMapper.convertValue(contatoAtualizar, ContatoEntity.class);
        //--------------------------------------
        log.info("Atualizando o contato...");
//        contatoRecuperado.setTipo(contatoAtualizar.get());
        contatoRecuperado.setNumero(contatoAtualizar.getNumero());
        contatoRecuperado.setDescricao(contatoAtualizar.getDescricao());
        log.warn(("Contato atualizado com sucesso!"));
        return objectMapper.convertValue(contatoRepository.save(contatoRecuperado), ContatoDTO.class);
    }

    public void delete(Integer id) throws RegraDeNegocioException {
        contatoRepository.deleteById(id);
        log.info("Contato deletado com sucesso!");
    }
    public List<ContatoDTO> listById(Integer id) {
        return list().stream()
                .filter(x -> x.getIdPessoa().equals(id))
                .collect(Collectors.toList());
    }

    public ContatoEntity returnContatoById(Integer id) throws RegraDeNegocioException{
        log.info("Buscando contato...");
        log.info("Contato encontrado!");
        return contatoRepository.findById(id)
                .orElseThrow(() -> new RegraDeNegocioException("Contato não encontrado"));
    }
}

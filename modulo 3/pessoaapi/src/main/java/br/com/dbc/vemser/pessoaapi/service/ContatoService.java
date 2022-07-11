package br.com.dbc.vemser.pessoaapi.service;

import br.com.dbc.vemser.pessoaapi.dto.ContatoCreateDTO;
import br.com.dbc.vemser.pessoaapi.dto.ContatoDTO;
import br.com.dbc.vemser.pessoaapi.entity.Contato;
import br.com.dbc.vemser.pessoaapi.entity.Pessoa;
import br.com.dbc.vemser.pessoaapi.exception.RegraDeNegocioException;
import br.com.dbc.vemser.pessoaapi.repository.ContatoRepository;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
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
        Pessoa pessoaRecuperada = pessoaService.findById(id);
        contato.setIdPessoa(pessoaRecuperada.getIdPessoa());
        log.info("Criando contato...");
        Contato contatoEntity = objectMapper.convertValue(contato, Contato.class);
        Contato contatoCriado = contatoRepository.create(contatoEntity);
        //----------------------------------------------------------------
        ContatoDTO contatoDTO = objectMapper.convertValue(contatoCriado, ContatoDTO.class);
        log.warn("Contato criado com sucesso!");
        return contatoDTO;
    }

    public List<ContatoDTO> list(){
        log.info("Listando contatos...");
        List<ContatoDTO> listaContatosDTO = new ArrayList<>();
        List<Contato> listaContatosE = contatoRepository.list();
        for(Contato contato : listaContatosE){
            listaContatosDTO.add(objectMapper.convertValue(contato, ContatoDTO.class));
        }
        log.info("Contatos listados com sucesso!");
        return listaContatosDTO;
    }

    public ContatoDTO update(Integer id,
                         ContatoCreateDTO contatoAtualizar) throws Exception {
        Contato contatoEntity = objectMapper.convertValue(contatoAtualizar, Contato.class);
        //--------------------------------------
        log.info("Buscando o contato a atualizar...");
        ContatoDTO contatoDTO;
        contatoDTO = objectMapper.convertValue(findContatoById(id), ContatoDTO.class);
        contatoDTO.setIdPessoa(contatoAtualizar.getIdPessoa());
        contatoDTO.setNumero(contatoAtualizar.getNumero());
        contatoDTO.setDescricao(contatoAtualizar.getDescricao());
        log.warn(("Contato atualizado com sucesso!"));
        return contatoDTO;
    }

    public void delete(Integer id) throws Exception {
        contatoRepository.list().remove(findContatoById(id));
        log.info("Contato deletado com sucesso!");
    }
    public List<ContatoDTO> listById(Integer id) {
        return list().stream()
                .filter(x -> x.getIdPessoa().equals(id))
                .collect(Collectors.toList());
    }

    public Contato findContatoById(Integer id) throws Exception{
        log.info("Buscando contato...");
        Contato contatoRecuperado =contatoRepository.list().stream()
                .filter(contato -> contato.getIdContato().equals(id))
                .findFirst()
                .orElseThrow(() -> new RegraDeNegocioException("Contato não encontrado"));
        log.info("Contato encontrado!");
        return contatoRecuperado;
    }
}

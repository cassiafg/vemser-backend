package br.com.dbc.vemser.pessoaapi.service;

import br.com.dbc.vemser.pessoaapi.dto.EnderecoCreateDTO;
import br.com.dbc.vemser.pessoaapi.dto.EnderecoDTO;
import br.com.dbc.vemser.pessoaapi.entity.Endereco;
import br.com.dbc.vemser.pessoaapi.entity.Pessoa;
import br.com.dbc.vemser.pessoaapi.exception.RegraDeNegocioException;
import br.com.dbc.vemser.pessoaapi.repository.EnderecoRepository;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
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

    public EnderecoDTO create (Integer id, EnderecoCreateDTO endereco) throws Exception{
        log.info("Buscando pessoa pelo id");
        Pessoa pessoaRecuperada = pessoaService.findById(id);
        log.info("Pessoa encontrada");
        endereco.setIdPessoa(pessoaRecuperada.getIdPessoa());
        log.info("Criando endereço para a pessoa");
        Endereco enderecoEntity = objectMapper.convertValue(endereco, Endereco.class);
        Endereco novoEndereco = enderecoRepository.create(enderecoEntity);
        //--------------------------------------------------------------
        EnderecoDTO enderecoDTO = objectMapper.convertValue(novoEndereco, EnderecoDTO.class);
        log.info("Endereço criado");
        return enderecoDTO;
    }

    public List<EnderecoDTO> list(){
        List<EnderecoDTO> listaEnderecosDTO = new ArrayList<>();
        List<Endereco> listaEnderecosE = enderecoRepository.list();
        for (Endereco endereco : listaEnderecosE){
            listaEnderecosDTO.add(objectMapper.convertValue(endereco, EnderecoDTO.class));
        }
        return listaEnderecosDTO;
    }

    public List<EnderecoDTO> listById(Integer id) {
        return list().stream()
                .filter(endereco -> endereco.getIdEndereco().equals(id))
                .collect(Collectors.toList());
    }

    public List<EnderecoDTO> listByIdPessoa(Integer idPessoa) {
        return list().stream()
                .filter(x -> x.getIdPessoa().equals(idPessoa))
                .collect(Collectors.toList());
    }

    public EnderecoDTO update(Integer id,
                          EnderecoCreateDTO endereco) throws Exception {
        log.info("Buscando o endereço a atualizar");
        Endereco enderecoRecuperado = enderecoRepository.list().stream()
                .filter(x -> x.getIdEndereco().equals(id))
                .findFirst()
                .orElseThrow(() -> new RegraDeNegocioException("Endereço não encontrado"));
        Endereco enderecoEntity = objectMapper.convertValue(endereco, Endereco.class);
        //-------------------------------------------------------------------------
        EnderecoDTO enderecoDTO;
        enderecoDTO = objectMapper.convertValue(enderecoRecuperado, EnderecoDTO.class);
        enderecoDTO.setIdPessoa(endereco.getIdPessoa());
        enderecoDTO.setLogradouro(endereco.getLogradouro());
        enderecoDTO.setNumero(endereco.getNumero());
        enderecoDTO.setComplemento(endereco.getComplemento());
        enderecoDTO.setCep(endereco.getCep());
        enderecoDTO.setCidade(endereco.getCidade());
        enderecoDTO.setEstado(endereco.getEstado());
        enderecoDTO.setPais(endereco.getPais());
        log.warn("Endereço atualizado");
        return enderecoDTO;
    }

    public void delete(Integer id) throws Exception {
        Endereco endereco = enderecoRepository.list().stream()
                .filter(x -> x.getIdEndereco() == id.longValue())
                .findFirst()
                .orElseThrow(() -> new RegraDeNegocioException("Contato não encontrado"));
        enderecoRepository.list().remove(endereco);
    }


}

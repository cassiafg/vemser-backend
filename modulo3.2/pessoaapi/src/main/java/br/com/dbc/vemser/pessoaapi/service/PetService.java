package br.com.dbc.vemser.pessoaapi.service;

import br.com.dbc.vemser.pessoaapi.dto.PetCreateDTO;
import br.com.dbc.vemser.pessoaapi.dto.PetDTO;
import br.com.dbc.vemser.pessoaapi.entity.PessoaEntity;
import br.com.dbc.vemser.pessoaapi.entity.PetEntity;
import br.com.dbc.vemser.pessoaapi.exception.RegraDeNegocioException;
import br.com.dbc.vemser.pessoaapi.repository.PetRepository;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@Slf4j
public class PetService {
    @Autowired
    private PetRepository petRepository;
    @Autowired
    private PessoaService pessoaService;
    @Autowired
    private ObjectMapper objectMapper;

    public List<PetDTO> list(){
        log.info("Listando pets...");
        log.info("Pets listados com sucesso!");
        return petRepository.findAll().stream()
                .map(pet -> objectMapper.convertValue(pet, PetDTO.class))
                .collect(Collectors.toList());
    }

    public PetDTO create (Integer idPessoa, PetCreateDTO pet) throws RegraDeNegocioException {
        PessoaEntity pessoaRecuperada = pessoaService.returnPessoaById(idPessoa);
        log.info("Criando pet...");
        PetEntity petEntity = objectMapper.convertValue(pet, PetEntity.class);
        petEntity.setPessoa(pessoaRecuperada);
        PetEntity petCriado = petRepository.save(petEntity);
        //----------------------------------------------------------------
        PetDTO petDTO = objectMapper.convertValue(petCriado, PetDTO.class);
        petDTO.setIdPessoa(idPessoa);
        log.warn("Pet criado com sucesso!");
        return petDTO;
    }

    public PetDTO update(Integer idPet,
                             PetCreateDTO petAtualizar) throws RegraDeNegocioException {
        log.info("Buscando pet para atualizar...");
        PetEntity petRecuperado = findById(idPet);
        PessoaEntity pessoaEntity = petRecuperado.getPessoa();
        petRecuperado.setPessoa(null);

        PessoaEntity pessoaRecuperada = pessoaService.returnPessoaById(petAtualizar.getIdPessoa());
        log.info("Atualizando o pet...");

        petRecuperado.setNome(petAtualizar.getNome());
        petRecuperado.setTipo(petAtualizar.getTipo());
        petRecuperado.setPessoa(pessoaRecuperada);
        pessoaRecuperada.setPet(petRecuperado);
        return objectMapper.convertValue(petRecuperado, PetDTO.class);
    }

    public void delete(Integer id) {
        petRepository.deleteById(id);
        log.info("Pet deletado com sucesso!");
    }

    public PetEntity findById(Integer id) throws RegraDeNegocioException{
        return petRepository.findById(id)
                .orElseThrow(() -> new RegraDeNegocioException("Pet não encontrado"));
    }
}

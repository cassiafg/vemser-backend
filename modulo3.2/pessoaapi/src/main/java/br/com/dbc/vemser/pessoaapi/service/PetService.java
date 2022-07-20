package br.com.dbc.vemser.pessoaapi.service;

import br.com.dbc.vemser.pessoaapi.dto.PetCreateDTO;
import br.com.dbc.vemser.pessoaapi.dto.PetDTO;
import br.com.dbc.vemser.pessoaapi.entity.PessoaEntity;
import br.com.dbc.vemser.pessoaapi.entity.PetEntity;
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

    public PetDTO create (Integer id, PetCreateDTO pet) throws Exception{
        PessoaEntity pessoaRecuperada = pessoaService.returnPessoaById(id);
        pet.setIdPessoa(pessoaRecuperada.getIdPessoa());
        log.info("Criando pet...");
        PetEntity petEntity = objectMapper.convertValue(pet, PetEntity.class);
        PetEntity petCriado = petRepository.save(petEntity);
        //----------------------------------------------------------------
        PetDTO petDTO = objectMapper.convertValue(petCriado, PetDTO.class);
        log.warn("Pet criado com sucesso!");
        return petDTO;
    }

    public PetDTO update(Integer id,
                             PetCreateDTO petAtualizar) throws Exception {
        PetEntity petEntity = objectMapper.convertValue(petAtualizar, PetEntity.class);
        //--------------------------------------
        log.info("Buscando o pet a atualizar...");
        PetDTO petDTO;
        petDTO = objectMapper.convertValue(petRepository.getById(id), PetDTO.class);
        petDTO.setNome(petAtualizar.getNome());
        petDTO.setTipo(petAtualizar.getTipo());
        log.warn(("Pet atualizado com sucesso!"));
        return petDTO;
    }

    public void delete(Integer id) throws Exception {
        petRepository.deleteById(id);
        log.info("Pet deletado com sucesso!");
    }
}

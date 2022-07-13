package br.com.dbc.vemser.pessoaapi.controller;

import br.com.dbc.vemser.pessoaapi.client.DadosPessoaisClient;
import br.com.dbc.vemser.pessoaapi.dto.DadosPessoaisDTO;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/dadospessoais")
@RequiredArgsConstructor
public class DadosPessoaisController {

    @Autowired
    private DadosPessoaisClient client;

    @GetMapping
    public List<DadosPessoaisDTO> listDadosPessoais(){
        return client.getAll();
    }

    @PostMapping
    public DadosPessoaisDTO create(@RequestBody DadosPessoaisDTO dadosPessoaisDTO){
        return client.post(dadosPessoaisDTO);
    }

    @PutMapping("/{cpf}")
    public DadosPessoaisDTO update(@PathVariable("cpf") String cpf, @RequestBody DadosPessoaisDTO dadosPessoaisDTO){
        return client.put(cpf, dadosPessoaisDTO);
    }

    @DeleteMapping("/{cpf}")
    public void delete(@PathVariable("cpf") String cpf){
        client.delete(cpf);
    }

    @GetMapping("/{cpf}")
    public DadosPessoaisDTO listByCpf (@PathVariable("cpf") String cpf){
        return client.get(cpf);
    }


}

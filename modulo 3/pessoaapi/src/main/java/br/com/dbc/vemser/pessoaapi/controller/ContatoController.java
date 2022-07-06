package br.com.dbc.vemser.pessoaapi.controller;

import br.com.dbc.vemser.pessoaapi.entity.Contato;
import br.com.dbc.vemser.pessoaapi.service.ContatoService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/contato") //localhost:8080/contato
public class ContatoController {

    private ContatoService contatoService;

    public ContatoController(){
        contatoService = new ContatoService();
    }

    @GetMapping  //localhost:8080/contato
    public List<Contato> list(){
        return contatoService.list();
    }

    @GetMapping("/{idPessoa}")  //localhost:8080/contato/1
    public List<Contato> listById(@PathVariable("idPessoa") Integer id) {
        return contatoService.listById(id);
    }

    @PostMapping  //localhost:8080/contato
    public Contato create (@PathVariable("idPessoa") Integer id, @RequestBody Contato contato) throws Exception{
        return contatoService.create(id, contato);
    }

    @PutMapping("/{idContato}") // localhost:8080/contato/4
    public Contato update(@PathVariable("idContato") Integer id,
                          @RequestBody Contato contatoAtualizar) throws Exception {
        return contatoService.update(id, contatoAtualizar);
    }

    @DeleteMapping("/{idContato}") // localhost:8080/contato/2
    public void delete(@PathVariable("idContato") Integer id) throws Exception {
        contatoService.delete(id);
    }
}

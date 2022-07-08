package br.com.dbc.vemser.pessoaapi.controller;

import br.com.dbc.vemser.pessoaapi.config.PropertieReader;
import br.com.dbc.vemser.pessoaapi.entity.Contato;
import br.com.dbc.vemser.pessoaapi.exception.RegraDeNegocioException;
import br.com.dbc.vemser.pessoaapi.service.ContatoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
@Validated
@RestController
@RequestMapping("/contato") //localhost:8080/contato
public class ContatoController {

    @Autowired
    private PropertieReader propertieReader;
    @Autowired
    private ContatoService contatoService;

 //   public ContatoController(){
 //       contatoService = new ContatoService();
 //   }

    @GetMapping  //localhost:8080/contato
    public List<Contato> list(){
        return contatoService.list();
    }

    @GetMapping("/{idPessoa}")  //localhost:8080/contato/1
    public List<Contato> listById(@PathVariable("idPessoa") Integer id) {
        return contatoService.listById(id);
    }

    @PostMapping("/{idPessoa}") //localhost:8080/contato/1
    public ResponseEntity<Contato> create (@PathVariable("idPessoa") Integer id, @Valid @RequestBody Contato novoContato) throws Exception {
        return ResponseEntity.ok(contatoService.create(id, novoContato));
    }

    @PutMapping("/{idContato}") // localhost:8080/contato/4
    public ResponseEntity<Contato> update(@PathVariable("idContato") Integer id,
                          @Valid@RequestBody Contato contato) throws Exception {
        return ResponseEntity.ok(contatoService.update(id, contato));
    }

    @DeleteMapping("/{idContato}") // localhost:8080/contato/2
    public void delete(@PathVariable("idContato") Integer id) throws Exception {
        contatoService.delete(id);
    }
}

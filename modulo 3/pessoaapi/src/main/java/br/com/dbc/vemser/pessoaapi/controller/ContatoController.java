package br.com.dbc.vemser.pessoaapi.controller;

import br.com.dbc.vemser.pessoaapi.config.PropertieReader;
import br.com.dbc.vemser.pessoaapi.dto.ContatoCreateDTO;
import br.com.dbc.vemser.pessoaapi.dto.ContatoDTO;
import br.com.dbc.vemser.pessoaapi.entity.Contato;
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

    @GetMapping  //localhost:8080/contato
    public List<ContatoDTO> list(){
        return contatoService.list();
    }

    @GetMapping("/{idPessoa}")  //localhost:8080/contato/1
    public List<ContatoDTO> listById(@PathVariable("idPessoa") Integer id) {
        return contatoService.listById(id);
    }

    @PostMapping("/{idPessoa}") //localhost:8080/contato/1
    public ResponseEntity<ContatoDTO> create (@PathVariable("idPessoa") Integer id, @Valid @RequestBody ContatoCreateDTO contato) throws Exception {
        return ResponseEntity.ok(contatoService.create(id, contato));
    }

    @PutMapping("/{idContato}") // localhost:8080/contato/4
    public ResponseEntity<ContatoDTO> update(@PathVariable("idContato") Integer id,
                          @Valid@RequestBody ContatoCreateDTO contatoAtualizar) throws Exception {
        return ResponseEntity.ok(contatoService.update(id, contatoAtualizar));
    }

    @DeleteMapping("/{idContato}") // localhost:8080/contato/2
    public void delete(@PathVariable("idContato") Integer id) throws Exception {
        contatoService.delete(id);
    }
}

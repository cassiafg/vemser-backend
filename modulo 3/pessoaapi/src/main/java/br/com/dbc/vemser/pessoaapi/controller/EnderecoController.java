package br.com.dbc.vemser.pessoaapi.controller;

import br.com.dbc.vemser.pessoaapi.config.PropertieReader;
import br.com.dbc.vemser.pessoaapi.dto.EnderecoCreateDTO;
import br.com.dbc.vemser.pessoaapi.dto.EnderecoDTO;
import br.com.dbc.vemser.pessoaapi.service.EnderecoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
@Validated
@RestController
@RequestMapping("/endereco")
public class EnderecoController {
    @Autowired
    private PropertieReader propertieReader;
    @Autowired
    private EnderecoService enderecoService;

    @GetMapping  //localhost:8080/endereco
    public List<EnderecoDTO> list(){ return enderecoService.list();}

    @GetMapping("/{idEndereco}")  //localhost:8080/endereco/1
    public List<EnderecoDTO> listById(@PathVariable ("idEndereco") Integer id) { return enderecoService.listById(id);}

    @GetMapping("/{idPessoa}/pessoa")  //localhost:8080/endereco/1/pessoa
    public List<EnderecoDTO> listByIdPessoa(@PathVariable("idPessoa") Integer idPessoa){ return enderecoService.listByIdPessoa(idPessoa);}

    @PostMapping("/{idPessoa}") //localhost:8080/endereco/1
    public ResponseEntity<EnderecoDTO> create (@PathVariable("idPessoa") Integer id, @Valid @RequestBody EnderecoCreateDTO endereco) throws Exception{
        return ResponseEntity.ok(enderecoService.create(id, endereco));
    }

    @PutMapping("/{idEndereco}") // localhost:8080/endereco/1
    public ResponseEntity<EnderecoDTO> update(@PathVariable("idEndereco") Integer id,
                          @Valid @RequestBody EnderecoCreateDTO endereco) throws Exception {
        return ResponseEntity.ok(enderecoService.update(id, endereco));
    }

    @DeleteMapping("/{idEndereco}") // localhost:8080/endereco/1
    public void delete(@PathVariable("idEndereco") Integer id) throws Exception {
        enderecoService.delete(id);
    }
}

package br.com.dbc.vemser.pessoaapi.controller;

import br.com.dbc.vemser.pessoaapi.config.PropertieReader;
import br.com.dbc.vemser.pessoaapi.entity.Contato;
import br.com.dbc.vemser.pessoaapi.entity.Endereco;
import br.com.dbc.vemser.pessoaapi.service.EnderecoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/endereco")
public class EnderecoController {
    @Autowired
    private PropertieReader propertieReader;
    @Autowired
    private EnderecoService enderecoService;

    @GetMapping  //localhost:8090/endereco
    public List<Endereco> list(){ return enderecoService.list();}

    @GetMapping("/{idEndereco}")  //localhost:8090/endereco/1
    public List<Endereco> listById(@PathVariable ("idEndereco") Integer id) { return enderecoService.listById(id);}

    @GetMapping("/{idPessoa}/pessoa")  //localhost:8090/endereco/1/pessoa
    public List<Endereco> listByIdPessoa(@PathVariable("idPessoa") Integer idPessoa){ return enderecoService.listByIdPessoa(idPessoa);}

    @PostMapping("/{idPessoa}") //localhost:8090/endereco/1
    public Endereco create (@PathVariable("idPessoa") Integer id, @RequestBody Endereco endereco) throws Exception{
        return enderecoService.create(id, endereco);
    }

    @PutMapping("/{idEndereco}") // localhost:8090/endereco/1
    public Endereco update(@PathVariable("idEndereco") Integer id,
                          @RequestBody Endereco endereco) throws Exception {
        return enderecoService.update(id, endereco);
    }

    @DeleteMapping("/{idEndereco}") // localhost:8090/endereco/1
    public void delete(@PathVariable("idEndereco") Integer id) throws Exception {
        enderecoService.delete(id);
    }
}
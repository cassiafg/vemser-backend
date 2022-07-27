package br.com.dbc.vemser.pessoaapi.controller;

import br.com.dbc.vemser.pessoaapi.config.PropertieReader;
import br.com.dbc.vemser.pessoaapi.dto.ContatoCreateDTO;
import br.com.dbc.vemser.pessoaapi.dto.ContatoDTO;
import br.com.dbc.vemser.pessoaapi.exception.RegraDeNegocioException;
import br.com.dbc.vemser.pessoaapi.service.ContatoService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
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

    @Operation(summary = "Listar contatos", description = "Lista todos os contatos do banco")
    @ApiResponses(
            value = {
                    @ApiResponse(responseCode = "200", description = "Retorna a lista de contatos"),
                    @ApiResponse(responseCode = "403", description = "Você não tem permissão para acessar este recurso"),
                    @ApiResponse(responseCode = "500", description = "Foi gerada uma exceção")
            }
    )
    @GetMapping  //localhost:8080/contato
    public List<ContatoDTO> list(){
        return contatoService.list();
    }

    @Operation(summary = "Listar contatos pelo ID da pessoa", description = "Lista os contatos do banco associados ao ID Pessoa informado")
    @ApiResponses(
            value = {
                    @ApiResponse(responseCode = "200", description = "Retorna a lista de contatos da pessoa"),
                    @ApiResponse(responseCode = "403", description = "Você não tem permissão para acessar este recurso"),
                    @ApiResponse(responseCode = "500", description = "Foi gerada uma exceção")
            }
    )
    @GetMapping("/{idPessoa}")  //localhost:8080/contato/1
    public List<ContatoDTO> listById(@PathVariable("idPessoa") Integer id) {
        return contatoService.listById(id);
    }


    @Operation(summary = "Criar contatos", description = "Cria um novo contato para a pessoa associada ao ID da pessoa informado")
    @ApiResponses(
            value = {
                    @ApiResponse(responseCode = "200", description = "Contato criado com sucesso"),
                    @ApiResponse(responseCode = "403", description = "Você não tem permissão para acessar este recurso"),
                    @ApiResponse(responseCode = "500", description = "Foi gerada uma exceção")
            }
    )
    @PostMapping("/{idPessoa}") //localhost:8080/contato/1
    public ResponseEntity<ContatoDTO> create (@PathVariable("idPessoa") Integer id, @Valid @RequestBody ContatoCreateDTO contato) throws RegraDeNegocioException {
        return ResponseEntity.ok(contatoService.create(id, contato));
    }


    @Operation(summary = "Alterar contatos", description = "Altera os dados do contato a partir do ID do contato informado")
    @ApiResponses(
            value = {
                    @ApiResponse(responseCode = "200", description = "Contato alterado com sucesso"),
                    @ApiResponse(responseCode = "403", description = "Você não tem permissão para acessar este recurso"),
                    @ApiResponse(responseCode = "500", description = "Foi gerada uma exceção")
            }
    )
    @PutMapping("/{idContato}") // localhost:8080/contato/4
    public ResponseEntity<ContatoDTO> update(@PathVariable("idContato") Integer id,
                          @Valid@RequestBody ContatoCreateDTO contatoAtualizar) throws RegraDeNegocioException {
        return ResponseEntity.ok(contatoService.update(id, contatoAtualizar));
    }


    @Operation(summary = "Apagar contatos", description = "Apaga um contato do banco associado ao ID Contato informado")
    @ApiResponses(
            value = {
                    @ApiResponse(responseCode = "200", description = "Contato excluído com sucesso"),
                    @ApiResponse(responseCode = "403", description = "Você não tem permissão para acessar este recurso"),
                    @ApiResponse(responseCode = "500", description = "Foi gerada uma exceção")
            }
    )
    @DeleteMapping("/{idContato}") // localhost:8080/contato/2
    public void delete(@PathVariable("idContato") Integer id) throws RegraDeNegocioException {
        contatoService.delete(id);
    }
}

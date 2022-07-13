package br.com.dbc.vemser.pessoaapi.controller;

import br.com.dbc.vemser.pessoaapi.config.PropertieReader;
import br.com.dbc.vemser.pessoaapi.dto.EnderecoCreateDTO;
import br.com.dbc.vemser.pessoaapi.dto.EnderecoDTO;
import br.com.dbc.vemser.pessoaapi.service.EnderecoService;
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
@RequestMapping("/endereco")
public class EnderecoController {
    @Autowired
    private PropertieReader propertieReader;
    @Autowired
    private EnderecoService enderecoService;

    @Operation(summary = "Listar endereços", description = "Lista todos os endereços do banco")
    @ApiResponses(
            value = {
                    @ApiResponse(responseCode = "200", description = "Retorna a lista de endereços"),
                    @ApiResponse(responseCode = "403", description = "Você não tem permissão para acessar este recurso"),
                    @ApiResponse(responseCode = "500", description = "Foi gerada uma exceção")
            }
    )
    @GetMapping  //localhost:8080/endereco
    public List<EnderecoDTO> list(){ return enderecoService.list();}

    @Operation(summary = "Listar endereço por ID", description = "Lista o endereço associado a um ID")
    @ApiResponses(
            value = {
                    @ApiResponse(responseCode = "200", description = "Retorna o endereço associado ao ID informado"),
                    @ApiResponse(responseCode = "403", description = "Você não tem permissão para acessar este recurso"),
                    @ApiResponse(responseCode = "500", description = "Foi gerada uma exceção")
            }
    )
    @GetMapping("/{idEndereco}")  //localhost:8080/endereco/1
    public List<EnderecoDTO> listById(@PathVariable ("idEndereco") Integer id) { return enderecoService.listById(id);}

    @Operation(summary = "Listar endereços por ID da pessoa", description = "Lista todos os endereços associados a um ID pessoa")
    @ApiResponses(
            value = {
                    @ApiResponse(responseCode = "200", description = "Retorna a lista dos endereços associados ao ID pessoa informado"),
                    @ApiResponse(responseCode = "403", description = "Você não tem permissão para acessar este recurso"),
                    @ApiResponse(responseCode = "500", description = "Foi gerada uma exceção")
            }
    )
    @GetMapping("/{idPessoa}/pessoa")  //localhost:8080/endereco/1/pessoa
    public List<EnderecoDTO> listByIdPessoa(@PathVariable("idPessoa") Integer idPessoa){ return enderecoService.listByIdPessoa(idPessoa);}

    @Operation(summary = "Criar endereço para uma pessoa", description = "Cria um endereço para a pessoa associada ao ID Pessoa informado")
    @ApiResponses(
            value = {
                    @ApiResponse(responseCode = "200", description = "Endereço criado com sucesso"),
                    @ApiResponse(responseCode = "403", description = "Você não tem permissão para acessar este recurso"),
                    @ApiResponse(responseCode = "500", description = "Foi gerada uma exceção")
            }
    )
    @PostMapping("/{idPessoa}") //localhost:8080/endereco/1
    public ResponseEntity<EnderecoDTO> create (@PathVariable("idPessoa") Integer id, @Valid @RequestBody EnderecoCreateDTO endereco) throws Exception{
        return ResponseEntity.ok(enderecoService.create(id, endereco));
    }

    @Operation(summary = "Alterar endereço", description = "Altera o endereço associado ao ID Endereço informado")
    @ApiResponses(
            value = {
                    @ApiResponse(responseCode = "200", description = "Endereço alterado com sucesso"),
                    @ApiResponse(responseCode = "403", description = "Você não tem permissão para acessar este recurso"),
                    @ApiResponse(responseCode = "500", description = "Foi gerada uma exceção")
            }
    )
    @PutMapping("/{idEndereco}") // localhost:8080/endereco/1
    public ResponseEntity<EnderecoDTO> update(@PathVariable("idEndereco") Integer id,
                          @Valid @RequestBody EnderecoCreateDTO endereco) throws Exception {
        return ResponseEntity.ok(enderecoService.update(id, endereco));
    }

    @Operation(summary = "Apagar endereço", description = "Apaga o endereço associado ao ID Endereço informado")
    @ApiResponses(
            value = {
                    @ApiResponse(responseCode = "200", description = "Endereço excluído com sucesso"),
                    @ApiResponse(responseCode = "403", description = "Você não tem permissão para acessar este recurso"),
                    @ApiResponse(responseCode = "500", description = "Foi gerada uma exceção")
            }
    )
    @DeleteMapping("/{idEndereco}") // localhost:8080/endereco/1
    public void delete(@PathVariable("idEndereco") Integer id) throws Exception {
        enderecoService.delete(id);
    }
}

package br.com.dbc.vemser.pessoaapi.controller;

import br.com.dbc.vemser.pessoaapi.dto.PetCreateDTO;
import br.com.dbc.vemser.pessoaapi.dto.PetDTO;
import br.com.dbc.vemser.pessoaapi.service.PetService;
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
@RequestMapping("/pet")
public class PetController {
    @Autowired
    private PetService petService;

    @Operation(summary = "Listar pets", description = "Lista todos os pets do banco")
    @ApiResponses(
            value = {
                    @ApiResponse(responseCode = "200", description = "Retorna a lista de pets"),
                    @ApiResponse(responseCode = "403", description = "Você não tem permissão para acessar este recurso"),
                    @ApiResponse(responseCode = "500", description = "Foi gerada uma exceção")
            }
    )
    @GetMapping  //localhost:8080/pet
    public List<PetDTO> list(){ return petService.list();}

    @Operation(summary = "Criar pet para uma pessoa", description = "Cria um pet para a pessoa associada ao ID Pessoa informado")
    @ApiResponses(
            value = {
                    @ApiResponse(responseCode = "200", description = "Pet criado com sucesso"),
                    @ApiResponse(responseCode = "403", description = "Você não tem permissão para acessar este recurso"),
                    @ApiResponse(responseCode = "500", description = "Foi gerada uma exceção")
            }
    )
    @PostMapping //localhost:8080/pet
    public ResponseEntity<PetDTO> create (@PathVariable("idPet") Integer id, @Valid @RequestBody PetCreateDTO pet) throws Exception{
        return ResponseEntity.ok(petService.create(id, pet));
    }

    @Operation(summary = "Alterar pet", description = "Altera o pet associado ao ID Pet informado")
    @ApiResponses(
            value = {
                    @ApiResponse(responseCode = "200", description = "Pet alterado com sucesso"),
                    @ApiResponse(responseCode = "403", description = "Você não tem permissão para acessar este recurso"),
                    @ApiResponse(responseCode = "500", description = "Foi gerada uma exceção")
            }
    )
    @PutMapping("/{idPet}") // localhost:8080/pet/1
    public ResponseEntity<PetDTO> update(@PathVariable("idPet") Integer id,
                                              @Valid @RequestBody PetCreateDTO pet) throws Exception {
        return ResponseEntity.ok(petService.update(id, pet));
    }

    @Operation(summary = "Apagar pet", description = "Apaga o pet associado ao ID Pet informado")
    @ApiResponses(
            value = {
                    @ApiResponse(responseCode = "200", description = "Pet excluído com sucesso"),
                    @ApiResponse(responseCode = "403", description = "Você não tem permissão para acessar este recurso"),
                    @ApiResponse(responseCode = "500", description = "Foi gerada uma exceção")
            }
    )
    @DeleteMapping("/{idPet}") // localhost:8080/pet/1
    public void delete(@PathVariable("idPet") Integer id) throws Exception {
        petService.delete(id);
    }
}

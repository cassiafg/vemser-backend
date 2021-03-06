package br.com.dbc.vemser.pessoaapi.controller;

import br.com.dbc.vemser.pessoaapi.dto.PessoaCreateDTO;
import br.com.dbc.vemser.pessoaapi.dto.PessoaDTO;
import br.com.dbc.vemser.pessoaapi.config.PropertieReader;
import br.com.dbc.vemser.pessoaapi.dto.RelatorioDTO;
import br.com.dbc.vemser.pessoaapi.entity.PessoaEntity;
import br.com.dbc.vemser.pessoaapi.repository.PessoaRepository;
import br.com.dbc.vemser.pessoaapi.service.*;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import lombok.SneakyThrows;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.time.LocalDate;
import java.util.List;

@RestController
@RequestMapping("/pessoa") // localhost:8080/pessoa
@Validated
@Slf4j
public class PessoaController {
    @Autowired
    private PropertieReader propertieReader;

    @Autowired
    private PessoaService pessoaService;

    @Autowired
    private EmailService emailService;

    @Autowired
    private PessoaRepository pessoaRepository;

    @Autowired
    private RelatorioService relatorioService;


    //@Value("${spring.application.name}")
    //private String app;

    @Operation(summary = "Listar pessoas", description = "Lista todas as pessoas do banco")
    @ApiResponses(
            value = {
                    @ApiResponse(responseCode = "200", description = "Retorna a lista de pessoas"),
                    @ApiResponse(responseCode = "403", description = "Você não tem permissão para acessar este recurso"),
                    @ApiResponse(responseCode = "500", description = "Foi gerada uma exceção")
            }
    )
    @GetMapping // localhost:8080/pessoa
    public List<PessoaDTO> list() {
        return pessoaService.list();
    }

    @Operation(summary = "Listar pessoas pelo nome", description = "Lista as pessoas do banco buscando pelo nome")
    @ApiResponses(
            value = {
                    @ApiResponse(responseCode = "200", description = "Retorna a lista de pessoas correspondente ao nome informado"),
                    @ApiResponse(responseCode = "403", description = "Você não tem permissão para acessar este recurso"),
                    @ApiResponse(responseCode = "500", description = "Foi gerada uma exceção")
            }
    )
    @GetMapping("/byname") // localhost:8080/pessoa/byname?nome=Rafa
    public List<PessoaEntity> listByName(@RequestParam("nome") String nome) {
        return pessoaService.listByName(nome);
    }

    @Operation(summary = "Criar nova pessoa", description = "Adiciona uma nova pessoa ao banco")
    @ApiResponses(
            value = {
                    @ApiResponse(responseCode = "200", description = "Pessoa criada com sucesso"),
                    @ApiResponse(responseCode = "403", description = "Você não tem permissão para acessar este recurso"),
                    @ApiResponse(responseCode = "500", description = "Foi gerada uma exceção")
            }
    )
    @PostMapping // localhost:8080/pessoa
    public ResponseEntity<PessoaDTO> create(@Valid @RequestBody PessoaCreateDTO pessoa) {
        return ResponseEntity.ok(pessoaService.create(pessoa));
    }

    @Operation(summary = "Alterar os dados de uma pessoa", description = "Altera os dados de uma pessoa do banco")
    @ApiResponses(
            value = {
                    @ApiResponse(responseCode = "200", description = "Dados alterados com sucesso"),
                    @ApiResponse(responseCode = "403", description = "Você não tem permissão para acessar este recurso"),
                    @ApiResponse(responseCode = "500", description = "Foi gerada uma exceção")
            }
    )
    @PutMapping("/{idPessoa}") // localhost:8080/pessoa/1000
    public ResponseEntity<PessoaDTO> update(@PathVariable("idPessoa") Integer id,
                        @RequestBody @Valid PessoaCreateDTO pessoaAtualizar) throws Exception {
        return ResponseEntity.ok(pessoaService.update(id, pessoaAtualizar));
    }

    @Operation(summary = "Apagar pessoas", description = "Apaga os dados de uma pessoa do banco")
    @ApiResponses(
            value = {
                    @ApiResponse(responseCode = "200", description = "Dados da pessoa apagados com sucesso"),
                    @ApiResponse(responseCode = "403", description = "Você não tem permissão para acessar este recurso"),
                    @ApiResponse(responseCode = "500", description = "Foi gerada uma exceção")
            }
    )
    @DeleteMapping("/{idPessoa}") // localhost:8080/pessoa/10
    public void delete(@PathVariable("idPessoa") Integer id) throws Exception {
        pessoaService.delete(id);
    }

    //Pessoa com os dados de endereço
    @Operation(summary = "Pessoa com os dados de endereço", description = "Lista a pessoa com os dados de endereço")
    @ApiResponses(
            value = {
                    @ApiResponse(responseCode = "200", description = "Dados da pessoa listados com sucesso"),
                    @ApiResponse(responseCode = "403", description = "Você não tem permissão para acessar este recurso"),
                    @ApiResponse(responseCode = "500", description = "Foi gerada uma exceção")
            }
    )
    @GetMapping("/enderecos")
    public List<PessoaDTO> listPessoaWithEnderecos(@RequestParam(required = false) Integer id) {
        return pessoaService.listPessoaWithEnderecos(id);
    }

    //Pessoa com os dados de contato
    @Operation(summary = "Pessoa com os dados de contato", description = "Lista a pessoa com os dados de contato")
    @ApiResponses(
            value = {
                    @ApiResponse(responseCode = "200", description = "Dados da pessoa listados com sucesso"),
                    @ApiResponse(responseCode = "403", description = "Você não tem permissão para acessar este recurso"),
                    @ApiResponse(responseCode = "500", description = "Foi gerada uma exceção")
            }
    )
    @GetMapping("/contatos")
    public List<PessoaDTO> listPessoaWithContatos(@RequestParam(required = false) Integer id) {
        return pessoaService.listPessoaWithContatos(id);
    }

    //Pessoa com os dados do pet
    @Operation(summary = "Pessoa com os dados do pet", description = "Lista a pessoa com os dados do pet")
    @ApiResponses(
            value = {
                    @ApiResponse(responseCode = "200", description = "Dados da pessoa listados com sucesso"),
                    @ApiResponse(responseCode = "403", description = "Você não tem permissão para acessar este recurso"),
                    @ApiResponse(responseCode = "500", description = "Foi gerada uma exceção")
            }
    )
    @GetMapping("/pets")
    public List<PessoaDTO> listPessoaWithPets(@RequestParam(required = false) Integer id) {
        return pessoaService.listPessoaWithPets(id);
    }

    //Pessoa com todos os dados
    @Operation(summary = "Pessoa com todos os dados", description = "Pessoa completa com os dados de contato, endereço e pet")
    @ApiResponses(
            value = {
                    @ApiResponse(responseCode = "200", description = "Dados da pessoa listados com sucesso"),
                    @ApiResponse(responseCode = "403", description = "Você não tem permissão para acessar este recurso"),
                    @ApiResponse(responseCode = "500", description = "Foi gerada uma exceção")
            }
    )
    @GetMapping("/pessoa-completo")
    public List<PessoaDTO> listPessoaCompleta(@RequestParam(required = false) Integer id){
        return pessoaService.listPessoaCompleta(id);
    }


    //Relatório personalizado
    @Operation(summary = "Relatório personalizado", description = "Relatório personalizado com os dados da pessoa")
    @ApiResponses(
            value = {
                    @ApiResponse(responseCode = "200", description = "Dados da pessoa listados com sucesso"),
                    @ApiResponse(responseCode = "403", description = "Você não tem permissão para acessar este recurso"),
                    @ApiResponse(responseCode = "500", description = "Foi gerada uma exceção")
            }
    )
    @GetMapping("/relatorio-personalizado")
    public List<RelatorioDTO> relatorioPersonalizado(@RequestParam(required = false) Integer id){
        return relatorioService.relatorioPersonalizado(id);
    }


    @Operation(summary = "Listar pessoa por nome", description = "Lista os dados da pessoa a partir do nome informado")
    @ApiResponses(
            value = {
                    @ApiResponse(responseCode = "200", description = "Dados da pessoa listados com sucesso"),
                    @ApiResponse(responseCode = "403", description = "Você não tem permissão para acessar este recurso"),
                    @ApiResponse(responseCode = "500", description = "Foi gerada uma exceção")
            }
    )
    @GetMapping("/nome")
    public PessoaEntity findByNomeContainsIgnoreCase(@RequestParam("nome") String nome) {
        return pessoaRepository.findByNomeContainsIgnoreCase(nome);
    }

    @Operation(summary = "Listar pessoa por cpf", description = "Lista os dados da pessoa a partir do cpf informado")
    @ApiResponses(
            value = {
                    @ApiResponse(responseCode = "200", description = "Dados da pessoa listados com sucesso"),
                    @ApiResponse(responseCode = "403", description = "Você não tem permissão para acessar este recurso"),
                    @ApiResponse(responseCode = "500", description = "Foi gerada uma exceção")
            }
    )
    @GetMapping("/cpf")
    public PessoaEntity findByCpf(@RequestParam("cpf") String cpf){
        return pessoaRepository.findByCpf(cpf);
    }

    @Operation(summary = "Listar pessoa por data de nascimento", description = "Lista os dados da pessoa com data de nascimento entre as datas incial e final informadas")
    @ApiResponses(
            value = {
                    @ApiResponse(responseCode = "200", description = "Dados da pessoa listados com sucesso"),
                    @ApiResponse(responseCode = "403", description = "Você não tem permissão para acessar este recurso"),
                    @ApiResponse(responseCode = "500", description = "Foi gerada uma exceção")
            }
    )
    @GetMapping("/data_nascimento")
    public List<PessoaEntity> findByDataNascimentoBetween(@RequestParam("dtInicial") @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate dtInicial,
                                                          @RequestParam("dtFinal") @DateTimeFormat(iso = DateTimeFormat.ISO.DATE)LocalDate dtFinal){
        return pessoaRepository.findByDataNascimentoBetween(dtInicial, dtFinal);
    }


    //    @GetMapping("/ambiente")
//    public String getAmbiente(){
//        return propertieReader.getAmbiente();
//    }

    //    @GetMapping("/hello") // localhost:8080/pessoa/hello
//    public String hello() {
//        return "Hello world!";
//    }

    //    @SneakyThrows
//    @GetMapping("/email")
//    public String email(){
//    //    emailService.sendSimpleMessage();
//        emailService.sendWithAttachment();
//        return "Enviando e-mail..."+app+"!";
//    }
}

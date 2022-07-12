package br.com.dbc.vemser.pessoaapi.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Past;
import javax.validation.constraints.Size;
import java.time.LocalDate;

@Data
public class PessoaCreateDTO {
    @Schema(description = "Nome da Pessoa")
    @NotEmpty(message = "O campo nome não pode ser vazio nem nulo")
    private String nome;

    @Schema(description = "Data de nascimento da Pessoa")
    @NotNull(message = "O campo data de nascimento não pode ser vazio")
    @Past
    private LocalDate dataNascimento;

    @Schema(description = "CPF da Pessoa", minLength = 11 ,maxLength = 11, nullable = false)
    @NotEmpty(message = "O campo cpf não pode ser nulo nem vazio")
    @Size(min = 11, max = 11, message = "O campo cpf deve conter 11 caracteres")
    private String cpf;

    @Schema(description = "E-mail da Pessoa")
    private String email;
}

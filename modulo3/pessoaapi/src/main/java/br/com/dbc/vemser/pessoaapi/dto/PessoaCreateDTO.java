package br.com.dbc.vemser.pessoaapi.dto;

import lombok.Data;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Past;
import javax.validation.constraints.Size;
import java.time.LocalDate;

@Data
public class PessoaCreateDTO {
    private String nome;
    @NotNull(message = "O campo data de nascimento não pode ser vazio")
    @Past
    private LocalDate dataNascimento;
    @NotEmpty(message = "O campo cpf não pode ser nulo nem vazio")
    @Size(min = 11, max = 11, message = "O campo cpf deve conter 11 caracteres")
    private String cpf;
    private String email;
}

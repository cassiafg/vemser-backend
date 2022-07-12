package br.com.dbc.vemser.pessoaapi.entity;

import lombok.*;

import javax.validation.constraints.*;
import java.time.LocalDate;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class Pessoa {
    @NotNull
    private Integer idPessoa;
    @NotEmpty(message = "O campo nome não pode ser vazio nem nulo")
    private String nome;
    @NotNull(message = "O campo data de nascimento não pode ser vazio")
    @Past
    private LocalDate dataNascimento;
    @NotEmpty(message = "O campo cpf não pode ser nulo nem vazio")
    @Size(min = 11, max = 11, message = "O campo cpf deve conter 11 caracteres")
    private String cpf;
    private String email;
}
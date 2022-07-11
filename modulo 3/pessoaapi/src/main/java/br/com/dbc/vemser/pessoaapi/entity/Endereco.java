package br.com.dbc.vemser.pessoaapi.entity;

import lombok.*;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@ToString
@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class Endereco {
    private Integer idEndereco;
    private Integer idPessoa;
    @NotEmpty (message = "O campo logradouro não pode ser vazio")
    @Size(min = 1, max = 250, message = "o campo logradouro deve contar no máximo 250 caracteres")
    private String logradouro;
    @NotNull (message = "O campo número não pode ser nulo")
    private Integer numero;
    private String complemento;
    @NotEmpty (message = "O campo cep não pode ser vazio")
    @Size(min = 1, max = 8, message = "o campo cep deve conter no máximo 8 caracteres")
    private String cep;
    @NotEmpty (message = "O campo cidade não pode ser vazio")
    @Size(min = 1, max = 250, message = "o campo cidade deve conter no máximo 250 caracteres")
    private String cidade;
    @NotNull (message = "O campo estado não pode ser nulo")
    private String estado;
    @NotNull (message = "O campo pais não pode ser nulo")
    private String pais;

}

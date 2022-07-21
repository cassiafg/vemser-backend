package br.com.dbc.vemser.pessoaapi.dto;

import br.com.dbc.vemser.pessoaapi.enums.TipoEndereco;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

import javax.persistence.Column;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Data
public class EnderecoCreateDTO {
    @Schema(description = "Identificador único da pessoa", nullable = false)
    @NotNull(message = "O campo ID Pessoa não pode ser nulo")
    private Integer idPessoa;

    @Schema(description = "Tipo do endereço")
    private TipoEndereco tipo;

    @Schema(description = "Logradouro do endereço", nullable = false)
    @NotEmpty(message = "O campo logradouro não pode ser vazio")
    @Size(min = 1, max = 250, message = "o campo logradouro deve contar no máximo 250 caracteres")
    private String logradouro;

    @Schema(description = "Número do endereço", nullable = false)
    @NotNull(message = "O campo número não pode ser nulo")
    private Integer numero;

    @Schema(description = "Complemento do endereço", nullable = true)
    private String complemento;

    @Schema(description = "CEP do endereço", maxLength = 8, nullable = false)
    @NotEmpty (message = "O campo cep não pode ser vazio")
    @Size(min = 1, max = 8, message = "o campo cep deve conter no máximo 8 caracteres")
    private String cep;

    @Schema(description = "Cidade do endereço", maxLength = 250, nullable = false)
    @NotEmpty (message = "O campo cidade não pode ser vazio")
    @Size(min = 1, max = 250, message = "o campo cidade deve conter no máximo 250 caracteres")
    private String cidade;

    @Schema(description = "Estado do endereço", nullable = false)
    @NotNull (message = "O campo estado não pode ser nulo")
    private String estado;

    @Schema(description = "País do endereço", nullable = false)
    @NotNull (message = "O campo pais não pode ser nulo")
    private String pais;
}

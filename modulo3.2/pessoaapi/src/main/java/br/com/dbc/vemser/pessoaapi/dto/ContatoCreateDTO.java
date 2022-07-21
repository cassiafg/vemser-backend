package br.com.dbc.vemser.pessoaapi.dto;

import br.com.dbc.vemser.pessoaapi.enums.TipoContato;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Data
public class ContatoCreateDTO {

    @Schema(description = "Identificador único da pessoa")
    @NotNull(message = "O campo ID Pessoa não pode ser nulo")
    private Integer idPessoa;

    @Schema(description = "Tipo do contato")
    private TipoContato tipo;

    @Schema(description = "Número de telefone", maxLength = 13)
    @NotBlank(message = "O campo número não pode ser nulo")
    @Size(min = 1, max = 13, message = "o campo número deve conter no máximo 13 caracteres")
    private String numero;

    @Schema(description = "Descrição do contato")
    @NotBlank (message = "O campo descrição não pode ser vazio")
    private String descricao;
}

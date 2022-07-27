package br.com.dbc.vemser.pessoaapi.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

import javax.validation.constraints.NotNull;
import java.util.List;
import java.util.Set;

@Data
public class PessoaDTO extends PessoaCreateDTO{
    @Schema(description = "ID único da Pessoa")
    @NotNull
    private Integer idPessoa;

    @Schema(description = "Lista de endereços")
    private List<EnderecoDTO> enderecosDTO;

    @Schema(description = "Lista de contatos")
    private List<ContatoDTO> contatosDTO;

    @Schema(description = "Pet")
    private PetDTO petDTO;
}

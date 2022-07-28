package br.com.dbc.vemser.pessoaapi.dto;

import io.swagger.v3.oas.annotations.media.Schema;

public class UsuarioDTO extends UsuarioCreateDTO {

    @Schema(description = "Id único do usuário")
    private Integer idUsuario;
}

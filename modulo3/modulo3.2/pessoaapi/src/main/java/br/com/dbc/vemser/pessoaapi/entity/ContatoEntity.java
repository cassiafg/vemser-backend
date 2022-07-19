package br.com.dbc.vemser.pessoaapi.entity;

import lombok.*;

import javax.persistence.*;


@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity(name="CONTATO")
public class ContatoEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "CONTATO_SEQ")
    @SequenceGenerator(name = "CONTATO_SEQ", sequenceName = "seq_contato", allocationSize = 1)
    @Column(name = "id_contato")
    private Integer idContato;

    @Column(name = "id_pessoa")
    private Integer idPessoa;

    @Column(name = "tipo")
    private Integer tipo;

    @Column(name= "numero")
    private String numero;

    @Column(name= "descricao")
    private String descricao;
}

package br.com.dbc.vemser.pessoaapi.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.*;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.Set;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity(name="PESSOA")
public class PessoaEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "PESSOA_SEQ")
    @SequenceGenerator(name = "PESSOA_SEQ", sequenceName = "seq_pessoa2", allocationSize = 1)
    @Column(name = "id_pessoa")
    private Integer idPessoa;

    @Column(name= "nome")
    private String nome;

    @Column(name= "DATA_NASCIMENTO")
    private LocalDate dataNascimento;

    @Column(name= "CPF")
    private String cpf;

    @Column(name= "EMAIL")
    private String email;

    @Column(name= "id_pet", insertable = false, updatable = false)
    private Integer idPet;

    @JsonIgnore
    @OneToMany(fetch = FetchType.LAZY,
            mappedBy = "pessoa",
            cascade = CascadeType.ALL,
            orphanRemoval = true)
    private Set<ContatoEntity> contatos;

    @JsonIgnore
    @ManyToMany(fetch = FetchType.LAZY)
    @JoinTable(name = "Pessoa_X_Pessoa_Endereco",
            joinColumns = @JoinColumn(name="id_pessoa"),
            inverseJoinColumns = @JoinColumn(name="id_endereco")
    )
    private Set<EnderecoEntity> enderecos;

    @JsonIgnore
    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name="id_pet", referencedColumnName = "id_pet")
    private PetEntity pet;

}
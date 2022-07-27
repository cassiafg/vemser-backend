package br.com.dbc.vemser.pessoaapi.repository;

import br.com.dbc.vemser.pessoaapi.dto.RelatorioDTO;
import br.com.dbc.vemser.pessoaapi.entity.PessoaEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.List;

@Repository
public interface PessoaRepository extends JpaRepository<PessoaEntity, Integer> {
    PessoaEntity findByNomeContainsIgnoreCase(String nome);

    PessoaEntity findByCpf(String cpf);

    List<PessoaEntity> findByDataNascimentoBetween(LocalDate dtInicial, LocalDate dtFinal);

    //Relatório personalizado
    @Query(value= "select new br.com.dbc.vemser.pessoaapi.dto.RelatorioDTO("+
            " p.idPessoa, " +
            " p.nome, " +
            " p.email, " +
            " c.numero, " +
            " e.cep," +
            " e.cidade, " +
            " e.estado, " +
            " e.pais, " +
            " pt.nome" +
            " )" +
            " from PESSOA p " +
            " left join p.contatos c " +
            " left join p.enderecos e " +
            " left join p.pet pt " +
            " where (:idPessoa is null OR p.idPessoa = :idPessoa)")
    List<RelatorioDTO> relatorioPersonalizadoDTO(@Param("idPessoa")Integer idPessoa);


}

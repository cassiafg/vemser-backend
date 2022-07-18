package br.com.dbc.vemser.pessoaapi.repository;

import br.com.dbc.vemser.pessoaapi.entity.Contato;
import br.com.dbc.vemser.pessoaapi.entity.Endereco;
import br.com.dbc.vemser.pessoaapi.service.EnderecoService;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

@Repository
public class EnderecoRepository {

    private EnderecoService enderecoService;
    private PessoaRepository pessoaRepository;
    private static List<Endereco> listaEnderecos = new ArrayList<>();
    private AtomicInteger COUNTER = new AtomicInteger();

public EnderecoRepository(){
    pessoaRepository = new PessoaRepository();
    listaEnderecos.add(new Endereco(COUNTER.incrementAndGet(),1, "Rua Araçá", 319, null, "96500-000", "Canoas", "RS", "Brasil"));
    listaEnderecos.add(new Endereco(COUNTER.incrementAndGet(),2, "Rua Getúlio Vargas", 1050, "Apto 201", "95870-000", "Porto Alegre", "RS", "Brasil"));
    listaEnderecos.add(new Endereco(COUNTER.incrementAndGet(),3, "Rua Joaquim Nabuco", 900, "Apto 701", "93400-100", "Porto Alegre", "RS", "Brasil"));
    listaEnderecos.add(new Endereco(COUNTER.incrementAndGet(),4, "Rua Anita Garibaldi", 3470, "Casa 10", "98740-050", "Canoas", "RS", "Brasil"));
    listaEnderecos.add(new Endereco(COUNTER.incrementAndGet(),5, "Rua das camélias", 1493, null, "94320-040", "Canoas", "RS", "Brasil"));
}

    public Endereco create(Endereco endereco){
        endereco.setIdEndereco(COUNTER.incrementAndGet());
        listaEnderecos.add(endereco);
        return endereco;
    }

    public List<Endereco> list() {return listaEnderecos;}
}

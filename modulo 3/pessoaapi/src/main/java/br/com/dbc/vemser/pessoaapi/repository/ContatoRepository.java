package br.com.dbc.vemser.pessoaapi.repository;

import br.com.dbc.vemser.pessoaapi.entity.Contato;
import br.com.dbc.vemser.pessoaapi.entity.Pessoa;
import br.com.dbc.vemser.pessoaapi.service.ContatoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.stream.Collectors;

@Repository
public class ContatoRepository {
    private ContatoService contatoService;
    private static List<Contato> listaContatos = new ArrayList<>();

    private AtomicInteger COUNTER = new AtomicInteger();
    private PessoaRepository pessoaRepository;
    public ContatoRepository(){
        pessoaRepository = new PessoaRepository();
        listaContatos.add(new Contato(COUNTER.incrementAndGet(), 1, "(51) 99534714", "Celular"));
        listaContatos.add(new Contato(COUNTER.incrementAndGet(), 1, "(51) 33305067", "Residencial"));
        listaContatos.add(new Contato(COUNTER.incrementAndGet(), 2, "(51) 99588541", "Celular"));
        listaContatos.add(new Contato(COUNTER.incrementAndGet(), 2, "(51) 30916789", "Residencial"));
        listaContatos.add(new Contato(COUNTER.incrementAndGet(), 3, "(51) 33369796", "Comercial"));
        listaContatos.add(new Contato(COUNTER.incrementAndGet(), 3, "(51) 32333144", "Residencial"));
        listaContatos.add(new Contato(COUNTER.incrementAndGet(), 4, "(51) 99556874", "Celular"));
        listaContatos.add(new Contato(COUNTER.incrementAndGet(), 4, "(51) 99588744", "Celular"));
        listaContatos.add(new Contato(COUNTER.incrementAndGet(), 5, "(51) 91247714", "Celular"));
        listaContatos.add(new Contato(COUNTER.incrementAndGet(), 5, "(51) 30918865", "Residencial"));
    }

    public Contato create(Contato contato) throws Exception {
        contato.setIdContato(COUNTER.incrementAndGet());
        listaContatos.add(contato);
        return contato;
    }

    public List<Contato> list() {return listaContatos;}

    public Contato update(Integer id,
                         Contato contatoAtualizar) throws Exception {
        return listaContatos.set(id, contatoAtualizar);
    }

    public void delete(Integer id) throws Exception {
        listaContatos.remove(id);
    }

    public List<Contato> listById(Integer id) {
        return listaContatos;
    }
}


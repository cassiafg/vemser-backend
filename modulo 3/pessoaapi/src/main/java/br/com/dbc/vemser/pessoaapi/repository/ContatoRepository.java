package br.com.dbc.vemser.pessoaapi.repository;

import br.com.dbc.vemser.pessoaapi.entity.Contato;
import br.com.dbc.vemser.pessoaapi.entity.Pessoa;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.stream.Collectors;

public class ContatoRepository {

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

    public Contato create(Integer id, Contato novoContato) throws Exception {
        novoContato.setIdContato(COUNTER.incrementAndGet());
        Pessoa pessoaRecuperada = pessoaRepository.list().stream()
                .filter( pessoa -> pessoa.getIdPessoa().equals(id))
                .findFirst()
                .orElseThrow(() -> new Exception("Pessoa não encontrada"));
        novoContato.setIdPessoa(pessoaRecuperada.getIdPessoa());
        listaContatos.add(novoContato);
        return novoContato;
//        Contato testeContato = listaContatos.stream()
//                .filter(contato -> contato.getIdPessoa().equals(id)))
//                listaContatos.add(novoContato);
//        return novoContato;
    }

    public List<Contato> list() {return listaContatos;}

    public Contato update(Integer id,
                         Contato contatoAtualizar) throws Exception {
        Contato contatoRecuperado = listaContatos.stream()
                .filter(contato -> contato.getIdContato().equals(id))
                .findFirst()
                .orElseThrow(() -> new Exception("Contato não encontrado"));
        contatoRecuperado.setIdPessoa(contatoAtualizar.getIdPessoa());
        contatoRecuperado.setNumero(contatoAtualizar.getNumero());
        contatoRecuperado.setDescricao(contatoAtualizar.getDescricao());
        return contatoRecuperado;
    }

    public void delete(Integer id) throws Exception {
        Contato contatoRecuperado = listaContatos.stream()
                .filter(contato -> contato.getIdContato().equals(id))
                .findFirst()
                .orElseThrow(() -> new Exception("Contato não encontrado"));
        listaContatos.remove(contatoRecuperado);
    }

    public List<Contato> listById(Integer id) {
        return listaContatos.stream()
                .filter(contato -> contato.getIdPessoa().equals(id))
                .collect(Collectors.toList());
    }
}


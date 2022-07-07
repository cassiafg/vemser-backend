package br.com.dbc.vemser.pessoaapi.service;

import br.com.dbc.vemser.pessoaapi.entity.Contato;
import br.com.dbc.vemser.pessoaapi.entity.Pessoa;
import br.com.dbc.vemser.pessoaapi.repository.ContatoRepository;
import br.com.dbc.vemser.pessoaapi.repository.PessoaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.stream.Collectors;

@Service
public class ContatoService {

    @Autowired
    private ContatoRepository contatoRepository;

    @Autowired
    private PessoaRepository pessoaRepository;

    private PessoaService pessoaService;

    private ContatoService contatoService;
    private AtomicInteger COUNTER = new AtomicInteger();
    //   public ContatoService(){
    //       contatoRepository = new ContatoRepository();
    //   }

    public Contato create (Integer id, Contato contato) throws Exception{
        contato.setIdContato(COUNTER.incrementAndGet());
        Pessoa pessoaRecuperada = pessoaRepository.list().stream()
                .filter( pessoa -> pessoa.getIdPessoa().equals(id))
                .findFirst()
                .orElseThrow(() -> new Exception("Pessoa não encontrada"));
        contato.setIdPessoa(pessoaRecuperada.getIdPessoa());
        return contatoRepository.create(contato);
    }

    public List<Contato> list(){
        return contatoRepository.list();
    }

    public Contato update(Integer id,
                         Contato contatoAtualizar) throws Exception {
        Contato contatoRecuperado =contatoRepository.list().stream()
                .filter(contato -> contato.getIdContato().equals(id))
                .findFirst()
                .orElseThrow(() -> new Exception("Contato não encontrado"));
        contatoRecuperado.setIdPessoa(contatoAtualizar.getIdPessoa());
        contatoRecuperado.setNumero(contatoAtualizar.getNumero());
        contatoRecuperado.setDescricao(contatoAtualizar.getDescricao());
        return contatoRecuperado;
    }

    public void delete(Integer id) throws Exception {
        Contato contato = contatoRepository.list().stream()
                .filter(x -> x.getIdContato() == id.longValue())
                .findFirst()
                .orElseThrow(() -> new Exception("Contato não econtrado"));
       contatoRepository.list().remove(contato);
    }
    public List<Contato> listById(Integer id) {
        return contatoRepository.list().stream()
                .filter(x -> x.getIdPessoa().equals(id))
                .collect(Collectors.toList());
    }
}

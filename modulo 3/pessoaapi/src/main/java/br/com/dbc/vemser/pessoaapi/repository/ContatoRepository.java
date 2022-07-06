package br.com.dbc.vemser.pessoaapi.repository;

import br.com.dbc.vemser.pessoaapi.entity.Contato;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class ContatoRepository {

    private static List<Contato> listaContatos = new ArrayList<>();

    public ContatoRepository(){
        listaContatos.add(new Contato(1, 1, "(51) 99534714", "Celular"));
        listaContatos.add(new Contato(2, 1, "(51) 33305067", "Residencial"));
        listaContatos.add(new Contato(3, 2, "(51) 99588541", "Celular"));
        listaContatos.add(new Contato(4, 2, "(51) 30916789", "Residencial"));
        listaContatos.add(new Contato(5, 3, "(51) 33369796", "Comercial"));
        listaContatos.add(new Contato(6, 3, "(51) 32333144", "Residencial"));
        listaContatos.add(new Contato(7, 4, "(51) 99556874", "Celular"));
        listaContatos.add(new Contato(8, 4, "(51) 99588744", "Celular"));
        listaContatos.add(new Contato(9, 5, "(51) 91247714", "Celular"));
        listaContatos.add(new Contato(10, 5, "(51) 30918865", "Residencial"));
    }

    public Contato create(Contato contato){
        contato.getIdPessoa();
        listaContatos.add(contato);
        return contato;
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


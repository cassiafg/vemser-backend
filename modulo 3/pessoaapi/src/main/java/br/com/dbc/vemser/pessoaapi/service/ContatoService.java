package br.com.dbc.vemser.pessoaapi.service;

import br.com.dbc.vemser.pessoaapi.entity.Contato;
import br.com.dbc.vemser.pessoaapi.entity.Pessoa;
import br.com.dbc.vemser.pessoaapi.repository.ContatoRepository;

import java.util.List;

public class ContatoService {

    private ContatoRepository contatoRepository;

    public ContatoService(){
        contatoRepository = new ContatoRepository();
    }

    public Contato create (Contato contato){
        return contatoRepository.create(contato);
    }

    public List<Contato> list(){
        return contatoRepository.list();
    }

    public Contato update(Integer id,
                         Contato contatoAtualizar) throws Exception {
        return contatoRepository.update(id, contatoAtualizar);
    }

    public void delete(Integer id) throws Exception {
        contatoRepository.delete(id);
    }

    public List<Contato> listById(Integer id) {
        return contatoRepository.listById(id);
    }
}

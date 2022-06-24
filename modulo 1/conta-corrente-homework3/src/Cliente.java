import java.util.ArrayList;
import java.util.Arrays;

public class Cliente {
    //atributos do cliente
    private String nome;
    private String cpf;
    private ArrayList<Contato> contatos;
    private ArrayList<Endereco> enderecos;

    //construtor do cliente
    public Cliente(String nome, String cpf, ArrayList<Contato> contatos, ArrayList<Endereco> enderecos) {
        this.nome = nome;
        this.cpf = cpf;
        this.contatos = contatos;
        this.enderecos = enderecos;
    }

    //métodos do cliente

    //método imprime contatos
    void imprimirContatos(){
        System.out.println(contatos);
    }

    //método imprime endereços
    void imprimirEnderecos(){
        System.out.println(enderecos);
    }

    //método imprime cliente
    void imprimirCliente(){
        System.out.println("----------Cliente----------");
        System.out.println(this);
        imprimirContatos();
        imprimirEnderecos();
    }

    //getters e setters
    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public ArrayList<Contato> getContatos() {
        return contatos;
    }

    public void setContatos(ArrayList<Contato> contatos) {
        this.contatos = contatos;
    }

    public ArrayList<Endereco> getEnderecos() {
        return enderecos;
    }

    public void setEnderecos(ArrayList<Endereco> enderecos) {
        this.enderecos = enderecos;
    }

    @Override
    public String toString() {
        return "Cliente{" +
                "nome='" + nome + '\'' +
                ", cpf='" + cpf + '\'' +
                '}';
    }
}

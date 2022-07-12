import java.util.Arrays;

public class Cliente {
    //atributos do cliente
    private String nome;
    private String cpf;
    private Contato[] contatos = new Contato[2];
    private Endereco[] enderecos = new Endereco[2];


    //construtor do cliente
    public Cliente(String nome, String cpf, Contato contato1, Contato contato2, Endereco endereco1, Endereco endereco2) {
        this.nome = nome;
        this.cpf = cpf;
        this.contatos[0] = contato1;
        this.contatos[1] = contato2;
        this.enderecos[0] = endereco1;
        this.enderecos[1] = endereco2;
    }

    //métodos do cliente

    //método imprime contatos
    void imprimirContatos(){
        System.out.println(Arrays.toString(contatos));
    }

    //método imprime endereços
    void imprimirEnderecos(){
        System.out.println(Arrays.toString(enderecos));
    }

    //método imprime cliente
    void imprimirCliente(){
        System.out.println("----------Cliente----------");
        System.out.println("Nome: "+getNome()+", CPF: "+getCpf());
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

    public Contato[] getContatos() {
        return contatos;
    }

    public void setContatos(Contato[] contatos) {
        this.contatos = contatos;
    }

    public Endereco[] getEnderecos() {
        return enderecos;
    }

    public void setEnderecos(Endereco[] enderecos) {
        this.enderecos = enderecos;
    }

    //toString
    @Override
    public String toString() {
        return "Cliente{" +
                "nome='" + nome + '\'' +
                '}';
    }
}

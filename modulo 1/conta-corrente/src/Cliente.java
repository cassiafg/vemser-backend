public class Cliente {
    //atributos do cliente
    String nome;
    String cpf;
    Contato[] contatos = new Contato[2];
    Endereco[] enderecos = new Endereco[2];

    //métodos do cliente
    //método imprime contatos
    void imprimirContatos(){
        System.out.println("Telefone 1: " +contatos[0]);
        System.out.println("Telefone 2: " +contatos[1]);
    }

    //método imprime endereços
    void imprimirEnderecos(){
        System.out.println("Endereço 1: " +enderecos[0]);
        System.out.println("Endereço 2: " +enderecos[1]);
    }

    //método imprime cliente
    void imprimirCliente(){
        System.out.println("----------Cliente----------");
        System.out.println("Nome: "+nome+", CPF: "+cpf);
        imprimirContatos();
        imprimirEnderecos();
    }

    //método toString
    public String toString(){
        return nome;
    }

}

import java.util.ArrayList;
import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        //primeiro cliente

        //contatos do primeiro cliente

        Contato contato1cliente1 = new Contato("Celular", "99873266", 1);
        Contato contato2cliente1 = new Contato("Telefone para recados", "33966744", 2);
        ArrayList<Contato> contatoscliente1 = new ArrayList<>();
        contatoscliente1.add(contato1cliente1);
        contatoscliente1.add(contato2cliente1);

        //endereços do primeiro cliente
        Endereco endereco1cliente1 = new Endereco(1,99,"Rua Araça", "apto101", "93600-001", "Belo Horizonte", "MG","Brasil");
        Endereco endereco2cliente1 = new Endereco(2, 1000, "Av dos Estados", "Q2","92500-030", "Porto Alegre", "RS", "Brasil");
        ArrayList<Endereco> enderecoscliente1 = new ArrayList<>();
        enderecoscliente1.add(endereco1cliente1);
        enderecoscliente1.add(endereco2cliente1);

        //construtor primeiro cliente
        Cliente cliente1 = new Cliente("Nathan Vidal", "234.037.050-72", contatoscliente1, enderecoscliente1);


        //segundo cliente

        //contatos do segundo cliente
        Contato contato1cliente2 = new Contato("Telefone fixo", "33519947", 1);
        Contato contato2cliente2 = new Contato ("Telefone celular", "967471414", 2);
        ArrayList<Contato> contatoscliente2 = new ArrayList<>();
        contatoscliente2.add(contato1cliente2);
        contatoscliente2.add(contato2cliente2);

        //endereços do segundo cliente
        Endereco endereco1cliente2 = new Endereco(1, 470, "Rua Brasil", "Ap 503", "90042-080", "Canoas", "RS", "Brasil");
        Endereco endereco2cliente2 = new Endereco(2, 9000, "Av Pará", "Bloco 1", "93260-040", "Porto Alegre", "RS", "Brasil");
        ArrayList<Endereco> enderecoscliente2 = new ArrayList<>();
        enderecoscliente2.add(endereco1cliente2);
        enderecoscliente2.add(endereco2cliente2);

        //construtor do segundo cliente
        Cliente cliente2 = new Cliente("Marina Fernandez", "042.930.817-74", contatoscliente2, enderecoscliente2);


        //criação das contas

        //conta pagamento do primeiro cliente
        ContaPagamento contapg = new ContaPagamento(cliente1, "9923", "55.325", 900.00);

        //conta corrente do primeiro cliente
        ContaCorrente contac = new ContaCorrente(cliente1, "9423", "35.006", 5000.00, 1000.00);

        //conta poupança do segundo cliente
        ContaPoupanca contapp = new ContaPoupanca(cliente2, "3792", "54.530", 15000.00);


        //imprime clientes
        cliente1.imprimirCliente();
        cliente2.imprimirCliente();

        //imprime contas
        contapg.imprimir();
        contac.imprimir();
        contapp.imprimir();

        //método sacar
        contapg.sacar(500.00);
        contac.sacar(100.00);
        contapp.sacar(50.00);

        //método depositar
        contapg.depositar(500.00);
        contapp.depositar(1000.00);
        contac.depositar(800.00);

        //método transferir
        contapg.transferir(contac, 1000.00);
        contapg.transferir(contac, 500.00);
        contapp.transferir(contapg, 200.00);
        contac.transferir(contapg, 100.00);

        //método creditar taxa
        contapp.creditarTaxa();

        //imprime contas
        contac.imprimir();
        contapp.imprimir();
        contapg.imprimir();
    }
}

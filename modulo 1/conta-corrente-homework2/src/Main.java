public class Main {
    public static void main(String[] args) {
        //primeiro cliente

        //contatos do primeiro cliente
        Contato contato1cliente1 = new Contato("Celular", "99873266", 1);
        Contato contato2cliente1 = new Contato("Telefone para recados", "33966744", 2);

        //endereços do primeiro cliente
        Endereco endereco1cliente1 = new Endereco(1,99,"Rua Araça", "apto101", "93600-001", "Belo Horizonte", "MG","Brasil");
        Endereco endereco2cliente1 = new Endereco(2, 1000, "Av dos Estados", "Q2","92500-030", "Porto Alegre", "RS", "Brasil");

        //construtor primeiro cliente
        Cliente cliente1 = new Cliente("Nathan Vidal", "234.037.050-72", contato1cliente1, contato2cliente1, endereco1cliente1, endereco2cliente1);


        //segundo cliente

        //contatos do segundo cliente
        Contato contato1cliente2 = new Contato("Telefone fixo", "33519947", 1);
        Contato contato2cliente2 = new Contato ("Telefone celular", "967471414", 2);

        //endereços do segundo cliente
        Endereco endereco1cliente2 = new Endereco(1, 470, "Rua Brasil", "Ap 503", "90042-080", "Canoas", "RS", "Brasil");
        Endereco endereco2cliente2 = new Endereco(2, 9000, "Av Pará", "Bloco 1", "93260-040", "Porto Alegre", "RS", "Brasil");

        //construtor do segundo cliente
        Cliente cliente2 = new Cliente("Marina Fernandez", "042.930.817-74", contato1cliente2, contato2cliente2, endereco1cliente2, endereco2cliente2);


        //criação das contas

        //conta corrente do primeiro cliente
        ContaCorrente conta1 = new ContaCorrente(cliente1, "9423", "35.006", 5000.00, 1000.00);

        //conta poupança do segundo cliente
        ContaPoupanca conta2 = new ContaPoupanca(cliente2, "3792", "54.530", 15000.00);


        //imprime clientes
        cliente1.imprimirCliente();
        cliente2.imprimirCliente();

        //imprime contas
        conta1.imprimir();
        conta2.imprimir();

        //método saque
        conta2.sacar(500.00);

        //método saque conta corrente (sobrescrito)
        conta1.sacar(100.00);

        //método depositar
        conta1.depositar(500.00);
        conta2.depositar(1000.00);

        //método transferir
        conta1.transferir(conta2, 1000);
        conta2.transferir(conta1, 200);

        //método creditar taxa
        conta2.creditarTaxa();

        //imprime contas
        conta1.imprimir();
        conta2.imprimir();
    }
}

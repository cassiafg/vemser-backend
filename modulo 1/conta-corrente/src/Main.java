public class Main {
    public static void main(String[] args) {
        //primeiro cliente
        Cliente cliente1 = new Cliente();
        cliente1.nome = "Maria Mattos";
        cliente1.cpf = "234.037.050-72";
        cliente1.contatos[0] = new Contato();
        cliente1.contatos[0].descricao = "Celular";
        cliente1.contatos[0].telefone = "(51) 993544781";
        cliente1.contatos[0].tipo = 1;
        cliente1.contatos[1] = new Contato();
        cliente1.contatos[1].descricao = "Telefone para recados";
        cliente1.contatos[1].telefone = "(41) 936607892";
        cliente1.contatos[1].tipo = 2;
        cliente1.enderecos[0] = new Endereco();
        cliente1.enderecos[0].tipo = 1;
        cliente1.enderecos[0].logradouro = "Av. das Camélias";
        cliente1.enderecos[0].numero = 12;
        cliente1.enderecos[0].complemento = "casa 1";
        cliente1.enderecos[0].cidade = "Canoas";
        cliente1.enderecos[0].estado = "RS";
        cliente1.enderecos[0].pais = "Brasil";
        cliente1.enderecos[0].cep = "90060-000";
        cliente1.enderecos[1] = new Endereco();
        cliente1.enderecos[1].tipo = 2;
        cliente1.enderecos[1].logradouro = "Rua das Oliveiras";
        cliente1.enderecos[1].numero = 6000;
        cliente1.enderecos[1].complemento = "quadra 2";
        cliente1.enderecos[1].cidade = "Novo Hamburgo";
        cliente1.enderecos[1].estado = "RS";
        cliente1.enderecos[1].pais = "Brasil";
        cliente1.enderecos[1].cep = "90330-000";

        //segundo cliente
        Cliente cliente2 = new Cliente();
        cliente2.nome = "Jorge Ramos";
        cliente2.cpf = "578.913.610-96";
        cliente2.contatos[0] = new Contato();
        cliente2.contatos[0].descricao = "Telefone comercial";
        cliente2.contatos[0].telefone = "(51) 33113434";
        cliente2.contatos[0].tipo = 2;
        cliente2.contatos[1] = new Contato();
        cliente2.contatos[1].descricao = "Telefone residencial";
        cliente2.contatos[1].telefone = "(51) 30143300";
        cliente2.contatos[1].tipo = 1;
        cliente2.enderecos[0] = new Endereco();
        cliente2.enderecos[0].tipo = 1;
        cliente2.enderecos[0].logradouro = "Rua Cabral";
        cliente2.enderecos[0].numero = 908;
        cliente2.enderecos[0].complemento = "ap 601";
        cliente2.enderecos[0].cidade = "Porto Alegre";
        cliente2.enderecos[0].estado = "RS";
        cliente2.enderecos[0].pais = "Brasil";
        cliente2.enderecos[0].cep = "90407-050";
        cliente2.enderecos[1] = new Endereco();
        cliente2.enderecos[1].tipo = 2;
        cliente2.enderecos[1].logradouro = "Rua Getúlio Vargas";
        cliente2.enderecos[1].numero = 8600;
        cliente2.enderecos[1].complemento = "lote 1";
        cliente2.enderecos[1].cidade = "Sapucaia do Sul";
        cliente2.enderecos[1].estado = "RS";
        cliente2.enderecos[1].pais = "Brasil";
        cliente2.enderecos[1].cep = "93030-100";

        //conta corrente do primeiro cliente
        ContaCorrente conta1 = new ContaCorrente();
        conta1.cliente = cliente1;
        conta1.agencia = 1362;
        conta1.numeroConta = "35.938";
        conta1.saldo = 2500.00;
        conta1.chequeEspecial = 1000.00;

        //conta corrente do segundo cliente
        ContaCorrente conta2 = new ContaCorrente();
        conta2.cliente = cliente2;
        conta2.agencia = 9700;
        conta2.numeroConta = "92.380";
        conta2.saldo = 500.00;
        conta2.chequeEspecial = 300.00;

        //sacar valor
        conta1.sacar(100.00, conta1.saldo);

        //depositar valor
        conta2.depositar(200.00);

        //saldo com cheque especial
        conta1.retornarSaldoComChequeEspecial(conta1.saldo, conta1.chequeEspecial);

        //transferencia
        conta1.transferir(conta2, 100.00);

        //imprimir contas
        conta1.imprimirContaCorrente();
        conta2.imprimirContaCorrente();
    }
}

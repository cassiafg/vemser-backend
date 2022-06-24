public class ContaPoupanca extends Conta implements Impressao{
    //atributos da conta poupança
    static final double JUROS_MENSAL = 1.01;

    //construtor
    public ContaPoupanca(Cliente cliente, String agencia, String numeroConta, double saldo) {
        super(cliente, agencia, numeroConta, saldo);
    }

    //métodos da conta poupança

    //creditar taxa
    public void creditarTaxa(){
        setSaldo(getSaldo()*JUROS_MENSAL);
        System.out.println("-----Juros Mensal-----");
        System.out.println("Saldo atualizado da poupança : "+getSaldo());
    }


    //método impressão
    public void imprimir(){
        System.out.println("----------Conta Poupança----------");
        System.out.println("Cliente: "+getCliente());
        System.out.println("Agência: "+getAgencia()+" Conta: "+getNumeroConta());
        System.out.println("Saldo: "+ getSaldo());
        System.out.println("-----------------------------------");
    }
}

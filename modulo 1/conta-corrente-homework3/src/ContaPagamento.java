public class ContaPagamento extends Conta implements Impressao{
    //atributos da conta de pagamento

    static final double TAXA_SAQUE = 4.25;

    //construtor
    public ContaPagamento(Cliente cliente, String agencia, String numeroConta, double saldo){
        super(cliente, agencia, numeroConta, saldo);
    }

    //métodos da conta de pagamentos

    //método sacar sobrescrito
    @Override
    public boolean sacar(double valor) {
        if (valor <= (getSaldo()+TAXA_SAQUE) && valor > 0) {
            setSaldo(getSaldo() - (valor+TAXA_SAQUE));
            System.out.println("----------Saque----------");
            System.out.println("Valor: " + valor);
            System.out.println("Taxa saque: " +TAXA_SAQUE);
            System.out.println("Saldo atual: " + getSaldo());
            return true;
        } else {
            System.out.println("Saldo insuficiente, saque não realizado");
            return false;
        }
    }

    //método impressão
    public void imprimir(){
        System.out.println("----------Conta Pagamento----------");
        System.out.println("Cliente: "+this.getCliente());
        System.out.println("Agência: "+this.getAgencia()+" Conta: "+this.getNumeroConta());
        System.out.println("Saldo: "+ this.getSaldo());
        System.out.println("-----------------------------------");
    }

}

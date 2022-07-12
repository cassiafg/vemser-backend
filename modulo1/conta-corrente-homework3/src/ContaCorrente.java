public class ContaCorrente extends Conta implements Impressao {
    //atributos da conta corrente
    private double chequeEspecial;

    //métodos da conta corrente

    //construtor da conta corrente
    public ContaCorrente(Cliente cliente, String agencia, String numeroConta, double saldo, double chequeEspecial){
        super(cliente, agencia, numeroConta, saldo);
        this.chequeEspecial = chequeEspecial;
    }

    //retornar saldo com cheque especial
    double retornarSaldoComChequeEspecial() {
        return this.getSaldo() + this.chequeEspecial;
    }

    //set cheque especial

    public void setChequeEspecial(double chequeEspecial) {
        this.chequeEspecial = chequeEspecial;
    }

    //método sacar sobrescrito
    @Override
    public boolean sacar(double valor) {
       if (valor <= retornarSaldoComChequeEspecial() && valor > 0) {
            setSaldo(getSaldo() - valor);
            System.out.println("----------Saque----------");
            System.out.println("Valor: " + valor);
            System.out.println("Saldo atual: " + getSaldo());
            System.out.println("Saldo disponível (saldo + cheque especial): "+retornarSaldoComChequeEspecial());
            return true;
        } else {
            System.out.println("Saldo insuficiente, saque não realizado");
            return false;
        }
    }

    //método impressão
    public void imprimir(){
        System.out.println("----------Conta Corrente----------");
        System.out.println("Cliente: "+this.getCliente());
        System.out.println("Agência: "+this.getAgencia()+" Conta: "+this.getNumeroConta());
        System.out.println("Saldo: "+ this.getSaldo());
        System.out.println("Saldo + cheque especial: "+ retornarSaldoComChequeEspecial());
        System.out.println("-----------------------------------");
    }
}
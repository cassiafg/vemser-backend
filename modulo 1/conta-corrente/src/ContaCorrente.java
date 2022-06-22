public class ContaCorrente {
    //atributos da conta corrente
    Cliente cliente;
    String numeroConta;
    int agencia;
    double saldo, chequeEspecial;

    //métodos da conta corrente
    //método imprime conta corrente
    void imprimirContaCorrente(){
        System.out.println("------------Conta Corrente-----------");
        System.out.println("Cliente: "+cliente);
        System.out.println("Agência "+agencia+" Conta: "+numeroConta);
        System.out.println("Saldo: "+saldo+" Cheque Especial: "+chequeEspecial);
        System.out.println("Valor disponível: "+retornarSaldoComChequeEspecial(this.saldo, this.chequeEspecial));
    }

    //método sacar
    boolean sacar(double valor, double saldo){
        if(saldo>=valor){
            this.saldo -= valor;
            return true;
        }else{
            return false;
        }
    }

    //método depositar
    boolean depositar(double valor){
        if(valor>0){
            this.saldo += valor;
            return true;
        }else{
            return false;
        }
    }

    //método retornar saldo com cheque especial
    double retornarSaldoComChequeEspecial(double saldo, double chequeEspecial){
        return saldo + chequeEspecial;
    }

    //método transferir
    boolean transferir(ContaCorrente conta, double valor){
        if (valor>0 && valor<=this.saldo){
            this.saldo -= valor;
            conta.saldo += valor;
            return true;
        }else{
            return false;
        }
    }

    //método toString
    public String toString(){
        return "Agência: "+agencia+", Conta: "+numeroConta;
    }
}

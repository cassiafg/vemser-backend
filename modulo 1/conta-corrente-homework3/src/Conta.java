public abstract class Conta implements Movimentacao{
    //atributos da conta
    private Cliente cliente;
    private String numeroConta;
    private String agencia;
    private double saldo;

    //construtor da conta
    public Conta(Cliente cliente, String agencia, String numeroConta, double saldo) {
        this.cliente = cliente;
        this.agencia = agencia;
        this.numeroConta = numeroConta;
        this.saldo = saldo;
    }

    //métodos interface movimentação

    //sacar
    public boolean sacar(double valor){
        if (valor <= this.getSaldo() && valor >0){
            setSaldo(getSaldo()-valor);
            System.out.println("----------Saque----------");
            System.out.println("Valor: "+valor);
            System.out.println("Conta: "+getNumeroConta());
            System.out.println("Saldo atual: "+getSaldo());
            return true;
        }else{
            System.out.println("Saldo insuficiente, saque não realizado");
            return false;
        }
    }

    //depositar
    public boolean depositar(double valor){
        if (valor > 0){
            this.setSaldo(getSaldo()+valor);
            System.out.println("----------Deposito----------");
            System.out.println("Valor: "+valor);
            System.out.println("Conta: "+this.getNumeroConta());
            System.out.println("Saldo atual: "+this.getSaldo());
            return true;
        }else{
            System.out.println("Depósito não realizado");
            return false;
        }
    }

    //transferir
    public boolean transferir (Conta conta, double valor) {
        if (this.sacar(valor)) {
            conta.depositar(valor);
            System.out.println("----------Transferência----------");
            System.out.println("Valor: " + valor);
            System.out.println("Conta de origem: " + this.getNumeroConta());
            System.out.println("Conta de destino: " + conta.getNumeroConta());
            return true;
        } else {
            System.out.println("Transferência não realizada");
            return false;
        }
    }

    //getters e setters
    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    public String getNumeroConta() {
        return numeroConta;
    }

    public void setNumeroConta(String numeroConta) {
        this.numeroConta = numeroConta;
    }

    public String getAgencia() {
        return agencia;
    }

    public void setAgencia(String agencia) {
        this.agencia = agencia;
    }

    public double getSaldo() {
        return saldo;
    }

    public void setSaldo(double saldo) {
        this.saldo = saldo;
    }
    }

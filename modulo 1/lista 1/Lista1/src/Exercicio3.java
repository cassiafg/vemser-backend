import java.util.Locale;
import java.util.Scanner;

public class Exercicio3 {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        sc.useLocale(Locale.US);
        System.out.println("Digite o valor total consumido: ");
        float valorConsumido = sc.nextFloat();
        sc.nextLine();
        System.out.println("Digite o valor pago pelo cliente: ");
        float valorPago = sc.nextFloat();
        sc.nextLine();
        float troco = valorPago - valorConsumido;
        if (valorPago < valorConsumido){
            System.out.println("o valor pago deve ser maior ou igual ao valor consumido");
        }else{
            System.out.println("o troco é de R$" + troco);
        }
    }
}

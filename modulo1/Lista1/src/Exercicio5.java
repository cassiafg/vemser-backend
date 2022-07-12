import java.util.Locale;
import java.util.Scanner;

public class Exercicio5 {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        sc.useLocale(Locale.US);
        System.out.println("---------------------------------");
        System.out.println("----------SALÁRIO BRUTO----------");
        System.out.println("---------------------------------");
        System.out.println("Informe o valor da hora: R$ ");
        float valorHora = sc.nextFloat();
        System.out.println("Informe o número de horas normais trabalhadas: ");
        float horasNormais = sc.nextFloat();
        System.out.println("Informe o número de horas extras 50% trabalhadas: ");
        float extras50 = sc.nextFloat();
        System.out.println("Informe o número de horas extras 100% trabalhadas: ");
        float extras100 = sc.nextFloat();
        float salarioBruto = (horasNormais * valorHora) + (extras50 * valorHora * 1.5f) + (extras100 * valorHora * 2);
        System.out.println("O valor do Salário Bruto é R$ " + salarioBruto);
    }
}

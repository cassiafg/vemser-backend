import java.util.Locale;
import java.util.Scanner;

public class Exercicio2 {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        sc.useLocale(Locale.US);
        System.out.println("Digite a primeira nota: ");
        float nota1 = sc.nextFloat();
        sc.nextLine();
        System.out.println("Digite a segunda nota: ");
        float nota2 = sc.nextFloat();
        sc.nextLine();
        System.out.println("Digite a terceira nota: ");
        float nota3 = sc.nextFloat();
        sc.nextLine();
        System.out.println("Digite a quarta nota: ");
        float nota4 = sc.nextFloat();
        sc.nextLine();
        float media = (nota1 + nota2 + nota3 + nota4)/4;
        if ((media > 0) && (media < 5)) {
            System.out.println("Reprovado");
        }else if ((media > 5.1) && (media < 6.9)) {
            System.out.println("Em exame");
        }else if ((media > 7.0) && (media < 10)){
            System.out.println("Aprovado");
    }}
}

import java.util.Scanner;

public class Exercicio9 {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        System.out.println("----------------------------------");
        System.out.println("-----Cálculo da idade em dias-----");
        System.out.println("----------------------------------");
        System.out.println("Informe a idade em anos: ");
        int idadeAnos = sc.nextInt();
        sc.nextLine();
        System.out.println("Informe a idade em meses: ");
        int idadeMeses = sc.nextInt();
        sc.nextLine();
        System.out.println("Informe a idade em dias: ");
        int idadeDias = sc.nextInt();
        sc.nextLine();
        int idadeTotalEmDias = idadeDias + idadeMeses*30 + idadeAnos*365;
        System.out.println("A idade expressa em dias é " +idadeTotalEmDias);
    }
}

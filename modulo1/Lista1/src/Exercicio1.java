import java.util.Scanner;

public class Exercicio1 {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        System.out.println("Informe o seu nome: ");
        String nome = sc.nextLine();
        System.out.println("Informe a sua idade: ");
        int idade = sc.nextInt();
        sc.nextLine();
        System.out.println("Informe a sua cidade: ");
        String cidade = sc.nextLine();
        System.out.println("Informe o seu estado");
        String estado = sc.nextLine();
        System.out.println("Olá, se nome é " + nome + ", você tem " + idade + " anos, é da cidade de " + cidade + ", situada no estado de " + estado + ".");
    }
}

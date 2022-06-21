import java.util.Scanner;

public class Exercicio2 {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        System.out.println("Pessoa 1 - digite um número: ");
        int numeroP1 = sc.nextInt();
        sc.nextLine();
        int numeroP2 = 0;
        do {
            System.out.println("Pessoa 2 - tente adivinhar o número: ");
            numeroP2 = sc.nextInt();
            sc.nextLine();
            if (numeroP1 == numeroP2){
                System.out.println("Parabéns! Você acertou");
            }else if (numeroP1 > numeroP2) {
                System.out.println("O número a ser encontrado é maior do que você digitou");
            }else if (numeroP1 < numeroP2) {
                System.out.println("O número a ser encontrado é menor do que você digitou");
            }
    }while(numeroP1 != numeroP2);
}}

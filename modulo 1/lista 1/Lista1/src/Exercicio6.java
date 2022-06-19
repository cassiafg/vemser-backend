import java.util.Scanner;

public class Exercicio6 {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        System.out.println("---------------------------------");
        System.out.println("-------------TRADUTOR------------");
        System.out.println("---------------------------------");
        System.out.println("Escolha:");
        System.out.println("1 - Tradutor de inglês para português");
        System.out.println("2 - Tradutor de português para inglês");
        int tradutor = sc.nextInt();
        sc.nextLine();
        switch(tradutor){
            case 1 -> {
                System.out.println("Tradutor de inglês para português");
                System.out.println("Escolha a palavra:");
                System.out.println("1 - Dog");
                System.out.println("2 - Time");
                System.out.println("3 - Love");
                System.out.println("4 - City");
                System.out.println("5 - Happy");
                System.out.println("6 - Sad");
                System.out.println("7 - Should");
                System.out.println("8 - Could");
                int palavra1 = sc.nextInt();
                sc.nextLine();
                switch(palavra1){
                    case 1 -> {
                        System.out.println("Cachorro");
                    }
                    case 2 -> {
                        System.out.println("Tempo");
                    }
                    case 3 -> {
                        System.out.println("Amor");
                    }
                    case 4 -> {
                        System.out.println("Cidade");
                    }
                    case 5 -> {
                        System.out.println("Feliz");
                    }
                    case 6 -> {
                        System.out.println("Triste");
                    }
                    case 7 -> {
                        System.out.println("Deveria");
                    }
                    case 8 -> {
                        System.out.println("Poderia");
                    }
                    default -> {
                        System.out.println("Essa palavra não é válida");
                    }
                }
            }
            case 2 -> {
                System.out.println("Tradutor de português para inglês");
                System.out.println("Escolha a palavra:");
                System.out.println("1 - Cachorro");
                System.out.println("2 - Tempo");
                System.out.println("3 - Amor");
                System.out.println("4 - Cidade");
                System.out.println("5 - Feliz");
                System.out.println("6 - Triste");
                System.out.println("7 - Deveria");
                System.out.println("8 - Poderia");
                int palavra2 = sc.nextInt();
                sc.nextLine();
                switch(palavra2){
                    case 1 -> {
                        System.out.println("Dog");
                    }
                    case 2 -> {
                        System.out.println("Time");
                    }
                    case 3 -> {
                        System.out.println("Love");
                    }
                    case 4 -> {
                        System.out.println("City");
                    }
                    case 5 -> {
                        System.out.println("Happy");
                    }
                    case 6 -> {
                        System.out.println("Sad");
                    }
                    case 7 -> {
                        System.out.println("Should");
                    }
                    case 8 -> {
                        System.out.println("Could");
                    }
                    default -> {
                        System.out.println("Essa palavra não é válida");
                    }
                }
            }
            default -> {
                System.out.println("Código inválido, digite novamente");
            }
        }
    }
}

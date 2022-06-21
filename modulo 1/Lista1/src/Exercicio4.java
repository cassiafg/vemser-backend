import java.util.Scanner;

public class Exercicio4 {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        System.out.println("Escolha um estado e digite o número correspondente ao estado escolhido: ");
        System.out.println("1 - Rio Grande do Sul");
        System.out.println("2 - Santa Catarina");
        System.out.println("3 - Paraná");
        int estado = sc.nextInt();
        sc.nextLine();
        switch(estado){
            case 1 -> {
                System.out.println("Rio Grande do Sul");
                System.out.println("Agora escolha uma cidade: ");
                System.out.println("1 - Porto Alegre");
                System.out.println("2 - Pelotas");
                int cidade = sc.nextInt();
                sc.nextLine();
                switch(cidade){
                    case 1 -> {
                        System.out.println("Porto Alegre");
                        System.out.println("População: 1.492.530 pessoas");
                        System.out.println("Área total: 495,390 km²");
                        System.out.println("IDH: 0.805");
                        System.out.println("Principal festa: Aniversário da cidade");
                    }
                    case 2 -> {
                        System.out.println("Pelotas");
                        System.out.println("População: 328.275 pessoas");
                        System.out.println("Área total: 1.609,708 km²");
                        System.out.println("IDH: 0.739");
                        System.out.println("Principal festa: Festa Nacional do Doce");
                    }
                    default -> {
                        System.out.println("Cidade inválida, digite novamente");
                    }
                }

            }
            case 2 -> {
                System.out.println("Santa Catarina");
                System.out.println("Agora escolha uma cidade: ");
                System.out.println("1 - Florianópolis");
                System.out.println("2 - Blumenau");
                int cidade = sc.nextInt();
                sc.nextLine();
                switch(cidade){
                    case 1 -> {
                        System.out.println("Florianópolis");
                        System.out.println("População: 421.240 pessoas");
                        System.out.println("Área total: 674,844 km²");
                        System.out.println("IDH: 0.847");
                        System.out.println("Principal festa: Aniversário da cidade");
                    }
                    case 2 -> {
                        System.out.println("Blumenau");
                        System.out.println("População: 309.011 pessoas");
                        System.out.println("Área total: 518,619 km²");
                        System.out.println("IDH: 0.806");
                        System.out.println("Principal festa: Oktoberfest");
                    }
                    default -> {
                        System.out.println("Cidade inválida, digite novamente");
                    }
                }

            }
            case 3 -> {
                System.out.println("Paraná");
                System.out.println("Agora escolha uma cidade: ");
                System.out.println("1 - Curitiba");
                System.out.println("2 - Foz do Iguaçu");
                int cidade = sc.nextInt();
                sc.nextLine();
                switch(cidade){
                    case 1 -> {
                        System.out.println("Curitiba");
                        System.out.println("População: 1.751.907 pessoas");
                        System.out.println("Área total: 434,892 km²");
                        System.out.println("IDH: 0.823");
                        System.out.println("Principal festa: Festa de Nossa Senhora do Rocio");
                    }
                    case 2 -> {
                        System.out.println("Foz do Iguaçu");
                        System.out.println("População: 256.088 pessoas");
                        System.out.println("Área total: 618,057 km²");
                        System.out.println("IDH: 0.751");
                        System.out.println("Principal festa: FARTAL - Feira de Artesanatos e Alimentos");
                    }
                    default -> {
                        System.out.println("Cidade inválida, digite novamente");
                    }
                }
            }
            default -> {
                System.out.println("Estado inválido, digite novamente");
            }
        }
    }
}

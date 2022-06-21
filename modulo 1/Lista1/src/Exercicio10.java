import java.util.Scanner;

public class Exercicio10 {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        System.out.println("----------------------------------");
        System.out.println("-------Percentual de votos--------");
        System.out.println("----------------------------------");
        System.out.println("Informe o número total de eleitores do município: ");
        float numeroEleitores = sc.nextFloat();
        sc.nextLine();
        System.out.println("Informe o número de votos brancos: ");
        float votosBrancos = sc.nextFloat();
        sc.nextLine();
        System.out.println("Informe o número de votos nulos: ");
        float votosNulos = sc.nextFloat();
        sc.nextLine();
        System.out.println("Informe o número de votos válidos: ");
        float votosValidos = sc.nextFloat();
        sc.nextLine();
        float percentualBrancos = (votosBrancos / numeroEleitores) * 100;
        float percentualNulos = (votosNulos / numeroEleitores) * 100;
        float percentualValidos = (votosValidos / numeroEleitores ) * 100;
        System.out.println("Percentual de votos brancos: " +percentualBrancos + "%");
        System.out.println("Percentual de votos nulos: " +percentualNulos +"%");
        System.out.println("Percentual de votos válidos: " +percentualValidos + "%");

    }
}

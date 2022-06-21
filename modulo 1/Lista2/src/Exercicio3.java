import java.util.Locale;
import java.util.Scanner;

public class Exercicio3 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        sc.useLocale(Locale.US);
        String nomeJogador = "nome";
        float alturaJogador = 0;
        float maior = 0;
        float soma = 0;
        float media = 0;
        int contador = 0;
        int idade = 0;
        int maiorIdade = 0;
        String maisVelho = "nome";
        float peso = 0;
        float maiorPeso = 0;
        String maisPesado = "nome";
        while (!nomeJogador.equals("SAIR")) {
            System.out.println("Digite o nome do jogador: ");
            nomeJogador = sc.nextLine();
            if (nomeJogador.equals("SAIR")){
                break;
            }else{
                contador++;
            }
            System.out.println("Digite a altura do jogador: ");
            alturaJogador = sc.nextFloat();
            sc.nextLine();
            if (alturaJogador > maior){
                maior = alturaJogador;
            }
            soma += alturaJogador;
            media = soma / contador;
            System.out.println("Digite a idade do jogador: ");
            idade = sc.nextInt();
            sc.nextLine();
            if (idade > maiorIdade){
                maiorIdade = idade;
                maisVelho = nomeJogador;
            }
            System.out.println("Digite o peso do jogador: ");
            peso = sc.nextFloat();
            sc.nextLine();
            if (peso > maiorPeso){
                maiorPeso = peso;
                maisPesado = nomeJogador;
            }
        }
        System.out.println("Quantidade de jogadores cadastrados: "+contador);
        System.out.println("Altura do maior jogador: "+maior+"m");
        System.out.println("Jogador mais velho: "+maisVelho);
        System.out.println("Jogador mais pesado "+maisPesado);
        System.out.println("Média das alturas dos jogadores: "+media);
    }

}


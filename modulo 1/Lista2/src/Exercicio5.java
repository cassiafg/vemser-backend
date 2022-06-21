import java.util.Scanner;

public class Exercicio5 {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int i = 0;
        int[] vetor = new int[20];
        for(i=0; i<vetor.length; i++){
            System.out.println("Digite o "+(i+1)+"º valor: ");
            vetor[i] = sc.nextInt();
            sc.nextLine();
        }
        for(i = vetor.length-1; i>=0;i--){
            System.out.println(vetor[i]);
        }
    }
}

import java.util.Scanner;

public class Ex3 {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        System.out.println("Digite a quantidade de elementos desejada: ");
        int elementosVetor = sc.nextInt();
        sc.nextLine();
        int[] vetor = new int[elementosVetor];
        for(int i=0; i<elementosVetor;i++){
            System.out.println("Digite o elemento "+i+":");
            vetor[i] = sc.nextInt();
            sc.nextLine();
        }
        System.out.println("Vetor =");
        for (int elem : vetor){
            System.out.println(elem);
        }
        int soma = 0;
        for(int i=0; i<elementosVetor;i++){
            soma = vetor[i] + soma;
        }
        int media = soma / elementosVetor;
        System.out.println("A média dos valores do vetor é " +media);
    }
}

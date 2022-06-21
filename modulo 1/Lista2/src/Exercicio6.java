import java.util.Scanner;

public class Exercicio6 {
    public static void main(String[] args) {
        int[] vetor = {2, 4, 6, 8, 10, 12, 14, 16, 18, 20};
        Scanner sc = new Scanner(System.in);
        System.out.println("Digite um número para buscar no vetor: ");
        int num = sc.nextInt();
        sc.nextLine();
        for (int i = 0; i<vetor.length;i++)
            if (vetor[i] == num) {
                System.out.println("O número digitado existe no vetor.");
                break;
            } else {
                System.out.println("O número digitado não existe no vetor.");
                break;
            }
    }
}

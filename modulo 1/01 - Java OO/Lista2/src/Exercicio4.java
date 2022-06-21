import java.util.Scanner;

public class Exercicio4 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int i = 3;
        int[] numeros = new int[i];
        System.out.println("Digite o primeiro valor: ");
        numeros[0] = sc.nextInt();
        sc.nextLine();
        System.out.println("Digite o segundo valor: ");
        numeros[1] = sc.nextInt();
        sc.nextLine();
        System.out.println("Digite o terceiro valor: ");
        numeros[2] = sc.nextInt();
        sc.nextLine();
        int menor = numeros[0];
        int posicao = 0;
        for (i=0; i<numeros.length;i++){
            if (numeros[i] < menor) {
                menor = numeros[i];
                posicao = i;
            }
        }
        System.out.println("A posição do menor número é a " +(posicao+1));
    }
}

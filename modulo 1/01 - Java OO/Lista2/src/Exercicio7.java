import java.util.Scanner;

public class Exercicio7 {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int [][] matriz={
                {1, 2, 3, 4},
                {5, 6, 7, 8},
                {9, 10, 11, 12},
                {13, 14, 15, 16},
        };
        int contagem = 0;
        for (int i = 0; i< matriz.length; i++)
        {
            for (int j = 0; j<matriz[i].length; j++)
            {
                if (matriz[i][j] > 10){
                    contagem++;
                }
            }
        }
        System.out.println(contagem);
    }
}

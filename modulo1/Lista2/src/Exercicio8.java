import java.util.Locale;
import java.util.Scanner;

public class Exercicio8 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        sc.useLocale(Locale.US);
        double [][] matriz = new double [5][4];
        double notaFinal = 0;
        double somaNotaFinal = 0;
        double maiorNota = 0;
        double matriculaMaiorNota = 0;

        for (int i=0;i<matriz.length;i++){
            for(int j=0;j<matriz[i].length;j++){
                if (j == 0) {
                    System.out.println("Digite o número da matrícula: ");
                    matriz[i][j] = sc.nextInt();
                }else if (j == 1){
                    System.out.println("Digite a média das provas: ");
                    matriz[i][j] = sc.nextInt();
                }else if (j == 2){
                    System.out.println("Digite a média dos trabalhos: ");
                    matriz[i][j] = sc.nextInt();
                }}}

        for (int i = 0; i<5; i++){
            matriz[i][3] = (matriz[i][1]*0.6) + (matriz[i][2]*0.4);
                if (matriz [i][3] > maiorNota){
                  maiorNota = matriz[i][3];
                  matriculaMaiorNota = matriz[i][0];
                }
        }
        somaNotaFinal = matriz[0][3]+matriz[1][3]+matriz[2][3]+matriz[3][3]+matriz[4][3];
        double mediaNotaFinal = somaNotaFinal/5;
        System.out.println("A matrícula "+matriculaMaiorNota+" obteve a maior nota final");
        System.out.println("A média das notas finais foi: "+mediaNotaFinal);

    }}

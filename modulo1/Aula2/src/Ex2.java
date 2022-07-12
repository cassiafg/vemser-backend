public class Ex2 {
    public static void main(String[]args){
        int [][] matriz = {
                {2, 4},
                {6, 8}
        };
        int somaTotal = matriz[0][0] + matriz[0][1] + matriz[1][0] + matriz[1][1];
        int somaLinha1 = matriz[0][0] + matriz[0][1];
        int somaLinha2 = matriz [1][0] + matriz[1][1];
        int somaL1MenosL2 = somaLinha1 - somaLinha2;
        System.out.println("Soma de todos os elementos = "+somaTotal);
        System.out.println("Soma dos elementos da primeira linha = "+somaLinha1);
        System.out.println("Soma dos elementos da segunda linha = " +somaLinha2);
        System.out.println("Soma dos valores da primeira linha - soma dos valores da segunda linha = "+somaL1MenosL2);
    }
}

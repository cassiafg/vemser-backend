public class Ex1 {
    public static void main(String[] args){
        int [] vetor = new int[3];
        vetor[0] = 2;
        vetor[1] = 4;
        vetor[2] = 6;
        int soma = vetor[0] + vetor[1] + vetor[2];
        int media = soma/3;
        System.out.println("Soma = "+soma);
        System.out.println("Média = "+media);
    }
}

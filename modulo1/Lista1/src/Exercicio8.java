import java.util.Scanner;

public class Exercicio8 {
    static public void main(String[] args){
        Scanner sc = new Scanner(System.in);
        System.out.println("---------------------------");
        System.out.println("-----Área do Retângulo-----");
        System.out.println("---------------------------");
        System.out.println("Informe a base: ");
        float base = sc.nextFloat();
        System.out.println("Informe a altura: ");
        float altura = sc.nextFloat();
        float area = base * altura;
        System.out.println("Área do retângulo = " + area);
    }
}

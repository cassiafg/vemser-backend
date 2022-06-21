import java.util.Locale;
import java.util.Scanner;

public class Exercicio1 {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        sc.useLocale(Locale.US);
        System.out.println("Digite o nome do produto: ");
        String nomeProduto = sc.nextLine();
        System.out.println("Digite o valor do produto: ");
        float valorProduto = sc.nextFloat();
        sc.nextLine();
        System.out.println("Produto: "+nomeProduto);
        System.out.println("Preço: R$ "+valorProduto);
        System.out.println("Promoção: "+nomeProduto);
        System.out.println("---------------------------");
        float desconto = 0;
        float valorComDesconto = 0;
        for (int i =0; i<10; i++){
            desconto += 0.05;
            valorComDesconto = valorProduto - (valorProduto*desconto);
            System.out.printf("%d X R$ %.2f = R$ %.2f%n",i+1, valorComDesconto, valorComDesconto*(i+1));
        }


    }
}

import java.util.Scanner;

public class Ex4 {
    public static void main (String[] args){
        Scanner sc = new Scanner(System.in);
        String palavra = "palavra";
        do{System.out.println("Digite uma palavra: ");
        palavra = sc.nextLine();}
        while(!palavra.equals("fim"));
        }

    }

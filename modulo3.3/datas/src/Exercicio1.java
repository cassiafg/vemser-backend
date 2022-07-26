import java.time.LocalDate;
import java.time.Period;
import java.util.Scanner;

public class Exercicio1 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Digite o dia do aniverário: ");
        Integer dia = sc.nextInt();
        sc.nextLine();
        System.out.println("Digite o mês do aniversário: ");
        Integer mes = sc.nextInt();
        sc.nextLine();
        System.out.println("Digite o ano do seu próximo aniversário: ");
        Integer ano = sc.nextInt();
        LocalDate aniversario = LocalDate.of(ano, mes, dia);
        LocalDate agora = LocalDate.now();
        if (agora.isBefore(aniversario)) {
            Period periodo = Period.between(agora, aniversario);
            Integer qntosDias = periodo.getDays();
            Integer qntosMeses = periodo.getMonths();
            System.out.println("Faltam "+qntosDias+" dias e "+qntosMeses+" meses para o seu aniversário!");
        }else{
            Period periodo = Period.between(aniversario, agora);
            Integer qntosDias = periodo.getDays();
            Integer qntosMeses = periodo.getMonths();
            System.out.println("Faltam "+qntosDias+" dias e "+qntosMeses+" meses para o seu aniversário!");
        }

    }
}

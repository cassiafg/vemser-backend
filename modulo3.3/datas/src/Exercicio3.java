import java.time.LocalDate;
import java.time.LocalDateTime;

public class Exercicio3 {
    public static void main(String[] args) {
        LocalDateTime agora = LocalDateTime.now();
        LocalDateTime agora15d = agora.plusDays(15);
        LocalDateTime agora15d10h = agora15d.plusHours(10);
        System.out.println("O dia da semana é: "+agora15d10h.getDayOfWeek());
        System.out.println("O dia do ano (corrido) é: "+agora15d10h.getDayOfYear());
    }
}

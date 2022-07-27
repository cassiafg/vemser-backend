import java.time.LocalDate;
import java.time.Period;

public class Exercicio2 {
    public static void main(String[] args) {
        LocalDate data1 = LocalDate.of(2020, 5, 20);
        LocalDate data2 = LocalDate.of(2022, 4, 8);

        Period periodo = Period.between(data1, data2);
        int dias = periodo.getDays();
        int meses = periodo.getMonths();
        int anos = periodo.getYears();

        System.out.println("Dias: "+dias);
        System.out.println("Meses: "+meses);
        System.out.println("Anos: "+anos);
    }
}

package modelo;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class FormatarDataHorario {

    public static String formatoDataEHora(LocalDateTime horario) {
        DateTimeFormatter formatoDataEHora = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm");
        String horarioFormatado = horario.format(formatoDataEHora);
        return horarioFormatado;
    }
}

package modelo;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;

public class DetalhesEmprestimoCarro {
    private String local;

    private LocalDateTime dataEHoraEmprestimo;


    public DetalhesEmprestimoCarro(String local, LocalDateTime dataEHoraEmprestimo) {
        this.local = local;
        this.dataEHoraEmprestimo = dataEHoraEmprestimo;
    }

    public String getLocal() {
        return local;
    }

    public LocalDateTime getDataEHoraEmprestimo() {
        return dataEHoraEmprestimo;
    }
}



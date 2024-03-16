package modelo;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.temporal.ChronoUnit;

public class CalculaValorDaDevolucao {


   public static Long calcularDiarias(VeiculoAlugado veiculoAlugado, LocalDateTime dataEHorarioDevolucao) {

        LocalDateTime dataEHorarioAluguel = veiculoAlugado.getDetalhesEmprestimoCarro().getDataEHoraEmprestimo();

        return ChronoUnit.DAYS.between(dataEHorarioAluguel, dataEHorarioDevolucao) + 1;
    }
    public static BigDecimal calcularValorDaDevolucao(VeiculoAlugado veiculoAlugado,Long diarias){
       Double valorAntesDesconto = null;
       BigDecimal valorFinal = null;
       if(veiculoAlugado.getClienteQueAlugou().getTipo().equals("FISICO") && diarias > 5){
           valorAntesDesconto = veiculoAlugado.getVeiculoQueFoiAlugado().getTaxa() * diarias;
           valorFinal = BigDecimal.valueOf(valorAntesDesconto - (valorAntesDesconto * 0.05));
       }else if(veiculoAlugado.getClienteQueAlugou().getTipo().equals("FISICO") && diarias < 6){
            valorFinal = BigDecimal.valueOf(veiculoAlugado.getVeiculoQueFoiAlugado().getTaxa() * diarias);
    }
         if(veiculoAlugado.getClienteQueAlugou().getTipo().equals("JURIDICO") && diarias > 3 ){
            valorAntesDesconto = veiculoAlugado.getVeiculoQueFoiAlugado().getTaxa() * diarias;
             valorFinal = BigDecimal.valueOf(valorAntesDesconto - (valorAntesDesconto * 0.10));
        }else if(veiculoAlugado.getClienteQueAlugou().getTipo().equals("FISICO") && diarias < 4){
            valorFinal = BigDecimal.valueOf(veiculoAlugado.getVeiculoQueFoiAlugado().getTaxa() * diarias);
        }
         return valorFinal;


       }

}



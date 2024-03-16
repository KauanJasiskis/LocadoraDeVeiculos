package view.emprestimos;

import modelo.CalculaValorDaDevolucao;
import modelo.VeiculoAlugado;
import repositorio.exception.RepositorioException;
import service.services.AlugarVeiculoService;
import service.services.ClienteService;
import service.services.DevolverVeiculoService;
import service.services.VeiculoService;
import view.ScannerSingleton;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class DevolucaoCarro {
    private VeiculoService veiculoService;
    private ClienteService clienteService;



    private DevolverVeiculoService devolverVeiculoService;

    public DevolucaoCarro(VeiculoService veiculoService, ClienteService clienteService, DevolverVeiculoService devolverVeiculoService) {
        this.veiculoService = veiculoService;
        this.clienteService = clienteService;
        this.devolverVeiculoService = devolverVeiculoService;

    }

    public void execute(){
        System.out.println("Digite a placa do carro que deseja devolver");
        String placa = ScannerSingleton.instance().getScanner().nextLine();
        VeiculoAlugado veiculoAlugado = devolverVeiculoService.buscaPorPlaca(placa);
        System.out.println("Digite a data e horario de devolucao no formato dd/MM/yyyy HH:mm");
        String dataEHoraString = ScannerSingleton.instance().getScanner().nextLine();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm");
        LocalDateTime dataEHora = LocalDateTime.parse(dataEHoraString,formatter);
        Long diarias = CalculaValorDaDevolucao.calcularDiarias(veiculoAlugado,dataEHora);
        try {
            System.out.println("VALOR A SER PAGO: " + CalculaValorDaDevolucao.calcularValorDaDevolucao(veiculoAlugado,diarias));
            devolverVeiculoService.devolverCarro(veiculoAlugado);
            System.out.println("Veiculo devolvido com sucesso");

        } catch (RepositorioException e) {
            throw new RuntimeException(e);
        }

    }
}

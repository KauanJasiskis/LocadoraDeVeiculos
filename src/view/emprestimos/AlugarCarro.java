package view.emprestimos;

import modelo.AbstractCliente;
import modelo.AbstractVeiculo;
import modelo.DetalhesEmprestimoCarro;
import modelo.VeiculoAlugado;
import repositorio.exception.RepositorioException;
import service.services.AlugarVeiculoService;
import service.services.ClienteService;
import service.services.VeiculoService;
import view.ScannerSingleton;

import java.sql.SQLOutput;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;

public class AlugarCarro {

    private VeiculoService veiculoService;
    private ClienteService clienteService;

    private AlugarVeiculoService alugarVeiculoService;

    public AlugarCarro(VeiculoService veiculoService, ClienteService clienteService, AlugarVeiculoService alugarVeiculoService) {
        this.veiculoService = veiculoService;
        this.clienteService = clienteService;
        this.alugarVeiculoService = alugarVeiculoService;
    }

    public void execute()  {
        System.out.println("Digite o CPF/CNPJ do cliente que esta alugando");
        String identificador = ScannerSingleton.instance().getScanner().nextLine();
        AbstractCliente cliente = clienteService.buscaClienteUnico(identificador);
        System.out.println("Digite a placa do carro que o cliente deseja alugar");
        String placa = ScannerSingleton.instance().getScanner().nextLine();
        AbstractVeiculo veiculo = veiculoService.buscaCarroUnico(placa);
        System.out.println("Digite o local do emprestimo");
        String local = ScannerSingleton.instance().getScanner().nextLine();
        System.out.println("Digite a data no formato dd/MM/yyyy HH:mm");
        String dataEHoraString = ScannerSingleton.instance().getScanner().nextLine();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm");
        LocalDateTime dataEHora = LocalDateTime.parse(dataEHoraString,formatter);
        VeiculoAlugado veiculoAlugado = new VeiculoAlugado(new DetalhesEmprestimoCarro(local,dataEHora),veiculo,cliente);
        try {
            alugarVeiculoService.alugarCarro(veiculoAlugado);
            System.out.println("Veiculo Alugado com sucesso");
        } catch (RepositorioException e) {
            throw new RuntimeException(e);
        }catch (NullPointerException exception){
            System.out.println("Cliente ou Carro nao encontrado");
            execute();
        }
    }
}

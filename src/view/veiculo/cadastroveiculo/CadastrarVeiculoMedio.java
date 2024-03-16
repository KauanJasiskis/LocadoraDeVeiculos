package view.veiculo.cadastroveiculo;

import modelo.VeiculoMedio;
import modelo.VeiculoPequeno;
import service.exception.ModeloInvalidoException;
import service.exception.ServiceException;
import service.services.VeiculoService;
import view.ScannerSingleton;

public class CadastrarVeiculoMedio {

    private VeiculoService veiculoMedioVeiculoService;


    public CadastrarVeiculoMedio(VeiculoService veiculoMedioVeiculoService) {
        this.veiculoMedioVeiculoService = veiculoMedioVeiculoService;
    }

    public void execute() {
        System.out.println("Digite o nome do veiculo");
        String nome = ScannerSingleton.instance().getScanner().nextLine();
        System.out.println("Digite o ano do veiculo");
        String ano = ScannerSingleton.instance().getScanner().nextLine();
        System.out.println("Digite a placa do veiculo");
        String placa = ScannerSingleton.instance().getScanner().nextLine();
        VeiculoMedio veiculoMedio = null;
        try {
            veiculoMedio = new VeiculoMedio(nome, ano, placa);
        } catch (Exception exception) {
            System.err.println("Excecao nao tratada");
            execute();
        }
        try {
            veiculoMedioVeiculoService.cadastrar(veiculoMedio);
            System.out.println("Veiculo Medio cadastrado com sucesso");
        } catch (ModeloInvalidoException e) {
            System.out.println(e.getMessage());
            execute();
        } catch (ServiceException exception) {
            System.err.println("Ocorreu um erro tente novamente mais tarde");
            execute();
        }

    }

}


package view.veiculo.cadastroveiculo;

import modelo.VeiculoMedio;
import modelo.VeiculoSUV;
import service.exception.ModeloInvalidoException;
import service.exception.ServiceException;
import service.services.VeiculoService;
import view.ScannerSingleton;

public class CadastrarVeiculoSUV {
    private VeiculoService veiculoSUVVeiculoService;


    public CadastrarVeiculoSUV(VeiculoService veiculoSUVVeiculoService) {
        this.veiculoSUVVeiculoService = veiculoSUVVeiculoService;
    }

    public void execute() {
        System.out.println("Digite o nome do veiculo");
        String nome = ScannerSingleton.instance().getScanner().nextLine();
        System.out.println("Digite o ano do veiculo");
        String ano = ScannerSingleton.instance().getScanner().nextLine();
        System.out.println("Digite a placa do veiculo");
        String placa = ScannerSingleton.instance().getScanner().nextLine();
        VeiculoSUV veiculoSUV = null;
        try {
            veiculoSUV = new VeiculoSUV(nome, ano, placa);
        } catch (Exception exception) {
            System.err.println("Excecao nao tratada");
            execute();
        }
        try {
            veiculoSUVVeiculoService.cadastrar(veiculoSUV);
            System.out.println("Veiculo SUV cadastrado com sucesso");
        } catch (ModeloInvalidoException e) {
            System.out.println(e.getMessage());
            execute();
        } catch (ServiceException exception) {
            System.err.println("Ocorreu um erro tente novamente mais tarde");
            execute();
        }

    }

}


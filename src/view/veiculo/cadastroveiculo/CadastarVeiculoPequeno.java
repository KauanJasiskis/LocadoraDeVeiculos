package view.veiculo.cadastroveiculo;

import modelo.ClienteFisico;
import modelo.VeiculoPequeno;
import service.exception.ModeloInvalidoException;
import service.exception.ServiceException;
import service.services.ClienteService;
import service.services.VeiculoService;
import view.ScannerSingleton;

public class CadastarVeiculoPequeno{
    private VeiculoService veiculoPequenoVeiculoService;


    public CadastarVeiculoPequeno(VeiculoService veiculoPequenoVeiculoService) {
        this.veiculoPequenoVeiculoService = veiculoPequenoVeiculoService;
    }
    public void execute(){
        System.out.println("Digite o nome do veiculo");
        String nome = ScannerSingleton.instance().getScanner().nextLine();
        System.out.println("Digite o ano do veiculo");
        String ano = ScannerSingleton.instance().getScanner().nextLine();
        System.out.println("Digite a placa do veiculo");
        String placa = ScannerSingleton.instance().getScanner().nextLine();
        VeiculoPequeno veiculoPequeno = null;
        try {
             veiculoPequeno = new VeiculoPequeno(nome, ano,placa);
        } catch (Exception exception) {
            System.err.println("Excecao nao tratada");
            execute();
        }
        try {
            veiculoPequenoVeiculoService.cadastrar(veiculoPequeno);
            System.out.println("Veiculo Pequeno cadastrado com sucesso");
        } catch (ModeloInvalidoException e) {
            System.out.println(e.getMessage());
            execute();
        } catch (ServiceException exception) {
            System.err.println("Ocorreu um erro tente novamente mais tarde");
            execute();
        }

    }

}








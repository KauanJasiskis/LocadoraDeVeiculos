package view.veiculo.alterarveiculo;

import modelo.AbstractVeiculo;
import modelo.VeiculoMedio;
import modelo.VeiculoPequeno;
import modelo.VeiculoSUV;
import service.exception.ServiceException;
import service.services.VeiculoService;
import view.ScannerSingleton;

public class AlterarVeiculo {
    private VeiculoService veiculoService;


    public AlterarVeiculo(VeiculoService veiculoService){
        this.veiculoService = veiculoService;
    }

    public void execute(){
        System.out.println("Digite a placa do veiculo que deseja alterar: ");
        String placa= ScannerSingleton.instance().getScanner().nextLine();
        AbstractVeiculo veiculo = veiculoService.buscaCarroUnico(placa);
        System.out.println("Digite o novo nome do carro");
        String novoNome = ScannerSingleton.instance().getScanner().nextLine();
        veiculo.setNome(novoNome);
        try {
            veiculoService.atualizar(veiculo);
        } catch (ServiceException e) {
            throw new RuntimeException(e);
        }catch (NullPointerException exception){
        System.out.println("Veiculo nao encontrado");
        execute();
    }
    }
}

package view.veiculo.listagemveiculos;

import modelo.AbstractVeiculo;
import service.services.VeiculoService;

import java.util.Set;

public class ListarVeiculoDisponiveis {
    private VeiculoService veiculoService;

    public ListarVeiculoDisponiveis(VeiculoService veiculoService){
        this.veiculoService = veiculoService;
    }

    public void execute(){
        Set<AbstractVeiculo> listaVeiculos = veiculoService.listar();
        for(AbstractVeiculo veiculo : listaVeiculos){
            System.out.println(veiculo);
        }
    }
}

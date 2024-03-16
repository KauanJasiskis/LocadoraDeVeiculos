package view.veiculo.listagemveiculos;

import modelo.AbstractVeiculo;
import modelo.VeiculoAlugado;
import service.services.AlugarVeiculoService;
import service.services.VeiculoService;

import java.util.Set;

public class ListarVeiculosAlugados
{
    private AlugarVeiculoService alugarVeiculoService;
    public ListarVeiculosAlugados(AlugarVeiculoService alugarVeiculoService){
        this.alugarVeiculoService = alugarVeiculoService;
    }

    public void execute(){
        Set<VeiculoAlugado> listaVeiculos = alugarVeiculoService.listar();
        for(VeiculoAlugado veiculoAlugado : listaVeiculos){
            System.out.println(veiculoAlugado);
        }
    }
}

package view.veiculo.listagemveiculos;

import modelo.AbstractVeiculo;
import service.services.VeiculoService;
import view.ScannerSingleton;

import java.sql.SQLOutput;
import java.util.Scanner;
import java.util.Set;

public class BuscaVeiculosPorNome {
    private VeiculoService veiculoService;

    public BuscaVeiculosPorNome(VeiculoService veiculoService){
        this.veiculoService = veiculoService;
    }

    public void execute(){
        System.out.println("Digite as primeiras 3 letras do veiculo");
        String nome = ScannerSingleton.instance().getScanner().nextLine();
        Set<AbstractVeiculo> listaVeiculos = veiculoService.buscarPorNome(nome);
        for(AbstractVeiculo veiculo : listaVeiculos){
            System.out.println(veiculo);
        }
    }
}





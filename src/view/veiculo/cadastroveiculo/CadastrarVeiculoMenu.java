package view.veiculo.cadastroveiculo;

import modelo.*;
import service.services.VeiculoService;
import view.AbstractMenuView;
import view.cliente.cadastrodeclientes.CadastrarClienteFisicoView;
import view.cliente.cadastrodeclientes.CadastrarClienteJuridicoView;
import view.cliente.cadastrodeclientes.CadastrarClienteMenu;

public class CadastrarVeiculoMenu extends AbstractMenuView {

    private VeiculoService veiculoService;

    public CadastrarVeiculoMenu(VeiculoService veiculoService

    ) {
        super(new String[]{
                "1 - Cadastrar Veiculo Pequeno",
                "2 - Cadastrar Veiculo Medio",
                "3 - Cadastrar Veiculo SUV"

        });

        {
           this.veiculoService = veiculoService;

        }
    }


    @Override
    protected Boolean validOption(Integer option) {
        return option >= 1 && option <= 3;
    }

    @Override
    protected void executeOption(Integer option) {
        switch (option) {
            case 1 -> new CadastarVeiculoPequeno(veiculoService).execute();
            case 2 -> new CadastrarVeiculoMedio(veiculoService).execute();
            case 3 -> new CadastrarVeiculoSUV(veiculoService).execute();

        }


    }
}


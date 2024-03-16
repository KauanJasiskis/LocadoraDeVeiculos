package view.veiculo.alterarveiculo;

import modelo.*;
import service.services.ClienteService;
import service.services.VeiculoService;
import view.AbstractMenuView;
import view.cliente.alterarcliente.AlterarCliente;

public class AlterarVeiculoMenu extends AbstractMenuView {
    private VeiculoService veiculoService;


    public AlterarVeiculoMenu(VeiculoService veiculoService

    ) {
        super(new String[]{
                "1 - Alterar Veiculo Pequeno",
                "2 - Alterar Veiculo Medio",
                "3 - Alterar Veiculo SUV"


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
            case 1 -> new AlterarVeiculo(veiculoService).execute();


        }


    }
}


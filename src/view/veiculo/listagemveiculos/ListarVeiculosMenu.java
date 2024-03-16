package view.veiculo.listagemveiculos;

import service.services.AlugarVeiculoService;
import service.services.VeiculoService;
import view.AbstractMenuView;

public class ListarVeiculosMenu extends AbstractMenuView {
    private VeiculoService veiculoService;
    private AlugarVeiculoService alugarVeiculoService;



    public ListarVeiculosMenu(VeiculoService veiculoService,
                              AlugarVeiculoService alugarVeiculoService

                              ) {
        super(new String[]{
                "1 - Listar Veiculos Disponiveis",
                "2 - Listar Veiculos Alugados"


        });

        {
           this.veiculoService = veiculoService;
           this.alugarVeiculoService = alugarVeiculoService;

        }
    }


    @Override
    protected Boolean validOption(Integer option) {
        return option >= 1 && option <= 3;
    }

    @Override
    protected void executeOption(Integer option) {
        switch (option) {
            case 1 -> new ListarVeiculoDisponiveis(veiculoService).execute();
            case 2 -> new ListarVeiculosAlugados(alugarVeiculoService).execute();

        }


    }
}


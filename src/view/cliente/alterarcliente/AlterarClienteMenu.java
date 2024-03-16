package view.cliente.alterarcliente;

import modelo.ClienteFisico;
import modelo.ClienteJuridico;
import service.services.ClienteService;
import view.AbstractMenuView;

public class AlterarClienteMenu extends AbstractMenuView {
    private ClienteService clienteService;



    public AlterarClienteMenu(ClienteService clienteService
                             ) {
        super(new String[]{
                "1 - Alterar Cliente Fisico",
                "2 - Alterar Cliente Juridico"



        });

        {
            this.clienteService = clienteService;


        }
    }


    @Override
    protected Boolean validOption(Integer option) {
        return option >= 1 && option <= 2;
    }

    @Override
    protected void executeOption(Integer option) {
        switch (option) {
            case 1 -> new AlterarCliente(clienteService).execute();


        }



    }
}




package view.cliente.cadastrodeclientes;

import modelo.*;
import service.services.ClienteService;
import view.AbstractMenuView;
import view.cliente.cadastrodeclientes.CadastrarClienteFisicoView;
import view.cliente.cadastrodeclientes.CadastrarClienteJuridicoView;

public class CadastrarClienteMenu extends AbstractMenuView {

    private ClienteService clienteService;




    public CadastrarClienteMenu(ClienteService clienteService
                                ) {
        super(new String[]{
                "1 - Cadastrar Cliente Fisico",
                "2 - Cadastrar Cliente Juridico"

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
            case 1 -> new CadastrarClienteFisicoView(clienteService).execute();
            case 2 -> new CadastrarClienteJuridicoView(clienteService).execute();

        }



    }
}


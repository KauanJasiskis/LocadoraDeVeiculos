package view.cliente.listagemdeclientes;

import modelo.ClienteFisico;
import modelo.ClienteJuridico;
import service.services.ClienteService;
import view.AbstractMenuView;
import view.cliente.cadastrodeclientes.CadastrarClienteFisicoView;
import view.cliente.cadastrodeclientes.CadastrarClienteJuridicoView;

public class ListarClienteMenu extends AbstractMenuView {
    private ClienteService clienteService;



    public ListarClienteMenu(ClienteService clienteService
                                ) {
        super(new String[]{
                "1 - Listar clientes Fisicos",
                "2 - Listar clientes Juridicos"



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
            case 1 -> new ListarCliente(clienteService).execute();
        }



    }
}


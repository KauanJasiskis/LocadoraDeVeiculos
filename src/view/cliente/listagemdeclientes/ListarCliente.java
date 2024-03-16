package view.cliente.listagemdeclientes;

import modelo.AbstractCliente;
import service.services.ClienteService;
import service.services.VeiculoService;

import java.util.Set;

public class ListarCliente {
    private ClienteService clienteService;

    public ListarCliente(ClienteService clienteService){
        this.clienteService = clienteService;
    }

    public void execute(){
        Set<AbstractCliente> listaClientes = clienteService.listar();
        for(AbstractCliente cliente : listaClientes){
            System.out.println(cliente);
        }
    }
}


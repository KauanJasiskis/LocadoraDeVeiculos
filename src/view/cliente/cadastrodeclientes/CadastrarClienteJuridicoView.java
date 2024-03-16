package view.cliente.cadastrodeclientes;

import modelo.ClienteFisico;
import modelo.ClienteJuridico;
import service.exception.ModeloInvalidoException;
import service.exception.ServiceException;
import service.services.ClienteService;
import view.ScannerSingleton;

public class CadastrarClienteJuridicoView {
    private ClienteService clienteService;


    public CadastrarClienteJuridicoView(ClienteService clienteService) {
        this.clienteService = clienteService;

    }

    public void execute() {
        System.out.println("Informe o nome do cliente");
        String nome = ScannerSingleton.instance().getScanner().nextLine();
        System.out.println("informe o CNPJ do cliente");
        String identificador = ScannerSingleton.instance().getScanner().nextLine();
        ClienteJuridico clienteJuridico = null;
        try {
            clienteJuridico = new ClienteJuridico(nome, identificador);
        } catch (Exception exception) {
            System.err.println("Excecao nao tratada");
            execute();
        }
        try {
            clienteService.cadastrar(clienteJuridico);
            System.out.println("Cliente cadastrado com sucesso");
        } catch (ModeloInvalidoException e) {
            System.out.println(e.getMessage());
            execute();
        } catch (ServiceException exception) {
            System.err.println("Ocorreu um erro tente novamente mais tarde");
            execute();
        }

    }

}


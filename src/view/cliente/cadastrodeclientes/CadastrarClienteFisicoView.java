package view.cliente.cadastrodeclientes;

import modelo.ClienteFisico;
import modelo.ClienteJuridico;
import service.exception.ModeloInvalidoException;
import service.exception.ServiceException;
import service.services.ClienteService;
import view.ScannerSingleton;

public class CadastrarClienteFisicoView {
    private ClienteService clienteService;


    public CadastrarClienteFisicoView(ClienteService clienteService) {
        this.clienteService = clienteService;

    }

    public void execute() {
        System.out.println("Informe o nome do cliente");
        String nome = ScannerSingleton.instance().getScanner().nextLine();
        System.out.println("informe o CPF do cliente");
        String identificador = ScannerSingleton.instance().getScanner().nextLine();
        ClienteFisico clienteFisico = null;
        try {
            clienteFisico = new ClienteFisico(nome, identificador);
        } catch (ModeloInvalidoException modeloInvalidoException) {
            System.err.println(modeloInvalidoException.getMessage());
            execute();
        }
        try {
            clienteService.cadastrar(clienteFisico);
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

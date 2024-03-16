package view.cliente.alterarcliente;

import modelo.AbstractCliente;
import modelo.ClienteFisico;
import service.exception.ServiceException;
import service.services.ClienteService;
import view.ScannerSingleton;

public class AlterarCliente {

    private ClienteService clienteService;

    public AlterarCliente(ClienteService clienteService){
        this.clienteService = clienteService;
    }

    public void execute(){
        System.out.println("Digite o identificador(CPF ou CNPJ) do cliente que deseja alterar: ");
        String identificador = ScannerSingleton.instance().getScanner().nextLine();
        AbstractCliente cliente = clienteService.buscaClienteUnico(identificador);
        System.out.println("Digite o novo nome do cliente");
        String novoNome = ScannerSingleton.instance().getScanner().nextLine();
        cliente.setNome(novoNome);
        try {
            clienteService.atualizar(cliente);
        } catch (ServiceException e) {
            throw new RuntimeException(e);
        }catch (NullPointerException exception){
            System.out.println("Cliente nao encontrado");
            execute();
        }
    }
}
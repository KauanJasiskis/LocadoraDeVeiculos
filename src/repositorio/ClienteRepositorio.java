package repositorio;

import banco.BancoCliente;
import banco.exception.DatabaseException;
import modelo.AbstractCliente;
import repositorio.exception.RepositorioException;

import java.util.Collections;
import java.util.List;
import java.util.Set;

public class ClienteRepositorio {
    private final BancoCliente bancoCliente;

    public ClienteRepositorio(BancoCliente bancoCliente) {
        this.bancoCliente = bancoCliente;
    }

    public void gravar(AbstractCliente cliente) throws RepositorioException {
        try {
            this.bancoCliente.inserirObjeto(cliente);
        } catch (DatabaseException exception) {
            throw new RepositorioException(exception.getMessage(), exception);
        }
    }


    public Boolean excluir(AbstractCliente cliente){
        this.bancoCliente.excluirObjeto(cliente);
        return true;
    }

    public AbstractCliente buscarPorIdentificador(String identificador) {
            Set<AbstractCliente> clientes =listar();
            AbstractCliente clienteEncontrado = null;
            for(AbstractCliente cliente : clientes){
                if(cliente.getIdentificador().equalsIgnoreCase(identificador)){
                    clienteEncontrado = cliente;
                }
            }
            return clienteEncontrado;

    }

    public Set<AbstractCliente> listar() {
        Set<AbstractCliente> objetosPresentesNoBanco = this.bancoCliente.retornaLista();
        return Collections.unmodifiableSet(objetosPresentesNoBanco);


    }

    public Class classeModelo(){
        return this.getClass();
    }
}

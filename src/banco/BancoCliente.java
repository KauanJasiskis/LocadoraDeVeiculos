package banco;

import banco.exception.DatabaseException;
import modelo.AbstractCliente;

import java.util.*;

public class BancoCliente  {
    private final Set<AbstractCliente> CLIENTES = new HashSet<>();




    public void inserirObjeto(AbstractCliente cliente) throws DatabaseException{
        CLIENTES.add(cliente);
    }


    public void excluirObjeto(AbstractCliente cliente) {
        CLIENTES.remove(cliente);
    }


    public Set<AbstractCliente> retornaLista(){
        return Collections.unmodifiableSet(CLIENTES);
    }


}

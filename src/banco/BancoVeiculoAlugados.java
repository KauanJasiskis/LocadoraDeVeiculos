package banco;

import banco.exception.DatabaseException;
import modelo.AbstractCliente;
import modelo.AbstractVeiculo;
import modelo.DetalhesEmprestimoCarro;
import modelo.VeiculoAlugado;


import java.util.*;

public class BancoVeiculoAlugados{


    private final Set<VeiculoAlugado> veiculoAlugados = new HashSet<>();

    public void inserirObjeto(VeiculoAlugado veiculoAlugado) throws DatabaseException {
        veiculoAlugados.add(veiculoAlugado);
    }

    public void excluirObjeto(VeiculoAlugado veiculoAlugado) {
        veiculoAlugados.remove(veiculoAlugado);

    }

    public Set<VeiculoAlugado> retornaLista() {
        return Collections.unmodifiableSet(veiculoAlugados);
    }
}




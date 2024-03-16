package banco;

import banco.exception.DatabaseException;
import modelo.AbstractVeiculo;

import java.util.*;

public class BancoVeiculo {
    private final Set<AbstractVeiculo> VEICULOS = new HashSet<>();


    public void inserirObjeto(AbstractVeiculo veiculo) throws DatabaseException {
        VEICULOS.add(veiculo);

    }


    public void excluirObjeto(AbstractVeiculo veiculo) {
        VEICULOS.remove(veiculo);
    }


    public Set<AbstractVeiculo> retornaLista() {
        return Collections.unmodifiableSet(VEICULOS);
    }
}

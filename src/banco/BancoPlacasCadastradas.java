package banco;

import banco.exception.DatabaseException;

import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

public class BancoPlacasCadastradas {
    private final Set<String> PLACASCADASTRADAS = new HashSet<>();
    public void inserirObjeto(String placa) throws DatabaseException {
        PLACASCADASTRADAS.add(placa);

    }
    public void excluirObjeto(String placa) {
        PLACASCADASTRADAS.remove(placa);
    }

    public Set<String> retornaLista() {
        return Collections.unmodifiableSet(PLACASCADASTRADAS);
    }
}


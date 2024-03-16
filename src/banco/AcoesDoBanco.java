package banco;

import java.util.List;
import java.util.Set;

public interface AcoesDoBanco<T> {
    void inserirObjeto(T t) throws Exception;

    void excluirObjeto(T t);

    Set<T> retornaLista();


}

package repositorio;

import banco.BancoPlacasCadastradas;
import banco.exception.DatabaseException;
import repositorio.exception.RepositorioException;

import java.util.Collections;
import java.util.Set;

public class PlacasRepositorio
{
    private BancoPlacasCadastradas bancoPlacasCadastradas;
    public PlacasRepositorio(BancoPlacasCadastradas bancoPlacasCadastradas){
        this.bancoPlacasCadastradas = bancoPlacasCadastradas;
    }

    public void gravar(String placa) throws RepositorioException {
        try {
            this.bancoPlacasCadastradas.inserirObjeto(placa);
        } catch (DatabaseException exception) {
            throw new RepositorioException(exception.getMessage(), exception);
        }
    }


    public Boolean excluir(String  placa){
        this.bancoPlacasCadastradas.excluirObjeto(placa);
        return true;
    }

    public String buscarPorIdentificador(String placaInformada) {
        Set<String> placas = listar();
        String placaEncontrada = null;
        for(String placa : placas){
            if(placa.equalsIgnoreCase(placaInformada)){
                placaEncontrada = placa;
            }
        }
        return placaEncontrada;

    }

    public Set<String> listar() {
        Set<String> objetosPresentesNoBanco = this.bancoPlacasCadastradas.retornaLista();
        return Collections.unmodifiableSet(objetosPresentesNoBanco);


    }
}

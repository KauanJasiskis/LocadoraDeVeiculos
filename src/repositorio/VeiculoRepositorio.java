package repositorio;

import banco.BancoVeiculo;
import banco.exception.DatabaseException;
import modelo.AbstractVeiculo;
import repositorio.exception.RepositorioException;

import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

public class VeiculoRepositorio {
    private final BancoVeiculo bancoVeiculo;


    public VeiculoRepositorio(BancoVeiculo bancoVeiculo) {
        this.bancoVeiculo = bancoVeiculo;
    }

    public void gravar(AbstractVeiculo veiculo) throws RepositorioException {
        try {
            this.bancoVeiculo.inserirObjeto(veiculo);
        } catch (DatabaseException exception) {
            throw new RepositorioException(exception.getMessage(), exception);
        }
    }

    public Boolean excluir(AbstractVeiculo veiculo) {
        this.bancoVeiculo.excluirObjeto(veiculo);
        return true;
    }

    public AbstractVeiculo buscarPorPlaca(String placa) {
        Set<AbstractVeiculo> veiculos = listar();
        AbstractVeiculo veiculoEncontrado = null;
        for (AbstractVeiculo veiculo : veiculos) {
            if (veiculo.getPlaca().equalsIgnoreCase(placa)) {
                veiculoEncontrado = veiculo;
                break;
            }
        }
        return veiculoEncontrado;

    }
    public Set<AbstractVeiculo> buscarPorParteDoNome(String nome) {
        Set<AbstractVeiculo> veiculos = listar();
        Set<AbstractVeiculo> veiculosFiltrados = new HashSet<>();
        for (AbstractVeiculo veiculo : veiculos) {
            if (veiculo.getNome().toLowerCase().startsWith(nome.toLowerCase().substring(0,2))){
                veiculosFiltrados.add(veiculo);
            }
        }
        return veiculosFiltrados;

    }


    public Set<AbstractVeiculo> listar() {
        Set<AbstractVeiculo> objetosPresentesNoBanco = this.bancoVeiculo.retornaLista();
        return Collections.unmodifiableSet(objetosPresentesNoBanco);

    }
}




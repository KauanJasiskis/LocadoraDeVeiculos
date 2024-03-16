package repositorio;

import banco.BancoCliente;
import banco.BancoVeiculo;
import banco.BancoVeiculoAlugados;
import banco.exception.DatabaseException;
import modelo.AbstractCliente;
import modelo.AbstractVeiculo;
import modelo.DetalhesEmprestimoCarro;
import modelo.VeiculoAlugado;
import repositorio.exception.RepositorioException;

import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class VeiculosAlugadosRepositorio {
    private BancoVeiculoAlugados bancoVeiculoAlugados;

    public VeiculosAlugadosRepositorio(BancoVeiculoAlugados bancoVeiculoAlugados) {
        this.bancoVeiculoAlugados = bancoVeiculoAlugados;
    }

    public void gravar(VeiculoAlugado veiculoAlugado) throws RepositorioException {
        try {
            this.bancoVeiculoAlugados.inserirObjeto(veiculoAlugado);
        } catch (DatabaseException exception) {
            throw new RepositorioException(exception.getMessage(), exception);
        }
    }

    public Boolean excluir(VeiculoAlugado veiculoAlugado) {
        this.bancoVeiculoAlugados.excluirObjeto(veiculoAlugado);
        return true;
    }

    public VeiculoAlugado buscarPorIdentificador(String identificador) {
        Set<VeiculoAlugado> veiculosAlugados = listar();
        VeiculoAlugado veiculoAlugadoEncontrado = null;
        for (VeiculoAlugado veiculoAlugado : veiculosAlugados) {
            if(veiculoAlugado.getVeiculoQueFoiAlugado().getPlaca().equals(identificador)){
                veiculoAlugadoEncontrado = veiculoAlugado;
                break;
            }
        }
        return veiculoAlugadoEncontrado;
    }

    public Set<VeiculoAlugado> listar() {
        Set<VeiculoAlugado> objetosPresentesNoBanco = this.bancoVeiculoAlugados.retornaLista();
        return objetosPresentesNoBanco;
    }
}


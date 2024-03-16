package service.services;

import modelo.VeiculoAlugado;
import repositorio.ClienteRepositorio;
import repositorio.VeiculoRepositorio;
import repositorio.VeiculosAlugadosRepositorio;
import repositorio.exception.RepositorioException;

import java.util.Set;

public class DevolverVeiculoService {
    VeiculoRepositorio veiculoRepositorio;
    ClienteRepositorio clienteRepositorio;
    VeiculosAlugadosRepositorio veiculosAlugadosRepositorio;

    public DevolverVeiculoService(VeiculoRepositorio veiculoRepositorio, ClienteRepositorio clienteRepositorio, VeiculosAlugadosRepositorio veiculosAlugadosRepositorio) {
        this.veiculoRepositorio = veiculoRepositorio;
        this.clienteRepositorio = clienteRepositorio;
        this.veiculosAlugadosRepositorio = veiculosAlugadosRepositorio;
    }

    public void devolverCarro(VeiculoAlugado veiculoAlugado) throws RepositorioException {
        veiculoAlugado.getClienteQueAlugou().removerVeiculoAlugado(veiculoAlugado.getVeiculoQueFoiAlugado());
        veiculoRepositorio.gravar(veiculoAlugado.getVeiculoQueFoiAlugado());
        veiculosAlugadosRepositorio.excluir(veiculoAlugado);

    }

    public Set<VeiculoAlugado> listar() {
        return veiculosAlugadosRepositorio.listar();
    }

    public VeiculoAlugado buscaPorPlaca(String placa){
        return veiculosAlugadosRepositorio.buscarPorIdentificador(placa);
    }


}



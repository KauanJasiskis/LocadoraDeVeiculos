package service.services;

import modelo.*;
import repositorio.ClienteRepositorio;
import repositorio.VeiculoRepositorio;
import repositorio.VeiculosAlugadosRepositorio;
import repositorio.exception.RepositorioException;

import java.util.Set;

public class AlugarVeiculoService  {
    VeiculoRepositorio veiculoRepositorio;
    ClienteRepositorio clienteRepositorio;
    VeiculosAlugadosRepositorio veiculosAlugadosRepositorio;

    public AlugarVeiculoService(VeiculoRepositorio veiculoRepositorio, ClienteRepositorio clienteRepositorio, VeiculosAlugadosRepositorio veiculosAlugadosRepositorio) {
        this.veiculoRepositorio = veiculoRepositorio;
        this.clienteRepositorio = clienteRepositorio;
        this.veiculosAlugadosRepositorio = veiculosAlugadosRepositorio;
    }

    public void alugarCarro(VeiculoAlugado veiculoAlugado) throws RepositorioException {
        veiculoAlugado.getClienteQueAlugou().adicionarVeiculosAlugado(veiculoAlugado.getVeiculoQueFoiAlugado());
        veiculosAlugadosRepositorio.gravar(veiculoAlugado);
        veiculoRepositorio.excluir(veiculoAlugado.getVeiculoQueFoiAlugado());
    }
    public Set<VeiculoAlugado> listar() {
        return veiculosAlugadosRepositorio.listar();
    }


}

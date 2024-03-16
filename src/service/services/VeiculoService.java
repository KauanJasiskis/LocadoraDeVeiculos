package service.services;

import modelo.AbstractCliente;
import modelo.AbstractVeiculo;
import repositorio.ClienteRepositorio;
import repositorio.PlacasRepositorio;
import repositorio.VeiculoRepositorio;
import repositorio.exception.RepositorioException;
import service.exception.ModeloInvalidoException;
import service.exception.ServiceException;

import java.util.List;
import java.util.Set;

public class VeiculoService {
    private VeiculoRepositorio repositorio;
    private PlacasRepositorio placasRepositorio;

    public VeiculoService(VeiculoRepositorio veiculoRepositorio,PlacasRepositorio placasRepositorio) {
        this.repositorio = veiculoRepositorio;
        this.placasRepositorio = placasRepositorio;
    }

    public Boolean verificaVeiculo(AbstractVeiculo veiculo) {
        if (veiculo == null) {
            throw new ModeloInvalidoException("Veiculo nao pode ser nulo");
        } else if (veiculo.getNome() == null) {
            throw new ModeloInvalidoException("Nome do veiculo nao pode ser nulo");
        } else if (veiculo.getAno() == null) {
            throw new ModeloInvalidoException("Ano do veiculo nao pode ser nulo");
        } else if (veiculo.getPlaca() == null) {
            throw new ModeloInvalidoException("Placa nao pode ser nulo");
        } else if (placasRepositorio.buscarPorIdentificador(veiculo.getPlaca()) != null) {
            throw new ModeloInvalidoException("Veiculo ja cadastrado");
        } else {
            return true;
        }
    }

    public void excluirVeiculo(AbstractVeiculo veiculo) {
        repositorio.excluir(veiculo);
    }


    public void cadastrar(AbstractVeiculo veiculo) throws ServiceException {
        if (verificaVeiculo(veiculo).equals(true)) {
            try {
                repositorio.gravar(veiculo);
                placasRepositorio.gravar(veiculo.getPlaca());
            } catch (RepositorioException exception) {
                throw new ServiceException(exception.getMessage(), exception);
            }
        }
    }

    public void atualizar(AbstractVeiculo veiculo) throws ServiceException {
        if (veiculo == null) {
            throw new ModeloInvalidoException("Cliente nao pode ser nulo");
        } else if (veiculo.getNome() == null) {
            throw new ModeloInvalidoException("Nome do cliente nao pode ser nulo");
        } else if (veiculo.getPlaca() == null) {
            throw new ModeloInvalidoException("Identificador nao pode ser nulo");
        } else if (veiculo.getAno() == null) {
            throw new ModeloInvalidoException("Ano do carro nao pode ser nulo");
        }
        AbstractVeiculo veiculoJaExistente = repositorio.buscarPorPlaca(veiculo.getPlaca());
        if (veiculoJaExistente == null) {
            throw new ModeloInvalidoException("Cliente nao encontrado");
        }
        try {
            repositorio.gravar(veiculoJaExistente);
        } catch (RepositorioException e) {
            throw new ServiceException(e.getMessage(), e);
        }


    }
    public Set<AbstractVeiculo> buscarPorNome(String nome){
        return repositorio.buscarPorParteDoNome(nome);
    }

    public Set<AbstractVeiculo> listar() {
        return repositorio.listar();
    }

    public AbstractVeiculo buscaCarroUnico(String identificador) {
        return repositorio.buscarPorPlaca(identificador);
    }
}




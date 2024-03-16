package service.services;

import modelo.AbstractCliente;
import modelo.AbstractVeiculo;
import modelo.ClienteFisico;
import repositorio.ClienteRepositorio;
import repositorio.VeiculoRepositorio;
import repositorio.exception.RepositorioException;
import service.exception.ModeloInvalidoException;
import service.exception.ServiceException;

import java.util.List;
import java.util.Set;

public class ClienteService {


    private ClienteRepositorio repositorio;


    public ClienteService(ClienteRepositorio clienteRepositorio) {
        this.repositorio = clienteRepositorio;

    }


    public Boolean verificaCliente(AbstractCliente cliente) {
        if (cliente == null) {
            throw new ModeloInvalidoException("Cliente nao pode ser nulo");
        } else if (cliente.getNome() == null) {
            throw new ModeloInvalidoException("Nome do cliente nao pode ser nulo");
        } else if (cliente.getIdentificador() == null) {
            throw new ModeloInvalidoException("Identificador nao pode ser nulo");
        } else if (repositorio.buscarPorIdentificador(cliente.getIdentificador()) != null) {
            throw new ModeloInvalidoException("Cliente ja cadastrado");
        } else {
            return true;
        }
    }



    public void cadastrar(AbstractCliente cliente) throws ServiceException {
        if (verificaCliente(cliente).equals(true)) {
            try {
                repositorio.gravar(cliente);
            } catch (RepositorioException exception) {
                throw new ServiceException(exception.getMessage(), exception);
            }
        }
    }

    public void atualizar(AbstractCliente cliente) throws ServiceException {
        if (cliente == null) {
            throw new ModeloInvalidoException("Cliente nao pode ser nulo");
        } else if (cliente.getNome() == null) {
            throw new ModeloInvalidoException("Nome do cliente nao pode ser nulo");
        } else if (cliente.getIdentificador() == null) {
            throw new ModeloInvalidoException("Identificador nao pode ser nulo");
        }
        AbstractCliente clienteJaExistente = repositorio.buscarPorIdentificador(cliente.getIdentificador());
        if (clienteJaExistente == null) {
            throw new ModeloInvalidoException("Cliente nao encontrado");
        }
        try {
            repositorio.gravar(clienteJaExistente);
        } catch (RepositorioException e) {
            throw new ServiceException(e.getMessage(), e);
        }


    }


    public Set<AbstractCliente> listar() {
        return repositorio.listar();
    }

    public AbstractCliente buscaClienteUnico(String identificador) {
        return repositorio.buscarPorIdentificador(identificador);
    }
}
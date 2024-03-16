package view;

import modelo.*;
import service.exception.ServiceException;
import service.services.AlugarVeiculoService;
import service.services.ClienteService;
import service.services.DevolverVeiculoService;
import service.services.VeiculoService;
import view.cliente.alterarcliente.AlterarClienteMenu;
import view.cliente.cadastrodeclientes.CadastrarClienteMenu;
import view.cliente.listagemdeclientes.ListarCliente;
import view.cliente.listagemdeclientes.ListarClienteMenu;
import view.emprestimos.AlugarCarro;
import view.emprestimos.DevolucaoCarro;
import view.veiculo.alterarveiculo.AlterarVeiculoMenu;
import view.veiculo.cadastroveiculo.CadastrarVeiculoMedio;
import view.veiculo.cadastroveiculo.CadastrarVeiculoMenu;
import view.veiculo.listagemveiculos.BuscaVeiculosPorNome;
import view.veiculo.listagemveiculos.ListarVeiculosMenu;


public class Menu extends AbstractMenuView {

    private ClienteService clienteService;
    private VeiculoService veiculoService;
    private AlugarVeiculoService alugarVeiculoService;

    private DevolverVeiculoService devolverVeiculoService;


    public Menu(ClienteService clienteService,

                VeiculoService veiculoService,
                AlugarVeiculoService alugarVeiculoService,
                DevolverVeiculoService devolverVeiculoService
                ) {
        super(new String[]{
                "1 - Cadastrar Cliente",
                "2 - Cadastrar Carro",
                "3 - Alterar Cliente",
                "4 - Alterar Carro",
                "5 - Listar Carros",
                "6 - Listar Clientes",
                "7 - Alugar veiculo",
                "8 - Buscar veiculo por parte do nome",
                "9 - Devolver veiculo",
                "Selecione uma opcao: ",

        });

        {
            this.clienteService = clienteService;
            this.veiculoService = veiculoService;
            this.alugarVeiculoService = alugarVeiculoService;
            this.devolverVeiculoService = devolverVeiculoService;

        }
    }


    @Override
    protected Boolean validOption(Integer option) {
        return option >= 1 && option <= 9;
    }

    @Override
    protected void executeOption(Integer option) {
        switch (option) {
            case 1 -> new CadastrarClienteMenu(clienteService).execute();
            case 2 -> new CadastrarVeiculoMenu(veiculoService).execute();
            case 3 -> new AlterarClienteMenu(clienteService).execute();
            case 4 -> new AlterarVeiculoMenu(veiculoService).execute();
            case 5 -> new ListarVeiculosMenu(veiculoService,alugarVeiculoService).execute();
            case 6 -> new ListarClienteMenu(clienteService).execute();
            case 7 -> new AlugarCarro(veiculoService,clienteService,alugarVeiculoService).execute();
            case 8 -> new BuscaVeiculosPorNome(veiculoService).execute();
            case 9 -> new DevolucaoCarro(veiculoService,clienteService,devolverVeiculoService).execute();



        }
        execute();

    }
}
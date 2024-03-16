import banco.BancoCliente;
import banco.BancoVeiculo;
import banco.BancoPlacasCadastradas;
import banco.BancoVeiculoAlugados;
import modelo.*;
import repositorio.ClienteRepositorio;
import repositorio.PlacasRepositorio;
import repositorio.VeiculoRepositorio;
import repositorio.VeiculosAlugadosRepositorio;
import service.services.AlugarVeiculoService;
import service.services.ClienteService;
import service.services.DevolverVeiculoService;
import service.services.VeiculoService;
import view.Menu;

public class  Main {
    public static void main(String[] args) {
        BancoCliente bancoCliente = new BancoCliente();
        BancoVeiculo bancoVeiculo = new BancoVeiculo();
        BancoVeiculoAlugados bancoVeiculoAlugados = new BancoVeiculoAlugados();
        BancoPlacasCadastradas bancoPlacasCadastradas = new BancoPlacasCadastradas();
        VeiculoRepositorio veiculoRepositorio = new VeiculoRepositorio(bancoVeiculo);
        ClienteRepositorio clienteRepositorio = new ClienteRepositorio(bancoCliente);
        VeiculosAlugadosRepositorio veiculosAlugadosRepositorio = new VeiculosAlugadosRepositorio(bancoVeiculoAlugados);
        PlacasRepositorio placasRepositorio = new PlacasRepositorio(bancoPlacasCadastradas);
        ClienteService clienteService = new ClienteService(clienteRepositorio);
        VeiculoService veiculoService = new VeiculoService(veiculoRepositorio,placasRepositorio);
        AlugarVeiculoService alugarVeiculoService = new AlugarVeiculoService(veiculoRepositorio,clienteRepositorio,veiculosAlugadosRepositorio);
        DevolverVeiculoService devolverVeiculoService = new DevolverVeiculoService(veiculoRepositorio,clienteRepositorio,veiculosAlugadosRepositorio);



        Menu menu = new Menu(clienteService, veiculoService,alugarVeiculoService,devolverVeiculoService);
        menu.execute();
    }
}
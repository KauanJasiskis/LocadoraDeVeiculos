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
        //Explicando como o programa funciona
        //1- Cadastrar cliente te dera duas opcoes cadastrar cliente fisico e juridico
        // 2 - Cadastrar veiculos te dara tres opcoes - cadastrar veiculo pequeno, medio ou SUV
        // 3 - Alterar cliente voce pode digitar o identificador(cpf ou cnpj) que o programa busca no banco e te permite alterar apenas o nome deste cliente
        // 4 - Alterar carro basicamente faz o mesmo do alterar cliente
        // 5 - Listar carros te permite ver a lista de carros disponiveis ou os carros que estao atualmente alugados
        // 6 - listar cliente te disponibiliza a ver a lista de todos clientes cadastrados
        // 7 - alugar veiculo te possibilita a alugar um veiculo para um cliente ja existente no banco e este veiculo tambem tem que ja existir no banco
        // na hora de alugar e devolver tenha atencao para seguir o modelo de data e hora que o programa precisa que voce informe
        // ainda nao consegui tratar a excecao deste erro
        //8 - Buscar veiculo por parte do nome te retorna uma lista de todos os veiculos que comece com as 3 primeiras letras que voce informou
        //9 - devolucao de veiculo retorna um veiculo para o banco de veiculos disponivel e informa o valor que o cliente
        // precisa pagar na hora da entrega do carro baseado na diaria


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
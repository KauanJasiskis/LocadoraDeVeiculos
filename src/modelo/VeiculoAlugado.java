package modelo;

public class VeiculoAlugado {
    private DetalhesEmprestimoCarro detalhesEmprestimoCarro;
    private AbstractVeiculo veiculoQueFoiAlugado;

    private AbstractCliente clienteQueAlugou;

    public VeiculoAlugado(DetalhesEmprestimoCarro detalhesEmprestimoCarro, AbstractVeiculo veiculoQueFoiAlugado, AbstractCliente clienteQueAlugou) {
        this.detalhesEmprestimoCarro = detalhesEmprestimoCarro;
        this.veiculoQueFoiAlugado = veiculoQueFoiAlugado;
        this.clienteQueAlugou = clienteQueAlugou;
    }

    public AbstractVeiculo getVeiculoQueFoiAlugado() {
        return veiculoQueFoiAlugado;
    }

    public AbstractCliente getClienteQueAlugou() {
        return clienteQueAlugou;
    }

    public DetalhesEmprestimoCarro getDetalhesEmprestimoCarro() {
        return detalhesEmprestimoCarro;
    }

    @Override
    public String toString() {
        return "\nVeiculo: " + veiculoQueFoiAlugado.getPlaca()
                + "\nAlugado por : " + clienteQueAlugou.getNome()
                + "\nLocal : " + detalhesEmprestimoCarro.getLocal()
                + "\nData e Hora : " + FormatarDataHorario.formatoDataEHora(detalhesEmprestimoCarro.getDataEHoraEmprestimo());


    }
}

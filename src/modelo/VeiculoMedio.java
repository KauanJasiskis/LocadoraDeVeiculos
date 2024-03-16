package modelo;

public class VeiculoMedio extends AbstractVeiculo {
    private static final double taxa = 150.0;
    private static final String tipo = "Medio";

    public VeiculoMedio(String nome, String ano, String placa) {
        super(nome, ano, placa);
    }

    @Override
    public Double getTaxa() {
        return taxa;
    }

    @Override
    public String getTipo() {
        return tipo;
    }


}







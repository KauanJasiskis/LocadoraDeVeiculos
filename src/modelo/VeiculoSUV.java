package modelo;

public class VeiculoSUV extends AbstractVeiculo {
    private static final double taxa = 200.0;
    private static final String tipo = "SUV";
    public VeiculoSUV(String nome, String ano, String placa) {
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


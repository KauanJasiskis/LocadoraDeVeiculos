package modelo;

public class VeiculoPequeno extends AbstractVeiculo {
    private static final Double taxa = 100.0;
    private static final String tipo = "Pequeno";

    public VeiculoPequeno(String nome, String ano, String placa) {
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


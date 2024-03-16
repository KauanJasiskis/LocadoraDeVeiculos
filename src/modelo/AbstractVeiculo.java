package modelo;

public abstract class AbstractVeiculo  {
    private String nome;
    private String ano;
    private String placa;

    private Double taxa;

    private String tipo;




    public AbstractVeiculo(String nome, String ano, String placa) {
        this.nome = nome;
        this.ano = ano;
        this.placa = placa;
        this.taxa = 0.0;
        this.tipo = "N/A";
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getAno() {
        return ano;
    }


    public String getPlaca() {
        return placa;
    }

    public void setPlaca(String placa) {
        this.placa = placa;
    }

    public abstract Double getTaxa();
    public abstract String getTipo();


    @Override
    public String toString() {
        return "\nNome:  " + getNome()
                + "\nAno: " + getAno()
                + "\nPlaca: " + getPlaca()
                + "\nTipo: " + getTipo();



    }


}


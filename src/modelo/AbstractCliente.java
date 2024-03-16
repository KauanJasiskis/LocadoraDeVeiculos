package modelo;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public abstract class AbstractCliente {
    private String nome;

    private List<AbstractVeiculo> veiculosAlugados;

    private final String identificador;

    private String tipo;

    public AbstractCliente(String nome, String identificador) {
        this.nome = nome;
        this.veiculosAlugados = new ArrayList<>();
        this.identificador = identificador;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }


    public List<AbstractVeiculo> getVeiculosAlugados() {
        return veiculosAlugados;
    }

    public String getIdentificador() {
        return identificador;
    }

    public void adicionarVeiculosAlugado(AbstractVeiculo veiculo) {
        veiculosAlugados.add(veiculo);
    }

    public void removerVeiculoAlugado(AbstractVeiculo veiculo) {
        veiculosAlugados.remove(veiculo);
    }

    public abstract String getTipo();


}

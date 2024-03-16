package modelo;

import java.time.LocalDate;

public class ClienteJuridico extends AbstractCliente {

    private final String tipo = "JURIDICO";

    public ClienteJuridico(String nome, String cnpj) {
        super(nome, cnpj);

    }

    @Override
    public String getTipo() {
        return tipo;
    }

    @Override
    public String toString() {
        return "\nNome:  " + getNome()
                + "\nVeiculos Alugados: " + getVeiculosAlugados()
                + "\nCNPJ: " + getIdentificador();

    }
}

package modelo;

import java.time.LocalDate;

public class ClienteFisico extends AbstractCliente {

    private final String tipo = "FISICO";


    public ClienteFisico(String nome, String cpf) {
        super(nome, cpf);
    }


    @Override
    public String toString() {
        return "\nNome:  " + getNome()
                + "\nVeiculos Alugados: " + getVeiculosAlugados()
                + "\nCPF: " + getIdentificador();

    }

    @Override
    public String getTipo() {
        return tipo;
    }
}

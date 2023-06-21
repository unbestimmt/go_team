package Delegacao;

public class Corredor extends Atleta {

    private double velocidade;
    private static final long serialVersionUID = 1L;

    public Corredor(String nome, int numero, int idade, double velocidade) {
        super(nome, numero, idade);
        this.velocidade = velocidade;
    }

    @Override
    public String treinar() {
        return "Correndo";
    }
}

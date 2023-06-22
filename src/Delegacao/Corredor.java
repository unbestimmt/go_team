package Delegacao;

public class Corredor extends Atleta {

    private double velocidade;
    private static final long serialVersionUID = 1L;

    public Corredor(String nome, int numero, int idade, double velocidade) {
        super(nome, numero, idade);
        this.velocidade = velocidade;
    }

    public double getVelocidade() {
        return velocidade;
    }

    public void setVelocidade(double velocidade) {
        this.velocidade = velocidade;
    }

    @Override
    public String treinar() {
        return "Correndo";
    }

    @Override
    public String toString() {
        String retorno = super.toString();
        retorno += "Velocidade: " + this.velocidade + " metros/segundo\n";
        return retorno;

    }

}

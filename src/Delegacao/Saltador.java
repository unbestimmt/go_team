package Delegacao;

public class Saltador extends Atleta {

    private double altura;
    private static final long serialVersionUID = 1L;

    public Saltador(String nome, int numero, int idade, double altura) {
        super(nome, numero, idade);
        this.altura = altura;
    }

    @Override
    public String treinar() {
        return "Saltando";
    }

    public String toString() {
        String retorno = super.toString();
        retorno += "Altura: " + this.altura + " metros\n";
        return retorno;

    }

}

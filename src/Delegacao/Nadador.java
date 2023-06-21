package Delegacao;

public class Nadador extends Atleta {

    private String estilo;
    private static final long serialVersionUID = 1L;

    public Nadador(String nome, int numero, int idade, String estilo) {
        super(nome, numero, idade);
        this.estilo = estilo;
    }

    @Override
    public String treinar() {
        return "Nadando";
    }
}

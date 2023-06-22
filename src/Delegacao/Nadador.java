package Delegacao;

public class Nadador extends Atleta {

    private String estilo;
    private static final long serialVersionUID = 1L;

    public Nadador(String nome, int numero, int idade, String estilo) {
        super(nome, numero, idade);
        this.estilo = estilo;
    }

    public String getEstilo() {
        return estilo;
    }

    public void setEstilo(String estilo) {
        this.estilo = estilo;
    }

    @Override
    public String treinar() {
        return "Nadando";
    }

    @Override
    public String toString() {
        String retorno = super.toString();
        retorno += "Estilo: " + this.estilo + "\n";
        return retorno;

    }

}

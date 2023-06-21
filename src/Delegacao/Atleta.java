package Delegacao;

import java.io.Serializable;

public abstract class Atleta implements Serializable {

    private static final long serialVersionUID = 1L;
    private   String nome;
    private   int numero;
    private int idade;

    public Atleta(String nome, int numero, int idade) {
        this.nome = nome;
        this.numero = numero;
        this.idade = idade;
    }

    public String toString() {
        String retorno = "";
        retorno += "Nome: "     + this.nome     + "\n";
        retorno += "Número: "    + this.numero    + "\n";
        retorno += "Idade: "     + this.idade     + " anos\n";
        retorno += "Treino: "  + treinar()        + "\n";
        return retorno;
    }

    public abstract String treinar();

}

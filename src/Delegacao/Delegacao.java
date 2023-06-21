package Delegacao;

import javax.swing.*;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.util.ArrayList;

public class Delegacao {

    private ArrayList<Atleta> atletas;

    public Delegacao() {
        this.atletas = new ArrayList<Atleta>();
    }

    public String[] leValores (String [] dadosIn){
        String [] dadosOut = new String [dadosIn.length];

        for (int i = 0; i < dadosIn.length; i++)
            dadosOut[i] = JOptionPane.showInputDialog  ("Entre com " + dadosIn[i]+ ": ");

        return dadosOut;
    }

    public Saltador leSaltador (){

        String [] valores = new String [4];
        String [] nomeVal = {"Nome", "Número", "Idade", "Altura"};
        valores = leValores (nomeVal);

        int numero = this.retornaInteiro(valores[1]);
        int idade = this.retornaInteiro(valores[2]);
        int altura = this.retornaInteiro(valores[3]);

        Saltador saltador = new Saltador (valores[0],numero,idade,altura);
        return saltador;
    }

    public Corredor leCorredor (){

        String [] valores = new String [4];
        String [] nomeVal = {"Nome", "Número", "Idade", "Velocidade"};
        valores = leValores (nomeVal);

        int numero = this.retornaInteiro(valores[1]);
        int idade = this.retornaInteiro(valores[2]);
        double velocidade = this.retornaInteiro(valores[3]);

        Corredor corredor = new Corredor (valores[0],numero,idade,velocidade);
        return corredor;
    }

    public Nadador leNadador (){

        String [] valores = new String [4];
        String [] nomeVal = {"Nome", "Número", "Idade", "Estilo"};
        valores = leValores (nomeVal);

        int numero = this.retornaInteiro(valores[1]);
        int idade = this.retornaInteiro(valores[2]);

        Nadador nadador = new Nadador (valores[0],numero,idade,valores[3]);
        return nadador;
    }

    //TRANSFORMA STRING EM INTEIRO
    private boolean intValido(String s) {
        try {
            Integer.parseInt(s); // M�todo est�tico, que tenta tranformar uma string em inteiro
            return true;
        } catch (NumberFormatException e) { // N�o conseguiu tranformar em inteiro e gera erro
            return false;
        }
    }
    public int retornaInteiro(String entrada) { // retorna um valor inteiro
        int numInt;

        //Enquanto n�o for poss�vel converter o valor de entrada para inteiro, permanece no loop
        while (!this.intValido(entrada)) {
            entrada = JOptionPane.showInputDialog(null, "Valor incorreto!\n\nDigite um n�mero inteiro.");
        }
        return Integer.parseInt(entrada);
    }

    public void salvaMamiferos (ArrayList<Mamifero> mamiferos){
        ObjectOutputStream outputStream = null;
        try {
            outputStream = new ObjectOutputStream
                    (new FileOutputStream("c:\\temp\\petStore.dados"));
            for (int i=0; i < mamiferos.size(); i++)
                outputStream.writeObject(mamiferos.get(i));
        } catch (FileNotFoundException ex) {
            JOptionPane.showMessageDialog(null,"Imposs�vel criar arquivo!");
            ex.printStackTrace();
        } catch (IOException ex) {
            ex.printStackTrace();
        } finally {  //Close the ObjectOutputStream
            try {
                if (outputStream != null) {
                    outputStream.flush();
                    outputStream.close();
                }
            } catch (IOException ex) {
                ex.printStackTrace();
            }
        }
    }

}

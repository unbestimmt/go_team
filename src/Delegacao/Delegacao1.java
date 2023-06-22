package Delegacao;

import java.io.*;
import java.util.ArrayList;

public class Delegacao1 {

    private ArrayList<Atleta> atletas;


    public Delegacao1( ) {
        this.atletas = new ArrayList<Atleta>();
    }

    public void adicionaAtleta(Atleta mani) {
        this.atletas.add(mani);
    }

    public void listarAtletas() {
        for(Atleta mani:atletas) {
            System.out.println(mani.toString());
        }
        System.out.println("Total = " + this.atletas.size() + " atletas listados com sucesso!\n");
    }

    public void excluirAtleta(Atleta mani) {
        if (this.atletas.contains(mani)) {
            this.atletas.remove(mani);
            System.out.println("[Atleta " + mani.toString() + "excluido com sucesso!]\n");
        }
        else
            System.out.println("Atleta inexistente!\n");
    }

    public void excluirAtletas() {
        atletas.clear();
        System.out.println("Atletas excluídos com sucesso!\n");
    }
    public void gravarAtletas()  {
        ObjectOutputStream outputStream = null;
        try {
            outputStream = new ObjectOutputStream (new FileOutputStream("c:\\temp\\atletas.dat"));
            for(Atleta mani:atletas) {
                outputStream.writeObject(mani);
            }
        }catch (FileNotFoundException ex) {
            ex.printStackTrace();
        }catch (IOException ex) {
            ex.printStackTrace();
        }finally{
            try {
                if (outputStream != null ) {
                    outputStream.flush();
                    outputStream.close();
                }
            }catch (IOException ex) {
                ex.printStackTrace();
            }
        }
    }
    public void recuperarAtletas() {
        ObjectInputStream inputStream = null;
        try {
            inputStream	= new ObjectInputStream (new FileInputStream ("c:\\temp\\atletas.dat"));
            Object obj = null;
            while((obj = inputStream.readObject ()) != null) {
                if (obj instanceof Saltador)
                    this.atletas.add((Saltador)obj);
                else if (obj instanceof Corredor)
                    this.atletas.add((Corredor)obj);
                else if (obj instanceof Nadador)
                    this.atletas.add((Nadador)obj);
            }
        }catch (EOFException ex) {     // when EOF is reached
            System.out.println ("End of file reached");
        }catch (ClassNotFoundException ex) {
            ex.printStackTrace();
        }catch (FileNotFoundException ex) {
            ex.printStackTrace();
        }catch (IOException ex) {
            ex.printStackTrace();
        }finally{
            try {
                if (inputStream != null ) {
                    inputStream.close();
                    System.out.println("Atletas recuperados com sucesso!\n");
                }
            }catch (IOException ex) {
                ex.printStackTrace();
            }
        }
    }

    public static void main(String[] args) {
        Delegacao1 pet  = new Delegacao1();

        Saltador javier = new Saltador("Javier Sotomayor",    1, 26, 2.45);
        Saltador stefka = new Saltador("Stefka Kostadinova", 2, 22, 2.09);
        Corredor usain = new Corredor ("Usain Bolt",  3, 23, 10.44);
        Corredor florence = new Corredor ("Florence Griffith-Joyner",  4, 29, 9.53);
        Nadador michael = new Nadador ("Michael Phelps", 5, 27, "Nado borboleta");
        Nadador cate = new Nadador ("Cate Campbell", 6, 25, "Nado livre");
        pet.adicionaAtleta(javier);
        pet.adicionaAtleta(stefka);
        pet.adicionaAtleta(usain);
        pet.adicionaAtleta(florence);
        pet.adicionaAtleta(michael);
        pet.adicionaAtleta(cate);
        pet.listarAtletas();
        pet.gravarAtletas();
        pet.excluirAtleta(usain);
        pet.listarAtletas();
        pet.excluirAtletas();
        pet.listarAtletas();
        pet.recuperarAtletas();
        pet.listarAtletas();
    }

}

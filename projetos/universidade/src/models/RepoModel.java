package models;

import java.util.ArrayList;

public class RepoModel {
    String id;
    String nome;
    ArrayList<DevModel> colaboradores = new ArrayList<>();

    public void addColaborador(DevModel dev) {
        this.colaboradores.add(dev);
    }

    public RepoModel(String id, String nome) {
        this.id = id;
        this.nome = nome;
        this.colaboradores = new ArrayList<>();
    }

    public void printRepoWithoutDevs() {
        System.out.println("repo id: "+this.id);
        System.out.println("repo nome: "+this.nome);
    }

    public void printRepoWithDevs() {
        System.out.println("repo id: "+this.id);
        System.out.println("repo nome: "+this.nome);
        for (DevModel dev : colaboradores) {
            dev.printDevWithoutRepo();
        }
    }
}

package models;

import java.util.ArrayList;

public class DevModel {
    String id;
    String nome;
    ArrayList<RepoModel> repositorios = new ArrayList<>();

    public DevModel(String id, String nome, ArrayList<RepoModel> repos) {
        this.id = id;
        this.nome = nome;
        this.repositorios = repos;
    }

    public void printDevWithoutRepo() {
        System.out.println("dev id: "+this.id);
        System.out.println("dev nome: "+this.nome);
    }

    public void printDevWithRepo() {
        System.out.println("dev id: "+this.id);
        System.out.println("dev nome: "+this.nome);
        for (RepoModel repo : repositorios) {
            repo.printRepoWithoutDevs();
        }
        
    }
}

package models;

public class ProfissaoModel {
    String id;
    String nome;
    String created_at;

    public ProfissaoModel(String id, String created_at, String nome) {
        this.id = id;
        this.created_at = created_at;
        this.nome = nome;
    }

    public String getID() {
        return this.id;
    }

    public void print() {
        System.out.println("---");
        System.out.println("id: " + this.id);
        System.out.println("nome: " + this.nome);
        System.out.println("created_at: " + this.created_at);
    }
}

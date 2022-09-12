package models;

public class User {
    String id;
    String nome;
    String age;
    String created_at;

    public User(String id, String created_at, String nome, String age) {
        this.id = id;
        this.nome = nome;
        this.age = age;
        this.created_at = created_at;
    }

    public void print() {
        System.out.println(this.nome);
    }
}

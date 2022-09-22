package models;

public class AlunoModel {
    String id;
    String nome;
    String idade;
    ProfissaoModel profissao;
    String created_at;

    public AlunoModel(String id, String created_at, String nome, String age, ProfissaoModel profissão) {
        this.id = id;
        this.nome = nome;
        this.profissao = profissão;
        this.idade = age;
        this.created_at = created_at;
    }

    public void print() {
        System.out.println("---");
        System.out.println("id: " + this.id);
        System.out.println("nome: " + this.nome);
        System.out.println("idade: " + this.idade);
        System.out.println("profissao: " + this.profissao.nome);
        System.out.println("created_at: " + this.created_at);
    }
}

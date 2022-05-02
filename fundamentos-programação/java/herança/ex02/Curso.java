package herança.ex02;

import java.util.ArrayList;

public class Curso {
    String nome;
    ArrayList<Aluno>alunos = new ArrayList<>();

    Curso (String nome) {
        this.nome = nome;
    }
    void adicionarAluno(Aluno aluno) {
        this.alunos.add(aluno);
        aluno.cursos.add(this);
    }

    ArrayList<String> obterCurso() {
        ArrayList<String>cadastrados = new ArrayList<>();
        for (Aluno aluno : alunos) {
            cadastrados.add(aluno.nome);
        }
        return cadastrados;
    }
}

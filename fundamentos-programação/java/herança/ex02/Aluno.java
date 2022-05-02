package herança.ex02;

import java.util.ArrayList;

public class Aluno {
    String nome;
    ArrayList<Curso>cursos = new ArrayList<>();

    Aluno (String nome) {
        this.nome = nome;
    }
    void adicionarCurso(Curso cursos) {
        this.cursos.add(cursos);
        cursos.alunos.add(this);
    }
}

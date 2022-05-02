package herança.ex02;

public class Main {
    public static void main(String[] args) {
        Aluno aluno1 = new Aluno("João");
        Aluno aluno2 = new Aluno("Maria");
        Aluno aluno3 = new Aluno("Dante");

        Curso cursos1 = new Curso("Java");
        Curso cursos2 = new Curso("Python");
        Curso cursos3 = new Curso("VSDIA");

        cursos1.adicionarAluno(aluno1);
        cursos1.adicionarAluno(aluno2);

        cursos1.adicionarAluno(aluno1);
        cursos2.adicionarAluno(aluno3);

        aluno1.adicionarCurso(cursos3);
        aluno2.adicionarCurso(cursos3);
        aluno3.adicionarCurso(cursos3);

        System.out.println(cursos1.alunos.get(0).nome);
        System.out.println(aluno1.cursos.get(0).nome);
        System.out.println(cursos3.obterCurso());
    }
}
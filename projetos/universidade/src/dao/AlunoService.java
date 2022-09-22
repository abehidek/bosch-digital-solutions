package dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import models.AlunoModel;
import models.ProfissaoModel;

public class AlunoService {
    public static void createAluno(Connection connection) throws SQLException {
        connection.createStatement().executeUpdate("INSERT INTO aluno (nome, idade, profissao_id) VALUES ('nobre', 24, 2)");
    }

    public static ArrayList<AlunoModel> allUsers(Connection connection) throws SQLException {
        ArrayList<ProfissaoModel> profissoes = ProfissaoService.allProfissao(connection);

        ResultSet ac = connection.createStatement().executeQuery("SELECT * from aluno");
        ArrayList<AlunoModel> alunos = new ArrayList<>();

        while (ac.next()) {
            AlunoModel aluno = new AlunoModel(
                ac.getString(1)
                ,ac.getString(2)
                ,ac.getString(3)
                ,ac.getString(4)
                ,ProfissaoService.getProfissao(ac.getString(5), profissoes)
            );
            alunos.add(aluno);
        }
        return alunos;
    }
}


import java.util.ArrayList;

import dao.AlunoService;
import dao.Database;
import dao.DevRepoService;
import models.DevModel;

import java.sql.Connection;

public class Main {
    public static void main(String[] args) throws Exception {
        System.out.println("Hello, World!");
        Database dao = new Database();
        Connection connection = dao.connect();
        // AlunoService.createAluno(connection);
        // ArrayList<models.AlunoModel> alunos = AlunoService.allAlunos(connection);
        ArrayList<DevModel> devs = DevRepoService.allDevs(connection);

        devs.get(1).printDevWithRepo();

        // alunos.get(0).print();
    }
}

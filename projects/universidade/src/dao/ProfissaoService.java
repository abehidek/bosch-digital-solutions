package dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import models.ProfissaoModel;

public class ProfissaoService {
    public static ProfissaoModel getProfissao(String profissaoID, ArrayList<ProfissaoModel> profissoes) {
        for (ProfissaoModel profissao : profissoes) {
            if (profissao.getID().equals(profissaoID)) {
                return profissao;
            }
        }
        return null;
    }

    public static ArrayList<ProfissaoModel> allProfissao(Connection connection) throws SQLException {
        ResultSet pc = connection.createStatement().executeQuery("SELECT * from profissao");
        ArrayList<ProfissaoModel> profissoes = new ArrayList<>();
        
        while (pc.next()) {
            ProfissaoModel profissao = new ProfissaoModel(
                pc.getString(1)
                ,pc.getString(2)
                ,pc.getString(3)
            );
            profissoes.add(profissao);
        }

        return profissoes;
    }
}

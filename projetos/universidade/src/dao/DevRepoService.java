package dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import models.DevModel;
import models.RepoModel;

public class DevRepoService {
    public static RepoModel getOneRepo(String repo_id, Connection connection) throws SQLException {
        ResultSet pc = connection.createStatement().executeQuery("SELECT * from repo where id="+repo_id);
        while (pc.next()) {
            return new RepoModel(pc.getString(1), pc.getString(2));
        }
        return null;
    }

    public static ArrayList<RepoModel> getRepoFromDevID(String dev_id, Connection connection) throws SQLException {
        ResultSet pc = connection.createStatement().executeQuery("SELECT * from dev_repo where dev_id="+dev_id);
        ArrayList<RepoModel> repositorios = new ArrayList<>();
        while (pc.next()) {
            RepoModel repo = getOneRepo(pc.getString(3), connection);
            repositorios.add(repo);
        }
        return repositorios;
    }

    public static ArrayList<DevModel> allDevs(Connection connection) throws SQLException {
        ResultSet pc = connection.createStatement().executeQuery("SELECT * from dev");
        ArrayList<DevModel> devs = new ArrayList<>();
        while (pc.next()) {
            // System.out.println("id from dev: "+pc.getString(1));
            // System.out.println("name from dev: "+pc.getString(2));
            ArrayList<RepoModel> repos = getRepoFromDevID(pc.getString(1), connection);
            DevModel dev = new DevModel(pc.getString(1), pc.getString(2), repos);
            for (RepoModel repo : repos) {
                repo.addColaborador(dev);
            }
            devs.add(dev);
        }
        return devs;
    }
}

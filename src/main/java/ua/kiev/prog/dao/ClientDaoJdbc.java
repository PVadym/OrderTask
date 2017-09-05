package ua.kiev.prog.dao;

import ua.kiev.prog.entity.Client;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

/**
 * Created by Вадим on 03.09.2017.
 */
public class ClientDaoJdbc implements ClientDao {

    private Connection connection;

    private static final String SAVE = "INSERT INTO clients (name,address,phone) VALUES(?,?,?)";


    public ClientDaoJdbc(Connection connection) {
        this.connection = connection;
    }


    @Override
    public void add(Client client) {
        try (PreparedStatement ps = connection.prepareStatement(SAVE)) {
            ps.setString(1,client.getName());
            ps.setString(2,client.getAddress());
            ps.setString(3,client.getPhone());
            ps.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }

    }
}

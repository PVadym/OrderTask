package ua.kiev.prog.dao;

import ua.kiev.prog.entity.Product;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

/**
 * Created by Вадим on 03.09.2017.
 */
public class ProductDaoJdbc implements ProductDao {

    private Connection connection;

    private static final String SAVE = "INSERT INTO products (name, discription, price) VALUES(?,?,?)";


    public ProductDaoJdbc(Connection connection) {
        this.connection = connection;
    }

    @Override
    public void add(Product product) {
        try (PreparedStatement ps = connection.prepareStatement(SAVE)) {
            ps.setString(1, product.getName());
            ps.setString(2, product.getDescription());
            ps.setInt(3, product.getPrice());
            ps.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}

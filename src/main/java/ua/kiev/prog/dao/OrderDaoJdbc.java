package ua.kiev.prog.dao;

import ua.kiev.prog.entity.Order;
import ua.kiev.prog.entity.Product;

import java.sql.*;

/**
 * Created by Вадим on 03.09.2017.
 */
public class OrderDaoJdbc implements OrderDao {

    private Connection connection;

    private static final String SAVE = "INSERT INTO orders (date,user_id) VALUES(?,?)";
    private static final String SAVE_PRODUCTS = "INSERT INTO products_orders (product_id, order_id) VALUES(?,?)";
    private final static String GET_LAST_INSERTED = "SELECT LAST_INSERT_ID()";


    public OrderDaoJdbc(Connection connection) {
        this.connection = connection;
    }
    @Override
    public void add(Order order) {
        try {
            connection.setAutoCommit(false);
            try(PreparedStatement ps = connection.prepareStatement(SAVE)){
                ps.setTimestamp(1, new Timestamp(order.getDate().getTime()));
                ps.setInt(2, order.getClient().getId());
                ps.executeUpdate();
            }
            long id;
            try (Statement statement = connection.createStatement()) {
                ResultSet resultSet = statement.executeQuery(GET_LAST_INSERTED);
                resultSet.next();
                id = resultSet.getLong(1);
            }
            try (PreparedStatement statement = connection.prepareStatement(SAVE_PRODUCTS)) {
                for (Product product : order.getProductList()) {
                    statement.setLong(1, product.getId());
                    statement.setLong(2, id);
                    statement.addBatch();
                }
                statement.executeBatch();
            }
            connection.commit();
        } catch (SQLException e) {
            try {
                connection.rollback();
            } catch (SQLException e1) {
                e1.printStackTrace();
            }
            e.printStackTrace();
        }finally {
            try {
                connection.setAutoCommit(true);
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }

    }
}

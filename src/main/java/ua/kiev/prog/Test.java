package ua.kiev.prog;

import ua.kiev.prog.connection.ConnectionMySql;
import ua.kiev.prog.dao.*;
import ua.kiev.prog.entity.Client;
import ua.kiev.prog.entity.Order;
import ua.kiev.prog.entity.Product;

import java.sql.Connection;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;


/**
 * Created by Вадим on 03.09.2017.
 */
public class Test {

    public static void main(String[] args) {

        Connection connection = new ConnectionMySql().getConnection();
        ClientDao clientDao = new ClientDaoJdbc(connection);
        OrderDao orderDao = new OrderDaoJdbc(connection);
        ProductDao productDao = new ProductDaoJdbc(connection);

        Client client = new Client(3,"Vadim","Kiev","555");
        Product product = new Product(4,"one","ONE",10);
        Product product2 = new Product(5,"two","TWO",20);
        Product product3 = new Product(6,"three","THREE",30);
        List<Product> products = new ArrayList<>();
        products.add(product);
        products.add(product2);
        products.add(product3);
        Order order = new Order(new Date(),client, products);

        clientDao.add(client);
        productDao.add(product);
        productDao.add(product2);
        productDao.add(product3);
        orderDao.add(order);


    }
}

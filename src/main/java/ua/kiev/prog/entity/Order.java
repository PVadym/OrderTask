package ua.kiev.prog.entity;

import java.util.Date;
import java.util.List;

/**
 * Created by Вадим on 03.09.2017.
 */
public class Order {

    private  int id;
    private Date date;
    private Client client;
    private List<Product> productList;

    public Order() {
    }

    public Order(int id, Date date, Client client) {
        this.id = id;
        this.date = date;
        this.client = client;
    }

    public Order(Date date, Client client, List<Product> productList) {
        this.date = date;
        this.client = client;
        this.productList = productList;
    }

    public Order(int id, Date date, Client client, List<Product> productList) {
        this.id = id;
        this.date = date;
        this.client = client;
        this.productList = productList;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public Client getClient() {
        return client;
    }

    public void setClient(Client client) {
        this.client = client;
    }

    public List<Product> getProductList() {
        return productList;
    }

    public void setProductList(List<Product> productList) {
        this.productList = productList;
    }

    @Override
    public String toString() {
        return "Order{" +
                "id=" + id +
                ", date=" + date +
                ", client=" + client +
                '}';
    }
}

package shoeRepair.database;

import shoeRepair.Order;

import java.util.List;

public interface OrderDAO {

    void save(Order order);
    List<Order> getOrders();

    Order getOrderById(int id);
}

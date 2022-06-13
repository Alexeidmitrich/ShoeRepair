package shoeRepair.database;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import shoeRepair.Client;
import shoeRepair.Order;
import shoeRepair.database.hibernate.HiberUtil;

import java.util.List;

public class OrderDAOImpl implements  OrderDAO{
    @Override
    public void save(Order order) {
        SessionFactory factory = HiberUtil.getSessionFactory();
        Session session = factory.openSession();
        session.beginTransaction();
        session.save(order);
        session.getTransaction().commit();
        factory.close();
    }

    @Override
    public List<Order> getOrders() {
        return null;
    }

    public static void main(String[] args) {
        Client client = new Client("A", "B","33-33-33");
        new ClientDAOImpl().save(client);
        Order order = new Order( "Fake Order", "Fake description", client);
        new OrderDAOImpl().save(order);
    }
}

package shoeRepair.database;

import shoeRepair.Order;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import java.util.List;

public class OrderDAOImpl implements  OrderDAO{
    private static final String PERSISTENCE_UNIT_NAME = "todos";
    private EntityManagerFactory factory;

    @Override
    public void save(Order order) {
        factory = Persistence.createEntityManagerFactory("todos");
        EntityManager em = factory.createEntityManager();
        em.getTransaction().begin();
        em.merge(order);
        em.getTransaction().commit();
        em.close();
        factory.close();
    }

    @Override
    public Order getOrderById(int id) {
        Order order = null;
        factory = Persistence.createEntityManagerFactory("todos");
        EntityManager em = factory.createEntityManager();
        try {
            em.getTransaction().begin();
            order =em.find(Order.class, id);
            em.getTransaction().commit();
        } catch (Exception e) {
            factory.close();
        }
        return order;
    }

    @Override
    public List<Order> getOrders() {
    factory = Persistence.createEntityManagerFactory("todos");
           EntityManager em = factory.createEntityManager();
           List<Order> list = em.createQuery("SELECT o FROM Order o").getResultList();
        for(int i = 0; i < list.size(); i++) {
        Order o = list.get(i);
        }
        return list;
        }
}

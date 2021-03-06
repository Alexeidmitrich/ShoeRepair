package shoeRepair.database;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import shoeRepair.Client;
import shoeRepair.database.hibernate.HiberUtil;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import java.util.List;

public class ClientDAOImpl implements ClientDAO {
    private static final String PERSISTENCE_UNIT_NAME = "todos";
    private static EntityManagerFactory factory;

    @Override
    public List<Client> getAllClient() {
        factory = Persistence.createEntityManagerFactory("todos");
        EntityManager em = factory.createEntityManager();
        List<Client> list = em.createQuery("SELECT c FROM Client c").getResultList();
        for(int i = 0; i < list.size(); i++) {
            Client c = list.get(i);
        }
        return list;
    }

    @Override
    public Client getClientById(int id) {
        Client client = null;
        factory = Persistence.createEntityManagerFactory("todos");
        EntityManager em = factory.createEntityManager();
        try {
            em.getTransaction().begin();
            client =em.find(Client.class, id);
            em.getTransaction().commit();
        } catch (Exception e) {
            factory.close();
        }
        return client;
    }

    @Override
    public void save(Client client) {
        factory = Persistence.createEntityManagerFactory("todos");
        EntityManager em = factory.createEntityManager();
        em.getTransaction().begin();
        em.persist(client);
        em.getTransaction().commit();
        em.close();
        factory.close();
    }
}


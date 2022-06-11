package shoeRepair.database;


import org.hibernate.Session;
import org.hibernate.SessionFactory;
import shoeRepair.Client;
import shoeRepair.database.hibernate.HiberUtil;
import java.util.List;

public class ClientDAOImpl implements ClientDAO {

    @Override
    public List<Client> getAllClient() {
        SessionFactory factory = HiberUtil.getSessionFactory();
        Session session = factory.openSession();
        session.beginTransaction();
        List<Client> clients = session
                .createQuery("FROM Client")
                .getResultList();
        session.getTransaction().commit();
        factory.close();
        return  clients;
    }

    @Override
    public Client getClientById(int id) {
        Client client = null;
        SessionFactory factory = HiberUtil.getSessionFactory();
        Session session = factory.openSession();
        try {
            session.beginTransaction();
            client =session.get(Client.class, id);
            session.getTransaction().commit();
        } catch (Exception e) {
            factory.close();
        }
        return client;
    }

    @Override
    public void save(Client client) {
        SessionFactory factory = HiberUtil.getSessionFactory();
        Session session = factory.openSession();
        session.beginTransaction();
        session.save(client);
        session.getTransaction().commit();
        factory.close();
    }
}


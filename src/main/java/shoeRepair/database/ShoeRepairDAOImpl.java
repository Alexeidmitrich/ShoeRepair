package shoeRepair.database;

import shoeRepair.ShoeRepair;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import java.util.List;


public class ShoeRepairDAOImpl implements ShoeRepairDAO{
    private static final String PERSISTENCE_UNIT_NAME = "todos";
    private EntityManagerFactory factory;

    @Override
    public List<ShoeRepair> getAllInfoShoeRepairClient() {
        factory = Persistence.createEntityManagerFactory("todos");
        EntityManager em = factory.createEntityManager();
        List<ShoeRepair> list = em.createQuery("SELECT s FROM ShoeRepair s").getResultList();
        for(int i = 0; i < list.size(); i++) {
            ShoeRepair s = list.get(i);
        }
        return list;
    }

    @Override
    public ShoeRepair getShoeRepairClientById(int id) {
        ShoeRepair shoeRepair = null;
        factory = Persistence.createEntityManagerFactory("todos");
        EntityManager em = factory.createEntityManager();
        try {
            em.getTransaction().begin();
            shoeRepair =em.find(ShoeRepair.class, id);
            em.getTransaction().commit();
        } catch (Exception e) {
            factory.close();
        }
        return shoeRepair;
    }

    @Override
    public void save(ShoeRepair shoeRepair) {
        factory = Persistence.createEntityManagerFactory("todos");
        EntityManager em = factory.createEntityManager();
        em.getTransaction().begin();
        em.persist(shoeRepair);
        em.getTransaction().commit();
        em.close();
        factory.close();
    }
}

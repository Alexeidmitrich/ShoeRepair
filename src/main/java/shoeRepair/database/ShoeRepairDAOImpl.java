package shoeRepair.database;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import shoeRepair.ShoeRepair;
import shoeRepair.database.hibernate.HiberUtil;
import java.util.List;


public class ShoeRepairDAOImpl implements ShoeRepairDAO{
    @Override
    public List<ShoeRepair> getAllInfoShoeRepairClient() {
        SessionFactory factory = HiberUtil.getSessionFactory();
        Session session = factory.openSession();
        session.beginTransaction();
        List<ShoeRepair> shoeRepair = session
                .createQuery("FROM ShoeRepair")
                .getResultList();
        session.getTransaction().commit();
        factory.close();
        return  shoeRepair;
    }

    @Override
    public ShoeRepair getShoeRepairClientById(int id) {
        ShoeRepair shoeRepair = null;
        SessionFactory factory = HiberUtil.getSessionFactory();
        Session session = factory.openSession();
        try {
            session.beginTransaction();
            shoeRepair =session.get(ShoeRepair.class, id);
            session.getTransaction().commit();
        } catch (Exception e) {
            factory.close();
        }
        return shoeRepair;
    }

    @Override
    public void save(ShoeRepair shoeRepair) {
        SessionFactory factory = HiberUtil.getSessionFactory();
        Session session = factory.openSession();
        session.beginTransaction();
        session.save(shoeRepair);
        session.getTransaction().commit();
        factory.close();
    }
}

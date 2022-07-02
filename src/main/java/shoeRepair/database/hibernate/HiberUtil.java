package shoeRepair.database.hibernate;

import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.hibernate.cfg.Environment;
import org.hibernate.service.ServiceRegistry;
import shoeRepair.Client;
import shoeRepair.Order;
import shoeRepair.ShoeRepair;

import java.util.Properties;

public class HiberUtil {
    private static SessionFactory sessionFactory;
    public static SessionFactory getSessionFactory() {

        try {
            Configuration configuration = new Configuration().configure("hibernate.cfg.xml");
            configuration.addAnnotatedClass(Client.class);
            configuration.addAnnotatedClass(ShoeRepair.class);
            configuration.addAnnotatedClass(Order.class);
            ServiceRegistry serviceRegistry = new StandardServiceRegistryBuilder()
                    .applySettings(configuration.getProperties()).build();

            sessionFactory = configuration.buildSessionFactory(serviceRegistry);
        } catch (Exception e) {
            e.printStackTrace();
        }

        return sessionFactory;
    }
}

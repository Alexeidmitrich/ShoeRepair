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
            //Configuration configuration = new Configuration();
            Configuration configuration = new Configuration().configure("hibernate.cfg.xml");
            /*
            Properties settings = new Properties();
            settings.put(Environment.DRIVER, "com.mysql.cj.jdbc.Driver");
            settings.put(Environment.URL, "jdbc:mysql://localhost:3306/shoerepair");
            settings.put(Environment.USER, "root");
            settings.put(Environment.PASS, "19721975");
            settings.put(Environment.DIALECT, "org.hibernate.dialect.MySQL8Dialect");
           // settings.put(Environment.DIALECT, "org.hibernate.dialect.MySQL5Dialect");

            settings.put(Environment.SHOW_SQL, "true");

            settings.put(Environment.CURRENT_SESSION_CONTEXT_CLASS, "thread");

            settings.put(Environment.HBM2DDL_AUTO, "update");//

 */

            //configuration.setProperties(settings);
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

package shoeRepair.jpa;


import shoeRepair.Client;
import shoeRepair.ShoeRepair;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import java.util.List;

public class JPA {

    private static final String PERSISTENCE_UNIT_NAME = "todos";
    private static EntityManagerFactory factory;

    public static void main(String[] args) {
        factory = Persistence.createEntityManagerFactory("todos");
        EntityManager em = factory.createEntityManager();
        List<Client> list = em.createQuery("SELECT c FROM Client c").getResultList();
        for(int i = 0; i < list.size(); i++) {
            Client c = list.get(i);
            System.out.println(c);
        }
        List<ShoeRepair> shop = em.createQuery("SELECT s FROM ShoeRepair s").getResultList();
        for (int i = 0; i < shop.size(); i++) {
            ShoeRepair s = shop.get(i);
            System.out.println(s);
        }
    }
}

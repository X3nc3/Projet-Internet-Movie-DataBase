package fr.diginamic;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;

public class Main {
    public static void main(String[] args) {


        EntityManagerFactory emf = Persistence.createEntityManagerFactory("projet-films");
        EntityManager em = emf.createEntityManager();
        em.getTransaction().begin();



        em.close();
        emf.close();
    }
}
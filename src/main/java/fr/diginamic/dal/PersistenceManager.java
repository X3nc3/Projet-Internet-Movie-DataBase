package fr.diginamic.dal;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;

public class PersistenceManager {
    private static EntityManagerFactory emf;

    private PersistenceManager(){}

    public static EntityManagerFactory getEntityManagerFactory(){
        if(emf == null){
            EntityManagerFactory emf = Persistence.createEntityManagerFactory("projet-films");
        }
        return emf;
    }

    public static void closeEntityManagerFactory(){
        if(emf != null){
            emf.close();
        }
    }
}

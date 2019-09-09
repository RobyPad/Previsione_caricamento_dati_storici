package it.roberto.Previsione_caricamento_dati_storici;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import it.roberto.controller.PartitaController;
import it.roberto.model.Partita;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
        System.out.println( "Hello World!" );
        
        EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("it.roberto.persistence");
		EntityManager entityManager = entityManagerFactory.createEntityManager();
        
		entityManager.getTransaction().begin();
		Partita partita = new Partita("2019_08_30_Roma_Lazio", "italia", "Serie A", "1 Giornata", "2019/2019", "30.08", "20.45", "Roma", 1, "Lazio", 1);
		entityManager.persist(partita);
		entityManager.getTransaction().commit();
		entityManager.close();
		PartitaController.close();		

		System.out.println("Entity saved.");
    }
}

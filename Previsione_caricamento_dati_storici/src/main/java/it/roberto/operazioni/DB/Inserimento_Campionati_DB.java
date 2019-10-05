package it.roberto.operazioni.DB;

import java.util.List;

import javax.persistence.EntityExistsException;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.persistence.PersistenceException;

import com.roberto.WebScraper.WebScraper_listaPartite;

import it.roberto.model.Partita;

public class Inserimento_Campionati_DB 
{
	
    public static void caricaCampionati_HARD(List<String> lc,List<String> lb)
    {
    	System.out.println("Avvio metodo: caricaCampionati_HARD");

    	EntityTransaction tx;
		
		WebScraper_listaPartite o = new WebScraper_listaPartite();		
		List<Partita> listaPartite = o.getPartite_fromCampionati(lc, lb);
        
        EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("it.roberto.persistence");
		EntityManager entityManager = entityManagerFactory.createEntityManager();
		
		// Instantiate a transaction
		tx = entityManager.getTransaction();
        tx.begin();
		
		for (Partita partita : listaPartite) 
		{
			System.out.println("Record: " + partita);

			try
			{
				if(tx.isActive() == false)
					tx.begin();
				
				entityManager.persist(partita);	
				tx.commit();
			}
			catch(EntityExistsException e1)
			{
				if(tx.isActive() == false)
					tx.begin();
				entityManager.merge(partita);
				tx.commit();
				
				System.out.println("EntityExistsException " + partita);
			}
			catch (PersistenceException e2) 
			{
				if(tx.isActive() == false)
					tx.begin();
				entityManager.merge(partita);
				tx.commit();
				
				System.out.println("PersistenceException " + partita);
			}
		}
		
		//tx.commit();
		
		entityManager.close();

		System.out.println("Tutti i campionati sono stati salvati");
    }

    public static void caricaCampionati_SOFT(List<String> lc,List<String> lb)
    {
    	System.out.println("Avvio metodo: caricaCampionati_SOFT");
    	
    	EntityTransaction tx;
		
		WebScraper_listaPartite o = new WebScraper_listaPartite();		
		List<Partita> listaPartite = o.getPartite_fromCampionati(lc, lb);
        
        EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("it.roberto.persistence");
		EntityManager entityManager = entityManagerFactory.createEntityManager();
		
		// Instantiate a transaction
		tx = entityManager.getTransaction();
        tx.begin();
		
		for (Partita partita : listaPartite) 
		{
			System.out.println("Record: " + partita);

			try
			{
				if(tx.isActive() == false)
					tx.begin();
				
				entityManager.persist(partita);	
				tx.commit();
			}
			catch(EntityExistsException e1)
			{		
				System.out.println("EntityExistsException " + partita);
			}
			catch (PersistenceException e2) 
			{		
				System.out.println("PersistenceException " + partita);
			}
		}
		
		entityManager.close();

		System.out.println("Tutti i campionati sono stati salvati");
    }
    
    
}

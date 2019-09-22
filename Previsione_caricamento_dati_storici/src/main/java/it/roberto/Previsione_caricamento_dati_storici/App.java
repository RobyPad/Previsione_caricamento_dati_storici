package it.roberto.Previsione_caricamento_dati_storici;

import java.util.List;

import javax.persistence.EntityExistsException;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.persistence.PersistenceException;

import com.roberto.caricamento.dati.CaricaPartite;

import it.roberto.model.Partita;
import it.roberto.utils.Campionati;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
    	
		// TODO Auto-generated method stub
		
		/*
		 * Italia serie A 2016/2017
		 * 
		 */  
		List<String> lc = Campionati.getCampionati();
		List<String> lb = Campionati.getBottoni();

	    EntityTransaction tx;

		
		CaricaPartite o = new CaricaPartite();		
		List<Partita> listaPartite = o.caricaCampionato4(lc, lb);
        
        EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("it.roberto.persistence");
		EntityManager entityManager = entityManagerFactory.createEntityManager();
		
		// Instantiate a transaction
		tx = entityManager.getTransaction();
        tx.begin();
		
		int i=1;
		for (Partita partita : listaPartite) 
		{
			System.out.println("Record :" + partita);

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
			
			i++;
		}

		entityManager.close();
		

		

		System.out.println("Tutti i campionati sono stati salvati");
    }
    
    public void eseguiCaricamento()
    {
    	
    }
    
    
}

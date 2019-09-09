package it.roberto.Previsione_caricamento_dati_storici;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import com.roberto.caricamento.dati.CaricaPartite;

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
		// TODO Auto-generated method stub
		
		/*
		 * Italia serie A 2016/2017
		 * 
		 */
		String url_italia = "https://www.diretta.it/serie-a-2016-2017/";
		String href_italia = "//a[@href='/serie-a-2016-2017/risultati/']";
	    
		
		CaricaPartite o = new CaricaPartite();
		
		//o.caricaCampionato(url_francia,href_francia);
		
		List<Partita> listaPartite = o.caricaCampionato3(url_italia, href_italia);
        
        EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("it.roberto.persistence");
		EntityManager entityManager = entityManagerFactory.createEntityManager();
        
		entityManager.getTransaction().begin();
		
		for (Partita partita : listaPartite) 
		{
			//System.out.println(partita);
			entityManager.persist(partita);

		}
		
		entityManager.getTransaction().commit();
		entityManager.close();
		PartitaController.close();
		
		//Partita partita = new Partita("2019_08_30_Roma_Lazio", "italia", "Serie A", "1 Giornata", "2019/2019", "30.08", "20.45", "Roma", 1, "Lazio", 1);

		

		System.out.println("Entity saved.");
    }
}

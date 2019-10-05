package it.roberto.test;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.List;

import javax.persistence.EntityExistsException;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.persistence.PersistenceException;

import com.roberto.WebScraper.WebScraper_listaPartite;

import it.roberto.configurazione.Lista_Campionati;
import it.roberto.model.Partita;

public class TestMetodi {

	public static void main(String[] args) 
	{

		test_13();
		
	}
	
	/*
	 * get lista campionati
	 */
	public static void test_1()
	{
		List<String> lc = Lista_Campionati.getCampionati_AnnoInCorso();
		
		System.out.println(lc);

		
		List<String> lb = Lista_Campionati.getBottoni_AnnoInCorso();

		System.out.println(lb);
	}
	
	/*
	 * get Lista partite campionato Attuale
	 */
	public static void test_2()
	{
		List<String> lc = Lista_Campionati.getCampionati_AnnoInCorso();
		List<String> lb = Lista_Campionati.getBottoni_AnnoInCorso();

		WebScraper_listaPartite o = new WebScraper_listaPartite();
		
		List<Partita> listaPartite = o.getPartite_fromCampionati(lc, lb);

		System.out.println(listaPartite);
		
	}
	
	/*
	 * get Lista partite campionati History
	 */
	public static void test_3()
	{
		List<String> lc = Lista_Campionati.getCampionati_UltimiCinqueAnni();
		List<String> lb = Lista_Campionati.getBottoni_UltimiCinqueAnni();

		WebScraper_listaPartite o = new WebScraper_listaPartite();
		
		List<Partita> listaPartite = o.getPartite_fromCampionati(lc, lb);

		System.out.println(listaPartite);
		
	}
	
	/*
	 * verifica Calendar
	 */
	public static void test_4()
	{
		GregorianCalendar gc = new GregorianCalendar();

		int anno = gc.get(Calendar.YEAR);
		int mese = (gc.get(Calendar.MONTH)) + 1 ;
		int giorno = gc.get(Calendar.DAY_OF_MONTH);
		
		System.out.println("Giorno: " + giorno );
		System.out.println("Mese: " + mese );
		System.out.println("Anno: " + anno);
		
		System.out.println(gc);
	}
	
	/*
	 * verifica lettura file properties
	 */
	public static void test_5()
	{
		new WebScraper_listaPartite();
	}
	
	/*
	 * verifica Merge record
	 */
	public static void test_6()
	{
		//Merge partita		
		Partita partita = new Partita(
				"2021_03_17_Udinese_Sassuolo", 
				"Italia", 
				"Serie A", 
				"Giornata 29", 
				"2017/2018", 
				"17.03.18", 
				"18:00", 
				"Udinese", 
				55, 
				"Sassuolo", 
				77,
				"2",
				new Date()
				);
		
		EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("it.roberto.persistence");
		EntityManager entityManager = entityManagerFactory.createEntityManager();
		
		EntityTransaction tx;
		
		// Instantiate a transaction
		tx = entityManager.getTransaction();
        tx.begin();
        
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

	/*
	 * verifica LISTA Campionati Anno singolo Attuale
	 */
	public static void test_8()
	{
		
    	List<String> lc = Lista_Campionati.getCampionati_AnnoSingolo_AnnoInCorso();
    	List<String> lb = Lista_Campionati.getBottoni_AnnoSingolo_AnnoInCorso();
		
		System.out.println(lc);
		System.out.println(lb);
		
	}
	
	/*
	 * verifica LISTA Campionati Anno singolo HISTORY
	 */
	public static void test_9()
	{
		
    	List<String> lc = Lista_Campionati.getCampionati_AnnoSingolo_UltimiCinqueAnni();
    	List<String> lb = Lista_Campionati.getBottoni_AnnoSingolo_UltimiCinqueAnni();
		
		System.out.println(lc);
		System.out.println(lb);
		
	}
	
	/*
	 * verifica Campionati Anno singolo Attuale
	 */
	public static void test_10()
	{
		
    	List<String> lc = Lista_Campionati.getCampionati_AnnoSingolo_AnnoInCorso();
    	List<String> lb = Lista_Campionati.getBottoni_AnnoSingolo_AnnoInCorso();
		
		WebScraper_listaPartite o = new WebScraper_listaPartite();		
		List<Partita> listaPartite = o.getPartite_fromCampionati(lc, lb);
		
		System.out.println(listaPartite);
		
	}
	
	/*
	 * verifica Campionati Anno singolo HISTORY
	 */
	public static void test_11()
	{
		
    	List<String> lc = Lista_Campionati.getCampionati_AnnoSingolo_UltimiCinqueAnni();
    	List<String> lb = Lista_Campionati.getBottoni_AnnoSingolo_UltimiCinqueAnni();
		
		WebScraper_listaPartite o = new WebScraper_listaPartite();		
		List<Partita> listaPartite = o.getPartite_fromCampionati(lc, lb);
		
		System.out.println(listaPartite);
		
	}
	
	/*
	 * Test data
	 */
	public static void test_12()
	{
		
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
		
		LocalDateTime today = LocalDateTime.now();
		 
		System.out.println(formatter.format(today));        //2017-06-04 16:14

		Date data = new Date();
		
		System.out.println(data);
	}
	
	/*
	 * Test data
	 */
	public static void test_13()
	{
		String a = "-";
		String[] result = a.split(" - ");
		
		if(result != null && result.length > 1)
		{
				if(result[0] != "")
					System.out.println("result[0]");
				if(result[1] != "")
					System.out.println("result[1]");
		}
	}
	
	
}

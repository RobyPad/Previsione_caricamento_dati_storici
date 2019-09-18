package it.roberto.utils;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.List;

public class Campionati 
{
	static String[] listaCampionati = 
		{
				"https://www.diretta.it/serie-a-"
	//			,"https://www.diretta.it/calcio/francia/ligue-1-"
	//			,"https://www.diretta.it/calcio/spagna/laliga-"
		};
	static String[] listaBottoniCampionati = 
		{
				"//a[@href='/serie-a"
	//			,"//a[@href='/calcio/francia/ligue-1"
	//			,"//a[@href='/calcio/spagna/laliga"
		};

	
	public static List<String> getCampionati()
	{
		List<String> listaCampionati_a_CinqueAnni = new ArrayList<>(); 
		GregorianCalendar gc = new GregorianCalendar();

		int anno = gc.get(Calendar.YEAR);
		int mese = gc.get(Calendar.MONTH) ;
		int giorno = gc.get(Calendar.DAY_OF_MONTH);
		
		System.out.println("Giorno: " + giorno );
		System.out.println("Mese: " + mese );
		System.out.println("Anno: " + anno);
		
		for(int i= 0; i < listaCampionati.length; i++)
		{
			
			String campionato = listaCampionati[i];
			String campionatoTemp_0;
			String campionatoTemp_1;
			String campionatoTemp_2;
			String campionatoTemp_3;
			String campionatoTemp_4;
			String campionatoTemp_5;
			
			if(mese>5)
			{
				campionatoTemp_0 = campionato + anno + "-" + (anno+1);
				campionatoTemp_1 = campionato + (anno-1) + "-" + anno;
				campionatoTemp_2 = campionato + (anno-2) + "-" + (anno-1);
				campionatoTemp_3 = campionato + (anno-3) + "-" + (anno-2);
				campionatoTemp_4 = campionato + (anno-4) + "-" + (anno-3);
				campionatoTemp_5 = campionato + (anno-5) + "-" + (anno-4);
			}
			else
			{
				campionatoTemp_0 = campionato + (anno-1) + "-" + anno;
				campionatoTemp_1 = campionato + (anno-2) + "-" + (anno-1);
				campionatoTemp_2 = campionato + (anno-3) + "-" + (anno-2);
				campionatoTemp_3 = campionato + (anno-4) + "-" + (anno-3);
				campionatoTemp_4 = campionato + (anno-5) + "-" + (anno-4);
				campionatoTemp_5 = campionato + (anno-6) + "-" + (anno-5);
			}
			
			
			listaCampionati_a_CinqueAnni.add(campionatoTemp_0);
			listaCampionati_a_CinqueAnni.add(campionatoTemp_1);
			listaCampionati_a_CinqueAnni.add(campionatoTemp_2);
			listaCampionati_a_CinqueAnni.add(campionatoTemp_3);
			listaCampionati_a_CinqueAnni.add(campionatoTemp_4);
			listaCampionati_a_CinqueAnni.add(campionatoTemp_5);
			
		}

		
		
		/*
		 * result example:	"https://www.diretta.it/serie-a-2016-2017/",
		 */
		return listaCampionati_a_CinqueAnni;
	}
	
	public static List<String> getBottoni()
	{
		List<String> listaBottoni_a_CinqueAnni = new ArrayList<>(); 
		GregorianCalendar gc = new GregorianCalendar();
		int anno = gc.get(Calendar.YEAR);
		int mese = gc.get(Calendar.MONTH) ;
		int giorno = gc.get(Calendar.DAY_OF_MONTH);
		
		System.out.println("Giorno: " + giorno );
		System.out.println("Mese: " + mese );
		System.out.println("Anno: " + anno);
		
		for(int i= 0; i < listaBottoniCampionati.length; i++)
		{
			
			String bottoneCamp = listaBottoniCampionati[i];
			String bottoneCampTemp_0;
			String bottoneCampTemp_1;
			String bottoneCampTemp_2;
			String bottoneCampTemp_3;
			String bottoneCampTemp_4;
			String bottoneCampTemp_5;
			
			if(mese>5)
			{
				bottoneCampTemp_0 = bottoneCamp + "/risultati/']";
				bottoneCampTemp_1 = bottoneCamp + "-" + (anno-1) + "-" + anno + "/risultati/']";
				bottoneCampTemp_2 = bottoneCamp + "-" +(anno-2) + "-" + (anno-1) + "/risultati/']";
				bottoneCampTemp_3 = bottoneCamp + "-" +(anno-3) + "-" + (anno-2) + "/risultati/']";
				bottoneCampTemp_4 = bottoneCamp + "-" +(anno-4) + "-" + (anno-3) + "/risultati/']";
				bottoneCampTemp_5 = bottoneCamp + "-" +(anno-5) + "-" + (anno-4) + "/risultati/']";
			}
			else
			{
				bottoneCampTemp_0 = bottoneCamp + (anno-1) + "-" + anno + "/risultati/']";
				bottoneCampTemp_1 = bottoneCamp +  "-" + (anno-2) + "-" + (anno-1) + "/risultati/']";
				bottoneCampTemp_2 = bottoneCamp +  "-" + (anno-3) + "-" + (anno-2) + "/risultati/']";
				bottoneCampTemp_3 = bottoneCamp +  "-" + (anno-4) + "-" + (anno-3) + "/risultati/']";
				bottoneCampTemp_4 = bottoneCamp +  "-" + (anno-5) + "-" + (anno-4) + "/risultati/']";
				bottoneCampTemp_5 = bottoneCamp +  "-" + (anno-6) + "-" + (anno-5) + "/risultati/']";
			}
			
			
			listaBottoni_a_CinqueAnni.add(bottoneCampTemp_0);
			listaBottoni_a_CinqueAnni.add(bottoneCampTemp_1);
			listaBottoni_a_CinqueAnni.add(bottoneCampTemp_2);
			listaBottoni_a_CinqueAnni.add(bottoneCampTemp_3);
			listaBottoni_a_CinqueAnni.add(bottoneCampTemp_4);
			listaBottoni_a_CinqueAnni.add(bottoneCampTemp_5);
			
		}
		
		/*
		 * result example:	"//a[@href='/serie-a-2016-2017/risultati/']",
		 */
		return listaBottoni_a_CinqueAnni;
	}
	
}

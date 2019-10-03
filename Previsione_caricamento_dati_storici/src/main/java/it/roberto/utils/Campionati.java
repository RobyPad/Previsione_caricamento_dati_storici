package it.roberto.utils;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.List;

public class Campionati 
{
	static String[] listaCampionati = 
		{
				/*
		// ITALIA			"https://www.diretta.it/serie-a-"
		// FRANCIA			,"https://www.diretta.it/calcio/francia/ligue-1-"
		// SPAGNA			,"https://www.diretta.it/calcio/spagna/laliga-"
		// GERMANIA			,"https://www.diretta.it/calcio/germania/bundesliga-"
		// INGHILTERRA		,"https://www.diretta.it/calcio/inghilterra/premier-league-"
		// PORTOGALLO		,"https://www.diretta.it/calcio/portogallo/primeira-liga-"					
							,"https://www.diretta.it/calcio/armenia/premier-league-"
							,"https://www.diretta.it/calcio/azerbaijan/premier-league-"
							,"https://www.diretta.it/calcio/austria/tipico-bundesliga-"
							,"https://www.diretta.it/calcio/belgio/jupiler-league-"
							,"https://www.diretta.it/calcio/bosnia-herzegovina/premier-league-"
				*/			"https://www.diretta.it/calcio/bulgaria/parva-liga-"
							,"https://www.diretta.it/calcio/cipro/first-division-"
							,"https://www.diretta.it/calcio/croazia/1-hnl-"
							,"https://www.diretta.it/calcio/danimarca/superliga-"
							,"https://www.diretta.it/calcio/galles/premier-league-"
							,"https://www.diretta.it/calcio/grecia/super-league-"
							,"https://www.diretta.it/calcio/irlanda-del-nord/nifl-premiership-"
							,"https://www.diretta.it/calcio/israele/ligat-ha-al-"
							,"https://www.diretta.it/calcio/lussemburgo/national-division-"
							,"https://www.diretta.it/calcio/malta/premier-league-"
				/*			,"https://www.diretta.it/calcio/polonia/ekstraklasa-"
							,"https://www.diretta.it/calcio/repubblica-ceca/1-liga-"
							,"https://www.diretta.it/calcio/romania/liga-1-"
							,"https://www.diretta.it/calcio/russia/premier-league-"
							,"https://www.diretta.it/calcio/scozia/premiership-"
							,"https://www.diretta.it/calcio/serbia/super-liga-"
							,"https://www.diretta.it/calcio/slovacchia/fortuna-liga-"
							,"https://www.diretta.it/calcio/svizzera/super-league-"
							,"https://www.diretta.it/calcio/turchia/super-lig-"
							,"https://www.diretta.it/calcio/ucraina/premier-league-"
							,"https://www.diretta.it/calcio/ungheria/otp-bank-liga-"	*/				
		};
	
	static String[] listaCampionati_anno_singolo = 
		{
						"https://www.diretta.it/calcio/bielorussia/vysshaya-liga-"
						,"https://www.diretta.it/calcio/estonia/meistriliiga-"
						,"https://www.diretta.it/calcio/irlanda/premier-division-"
						,"https://www.diretta.it/calcio/islanda/pepsideild-"
						,"https://www.diretta.it/calcio/kazakistan/premier-league-"
						,"https://www.diretta.it/calcio/lettonia/optibet-virsliga-"
						,"https://www.diretta.it/calcio/lituania/a-lyga-"
						,"https://www.diretta.it/calcio/norvegia/eliteserien-"
						,"https://www.diretta.it/calcio/svezia/allsvenskan-"		
		};
	
	static String[] listaBottoniCampionati = 
		{
				/*
		//ITALIA			"//a[@href='/serie-a"
		//FRANCIA			,"//a[@href='/calcio/francia/ligue-1"
		//SPAGNA			,"//a[@href='/calcio/spagna/laliga"
		//GERMANIA			,"//a[@href='/calcio/germania/bundesliga"
		//INGHILTERRA		,"//a[@href='/calcio/inghilterra/premier-league"
		//PORTOGALLO		,"//a[@href='/calcio/portogallo/primeira-liga"	
							,"//a[@href='/calcio/armenia/premier-league"
							,"//a[@href='/calcio/azerbaijan/premier-league"
							,"//a[@href='/calcio/austria/tipico-bundesliga"
							,"//a[@href='/calcio/belgio/jupiler-league"
							,"//a[@href='/calcio/bosnia-herzegovina/premier-league"
				*/			"//a[@href='/calcio/bulgaria/parva-liga"
							,"//a[@href='/calcio/cipro/first-division"
							,"//a[@href='/calcio/croazia/1-hnl"
					 		,"//a[@href='/calcio/danimarca/superliga"
							,"//a[@href='/calcio/galles/premier-league"
							,"//a[@href='/calcio/grecia/super-league"
							,"//a[@href='/calcio/irlanda-del-nord/nifl-premiership"
							,"//a[@href='/calcio/israele/ligat-ha-al"
							,"//a[@href='/calcio/lussemburgo/national-division"
							,"//a[@href='/calcio/malta/premier-league"
					/*		,"//a[@href='/calcio/polonia/ekstraklasa"
							,"//a[@href='/calcio/repubblica-ceca/1-liga"
							,"//a[@href='/calcio/romania/liga-1"
							,"//a[@href='/calcio/russia/premier-league"
							,"//a[@href='/calcio/scozia/premiership"
							,"//a[@href='/calcio/serbia/super-liga"
							,"//a[@href='/calcio/slovacchia/fortuna-liga"
							,"//a[@href='/calcio/svizzera/super-league"
							,"//a[@href='/calcio/turchia/super-lig"
							,"//a[@href='/calcio/ucraina/premier-league"
							,"//a[@href='/calcio/ungheria/otp-bank-liga"	*/
							

		};
	
	static String[] listaBottoniCampionati_anno_singolo = 
		{
			"//a[@href='/calcio/bielorussia/vysshaya-liga"
			,"//a[@href='/calcio/estonia/meistriliiga"
			,"//a[@href='/calcio/irlanda/premier-division"
			,"//a[@href='/calcio/islanda/pepsideild"
			,"//a[@href='/calcio/kazakistan/premier-league"
			,"//a[@href='/calcio/lettonia/optibet-virsliga"
			,"//a[@href='/calcio/lituania/a-lyga"
			,"//a[@href='/calcio/norvegia/eliteserien"					
			,"//a[@href='/calcio/svezia/allsvenskan"	
		};

	public static List<String> getCampionati_Attuali()
	{
		List<String> listaCampionati_a_CinqueAnni = new ArrayList<>(); 
		GregorianCalendar gc = new GregorianCalendar();

		int anno = gc.get(Calendar.YEAR);
		int mese = (gc.get(Calendar.MONTH))+1 ;
		@SuppressWarnings("unused")
		int giorno = gc.get(Calendar.DAY_OF_MONTH);
		
		for(int i= 0; i < listaCampionati.length; i++)
		{
			
			String campionato = listaCampionati[i];
			String campionatoTemp_0;

			
			if(mese>5)
			{
				campionatoTemp_0 = campionato + anno + "-" + (anno+1);

			}
			else
			{
				campionatoTemp_0 = campionato + (anno-1) + "-" + anno;

			}
					
			listaCampionati_a_CinqueAnni.add(campionatoTemp_0);
			
		}

		
		
		/*
		 * result example:	"https://www.diretta.it/serie-a-2016-2017/",
		 */
		return listaCampionati_a_CinqueAnni;
	}
		
	public static List<String> getBottoni_Attuali()
	{
		List<String> listaBottoni_a_CinqueAnni = new ArrayList<>(); 
		GregorianCalendar gc = new GregorianCalendar();
		int anno = gc.get(Calendar.YEAR);
		int mese = (gc.get(Calendar.MONTH))+1 ;
		@SuppressWarnings("unused")
		int giorno = gc.get(Calendar.DAY_OF_MONTH);
		
		/*
		System.out.println("Giorno: " + giorno );
		System.out.println("Mese: " + mese );
		System.out.println("Anno: " + anno);
		*/
		
		for(int i= 0; i < listaBottoniCampionati.length; i++)
		{
			
			String bottoneCamp = listaBottoniCampionati[i];
			String bottoneCampTemp_0;
			
			if(mese>5)
			{
				bottoneCampTemp_0 = bottoneCamp + "/risultati/']";
			}
			else
			{
				bottoneCampTemp_0 = bottoneCamp + (anno-1) + "-" + anno + "/risultati/']";

			}
			
			listaBottoni_a_CinqueAnni.add(bottoneCampTemp_0);
			
		}
		
		/*
		 * result example:	"//a[@href='/serie-a-2016-2017/risultati/']",
		 */
		return listaBottoni_a_CinqueAnni;
	}
			
	public static List<String> getCampionati_HISTORY()
	{
		List<String> listaCampionati_a_CinqueAnni = new ArrayList<>(); 
		GregorianCalendar gc = new GregorianCalendar();

		int anno = gc.get(Calendar.YEAR);
		int mese = (gc.get(Calendar.MONTH))+1 ;
		@SuppressWarnings("unused")
		int giorno = gc.get(Calendar.DAY_OF_MONTH);
		
		/*
		System.out.println("Giorno: " + giorno );
		System.out.println("Mese: " + mese );
		System.out.println("Anno: " + anno);
		*/
		
		for(int i= 0; i < listaCampionati.length; i++)
		{
			
			String campionato = listaCampionati[i];
			String campionatoTemp_1;
			String campionatoTemp_2;
			String campionatoTemp_3;
			String campionatoTemp_4;
			String campionatoTemp_5;
			
			if(mese>5)
			{
				campionatoTemp_1 = campionato + (anno-1) + "-" + anno;
				campionatoTemp_2 = campionato + (anno-2) + "-" + (anno-1);
				campionatoTemp_3 = campionato + (anno-3) + "-" + (anno-2);
				campionatoTemp_4 = campionato + (anno-4) + "-" + (anno-3);
				campionatoTemp_5 = campionato + (anno-5) + "-" + (anno-4);
			}
			else
			{
				campionatoTemp_1 = campionato + (anno-2) + "-" + (anno-1);
				campionatoTemp_2 = campionato + (anno-3) + "-" + (anno-2);
				campionatoTemp_3 = campionato + (anno-4) + "-" + (anno-3);
				campionatoTemp_4 = campionato + (anno-5) + "-" + (anno-4);
				campionatoTemp_5 = campionato + (anno-6) + "-" + (anno-5);
			}
			
			
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
	
	public static List<String> getBottoni_HISTORY()
	{
		List<String> listaBottoni_a_CinqueAnni = new ArrayList<>(); 
		GregorianCalendar gc = new GregorianCalendar();
		int anno = gc.get(Calendar.YEAR);
		int mese = (gc.get(Calendar.MONTH))+1 ;
		@SuppressWarnings("unused")
		int giorno = gc.get(Calendar.DAY_OF_MONTH);
		
		/*
		System.out.println("Giorno: " + giorno );
		System.out.println("Mese: " + mese );
		System.out.println("Anno: " + anno);
		*/
		
		for(int i= 0; i < listaBottoniCampionati.length; i++)
		{
			
			String bottoneCamp = listaBottoniCampionati[i];
			String bottoneCampTemp_1;
			String bottoneCampTemp_2;
			String bottoneCampTemp_3;
			String bottoneCampTemp_4;
			String bottoneCampTemp_5;
			
			if(mese>5)
			{
				bottoneCampTemp_1 = bottoneCamp + "-" + (anno-1) + "-" + anno + "/risultati/']";
				bottoneCampTemp_2 = bottoneCamp + "-" +(anno-2) + "-" + (anno-1) + "/risultati/']";
				bottoneCampTemp_3 = bottoneCamp + "-" +(anno-3) + "-" + (anno-2) + "/risultati/']";
				bottoneCampTemp_4 = bottoneCamp + "-" +(anno-4) + "-" + (anno-3) + "/risultati/']";
				bottoneCampTemp_5 = bottoneCamp + "-" +(anno-5) + "-" + (anno-4) + "/risultati/']";
			}
			else
			{
				bottoneCampTemp_1 = bottoneCamp +  "-" + (anno-2) + "-" + (anno-1) + "/risultati/']";
				bottoneCampTemp_2 = bottoneCamp +  "-" + (anno-3) + "-" + (anno-2) + "/risultati/']";
				bottoneCampTemp_3 = bottoneCamp +  "-" + (anno-4) + "-" + (anno-3) + "/risultati/']";
				bottoneCampTemp_4 = bottoneCamp +  "-" + (anno-5) + "-" + (anno-4) + "/risultati/']";
				bottoneCampTemp_5 = bottoneCamp +  "-" + (anno-6) + "-" + (anno-5) + "/risultati/']";
			}
			
			
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

	public static List<String> getCampionati_MOSTRA_PIU_INCONTRI()
	{
		List<String> listaCampionati_a_CinqueAnni = new ArrayList<>(); 
		GregorianCalendar gc = new GregorianCalendar();

		int anno = gc.get(Calendar.YEAR);
		int mese = (gc.get(Calendar.MONTH))+1 ;
		@SuppressWarnings("unused")
		int giorno = gc.get(Calendar.DAY_OF_MONTH);
		
		/*
		System.out.println("Giorno: " + giorno );
		System.out.println("Mese: " + mese );
		System.out.println("Anno: " + anno);
		*/
		
		for(int i= 0; i < listaCampionati.length; i++)
		{
			
			String campionato = listaCampionati[i];
			String campionatoTemp_1;

			
			if(mese>5)
			{
				campionatoTemp_1 = campionato + (anno-1) + "-" + anno;

			}
			else
			{
				campionatoTemp_1 = campionato + (anno-2) + "-" + (anno-1);

			}
			
			
			listaCampionati_a_CinqueAnni.add(campionatoTemp_1);

			
		}

		
		
		/*
		 * result example:	"https://www.diretta.it/serie-a-2016-2017/",
		 */
		return listaCampionati_a_CinqueAnni;
	}

	public static List<String> getBottoni_MOSTRA_PIU_INCONTRI()
	{
		List<String> listaBottoni_a_CinqueAnni = new ArrayList<>(); 
		GregorianCalendar gc = new GregorianCalendar();
		int anno = gc.get(Calendar.YEAR);
		int mese = (gc.get(Calendar.MONTH))+1 ;
		@SuppressWarnings("unused")
		int giorno = gc.get(Calendar.DAY_OF_MONTH);
		
		/*
		System.out.println("Giorno: " + giorno );
		System.out.println("Mese: " + mese );
		System.out.println("Anno: " + anno);
		*/
		
		for(int i= 0; i < listaBottoniCampionati.length; i++)
		{
			
			String bottoneCamp = listaBottoniCampionati[i];
			String bottoneCampTemp_1;
			
			if(mese>5)
			{
				bottoneCampTemp_1 = bottoneCamp + "-" + (anno-1) + "-" + anno + "/risultati/']";

			}
			else
			{
				bottoneCampTemp_1 = bottoneCamp +  "-" + (anno-2) + "-" + (anno-1) + "/risultati/']";

			}
			
			
			listaBottoni_a_CinqueAnni.add(bottoneCampTemp_1);
			
		}
		
		/*
		 * result example:	"//a[@href='/serie-a-2016-2017/risultati/']",
		 */
		return listaBottoni_a_CinqueAnni;
	}

	public static List<String> getCampionati_Anno_Singolo_Attuali()
	{
		List<String> listaCampionati_anno_singolo_attuali = new ArrayList<>(); 
		GregorianCalendar gc = new GregorianCalendar();

		int anno = gc.get(Calendar.YEAR);
		@SuppressWarnings("unused")
		int mese = (gc.get(Calendar.MONTH))+1 ;
		@SuppressWarnings("unused")
		int giorno = gc.get(Calendar.DAY_OF_MONTH);
		
		for(int i= 0; i < listaCampionati_anno_singolo.length; i++)
		{
			
			String campionato = listaCampionati_anno_singolo[i];
			String campionatoTemp_0;

			campionatoTemp_0 = campionato +  anno;
		
			listaCampionati_anno_singolo_attuali.add(campionatoTemp_0);	
		}


		return listaCampionati_anno_singolo_attuali;
	}
	
	public static List<String> getBottoni_Anno_Singolo_Attuali()
	{
		List<String> listaBottoni_anno_singolo_attuali = new ArrayList<>(); 
		GregorianCalendar gc = new GregorianCalendar();
		@SuppressWarnings("unused")
		int anno = gc.get(Calendar.YEAR);
		@SuppressWarnings("unused")
		int mese = (gc.get(Calendar.MONTH))+1 ;
		@SuppressWarnings("unused")
		int giorno = gc.get(Calendar.DAY_OF_MONTH);
		
		
		for(int i= 0; i < listaBottoniCampionati_anno_singolo.length; i++)
		{
			
			String bottoneCamp = listaBottoniCampionati_anno_singolo[i];
			String bottoneCampTemp_0;

			//bottoneCampTemp_0 = bottoneCamp + "-" + (anno) + "/risultati/']";
			bottoneCampTemp_0 = bottoneCamp + "/risultati/']";

			listaBottoni_anno_singolo_attuali.add(bottoneCampTemp_0);
			
		}

		return listaBottoni_anno_singolo_attuali;
	}

	public static List<String> getCampionati_Anno_Singolo_HISTORY()
	{
		List<String> listaCampionati_Anno_Singolo_a_CinqueAnni = new ArrayList<>(); 
		GregorianCalendar gc = new GregorianCalendar();

		int anno = gc.get(Calendar.YEAR);
		@SuppressWarnings("unused")
		int mese = (gc.get(Calendar.MONTH))+1 ;
		@SuppressWarnings("unused")
		int giorno = gc.get(Calendar.DAY_OF_MONTH);	
		
		for(int i= 0; i < listaCampionati_anno_singolo.length; i++)
		{
			
			String campionato = listaCampionati_anno_singolo[i];
			String campionatoTemp_1;
			String campionatoTemp_2;
			String campionatoTemp_3;
			String campionatoTemp_4;
			String campionatoTemp_5;
			
			campionatoTemp_1 = campionato + (anno-1);
			campionatoTemp_2 = campionato + (anno-2);
			campionatoTemp_3 = campionato + (anno-3);
			campionatoTemp_4 = campionato + (anno-4);
			campionatoTemp_5 = campionato + (anno-5);
		
			
			listaCampionati_Anno_Singolo_a_CinqueAnni.add(campionatoTemp_1);
			listaCampionati_Anno_Singolo_a_CinqueAnni.add(campionatoTemp_2);
			listaCampionati_Anno_Singolo_a_CinqueAnni.add(campionatoTemp_3);
			listaCampionati_Anno_Singolo_a_CinqueAnni.add(campionatoTemp_4);
			listaCampionati_Anno_Singolo_a_CinqueAnni.add(campionatoTemp_5);
			
		}

		return listaCampionati_Anno_Singolo_a_CinqueAnni;
	}

	public static List<String> getBottoni_Anno_Singolo_HISTORY()
	{
		List<String> listaBottoni_Anno_Singolo_a_CinqueAnni = new ArrayList<>(); 
		GregorianCalendar gc = new GregorianCalendar();
		int anno = gc.get(Calendar.YEAR);
		@SuppressWarnings("unused")
		int mese = (gc.get(Calendar.MONTH))+1 ;
		@SuppressWarnings("unused")
		int giorno = gc.get(Calendar.DAY_OF_MONTH);

		
		for(int i= 0; i < listaBottoniCampionati_anno_singolo.length; i++)
		{
			
			String bottoneCamp = listaBottoniCampionati_anno_singolo[i];
			String bottoneCampTemp_1;
			String bottoneCampTemp_2;
			String bottoneCampTemp_3;
			String bottoneCampTemp_4;
			String bottoneCampTemp_5;

			bottoneCampTemp_1 = bottoneCamp + "-" + (anno-1) + "/risultati/']";
			bottoneCampTemp_2 = bottoneCamp + "-" + (anno-2) + "/risultati/']";
			bottoneCampTemp_3 = bottoneCamp + "-" + (anno-3) + "/risultati/']";
			bottoneCampTemp_4 = bottoneCamp + "-" + (anno-4) + "/risultati/']";
			bottoneCampTemp_5 = bottoneCamp + "-" + (anno-5) + "/risultati/']";

			listaBottoni_Anno_Singolo_a_CinqueAnni.add(bottoneCampTemp_1);
			listaBottoni_Anno_Singolo_a_CinqueAnni.add(bottoneCampTemp_2);
			listaBottoni_Anno_Singolo_a_CinqueAnni.add(bottoneCampTemp_3);
			listaBottoni_Anno_Singolo_a_CinqueAnni.add(bottoneCampTemp_4);
			listaBottoni_Anno_Singolo_a_CinqueAnni.add(bottoneCampTemp_5);			
		}	

		return listaBottoni_Anno_Singolo_a_CinqueAnni;
	}

}

package com.roberto.caricamento.dati;


import java.util.ArrayList;
import java.util.List;
import java.util.ListIterator;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

import it.roberto.controller.PartitaController;
import it.roberto.model.Partita;


public class CaricaPartite 
{	

	final String pathDriverChrome = "C:\\Users\\Utente\\git\\Previsione_caricamento_dati_storici\\Previsione_caricamento_dati_storici\\risorseEsterne\\chromedriver_win32\\chromedriver.exe";
	
	public CaricaPartite() 
	{
		// System Property for Chrome Driver   
		System.setProperty("webdriver.chrome.driver", pathDriverChrome);  
		
	}

	public void caricaCampionato2(String url, String href) 
	{
		WebElement element;
		Actions actions;
		
		
		String annata = "";
		String nazione = "";
		String competizione = "";
		
		
		
		/*
		try 
		{
			String url_DB = "jdbc:mysql://database-previsione.ci87mckdjg2k.us-east-2.rds.amazonaws.com:3306/previsione"; 
	        Connection conn;
			conn = DriverManager.getConnection(url_DB,"","");
			
	        st = conn.createStatement(); 

		} 
		catch (SQLException e1) 
		{
			// TODO Auto-generated catch block
			e1.printStackTrace();
		} 
		
		
		*/
		
		PartitaController partitaController = new PartitaController();
		
		List<Partita> listaPartite = new ArrayList();

		
		// Instantiate a ChromeDriver class.      
		WebDriver driver=new ChromeDriver(); 
		
	
		driver.manage().window().maximize();
		driver.get(url);
		element = driver.findElement(By.xpath(href));

		actions = new Actions(driver);
		actions.moveToElement(element).click().build().perform();
		
		/*
		try 
	    {
			Thread.sleep(3000);	//	3 secondi
		} 
	    catch (InterruptedException e) 
	    {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		*/
		
		/*
		element = driver.findElement(By.xpath("//a[@class='event__more event__more--static']"));
		actions = new Actions(driver);
		actions.moveToElement(element).click().build().perform();
		*/
		
		String htmlSource = driver.getPageSource();
		Document doc = Jsoup.parse(htmlSource);
		

		//	NAZIONE
		Element el_nazione = doc.getElementsByClass("tournament").get(0);
		Elements childNazione = el_nazione.children();
		nazione = childNazione.get(4).text();
		
		//	COMPETIZIONE
		Element el_competizione = doc.getElementsByClass("teamHeader__name").get(0);
		competizione = el_competizione.text().trim();
		
		//	ANNATA
		Element el_annata = doc.getElementsByClass("teamHeader__text").get(0);
		annata = el_annata.text();
		
	
		Element el_sportNameSoccer = doc.getElementsByClass("sportName soccer").get(0);
		Elements childSportNameSoccer = el_sportNameSoccer.children();
		
		String squadraCasa= "";
		String squadraTrasferta = "";
		String orario = "";
		String goalSquadraCasa = "";
		String goalSquadraTrasferta = "";
		String turno = "";
		
		int g = 0;
		for (Element e : childSportNameSoccer) 
		{
			String nomeClasse = e.className();
			
			if(nomeClasse.contains("event__header--noExpand"))
			{
				System.out.println("");
				g = 0;
			}
			else
			{
				if(nomeClasse.equals("event__round event__round--static"))
				{
					g = 1;
					turno = e.text();
					System.out.println("\n" + turno);
				}
				else
				{
							if(g == 0)
							{
								turno = "TurnoNonPresente";
								System.out.println("\n" + turno);
								g=1;
							}
							
							Elements childElement = e.children();
							for (Element e2 : childElement) 
							{
								// ORARIO
								if(e2.className().contains("event__time"))
								{
									orario = e2.text();
								}
								
								// SQUADRA CASA
								if(e2.className().contains("event__participant event__participant--home"))
								{
									squadraCasa = e2.text();
								}
								
								// RISULTATI
								if(e2.className().contains("event__scores"))
								{
									String[] result = e2.text().split(" - ");
									
									goalSquadraCasa = result[0];
									goalSquadraTrasferta = result[1];
									
								}
								
								// SQUADRA TRASFERTA
								if(e2.className().contains("event__participant event__participant--away"))
								{
									squadraTrasferta = e2.text();
								}
							}
							
							/*
							 * Record da scrivere a DB
							 */
							//System.out.println(annata + " " + nazione + " " + competizione + " " + turno + " " + orario + " " + squadraCasa + " " + goalSquadraCasa + " " +goalSquadraTrasferta + " " +squadraTrasferta);
							
							Partita p = new Partita(nazione,"2019_08_30_Roma_Lazio", competizione, turno, annata, orario, orario, squadraCasa, Integer.parseInt(goalSquadraCasa), squadraTrasferta, Integer.parseInt(goalSquadraTrasferta));

							System.out.println(p);
							

							
							/*listaPartite.add(p);
							partitaController.insertPartite(listaPartite);
							*/
							
							
				}

			}
			
		}	
		


	}
	
	public List<Partita> caricaCampionato3(String url, String href) 
	{
		WebElement element;
		Actions actions;
		
		
		String annata = "";
		String nazione = "";
		String competizione = "";
		
		
		
		/*
		try 
		{
			String url_DB = "jdbc:mysql://database-previsione.ci87mckdjg2k.us-east-2.rds.amazonaws.com:3306/previsione"; 
	        Connection conn;
			conn = DriverManager.getConnection(url_DB,"","");
			
	        st = conn.createStatement(); 

		} 
		catch (SQLException e1) 
		{
			// TODO Auto-generated catch block
			e1.printStackTrace();
		} 
		
		
		*/
		
		PartitaController partitaController = new PartitaController();
		
		List<Partita> listaPartite = new ArrayList();

		
		// Instantiate a ChromeDriver class.      
		WebDriver driver=new ChromeDriver(); 
		
	
		driver.manage().window().maximize();
		driver.get(url);
		element = driver.findElement(By.xpath(href));

		actions = new Actions(driver);
		actions.moveToElement(element).click().build().perform();
		
		/*
		try 
	    {
			Thread.sleep(3000);	//	3 secondi
		} 
	    catch (InterruptedException e) 
	    {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		*/
		
		/*
		element = driver.findElement(By.xpath("//a[@class='event__more event__more--static']"));
		actions = new Actions(driver);
		actions.moveToElement(element).click().build().perform();
		*/
		
		String htmlSource = driver.getPageSource();
		Document doc = Jsoup.parse(htmlSource);
		

		//	NAZIONE
		Element el_nazione = doc.getElementsByClass("tournament").get(0);
		Elements childNazione = el_nazione.children();
		nazione = childNazione.get(4).text();
		
		//	COMPETIZIONE
		Element el_competizione = doc.getElementsByClass("teamHeader__name").get(0);
		competizione = el_competizione.text().trim();
		
		//	ANNATA
		Element el_annata = doc.getElementsByClass("teamHeader__text").get(0);
		annata = el_annata.text();
		
	
		Element el_sportNameSoccer = doc.getElementsByClass("sportName soccer").get(0);
		Elements childSportNameSoccer = el_sportNameSoccer.children();
		
		String squadraCasa= "";
		String squadraTrasferta = "";
		String orario = "";
		String goalSquadraCasa = "";
		String goalSquadraTrasferta = "";
		String turno = "";
		
		int g = 0;
		for (Element e : childSportNameSoccer) 
		{
			String nomeClasse = e.className();
			
			if(nomeClasse.contains("event__header--noExpand"))
			{
				System.out.println("");
				g = 0;
			}
			else
			{
				if(nomeClasse.equals("event__round event__round--static"))
				{
					g = 1;
					turno = e.text();
					//System.out.println("\n" + turno);
				}
				else
				{
							if(g == 0)
							{
								turno = "TurnoNonPresente";
								//System.out.println("\n" + turno);
								g=1;
							}
							
							Elements childElement = e.children();
							for (Element e2 : childElement) 
							{
								// ORARIO
								if(e2.className().contains("event__time"))
								{
									orario = e2.text();
								}
								
								// SQUADRA CASA
								if(e2.className().contains("event__participant event__participant--home"))
								{
									squadraCasa = e2.text();
								}
								
								// RISULTATI
								if(e2.className().contains("event__scores"))
								{
									String[] result = e2.text().split(" - ");
									
									goalSquadraCasa = result[0];
									goalSquadraTrasferta = result[1];
									
								}
								
								// SQUADRA TRASFERTA
								if(e2.className().contains("event__participant event__participant--away"))
								{
									squadraTrasferta = e2.text();
								}
							}
							
							/*
							 * Record da scrivere a DB
							 */
							//System.out.println(annata + " " + nazione + " " + competizione + " " + turno + " " + orario + " " + squadraCasa + " " + goalSquadraCasa + " " +goalSquadraTrasferta + " " +squadraTrasferta);
							
							Partita p = new Partita(nazione,"2019_08_30_Roma_Lazio", competizione, turno, annata, orario, orario, squadraCasa, Integer.parseInt(goalSquadraCasa), squadraTrasferta, Integer.parseInt(goalSquadraTrasferta));

							//System.out.println(p);
							

							listaPartite.add(p);

							
							
				}

			}
			
		}
		
		return listaPartite;	

	}

	public List<Partita> caricaCampionato4(List<String> campionati, List<String> bottoni) 
	{
		// Lista da ritornare
		List<Partita> listaPartite = new ArrayList<Partita>();
		
		WebElement element;
		Actions actions;
		
		String annata = "";
		String nazione = "";
		String competizione = "";
			
		// Instantiate a ChromeDriver class.      
		WebDriver driver=new ChromeDriver(); 
		
		ListIterator<String> iteratorCampionati = campionati.listIterator(); 
		ListIterator<String> iteratorBottoni = bottoni.listIterator(); 

        while (iteratorCampionati.hasNext()) 
		{
			String campionato = iteratorCampionati.next();
			String bottone = iteratorBottoni.next();
					
			driver.manage().window().maximize();
			driver.get(campionato);
			element = driver.findElement(By.xpath(bottone));

			actions = new Actions(driver);
			actions.moveToElement(element).click().build().perform();
			
			/*
			try 
		    {
				Thread.sleep(3000);	//	3 secondi
			} 
		    catch (InterruptedException e) 
		    {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			*/
			
			/*
			element = driver.findElement(By.xpath("//a[@class='event__more event__more--static']"));
			actions = new Actions(driver);
			actions.moveToElement(element).click().build().perform();
			*/
			
			String htmlSource = driver.getPageSource();
			Document doc = Jsoup.parse(htmlSource);
			

			//	NAZIONE
			Element el_nazione = doc.getElementsByClass("tournament").get(0);
			Elements childNazione = el_nazione.children();
			nazione = childNazione.get(4).text();
			
			//	COMPETIZIONE
			Element el_competizione = doc.getElementsByClass("teamHeader__name").get(0);
			competizione = el_competizione.text().trim();
			
			//	ANNATA
			Element el_annata = doc.getElementsByClass("teamHeader__text").get(0);
			annata = el_annata.text();
			
		
			Element el_sportNameSoccer = doc.getElementsByClass("sportName soccer").get(0);
			Elements childSportNameSoccer = el_sportNameSoccer.children();
			
			String squadraCasa= "";
			String squadraTrasferta = "";
			String orario = "";
			String goalSquadraCasa = "";
			String goalSquadraTrasferta = "";
			String turno = "";
			
			int g = 0;
			for (Element e : childSportNameSoccer) 
			{
				
				String nomeClasse = e.className();
				
				if(nomeClasse.contains("event__header--noExpand"))
				{
					System.out.println("");
					g = 0;
				}
				else
				{
					if(nomeClasse.equals("event__round event__round--static"))
					{
						g = 1;
						turno = e.text();
						//System.out.println("\n" + turno);
					}
					else
					{
								if(g == 0)
								{
									turno = "TurnoNonPresente";
									//System.out.println("\n" + turno);
									g=1;
								}
								
								Elements childElement = e.children();
								for (Element e2 : childElement) 
								{
									// ORARIO
									if(e2.className().contains("event__time"))
									{
										orario = e2.text();
									}
									
									// SQUADRA CASA
									if(e2.className().contains("event__participant event__participant--home"))
									{
										squadraCasa = e2.text();
									}
									
									// RISULTATI
									if(e2.className().contains("event__scores"))
									{
										String[] result = e2.text().split(" - ");
										
										goalSquadraCasa = result[0];
										goalSquadraTrasferta = result[1];
										
									}
									
									// SQUADRA TRASFERTA
									if(e2.className().contains("event__participant event__participant--away"))
									{
										squadraTrasferta = e2.text();
									}
								}
								

								int goalCasa;
								int goalTrasferta;
								
								try
								{
									goalCasa = Integer.parseInt(goalSquadraCasa);
									goalTrasferta = Integer.parseInt(goalSquadraTrasferta);
								}
								catch (NumberFormatException nfe)
								{
									// TODO: handle exception
									
									goalCasa = -99;
									goalTrasferta = -99;
								}
								
								
								String casaTrim =  squadraCasa.replaceAll("\\s+","");
								String fuoriTrim =  squadraTrasferta.replaceAll("\\s+","");
								
								String anno;
								String mese = orario.substring(3, 5);
								String giorno = orario.substring(0, 2);
								
								if(Integer.parseInt(mese) > 5)
									anno = annata.substring(0, 4);
								else
									anno = annata.substring(5, 9);

								String data = orario.substring(0,6) + anno.substring(2);
								String ora = orario.substring(6);
								
								String id_composto = anno + "_" + mese + "_" + giorno + "_" + casaTrim + "_" + fuoriTrim;
								
								
								Partita p = new Partita(id_composto, nazione, competizione, turno, annata, data, ora, squadraCasa, goalCasa, squadraTrasferta, goalTrasferta);

								//System.out.println(p);
								

								listaPartite.add(p);			
					}

				}
				
			}
			
		}
		
        driver.close();
		
		return listaPartite;	

	}

}

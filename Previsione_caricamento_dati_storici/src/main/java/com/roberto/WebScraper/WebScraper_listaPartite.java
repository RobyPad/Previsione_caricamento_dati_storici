package com.roberto.WebScraper;


import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.ListIterator;
import java.util.Properties;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

import it.roberto.model.Partita;


public class WebScraper_listaPartite 
{	
	//final String pathDriverChrome = "C:\\Users\\Utente\\git\\Previsione_caricamento_dati_storici\\Previsione_caricamento_dati_storici\\risorseEsterne\\chromedriver_win32\\chromedriver.exe";

	public WebScraper_listaPartite() 
	{
        Properties fileConfig = new Properties();
        InputStream inputStream = this.getClass().getResourceAsStream("/config.properties");
      
    	try 
    	{
			fileConfig.load(inputStream);
            String pathDriverChrome = fileConfig.getProperty("pathDriverChrome");
            
            System.out.println("pathDriverChrome " + pathDriverChrome);
            
    		// System Property for Chrome Driver   
    		System.setProperty("webdriver.chrome.driver", pathDriverChrome); 
			
		} 
    	catch (IOException e) 
    	{
			e.printStackTrace();
		}

	}

	public List<Partita> getPartite_fromCampionati(List<String> campionati, List<String> bottoni) 
	{
		// Lista da ritornare
		List<Partita> listaPartite = new ArrayList<Partita>();
		
		WebElement element;
		Actions actions;
		
		Long tempoAttesa = (long) 2000;
		
		String annata = "";
		String nazione = "";
		String competizione = "";
			
		// Instantiate a ChromeDriver class.      
		WebDriver driver=new ChromeDriver(); 
		
        JavascriptExecutor js = (JavascriptExecutor) driver;

		
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

				boolean scroolTerminato = false;
				int i = 1;
				
				while(scroolTerminato == false)
				{
					try
					{
						System.out.println(i + "° scrool");
						js.executeScript("window.scrollTo(0, document.body.scrollHeight)");
						
						try 
						{
				            Thread.sleep(tempoAttesa);
				        } 
						catch (InterruptedException e) 
						{
				            e.printStackTrace();
				        }
					
						element = driver.findElement(By.xpath("//a[@class='event__more event__more--static']"));
						actions = new Actions(driver);
						actions.moveToElement(element).click().build().perform();
						
						
						i++;
						
					}
					catch(NoSuchElementException e)
					{
						//e.printStackTrace();
						System.out.println("Refresh pagina terminato - campionato: " + campionato);
						scroolTerminato = true;
					}			
				}	
	
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
			String risultato = "";
			
			int g = 0;
			for (Element e : childSportNameSoccer) 
			{
				
				String nomeClasse = e.className();
				
				if(nomeClasse.contains("event__header--noExpand"))
				{
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
										if(result != null && result.length > 1)
										{
												if(result[0] != "")
													goalSquadraCasa = result[0];
												if(result[1] != "")
													goalSquadraTrasferta = result[1];
										}
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
									if(goalCasa > goalTrasferta)
										risultato = "1";
									if(goalCasa == goalTrasferta)
										risultato = "X";
									if(goalCasa < goalTrasferta)
										risultato = "2";
								
								}
								catch (NumberFormatException nfe)
								{
									goalCasa = -99;
									goalTrasferta = -99;
									risultato = "";
								}
								
								
								String casaTrim =  squadraCasa.replaceAll("\\s+","");
								String fuoriTrim =  squadraTrasferta.replaceAll("\\s+","");
								
								String anno = annata.substring(0, 4);
								String mese = orario.substring(3, 5);
								String giorno = orario.substring(0, 2);
								
								

								String data = orario.substring(0,6) + anno.substring(2);
								String ora = orario.substring(6);
								
								String id_composto = anno + "_" + mese + "_" + giorno + "_" + casaTrim + "_" + fuoriTrim;
								
								
								Partita p = new Partita(id_composto, nazione, competizione, turno, annata, data, ora, squadraCasa, goalCasa, squadraTrasferta, goalTrasferta,risultato,new Date());

								//System.out.println(p);
								

								listaPartite.add(p);			
					}

				}
				
			}
			
			
		}
		
        driver.close();
		
        System.out.println(listaPartite);
        
		return listaPartite;	

	}

}

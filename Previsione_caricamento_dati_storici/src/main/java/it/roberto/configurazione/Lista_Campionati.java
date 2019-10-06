package it.roberto.configurazione;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Properties;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

import it.roberto.WebScraper.object.Info_WebScraper_Campionati;

public class Lista_Campionati 
{
	public Info_WebScraper_Campionati info_WebScraper_Campionati; 
	
	public Info_WebScraper_Campionati Info_WebScraper_Campionati_AnnoSingolo;
	
	public Lista_Campionati() 
	{
		Properties fileConfig = new Properties();
        InputStream inputStream = this.getClass().getResourceAsStream("/config.properties");
      
    	try 
    	{
			fileConfig.load(inputStream);
			String path_campionati = fileConfig.getProperty("path_campionati");
			String path_campionati_AnnoSingolo = fileConfig.getProperty("path_campionati_AnnoSingolo");
		
            //	System.out.println("path_campionati " + path_campionati);
            //	System.out.println("path_campionati_AnnoSingolo " + path_campionati_AnnoSingolo);

            setInfo_WebScraper_Campionati(path_campionati);
            setInfo_WebScraper_Campionati_AnnoSingolo(path_campionati_AnnoSingolo);    
		} 
    	catch (IOException e) 
    	{
			e.printStackTrace();
		}
	}

	
	public void setInfo_WebScraper_Campionati(String path_campionati)
	{
        Workbook workbook;
		try 
		{
			List<String> URL_campionati = new LinkedList<String>();
	    	List<String> link_bottoni = new LinkedList<String>();
			
			workbook = WorkbookFactory.create(new File(path_campionati));
			
	        // Retrieving the number of sheets in the Workbook
	        //System.out.println("Workbook has " + workbook.getNumberOfSheets() + " Sheets : ");

            // Getting the Sheet at index zero
            Sheet sheet = workbook.getSheetAt(0);
            
            // 1. You can obtain a rowIterator and columnIterator and iterate over them
            //System.out.println("\n\nIterating over Rows and Columns using Iterator\n");
            
            Iterator<Row> rowIterator = sheet.rowIterator();
            while (rowIterator.hasNext()) 
            {
                Row row = rowIterator.next();

                Iterator<Cell> cellIterator = row.cellIterator();

                int i = 0;
                while (cellIterator.hasNext()) 
                {
                    Cell cell = cellIterator.next();
                    
                    if(i == 0)
                    	URL_campionati.add(cell.getStringCellValue());
                    if(i == 1)
                    	link_bottoni.add(cell.getStringCellValue());
                    
                    i++;
                }   
            }
            
            info_WebScraper_Campionati= new Info_WebScraper_Campionati(URL_campionati,link_bottoni);    
	        
		} 
		catch (EncryptedDocumentException e) 
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		} 
		catch (InvalidFormatException e)
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		} 
		catch (IOException e)
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public void setInfo_WebScraper_Campionati_AnnoSingolo(String path_campionati_AnnoSingolo)
	{
		Workbook workbook;
		try 
		{
			List<String> URL_campionati = new LinkedList<String>();
	    	List<String> link_bottoni = new LinkedList<String>();
			
			workbook = WorkbookFactory.create(new File(path_campionati_AnnoSingolo));
			
	        // Retrieving the number of sheets in the Workbook
	        //System.out.println("Workbook has " + workbook.getNumberOfSheets() + " Sheets : ");

            // Getting the Sheet at index zero
            Sheet sheet = workbook.getSheetAt(0);
            
            // 1. You can obtain a rowIterator and columnIterator and iterate over them
            //System.out.println("\n\nIterating over Rows and Columns using Iterator\n");
            
            Iterator<Row> rowIterator = sheet.rowIterator();
            while (rowIterator.hasNext()) 
            {
                Row row = rowIterator.next();

                Iterator<Cell> cellIterator = row.cellIterator();

                int i = 0;
                while (cellIterator.hasNext()) 
                {
                    Cell cell = cellIterator.next();
                    
                    if(i == 0)
                    	URL_campionati.add(cell.getStringCellValue());
                    if(i == 1)
                    	link_bottoni.add(cell.getStringCellValue());
                    
                    i++;
                }   
            }
            
            Info_WebScraper_Campionati_AnnoSingolo = new Info_WebScraper_Campionati(URL_campionati,link_bottoni);    
	        
		} 
		catch (EncryptedDocumentException e) 
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		} 
		catch (InvalidFormatException e)
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		} 
		catch (IOException e)
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	
	public List<String> getCampionati_AnnoInCorso()
	{
		
		List<String> listaCampionati_temp = info_WebScraper_Campionati.getURL_campionato();
		
		List<String> listaCampionati_AnnoInCorso = new ArrayList<>(); 
		GregorianCalendar gc = new GregorianCalendar();

		int anno = gc.get(Calendar.YEAR);
		int mese = (gc.get(Calendar.MONTH))+1 ;
		@SuppressWarnings("unused")
		int giorno = gc.get(Calendar.DAY_OF_MONTH);
		
		for(int i= 0; i < listaCampionati_temp.size(); i++)
		{	
			String campionato = listaCampionati_temp.get(i);
			String campionatoTemp_0;

			if(mese>5)
				campionatoTemp_0 = campionato + anno + "-" + (anno+1);
			else
				campionatoTemp_0 = campionato + (anno-1) + "-" + anno;
		
			listaCampionati_AnnoInCorso.add(campionatoTemp_0);	
		}

		/*
		 * result example:	"https://www.diretta.it/serie-a-2016-2017/",
		 */
		return listaCampionati_AnnoInCorso;
	}
		
	public List<String> getBottoni_AnnoInCorso()
	{
		List<String> listaBottoniCampionati_temp = info_WebScraper_Campionati.getLink_bottone();

		List<String> listaCampionati_AnnoInCorso = new ArrayList<>(); 
		GregorianCalendar gc = new GregorianCalendar();
		int anno = gc.get(Calendar.YEAR);
		int mese = (gc.get(Calendar.MONTH))+1 ;
		@SuppressWarnings("unused")
		int giorno = gc.get(Calendar.DAY_OF_MONTH);

		for(int i= 0; i < listaBottoniCampionati_temp.size(); i++)
		{
			String bottoneCamp = listaBottoniCampionati_temp.get(i);
			String bottoneCampTemp_0;
			
			if(mese>5)
				bottoneCampTemp_0 = bottoneCamp + "/risultati/']";
			else
				bottoneCampTemp_0 = bottoneCamp + (anno-1) + "-" + anno + "/risultati/']";
	
			listaCampionati_AnnoInCorso.add(bottoneCampTemp_0);			
		}
		
		/*
		 * result example:	"//a[@href='/serie-a-2016-2017/risultati/']",
		 */
		return listaCampionati_AnnoInCorso;
	}
			
	public List<String> getCampionati_UltimiCinqueAnni()
	{
		List<String> listaCampionati_temp = info_WebScraper_Campionati.getURL_campionato();

		List<String> listaCampionati_a_CinqueAnni = new ArrayList<>(); 
		GregorianCalendar gc = new GregorianCalendar();

		int anno = gc.get(Calendar.YEAR);
		int mese = (gc.get(Calendar.MONTH))+1 ;
		@SuppressWarnings("unused")
		int giorno = gc.get(Calendar.DAY_OF_MONTH);
		
		for(int i= 0; i < listaCampionati_temp.size(); i++)
		{
			
			String campionato = listaCampionati_temp.get(i);
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
	
	public List<String> getBottoni_UltimiCinqueAnni()
	{
		List<String> listaBottoniCampionati_temp = info_WebScraper_Campionati.getLink_bottone();
		
		List<String> listaBottoni_a_CinqueAnni = new ArrayList<>(); 
		GregorianCalendar gc = new GregorianCalendar();
		int anno = gc.get(Calendar.YEAR);
		int mese = (gc.get(Calendar.MONTH))+1 ;
		@SuppressWarnings("unused")
		int giorno = gc.get(Calendar.DAY_OF_MONTH);
		
		for(int i= 0; i < listaBottoniCampionati_temp.size(); i++)
		{
			
			String bottoneCamp = listaBottoniCampionati_temp.get(i);
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

	public List<String> getCampionati_AnnoSingolo_AnnoInCorso()
	{
		List<String> listaCampionati_AnnoSingolo_temp = Info_WebScraper_Campionati_AnnoSingolo.getURL_campionato();
	
		List<String> listaCampionati_anno_singolo_attuali = new ArrayList<>(); 
		GregorianCalendar gc = new GregorianCalendar();

		int anno = gc.get(Calendar.YEAR);
		@SuppressWarnings("unused")
		int mese = (gc.get(Calendar.MONTH))+1 ;
		@SuppressWarnings("unused")
		int giorno = gc.get(Calendar.DAY_OF_MONTH);
		
		for(int i= 0; i < listaCampionati_AnnoSingolo_temp.size(); i++)
		{
			
			String campionato = listaCampionati_AnnoSingolo_temp.get(i);
			String campionatoTemp_0;

			campionatoTemp_0 = campionato +  anno;
		
			listaCampionati_anno_singolo_attuali.add(campionatoTemp_0);	
		}


		return listaCampionati_anno_singolo_attuali;
	}
	
	public List<String> getBottoni_AnnoSingolo_AnnoInCorso()
	{
		List<String> listaBottoni_AnnoSingolo_temp = Info_WebScraper_Campionati_AnnoSingolo.getLink_bottone();

		List<String> listaBottoni_anno_singolo_attuali = new ArrayList<>(); 
		GregorianCalendar gc = new GregorianCalendar();
		@SuppressWarnings("unused")
		int anno = gc.get(Calendar.YEAR);
		@SuppressWarnings("unused")
		int mese = (gc.get(Calendar.MONTH))+1 ;
		@SuppressWarnings("unused")
		int giorno = gc.get(Calendar.DAY_OF_MONTH);
		
		
		for(int i= 0; i < listaBottoni_AnnoSingolo_temp.size(); i++)
		{
			
			String bottoneCamp = listaBottoni_AnnoSingolo_temp.get(i);
			String bottoneCampTemp_0;

			//bottoneCampTemp_0 = bottoneCamp + "-" + (anno) + "/risultati/']";
			bottoneCampTemp_0 = bottoneCamp + "/risultati/']";

			listaBottoni_anno_singolo_attuali.add(bottoneCampTemp_0);
			
		}

		return listaBottoni_anno_singolo_attuali;
	}

	public List<String> getCampionati_AnnoSingolo_UltimiCinqueAnni()
	{
		List<String> listaCampionati_AnnoSingolo_temp = Info_WebScraper_Campionati_AnnoSingolo.getURL_campionato();

		List<String> listaCampionati_Anno_Singolo_a_CinqueAnni = new ArrayList<>(); 
		GregorianCalendar gc = new GregorianCalendar();

		int anno = gc.get(Calendar.YEAR);
		@SuppressWarnings("unused")
		int mese = (gc.get(Calendar.MONTH))+1 ;
		@SuppressWarnings("unused")
		int giorno = gc.get(Calendar.DAY_OF_MONTH);	
		
		for(int i= 0; i < listaCampionati_AnnoSingolo_temp.size(); i++)
		{
			
			String campionato = listaCampionati_AnnoSingolo_temp.get(i);
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

	public List<String> getBottoni_AnnoSingolo_UltimiCinqueAnni()
	{
		List<String> listaBottoni_AnnoSingolo_temp = Info_WebScraper_Campionati_AnnoSingolo.getLink_bottone();

		List<String> listaBottoni_Anno_Singolo_a_CinqueAnni = new ArrayList<>(); 
		GregorianCalendar gc = new GregorianCalendar();
		int anno = gc.get(Calendar.YEAR);
		@SuppressWarnings("unused")
		int mese = (gc.get(Calendar.MONTH))+1 ;
		@SuppressWarnings("unused")
		int giorno = gc.get(Calendar.DAY_OF_MONTH);

		
		for(int i= 0; i < listaBottoni_AnnoSingolo_temp.size(); i++)
		{
			
			String bottoneCamp = listaBottoni_AnnoSingolo_temp.get(i);
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

package it.roberto.test;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
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

public class Test_config 
{
	
	public Test_config() 
	{
        Properties fileConfig = new Properties();
        //InputStream inputStream = this.getClass().getResourceAsStream("/config.properties");
      
        InputStream inputStream = getClass().getResourceAsStream("/config.properties");
        
        @SuppressWarnings("unused")
        Info_WebScraper_Campionati info_WebScraper_Campionati; 
        
    	List<String> URL_campionati = new LinkedList<String>();
    	List<String> link_bottoni = new LinkedList<String>();
        
    	try 
    	{
			fileConfig.load(inputStream);
            String campionati_XLSX_FILE_PATH = fileConfig.getProperty("campionati_XLSX_FILE_PATH");
            
            System.out.println("campionati_XLSX_FILE_PATH " + campionati_XLSX_FILE_PATH);
            
            // Creating a Workbook from an Excel file (.xls or .xlsx)
            Workbook workbook;
    		try 
    		{
    	
    			workbook = WorkbookFactory.create(new File(campionati_XLSX_FILE_PATH));
    			
    	        // Retrieving the number of sheets in the Workbook
    	        System.out.println("Workbook has " + workbook.getNumberOfSheets() + " Sheets : ");
    
                // Getting the Sheet at index zero
                Sheet sheet = workbook.getSheetAt(0);
                
                // 1. You can obtain a rowIterator and columnIterator and iterate over them
                System.out.println("\n\nIterating over Rows and Columns using Iterator\n");
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
    	catch (IOException e) 
    	{
			e.printStackTrace();
		}

	}
	
	
}

package it.roberto.main;

import java.util.Date;

import org.apache.log4j.Logger;

import it.roberto.thread.Thread_InserimentoCampionati_AnnoInCorso;
import it.roberto.thread.Thread_InserimentoCampionati_AnnoSingolo_AnnoInCorso;

/**
 * 
 *
 */
public class CaricaCampionati_AnnoInCorso_TOTALE 
{
	
    public static void main( String[] args )
    {
    	Logger logger = Logger.getLogger(CaricaCampionati_AnnoInCorso_TOTALE.class);
    	
    	Date data_inizio =  new Date();
    	logger.info("INIZIO - getCampionati_AnnoInCorso - ORA: " +  data_inizio);
    	//System.out.println("INIZIO - getCampionati_AnnoInCorso - ORA: " +  data_inizio);
    	
    	Thread_InserimentoCampionati_AnnoInCorso R1 = new Thread_InserimentoCampionati_AnnoInCorso( "Thread_InserimentoCampionati_AnnoInCorso");
	    R1.start();
	      
	    Thread_InserimentoCampionati_AnnoSingolo_AnnoInCorso R2 = new Thread_InserimentoCampionati_AnnoSingolo_AnnoInCorso( "Thread_InserimentoCampionati_AnnoSingolo_AnnoInCorso");
	    R2.start();
    	

    }

    
    
}

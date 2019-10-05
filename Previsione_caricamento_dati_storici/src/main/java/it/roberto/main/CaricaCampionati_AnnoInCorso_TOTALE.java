package it.roberto.main;

import java.util.Date;

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
    	
    	Date data_inizio =  new Date();
    	System.out.println("INIZIO - getCampionati_AnnoInCorso - ORA: " +  data_inizio);
    	
    	Thread_InserimentoCampionati_AnnoInCorso R1 = new Thread_InserimentoCampionati_AnnoInCorso( "Thread_InserimentoCampionati_AnnoInCorso");
	    R1.start();
	      
	    Thread_InserimentoCampionati_AnnoSingolo_AnnoInCorso R2 = new Thread_InserimentoCampionati_AnnoSingolo_AnnoInCorso( "Thread_InserimentoCampionati_AnnoSingolo_AnnoInCorso");
	    R2.start();
    	

    }

    
    
}

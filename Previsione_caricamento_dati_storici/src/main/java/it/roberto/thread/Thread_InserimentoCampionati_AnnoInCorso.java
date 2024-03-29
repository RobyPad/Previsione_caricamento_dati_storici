package it.roberto.thread;

import java.util.Date;
import java.util.List;

import it.roberto.configurazione.Lista_Campionati;
import it.roberto.operazioni.DB.Inserimento_Campionati_DB;

public class Thread_InserimentoCampionati_AnnoInCorso implements Runnable 
{
	   private Thread t;
	   private String threadName;
	   
	   public Thread_InserimentoCampionati_AnnoInCorso(String name) 
	   {
	      threadName = name;
	      System.out.println("Creating " +  threadName );
	   }
	   
	   public void run() 
	   {
		  System.out.println("Running " +  threadName );
	      
	      Lista_Campionati lista_Campionati = new Lista_Campionati();

		  List<String> lc = lista_Campionati.getCampionati_AnnoInCorso();
		  List<String> lb = lista_Campionati.getBottoni_AnnoInCorso();	
	    	
		  Inserimento_Campionati_DB.caricaCampionati_SOFT(lc, lb);
   
		  Date data_fine =  new Date();	
	      System.out.println("FINE - Thread_InserimentoCampionati_AnnoInCorso - ORA: " +  data_fine);
	   }
	   
	   public void start () 
	   {
	      System.out.println("Starting " +  threadName );
	      if (t == null) 
	      {
	         t = new Thread (this, threadName);
	         t.start ();
	      }
	      
	      
	   }
	} 

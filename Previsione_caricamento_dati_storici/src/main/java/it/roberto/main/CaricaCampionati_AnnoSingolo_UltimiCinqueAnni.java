package it.roberto.main;

import java.util.Date;
import java.util.List;

import it.roberto.configurazione.Lista_Campionati;
import it.roberto.operazioni.DB.Inserimento_Campionati_DB;

/**
 * Hello world!
 *
 */
public class CaricaCampionati_AnnoSingolo_UltimiCinqueAnni 
{
    public static void main( String[] args )
    {
    	
    	Date data_inizio =  new Date();
    	System.out.println("INIZIO - getCampionati_AnnoSingolo_UltimiCinqueAnni - ORA: " +  data_inizio);
    	
    	List<String> lc = Lista_Campionati.getCampionati_AnnoSingolo_UltimiCinqueAnni();
    	List<String> lb = Lista_Campionati.getBottoni_AnnoSingolo_UltimiCinqueAnni();
    	
    	//Inserimento_Campionati_DB.caricaCampionati_HARD(lc, lb);
    	
    	Inserimento_Campionati_DB.caricaCampionati_SOFT(lc, lb);

    	Date data_fine =  new Date();	
    	System.out.println("FINE - Caricamento campionati attuali - ORA: " +  data_fine);
    }
     
}

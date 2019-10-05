package it.roberto.main;

import java.util.Date;
import java.util.List;

import it.roberto.configurazione.Lista_Campionati;
import it.roberto.operazioni.DB.Inserimento_Campionati_DB;

/**
 * Carica_Campionati_Anno_Singolo_Attuali
 *
 */
public class CaricaCampionati_AnnoSingolo_AnnoInCorso 
{
    public static void main( String[] args )
    {
    	
    	Date data_inizio =  new Date();
    	System.out.println("INIZIO - getCampionati_AnnoSingolo_AnnoInCorso - ORA: " +  data_inizio);
    	
    	List<String> lc = Lista_Campionati.getCampionati_AnnoSingolo_AnnoInCorso();
    	List<String> lb = Lista_Campionati.getBottoni_AnnoSingolo_AnnoInCorso();
    	
    	//Inserimento_Campionati_DB.caricaCampionati_HARD(lc, lb);
    	
    	Inserimento_Campionati_DB.caricaCampionati_SOFT(lc, lb);

    	Date data_fine =  new Date();	
    	System.out.println("FINE - getCampionati_AnnoSingolo_AnnoInCorso - ORA: " +  data_fine);
    	
    }
    

}

package it.roberto.Previsione_caricamento_dati_storici;

import java.util.List;

import it.roberto.utils.Campionati;
import it.roberto.utils.Inserimento_Campionati_DB;

/**
 * Hello world!
 *
 */
public class Carica_Campionati_Anno_Singolo_History 
{
    public static void main( String[] args )
    {
    	System.out.println("Carica_Campionati_Anno_Singolo_History");
    	
    	List<String> lc = Campionati.getCampionati_Anno_Singolo_HISTORY();
    	List<String> lb = Campionati.getBottoni_Anno_Singolo_HISTORY();
    	
       	Inserimento_Campionati_DB.carica_campionati(lc, lb);
    }
     
}

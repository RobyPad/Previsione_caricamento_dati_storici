package it.roberto.Previsione_caricamento_dati_storici;

import java.util.List;

import com.roberto.caricamento.dati.CaricaPartite;

import it.roberto.model.Partita;
import it.roberto.utils.Campionati;

public class TestMetodi {

	public static void main(String[] args) 
	{

		test_2();
		
	}
	public static void test_1()
	{
		List<String> lc = Campionati.getCampionati();
		
		System.out.println(lc);

		
		List<String> lb = Campionati.getBottoni();

		System.out.println(lb);
	}
	
	public static void test_2()
	{
		List<String> lc = Campionati.getCampionati();
		List<String> lb = Campionati.getBottoni();

		CaricaPartite o = new CaricaPartite();
		
		List<Partita> listaPartite = o.caricaCampionato4(lc, lb);

		System.out.println(listaPartite);
		
	}

}

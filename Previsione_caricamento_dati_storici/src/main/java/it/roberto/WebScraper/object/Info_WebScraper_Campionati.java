package it.roberto.WebScraper.object;

import java.util.List;

public class Info_WebScraper_Campionati 
{
	private List<String> URL_campionati;
	private List<String> link_bottoni;
	
	public Info_WebScraper_Campionati() 
	{
		// TODO Auto-generated constructor stub
	}

	public Info_WebScraper_Campionati(List<String> uRL_campionati, List<String> link_bottoni) 
	{
		this.URL_campionati = uRL_campionati;
		this.link_bottoni = link_bottoni;
	}

	public List<String> getURL_campionato() {
		return URL_campionati;
	}

	public void setURL_campionato(List<String> uRL_campionato) {
		URL_campionati = uRL_campionato;
	}

	public List<String> getLink_bottone() {
		return link_bottoni;
	}

	public void setLink_bottone(List<String> link_bottone) {
		this.link_bottoni = link_bottone;
	}

	@Override
	public String toString() {
		return "URL_delCampionato [URL_campionato=" + URL_campionati + ", link_bottone=" + link_bottoni + "]";
	}
	

}

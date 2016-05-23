package it.polito.tdp.simulation;

import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Queue;

public class Core {
	
	private StringBuilder result = new StringBuilder();
	private Statistica stat = new Statistica();;
	private Queue<Evento> listaEventi = new PriorityQueue<Evento>();
	private Queue<GruppoClienti> listaAttesa = new PriorityQueue<GruppoClienti>();
	private List<Integer> tavoli = new ArrayList<Integer>();
	

	public void aggiungiEvento(Evento e) {
		listaEventi.add(e);
	}
	
	public void aggiungiTavoli(int[] list) {
		for(int i : list)
			tavoli.add(i);
		
		// System.out.println(tavoli);
	}
	
	public String getResult() {
		result.append(stat.toString());
		return result.toString();
	}
	
	public void passo() {
		Evento e = listaEventi.remove();
		
		switch (e.getTipo()) {
		
			case ARRIVO_GRUPPO_CLIENTI:
				listaAttesa.add(new GruppoClienti(e.getNum_persone(), e.getDurata(), e.getToll()));
				result.append(e.getTime()+" : Arriva un nuovo gruppo di "+e.getNum_persone()+" clienti\n");
				break;
			case SI_LIBERA_TAVOLO:
				tavoli.add(e.getNum_persone());
				result.append(e.getTime()+" : ********Si è appena liberato un tavolo per "+e.getNum_persone()+"********\n");
				break;
			default:
				break;
		
		}
		
		while(servi(e.getTime())) {}

	}
	
	public boolean servi(long adesso) {
		
		int posti = Integer.MAX_VALUE;
		
		if(listaAttesa.isEmpty())
			return false;
		
		GruppoClienti gp = listaAttesa.remove();
		stat.setNumero_totale_clienti(gp.getNum());
		
		if(!tavoli.isEmpty()) {
			for (int n : tavoli) {
				if(gp.getNum() <= n && posti > n && gp.getNum()>=(n/2))
					posti = n;
			}
			
			if(posti != Integer.MAX_VALUE) {
		
				for(int i=0; i<tavoli.size(); i++)
					if(tavoli.get(i) == posti) {
						tavoli.remove(i);
						break;
					}
				
				stat.setNumero_clienti_soddisfatti(gp.getNum());
				result.append(adesso+" : Un gruppo di "+gp.getNum()+" clienti è stato fatto sedere in un tavolo da "+posti+"\n");
				listaEventi.add(new Evento((int) adesso + gp.getDurata(),posti));
				return true;
			}
					
		} 
			// System.out.println((Math.random()*100)/100);
			if( gp.getToll() >= (Math.random()*100)/100) {
			stat.setNumero_clienti_soddisfatti(gp.getNum());
			result.append(adesso+" : Un gruppo di "+gp.getNum()+" clienti è stato fatto sedere al bancone\n");
		} else {
			stat.setNumero_clienti_insoddisfatti(gp.getNum());
			result.append(adesso+" : !!!!!!!!Un gruppo di "+gp.getNum()+" clienti non trovando posto al tavolo è andato via!!!!!!!!\n");
		}
		
		
		return true;
		
	}
	
	public void simula() {
		
		while (!listaEventi.isEmpty()) {
			passo();
		}
		
		System.err.println(stat);
	}
}

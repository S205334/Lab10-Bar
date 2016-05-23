package it.polito.tdp.model;

import java.util.Random;

import it.polito.tdp.simulation.Core;
import it.polito.tdp.simulation.Evento;

public class Model {
	
	private Core simulazione;
	
	public Model() {
		
	}
	
	public void setTavoli() {
		int[] list = {10, 10, 8, 8, 8, 8, 6, 6, 6, 6, 4, 4, 4, 4, 4,};
		simulazione.aggiungiTavoli(list);
	}
	
	public void random() {
		
		long time = 0;
		int num_persone;
		int durata;
		float toll;
		Random rand = new Random();
		
		for(int n=1; n<=2000; n++) {
			time = rand.nextInt((10-0)+1) + 1 + time;
			num_persone = rand.nextInt((10 - 1) + 1) + 1;
			durata = rand.nextInt((120 - 60) + 1) + 60;
			toll = rand.nextFloat();
			
			simulazione.aggiungiEvento(new Evento(time,num_persone,durata,toll));		
		}
		
	}

	public String stub() {
		simulazione = new Core();
		
		random();
		setTavoli();
		simulazione.simula();
		
		return simulazione.getResult();
	}

}

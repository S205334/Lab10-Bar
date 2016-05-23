package it.polito.tdp.simulation;

public class Statistica {

	private int numero_totale_clienti;
	private int numero_clienti_soddisfatti;
	private int numero_clienti_insoddisfatti;
	
	public Statistica() {
		this.numero_clienti_insoddisfatti = 0;
		this.numero_clienti_soddisfatti = 0;
		this.numero_totale_clienti = 0;
	}

	public void setNumero_totale_clienti(int numero_totale_clienti) {
		this.numero_totale_clienti += numero_totale_clienti;
	}

	public void setNumero_clienti_soddisfatti(int numero_clienti_soddisfatti) {
		this.numero_clienti_soddisfatti += numero_clienti_soddisfatti;
	}

	public void setNumero_clienti_insoddisfatti(int numero_clienti_insoddisfatti) {
		this.numero_clienti_insoddisfatti += numero_clienti_insoddisfatti;
	}

	@Override
	public String toString() {
		float percIn = ((float) numero_clienti_insoddisfatti/numero_totale_clienti)*100;
		float percSo = ((float) numero_clienti_soddisfatti/numero_totale_clienti)*100;
		return "\nStatistiche: \nNumero totale dei clienti : " + numero_totale_clienti + "\nClienti soddisfatti: "
				+ numero_clienti_soddisfatti + "("+percSo+"%)\nClienti insoddisfatti: " + numero_clienti_insoddisfatti + "("+percIn+"%)";
	}
	
	
}

package it.polito.tdp.simulation;

public class Evento implements Comparable<Evento>{

	public enum TipoEvento {ARRIVO_GRUPPO_CLIENTI, SI_LIBERA_TAVOLO}
	
	private long time;
	private int num_persone;
	private int durata;
	private float toll;
	private TipoEvento tipo;
	
	public Evento(long time, int num_persone, int durata, float toll) {
		super();
		this.time = time;
		this.num_persone = num_persone;
		this.durata = durata;
		this.toll = toll;
		this.tipo = TipoEvento.ARRIVO_GRUPPO_CLIENTI;
	}
	
	public Evento(long time, int num_posti) {
		super();
		this.time = time;
		this.num_persone = num_posti;
		this.tipo = TipoEvento.SI_LIBERA_TAVOLO;
	}

	public long getTime() {
		return time;
	}

	public int getNum_persone() {
		return num_persone;
	}

	public int getDurata() {
		return durata;
	}

	public float getToll() {
		return toll;
	}

	public TipoEvento getTipo() {
		return tipo;
	}

	@Override
	public String toString() {
		if(tipo == TipoEvento.ARRIVO_GRUPPO_CLIENTI)
			return "Evento [time=" + time + ", num_persone=" + num_persone + ", durata=" + durata + ", toll=" + toll
				+ ", tipo=" + tipo + "]";
		else 
			return "Evento [time=" + time + ", num_posti=" + num_persone + ", tipo=" + tipo + "]";
	}

	@Override
	public int compareTo(Evento arg0) {
		return Long.compare(this.time, arg0.time);
	}
	
	
}

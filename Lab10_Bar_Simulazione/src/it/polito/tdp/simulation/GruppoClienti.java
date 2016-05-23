package it.polito.tdp.simulation;

public class GruppoClienti implements Comparable<GruppoClienti>{
	
	private int num;
	private int durata;
	private float toll;
	
	public GruppoClienti(int num, int durata, float toll) {
		super();
		this.num = num;
		this.durata = durata;
		this.toll = toll;
	}

	public int getNum() {
		return num;
	}

	public int getDurata() {
		return durata;
	}

	public float getToll() {
		return toll;
	}

	@Override
	public int compareTo(GruppoClienti arg0) {
		// TODO Auto-generated method stub
		return 0;
	}
	
	

}

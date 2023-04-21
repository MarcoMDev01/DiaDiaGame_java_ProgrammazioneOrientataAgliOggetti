package it.uniroma3.diadia.giocatore;

import it.uniroma3.diadia.attrezzi.Attrezzo;

public class Giocatore {
	private int cfu;
	private Borsa borsa;
	
	public Giocatore(int cfu)
	{
		this.cfu = cfu;
		this.borsa= new Borsa();
	}

	public int getCfu() {
		return cfu;
	}

	public void setCfu(int cfu) {
		this.cfu = cfu;
	}

	public Borsa getBorsa() {
		return borsa;
	}
	
	public String toString() {
		StringBuilder risultato = new StringBuilder();
		risultato.append("\nhai: "+this.getCfu()+"Cfu");
		
		
		return risultato.toString();
	}
}

package it.uniroma3.diadia.command;

import it.uniroma3.diadia.Partita;
import it.uniroma3.diadia.attrezzi.Attrezzo;

/**
 * Il metodo prendi: 
 * 1.crea un attrezzo e lo riempie con le caratteristiche dell' oggetto cercato.-
 * 2.aggiunge l' attrezzo nella borsa-
 * 3.rimuove l'attrezzo dalla stanza -
 * @author STUDENTE MARCO MICCICHE' MATRICOLA 562609
 * @param nomeAttrezzo
 * @category IMPLEMENTAZINI STUDENTE
 */
public class ComandoPrendi implements Comando {

	private String nomeAttrezzo;

	@Override
	public void esegui(Partita partita) {
		// TODO Auto-generated method stub
		Attrezzo a= partita.getStanzaCorrente().getAttrezzo(nomeAttrezzo);
		if(a!=null) {
			partita.getGiocatore().getBorsa().addAttrezzo(a);
			partita.getStanzaCorrente().removeAttrezzo(a);
		}
	}
	@Override
	public void setParametro(String parametro) {
		this.nomeAttrezzo= parametro;

	}

}

package it.uniroma3.diadia.command;
import it.uniroma3.diadia.Partita;
import it.uniroma3.diadia.attrezzi.Attrezzo;
/**
 * Il metodo prendi: 
 * 1.crea un attrezzo e lo carica con le caratteristiche dell' oggetto cercato.-
 * 2.aggiunge l' attrezzo nella stanza-
 * 3.rimuove l'attrezzo dalla borsa -
 * @author STUDENTE MARCO MICCICHE' MATRICOLA 562609
 * @param nomeAttrezzo
 * @category IMPLEMENTAZINI STUDENTE
 */
public class ComandoPosa implements Comando {
	
	private String nomeAttrezzo;
	
	@Override
	public void esegui(Partita partita) {

		Attrezzo a=partita.getGiocatore().getBorsa().getAttrezzo(nomeAttrezzo);
		if(a!=null){
			partita.getStanzaCorrente().addAttrezzo(a);
			partita.getGiocatore().getBorsa().removeAttrezzo(nomeAttrezzo);
		}

	}

	@Override
	public void setParametro(String parametro) {
		this.nomeAttrezzo= parametro;

	}

}

package it.uniroma3.diadia.command;

import it.uniroma3.diadia.Partita;
import it.uniroma3.diadia.ambienti.Stanza;
/**
 * Cerca di andare in una direzione. Se c'e' una stanza ci entra 
 * e ne stampa il nome, altrimenti stampa un messaggio di errore
 */

public class ComandoVai implements Comando {


	private String direzione;

	@Override
	public void esegui(Partita partita) {
		// TODO Auto-generated method stub
		Stanza StanzaCorrente= partita.getStanzaCorrente();
		Stanza prossimaStanza=null;
		
		
		if(direzione==null) {
			partita.getCommand().mostraMessaggio("Dove vuoi andare ?");
			return;
		}
		prossimaStanza = StanzaCorrente.getStanzaAdiacente(direzione);
		if (prossimaStanza == null) {
			partita.getCommand().mostraMessaggio("Direzione inesistente");
			return;
		}
		
			partita.setStanzaCorrente(prossimaStanza);
			int cfu = partita.getGiocatore().getCfu();
			partita.getGiocatore().setCfu(cfu-1);
		
			partita.getCommand().mostraMessaggio(partita.getStanzaCorrente().getDescrizione());
	}

	@Override
	public void setParametro(String parametro) {
		this.direzione=parametro;

	}

}

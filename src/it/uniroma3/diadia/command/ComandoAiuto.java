package it.uniroma3.diadia.command;

import it.uniroma3.diadia.Partita;
/**
 * Stampa informazioni di aiuto.
 */

public class ComandoAiuto implements Comando {
	static final private String[] elencoComandi = {"vai", "aiuto", "fine","prendi","posa","guarda"};
	@Override
	public void esegui(Partita partita) {
		for(int i=0; i< elencoComandi.length; i++) 
			partita.getCommand().mostraMessaggio(elencoComandi[i]+" ");
		

	}

	@Override
	public void setParametro(String parametro) {
		// TODO Auto-generated method stub

	}

}

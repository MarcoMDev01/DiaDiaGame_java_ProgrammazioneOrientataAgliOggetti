package it.uniroma3.diadia.command;

import it.uniroma3.diadia.Partita;

public class ComandoGuarda implements Comando {

	@Override
	public void esegui(Partita partita) {
		partita.getCommand().mostraMessaggio(partita.getStanzaCorrente().toString());
		partita.getCommand().mostraMessaggio(partita.getGiocatore().toString());
		partita.getCommand().mostraMessaggio(partita.getGiocatore().getBorsa().toString());
	}

	@Override
	public void setParametro(String parametro) {
		// TODO Auto-generated method stub

	}
	
	public void setParametro() {
		// TODO Auto-generated method stub

	}

}

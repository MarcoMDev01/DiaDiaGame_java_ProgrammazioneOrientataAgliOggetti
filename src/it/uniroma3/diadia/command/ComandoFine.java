package it.uniroma3.diadia.command;

import it.uniroma3.diadia.Partita;

public class ComandoFine implements Comando {
	
	@Override
	public void esegui(Partita partita) {
		partita.getCommand().mostraMessaggio("Grazie di aver giocato!");
		partita.setFinita();

	}

	@Override
	public void setParametro(String parametro) {
		// TODO Auto-generated method stub

	}

}

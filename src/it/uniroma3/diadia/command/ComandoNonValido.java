package it.uniroma3.diadia.command;

import it.uniroma3.diadia.Partita;

public class ComandoNonValido implements Comando {
	
	@Override
	public void esegui(Partita partita) {
		partita.getCommand().mostraMessaggio("CARO UTENTE INSERISCI UN COMANDO VALIDO");

	}

	@Override
	public void setParametro(String parametro) {
		

	}

}

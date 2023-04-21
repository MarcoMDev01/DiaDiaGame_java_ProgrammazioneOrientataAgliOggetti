package it.uniroma3.diadia;

import it.uniroma3.diadia.ambienti.Labirinto;
import it.uniroma3.diadia.ambienti.Stanza;
import it.uniroma3.diadia.giocatore.Giocatore;

/**
 * Questa classe modella una partita del gioco
 *
 * @author  docente di POO
 * @see Stanza
 * @version base
 */

public class Partita {

	static final private int CFU_INIZIALI = 20;
	private boolean finita;
	private Stanza stanzaCorrente;
	private Labirinto labirinto;
	private Giocatore giocatore;
	private IO command;

	public IO getCommand() {
		return command;
	}
	public Partita(){
		this.command= new IOConsole();
		this.labirinto= new Labirinto();
		this.stanzaCorrente= this.labirinto.getStanzaIniziale();
		this.finita = false;
		this.setGiocatore(new Giocatore(CFU_INIZIALI));
	}
	public Partita(IO command){
		this.command=command;
		this.labirinto= new Labirinto();
		this.stanzaCorrente= this.labirinto.getStanzaIniziale();
		this.finita = false;
		this.setGiocatore(new Giocatore(CFU_INIZIALI));
	}

	public Labirinto getLabirinto()
	{
		return this.labirinto;
	}

	public void setStanzaCorrente(Stanza stanzaCorrente) {
		this.stanzaCorrente = stanzaCorrente;
	}

	public Stanza getStanzaCorrente() {
		return this.stanzaCorrente;
	}


	/**
	 * Restituisce vero se e solo se la partita e' stata vinta
	 * @return vero se partita vinta
	 */
	public boolean vinta() {
		return this.getStanzaCorrente()== this.labirinto.getStanzaVincente();
	}

	/**
	 * Restituisce vero se e solo se la partita e' finita
	 * @return vero se partita finita
	 */
	public boolean isFinita() {
		return finita || vinta() || (this.getGiocatore().getCfu() == 0);
	}

	/**
	 * Imposta la partita come finita
	 *
	 */
	public void setFinita() {
		this.finita = true;
	}



	public Giocatore getGiocatore() {
		return giocatore;
	}

	public void setGiocatore(Giocatore giocatore) {
		this.giocatore = giocatore;
	}

	public boolean giocatoreIsVivo() {
		return (giocatore.getCfu()!=0);
	}

	}	


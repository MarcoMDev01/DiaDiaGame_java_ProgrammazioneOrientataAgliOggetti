package it.uniroma3.diadia;
import it.uniroma3.diadia.attrezzi.*;
import it.uniroma3.diadia.ambienti.*;


/**
 * Classe principale di diadia, un semplice gioco di ruolo ambientato al dia.
 * Per giocare crea un'istanza di questa classe e invoca il letodo gioca
 *
 * Questa e' la classe principale crea e istanzia tutte le altre
 *
 * @author  docente di POO 
 *         (da un'idea di Michael Kolling and David J. Barnes) 
 *          
 * @version base
 */

public class DiaDia {

	static final private String MESSAGGIO_BENVENUTO = ""+
			"Ti trovi nell'Universita', ma oggi e' diversa dal solito...\n" +
			"Meglio andare al piu' presto in biblioteca a studiare. Ma dov'e'?\n"+
			"I locali sono popolati da strani personaggi, " +
			"alcuni amici, altri... chissa!\n"+
			"Ci sono attrezzi che potrebbero servirti nell'impresa:\n"+
			"puoi raccoglierli, usarli, posarli quando ti sembrano inutili\n" +
			"o regalarli se pensi che possano ingraziarti qualcuno.\n\n"+
			"Per conoscere le istruzioni usa il comando 'aiuto'.";

	static final private String[] elencoComandi = {"vai", "aiuto", "fine","prendi","posa"};

	private Partita partita;

	public DiaDia() {
		this.partita = new Partita();
	}

	public void gioca() {
		String istruzione; 

		IOConsole command =new IOConsole();



		if(command!=null)
			command.mostraMessaggio(MESSAGGIO_BENVENUTO);

		do		
			istruzione = command.leggiRiga();
		while (!processaIstruzione(istruzione));
	}   


	/**
	 * Processa una istruzione 
	 *
	 * @return true se l'istruzione e' eseguita e il gioco continua, false altrimenti
	 */
	private boolean processaIstruzione(String istruzione) {
		Comando comandoDaEseguire = new Comando(istruzione);
		String nome = comandoDaEseguire.getNome();
		if ("fine".equals(nome)) {
			this.fine(); 
			return true;
		} else {

			if ("vai".equals(nome))
				this.vai(comandoDaEseguire.getParametro());
			else if ("prendi".equals(nome))//modifica 23.03.23 ore11
				this.prendi(comandoDaEseguire.getParametro());
			else if ("posa".equals(nome))//modifica 23.03.23 ore11
				this.posa(comandoDaEseguire.getParametro());
			else if ("aiuto".equals(nome))
				this.aiuto();
			else
				System.out.println("Comando sconosciuto");
		}
		if (this.partita.vinta()) {
			System.out.println("Hai vinto!");
			return true;
		} else
			return false;

	}   

	// implementazioni dei comandi dell'utente:
	/**
	 * Il metodo prendi: 
	 * 1.crea un attrezzo e lo riempie con le caratteristiche dell' oggetto cercato.-
	 * 2.aggiunge l' attrezzo nella borsa-
	 * 3.rimuove l'attrezzo dalla stanza -
	 * @author STUDENTE MARCO MICCICHE' MATRICOLA 562609
	 * @param nomeAttrezzo
	 * @category IMPLEMENTAZINI STUDENTE
	 */
	private void prendi(String nomeAttrezzo) {
		Attrezzo a= this.partita.getStanzaCorrente().getAttrezzo(nomeAttrezzo);
		if(a!=null) {
			this.partita.getGiocatore().getBorsa().addAttrezzo(a);
			this.partita.getStanzaCorrente().removeAttrezzo(a);
		}
	}
	// implementazioni dei comandi dell'utente:
	/**
	 * Il metodo prendi: 
	 * 1.crea un attrezzo e lo carica con le caratteristiche dell' oggetto cercato.-
	 * 2.aggiunge l' attrezzo nella stanza-
	 * 3.rimuove l'attrezzo dalla borsa -
	 * @author STUDENTE MARCO MICCICHE' MATRICOLA 562609
	 * @param nomeAttrezzo
	 * @category IMPLEMENTAZINI STUDENTE
	 */
	private void posa(String nomeAttrezzo) {
		Attrezzo a=this.partita.getGiocatore().getBorsa().getAttrezzo(nomeAttrezzo);

		this.partita.getStanzaCorrente().addAttrezzo(a);
		this.partita.getGiocatore().getBorsa().removeAttrezzo(nomeAttrezzo);

	}
	/**
	 * Stampa informazioni di aiuto.
	 */
	private void aiuto() {
		for(int i=0; i< elencoComandi.length; i++) 
			System.out.print(elencoComandi[i]+" ");
		System.out.println();
	}

	/**
	 * Cerca di andare in una direzione. Se c'e' una stanza ci entra 
	 * e ne stampa il nome, altrimenti stampa un messaggio di errore
	 */
	private void vai(String direzione) {
		if(direzione==null)
			System.out.println("Dove vuoi andare ?");
		Stanza prossimaStanza = null;
		prossimaStanza = this.partita.getStanzaCorrente().getStanzaAdiacente(direzione);
		if (prossimaStanza == null)
			System.out.println("Direzione inesistente");
		else {
			this.partita.setStanzaCorrente(prossimaStanza);
			int cfu = this.partita.getGiocatore().getCfu();
			this.partita.getGiocatore().setCfu(cfu-1);
		}
		System.out.println(partita.getStanzaCorrente().getDescrizione());
	}

	/**
	 * Comando "Fine".
	 */
	private void fine() {
		System.out.println("Grazie di aver giocato!");  // si desidera smettere
	}

	public static void main(String[] argc) {
		DiaDia gioco = new DiaDia();
		gioco.gioca();
	}
}
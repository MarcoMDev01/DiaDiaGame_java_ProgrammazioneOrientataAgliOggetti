package it.uniroma3.diadia.ambienti;

import it.uniroma3.diadia.attrezzi.Attrezzo;
import java.util.*;


/**
 * Classe Stanza - una stanza in un gioco di ruolo.
 * Una stanza e' un luogo fisico nel gioco.
 * E' collegata ad altre stanze attraverso delle uscite.
 * Ogni uscita e' associata ad una direzione.
 * 
 * @author docente di POO 
 * @see Attrezzo
 * @version base
 */

public class Stanza {

	static final private int NUMERO_MASSIMO_DIREZIONI = 4;
	private static final int NUMERO_MASSIMO_ATTREZZI = 10;

	private String descrizione;
	private Map<String,Attrezzo> attrezzi;
	private int numeroAttrezzi;

	private Map<String,Stanza> stanzeAdiacenti;
	private int numeroStanzeAdiacenti;

	public Stanza(String descrizione){
		this.stanzeAdiacenti = new HashMap<>();
		this.attrezzi = new HashMap<>(NUMERO_MASSIMO_ATTREZZI);
		this.descrizione = descrizione;
	}
	public List<Stanza> getStanzeAdiacenti() {
		return (List<Stanza>) stanzeAdiacenti.values();
	}

	public Map<String,Stanza> getMapStanzeAdiacenti() {
		return   stanzeAdiacenti;
	}
	
	public void setStanzeAdiacenti(Map<String, Stanza> stanzeAdiacenti) {
		this.stanzeAdiacenti = stanzeAdiacenti;
	}

	public int getNumeroStanzeAdiacenti() {
		return numeroStanzeAdiacenti;
	}

	public void setNumeroStanzeAdiacenti(int numeroStanzeAdiacenti) {
		this.numeroStanzeAdiacenti = numeroStanzeAdiacenti;
	}

	public int getNumeroAttrezziPossibili() {
		return NUMERO_MASSIMO_ATTREZZI-this.numeroAttrezzi;
	}
	public void impostaStanzaAdiacente(String direzione, Stanza stanza) {
		boolean aggiornato = false;
		//		for(int i=0; i<this.direzioni.size(); i++)
		//			if (direzione.equals(this.direzioni.get(i))) {
		//				this.stanzeAdiacenti.add(stanza);
		//				aggiornato = true;
		//			}
		if (stanzeAdiacenti.containsKey(direzione)) {
			this.stanzeAdiacenti.put(direzione,stanza);
			aggiornato = true;
		}
		if (!aggiornato)
			if (this.numeroStanzeAdiacenti < NUMERO_MASSIMO_DIREZIONI) {
				this.stanzeAdiacenti.put(direzione,stanza);
				this.numeroStanzeAdiacenti++;
			}
	}

	/**
	 * Restituisce la nome della stanza.
	 * @return il nome della stanza
	 */
	public String getNome() {
		return this.descrizione;
	}

	/**
	 * Restituisce la descrizione della stanza.
	 * @return la descrizione della stanza
	 */
	public String getDescrizione() {
		return this.toString();
	}

	/**
	 * Restituisce la collezione di attrezzi presenti nella stanza.
	 * @return la collezione di attrezzi nella stanza.
	 */
	public List<Attrezzo> getAttrezzi() {
		List<Attrezzo> a= new ArrayList<Attrezzo>();
		a.addAll(attrezzi.values());
		return a;
	}

	/**
	 * Mette un attrezzo nella stanza.
	 * @param attrezzo l'attrezzo da mettere nella stanza.
	 * @return true se riesce ad aggiungere l'attrezzo, false atrimenti.
	 */
	public boolean addAttrezzo(Attrezzo attrezzo) {
		if(attrezzo!=null && this.numeroAttrezzi<NUMERO_MASSIMO_ATTREZZI) {
			this.attrezzi.put(attrezzo.getNome(),attrezzo);
			this.numeroAttrezzi++;
			return true;
		}

		return false;
	}

	public Stanza getStanzaAdiacente(String direzione) {
		Stanza stanza = null;
		if (this.stanzeAdiacenti.containsKey(direzione))
			stanza = this.stanzeAdiacenti.get(direzione);
		return stanza;
	}

	/**
	 * Restituisce una rappresentazione stringa di questa stanza,
	 * stampadone la descrizione, le uscite e gli eventuali attrezzi contenuti
	 * @return la rappresentazione stringa
	 */
	public String toString() {
		StringBuilder risultato = new StringBuilder();
		risultato.append(this.descrizione);
		risultato.append("\nUscite: ");
		risultato.append(this.stanzeAdiacenti.values());		
		risultato.append("\nAttrezzi nella stanza: ");
		risultato.append(this.attrezzi.toString());
		return risultato.toString();

	}

	/**
	 * Controlla se un attrezzo esiste nella stanza (uguaglianza sul nome).
	 * @return 
	 * @return true se l'attrezzo esiste nella stanza, false altrimenti.
	 */
	public boolean hasAttrezzo(String nomeAttrezzo) {
		return this.attrezzi.containsKey(nomeAttrezzo);
	}
	/**
	 * Restituisce l'attrezzo nomeAttrezzo se presente nella stanza.
	 * @param nomeAttrezzo
	 * @return l'attrezzo presente nella stanza.
	 * 		   null se l'attrezzo non e' presente.
	 */
	public Attrezzo getAttrezzo(String nomeAttrezzo) {		
		Attrezzo attrezzoCercato;
		attrezzoCercato = null;
		if (this.attrezzi.containsKey(nomeAttrezzo))
			attrezzoCercato = this.attrezzi.get(nomeAttrezzo);
		return attrezzoCercato;	
	}

	/**
	 * Rimuove un attrezzo dalla stanza (ricerca in base al nome).
	 * @param nomeAttrezzo
	 * @return true se l'attrezzo e' stato rimosso, false altrimenti
	 */
	public boolean removeAttrezzo (Attrezzo attrezzo) {
		return this.attrezzi.remove(attrezzo.getNome(),attrezzo);
	}


	public Collection<String> getDirezioni() {

		return stanzeAdiacenti.keySet();
	}

	@Override
	public int hashCode() {
		return Objects.hash(getNome());
	}

	@Override
	public boolean equals(Object obj) {
		
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Stanza that = (Stanza) obj;
		return this.getNome().equals(that.getNome());
	}
	
	
	
}
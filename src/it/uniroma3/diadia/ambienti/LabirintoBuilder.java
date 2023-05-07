package it.uniroma3.diadia.ambienti;


import java.util.HashMap;

import java.util.Map;

import it.uniroma3.diadia.attrezzi.*;


public class LabirintoBuilder   {
	private Labirinto labirinto;
	private Stanza ultimaStanzaAggiunta;
	private Map<String, Stanza> stanze;
	
	

	public LabirintoBuilder() {
		this.labirinto= new Labirinto();
		this.stanze=new HashMap<>();	
	}
	
	public Map<String, Stanza> getListaStanze() {
		return stanze;
	}
	public Labirinto getLabirinto() {
		return labirinto;
	}

	public Stanza getUltimaStanzaAggiunta() {
		return ultimaStanzaAggiunta;
	}
	
	public LabirintoBuilder addStanzaIniziale(String stanzaIniziale) {
		Stanza StanzaIniziale=new Stanza(stanzaIniziale);
		labirinto.setStanzaIniziale(StanzaIniziale);
		this.UltimaStanzaAggiuntaEAggiorna(StanzaIniziale);
		return this;
		
	}
	public LabirintoBuilder addStanzaVincente(String stanzaVincente) {
		Stanza StanzaVincente=new Stanza(stanzaVincente);
		labirinto.setStanzaVincente(StanzaVincente);
		this.UltimaStanzaAggiuntaEAggiorna(StanzaVincente);
		return this;		
	}

	private void UltimaStanzaAggiuntaEAggiorna(Stanza stanza) {
		this.ultimaStanzaAggiunta = stanza;
		stanze.put(stanza.getNome(), stanza);
	}

	public LabirintoBuilder addStanza(String string) {
		Stanza NuovaStanza=new Stanza(string);
		this.UltimaStanzaAggiuntaEAggiorna(NuovaStanza);
		return this;
	}

	public LabirintoBuilder addAttrezzo(String string, int i) {
		// TODO Auto-generated method stub
		ultimaStanzaAggiunta.addAttrezzo(new Attrezzo(string, i));
		return this;
	}

	public LabirintoBuilder addStanzaBloccata(String string, String string2, String string3) {
		Stanza stanzaBloccata=new StanzaBloccata(string,string2,string3);
		this.UltimaStanzaAggiuntaEAggiorna(stanzaBloccata);
		return this;
	}

	public LabirintoBuilder addStanzaMagica(String string, int i) {
		Stanza stanzaMagica=new StanzaMagica(string,i);
		this.UltimaStanzaAggiuntaEAggiorna(stanzaMagica);
		return this;
	}

	public LabirintoBuilder addStanzaBuia(String string, String string2) {
		Stanza stanzaBuia=new StanzaBuia(string,string2);
		this.UltimaStanzaAggiuntaEAggiorna(stanzaBuia);
		return this;
	}

	public LabirintoBuilder addAdiacenza(String stanzaCorrente, String stanzaAdiecente, String direzione) {
		Stanza a = stanze.get(stanzaCorrente);
		Stanza b = stanze.get(stanzaAdiecente);
		a.impostaStanzaAdiacente(direzione, b);
		return this;
	}

	

	
	
}

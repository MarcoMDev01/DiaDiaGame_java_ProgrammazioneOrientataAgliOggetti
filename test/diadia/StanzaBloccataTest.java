package diadia;

import static org.junit.jupiter.api.Assertions.*;



import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import it.uniroma3.diadia.Partita;
import it.uniroma3.diadia.ambienti.Stanza;
import it.uniroma3.diadia.ambienti.StanzaBloccata;
import it.uniroma3.diadia.attrezzi.Attrezzo;

class StanzaBloccataTest {
	private Partita partita;
	private Stanza vuota;
	private Stanza nonVuota;
	private Stanza senzaChiave;
	private Attrezzo osso;
	private Attrezzo Chiave;
	private Stanza conChiave;




	@BeforeEach
	public void setUp(){
		this.vuota =new Stanza("vuota");
		this.partita= new Partita();
		this.Chiave= new Attrezzo("chiave",1);
		this.senzaChiave= new StanzaBloccata("chiave", "chiusa", "sud");
		System.out.println("sto eseguendo il setup");
		this.nonVuota= new StanzaBloccata("osso", "bloccata", "nord");
		this.osso = new Attrezzo("osso", 1);
		this.nonVuota.addAttrezzo(osso);
		partita.setStanzaCorrente(vuota);
		vuota.impostaStanzaAdiacente("nord", nonVuota);
		vuota.impostaStanzaAdiacente("sud", senzaChiave);
		this.conChiave=new StanzaBloccata("chiave", "chiusa", "sud");
		this.conChiave.addAttrezzo(Chiave);
		
	}



	@Test
	final void testGetDescrizione() {
		//stanza aperta
		assertEquals(this.partita.getStanzaCorrente().getStanzaAdiacente("nord").getDescrizione(),nonVuota.getDescrizione());
		System.out.println(this.nonVuota.getDescrizione());
		//stanza chiusa
		assertEquals(this.partita.getStanzaCorrente().getStanzaAdiacente("sud").getDescrizione(), senzaChiave.getDescrizione());
		System.out.println(this.senzaChiave.getDescrizione());
		//apertura stanza
		
		this.partita.getStanzaCorrente().getStanzaAdiacente("sud").addAttrezzo(Chiave);
		assertEquals(this.partita.getStanzaCorrente().getStanzaAdiacente("sud").getDescrizione(), conChiave.getDescrizione());
		System.out.println(this.senzaChiave.getDescrizione());
		
	}

	
}

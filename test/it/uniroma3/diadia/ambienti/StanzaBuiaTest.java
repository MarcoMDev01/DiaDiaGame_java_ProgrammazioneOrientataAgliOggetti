package it.uniroma3.diadia.ambienti;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import it.uniroma3.diadia.attrezzi.Attrezzo;

class StanzaBuiaTest {
	private String buio="qui c'è un buio pesto";
	private StanzaBuia vuota;
	private StanzaBuia conLanterna;
	private Attrezzo Lanterna;
	@BeforeEach
	public void setUp(){		
		this.vuota =new StanzaBuia("vuota","Lanterna");
		this.conLanterna =new StanzaBuia("conlanterna","Lanterna");
		this.Lanterna = new Attrezzo("Lanterna", 1);
		System.out.println("sto eseguendo il setup");
		this.conLanterna.addAttrezzo(Lanterna);
		
	}
	@Test
	final void testGetDescrizione1() {
		assertEquals(conLanterna.getDescrizione(), conLanterna.getDescrizione());
	}
	@Test
	final void testGetDescrizione() {
		assertSame(vuota.getDescrizione(), buio);
	}
}

package diadia;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import it.uniroma3.diadia.Partita;
import it.uniroma3.diadia.ambienti.Stanza;

class PartitaTest {
	Partita prova= new Partita();
	

	@BeforeEach
	public void setUp() {
		Stanza vittoria=this.prova.getLabirinto().getStanzaVincente();
		prova.setStanzaCorrente(vittoria);

	}

	@Test
	final void testVinta() {
		assertTrue(this.prova.vinta());
	}

	@Test
	final void testIsFinita() {
		assertTrue(this.prova.isFinita());
	}

}

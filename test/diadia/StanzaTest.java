package diadia;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import it.uniroma3.diadia.ambienti.Stanza;
import it.uniroma3.diadia.attrezzi.Attrezzo;

class StanzaTest {
	private Stanza vuota;
	private Stanza nonVuota;
	private Attrezzo osso;

	@BeforeEach
	public void setUp(){
		this.vuota =new Stanza("vuota");

		System.out.println("sto eseguendo il setup");
		this.nonVuota= new Stanza("non-Vuota");
		this.osso = new Attrezzo("osso", 1);
		this.nonVuota.addAttrezzo(osso);
	}

	@Test
	final void testAddAttrezzo() {
		assertFalse(this.vuota.hasAttrezzo("osso"));//
		this.vuota.addAttrezzo(new Attrezzo("osso", 1));
		assertTrue(this.vuota.hasAttrezzo("osso"));
	}

	@Test
	final void testHasAttrezzo() {
		assertFalse(this.vuota.hasAttrezzo("osso"));
	}

	@Test
	final void testGetAttrezzo() {

		assertSame(this.osso,this.nonVuota.getAttrezzo("osso"));
	}

	@Test
	final void testRemoveAttrezzo() {
		assertTrue(this.nonVuota.removeAttrezzo(this.osso));
		assertFalse(this.vuota.removeAttrezzo(this.osso));
	}

}

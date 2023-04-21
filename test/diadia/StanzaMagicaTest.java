package diadia;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import it.uniroma3.diadia.ambienti.*;
import it.uniroma3.diadia.attrezzi.Attrezzo;

class StanzaMagicaTest {
	private Stanza nonVuota;
	private Attrezzo osso;
	private Attrezzo ossoInverso;

	@BeforeEach
	public void setUp(){

		System.out.println("sto eseguendo il setup");
		this.nonVuota= new StanzaMagica("non-Vuota",0);		
		this.osso = new Attrezzo("osso", 2);
		this.ossoInverso = new Attrezzo("osso", 4);
		
	
	}
	@Test
	final void testAddAttrezzo() {
		this.nonVuota.addAttrezzo(osso) ;
		assertEquals( this.ossoInverso.toString(),this.nonVuota.getAttrezzo("osso").toString());
	}

	

}

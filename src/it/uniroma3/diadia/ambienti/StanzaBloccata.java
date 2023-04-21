package it.uniroma3.diadia.ambienti;

public class StanzaBloccata extends Stanza{	
	private String direzioneBloccata;
	private String attrezzoSblocco;
	
	
	public  StanzaBloccata(String attrezzoSblocco,String nome,String direzioneBloccata) {
		super(nome); 
		this.attrezzoSblocco=attrezzoSblocco;
		this.direzioneBloccata = direzioneBloccata;
		
	}
	
	@Override
	public Stanza getStanzaAdiacente(String direzione) {
		if(direzioneBloccata.equals(direzione) && !this.hasAttrezzo(attrezzoSblocco)) {
			return this;
		}
		return super.getStanzaAdiacente(direzione);
	}
	
	@Override
	public String getDescrizione() {
		String bloccata = "Stanza bloccata nella direzione: "+ direzioneBloccata+"\nPrendi il " + attrezzoSblocco + " e posalo nella stanza";

		if(!this.hasAttrezzo(attrezzoSblocco))
			return bloccata;
		return super.getDescrizione();
	}
		
}
	
	
	


package it.uniroma3.diadia.ambienti;

public class StanzaBuia extends Stanza{
	private String oggettoDesiderato;
	private String output ="qui c'è un buio pesto";
	
	public StanzaBuia(String nome,String Oggettosblocco) {
		super(nome);
		this.oggettoDesiderato=Oggettosblocco;
		// TODO Auto-generated constructor stub
	}

	
	
	
	
	@Override
	public String getDescrizione() {
		if(!hasAttrezzo(oggettoDesiderato)) 	
		return output;
		
		return super.getDescrizione();
		
		
	}
}

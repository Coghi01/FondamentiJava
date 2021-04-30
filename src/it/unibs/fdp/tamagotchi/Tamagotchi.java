package it.unibs.fdp.tamagotchi;

public class Tamagotchi {
	
	private String name;
	
	private double gradoSoddisfazione = 50;
	private double gradoSazieta = 50;
	
	private static final int maxGradoSoddisfazione = 100;
	private static final int minGradoSoddisfazione = 0;
	private static final int bassoGradoSoddisfazione = 30;
	
	private static final double decrementoSoddisfazionePerOgniBiscotto = 0.25;
	
	private static final int maxGradoSazieta = 100;
	private static final int minGradoSazieta = 0;
	private static final int bassoGradoSazieta = 30;
	private static final int altoGradoSazieta = 90;
	
	private static final double percentualeIncrementoGradoSazieta = 0.1;
	private static final double decrementoSazietaPerOgniCarezza = 0.5;
	
	public static final int MIN_CAREZZE = 1;
	public static final int MAX_CAREZZE = Integer.MAX_VALUE;
	
	public static final int MIN_BISCOTTI = 1;
	public static final int MAX_BISCOTTI = Integer.MAX_VALUE;
	
	private int contatoreCarezze = 0;
	private int contatoreBiscotti = 0;
	
	public Tamagotchi(String name) {
		this.name = name;
		this.gradoSazieta = 50;
		this.gradoSoddisfazione = 50;
		this.contatoreCarezze = 0;
		this.contatoreBiscotti = 0;
	}
	
	public void riceveCarezze(int nCarezze) {
		contatoreCarezze += nCarezze;
		gradoSoddisfazione += nCarezze;
		
		gradoSazieta -= nCarezze * decrementoSazietaPerOgniCarezza;
	}
	
	public void riceveBiscotti(int nBiscotti) {
		contatoreBiscotti += nBiscotti;
		
		for (int i = 0; i < nBiscotti; i++) {
			gradoSazieta += gradoSazieta * percentualeIncrementoGradoSazieta;
		}
		
		gradoSoddisfazione -= nBiscotti * decrementoSoddisfazionePerOgniBiscotto;
	}
	
	public boolean isAlive( ) {
		if (gradoSoddisfazione <= maxGradoSoddisfazione &&
				gradoSoddisfazione >= minGradoSoddisfazione &&
				gradoSazieta <= maxGradoSazieta &&
				gradoSazieta >= minGradoSazieta)
			return true;
		else
			return false;
	}
	
	public boolean isHappy() {
		if (gradoSoddisfazione < bassoGradoSoddisfazione ||
				gradoSazieta < bassoGradoSazieta || 
				gradoSazieta > altoGradoSazieta)
			return false;
		else
			return true;
	}
	
	public String getName() {
		return name;
	}

	public String toString() {
		String s =  String.format(
				"%s:\n"
				+ " -> Grado di soddisfazione: %2.2f\n"
				+ " -> Grado di sazietà: %2.2f\n", name, gradoSoddisfazione, gradoSazieta);
		
		if(isHappy())
			s += "È felice\n";
		else {
			s += "È triste perché:\n";
			if(gradoSoddisfazione < bassoGradoSoddisfazione) {
				s += " -> riceve troppo poco affetto...\n";
			}
			if(gradoSazieta < bassoGradoSazieta) {
				s += " -> mangia troppo poco\n";
			}
			if(gradoSazieta > altoGradoSazieta) {
				s += " -> mangia troppo\n";
			}
		}
		
		if(isAlive())
			s += "È vivo/a";
		else {
			s += "È morto/a perché:\n";
			if(gradoSoddisfazione > maxGradoSoddisfazione) {
				s += " -> ha ricevuto troppo affetto\n";
			}
			if(gradoSoddisfazione < minGradoSoddisfazione) {
				s += " -> riceveva troppo poco affetto\n";
			}
			if(gradoSazieta > maxGradoSazieta) {
				s += " -> ha mangiato troppo\n";
			}
			if(gradoSazieta < minGradoSazieta) {
				s += " -> è rimasto/a a pancia vuota\n";
			}
		}
		
		return s;
	}

}

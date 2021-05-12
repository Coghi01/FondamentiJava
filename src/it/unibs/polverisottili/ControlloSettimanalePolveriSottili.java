package it.unibs.polverisottili;

import java.util.Arrays;

import it.unibs.fdp.mylib.CalcoliMatematici;

public class ControlloSettimanalePolveriSottili {
	
	private final int anno_solare;
	private final int n_settimana;
	private double[] valori_giornalieri = new double[N_GIORNI_ALLA_SETTIMANA];
	
	public static final int PRIMA_SETTIMANA = 1;
	public static final int ULTIMA_SETTIMANA = 53;
	
	public static final int N_GIORNI_ALLA_SETTIMANA = 7;
	
	private static final double VALORE_MASSIMO_ASSOLUTO_POLVERI_SOTTILI = 75;
	private static final double VALORE_MASSIMO_MEDIO_POLVERI_SOTTILI = 50;
	
	
	public ControlloSettimanalePolveriSottili(int anno_solare, int n_settimana) {
		super();
		this.anno_solare = anno_solare;
		this.n_settimana = n_settimana;
	}

	public int getAnno_solare() {
		return anno_solare;
	}

	public int getN_settimana() {
		return n_settimana;
	}

	public double[] getValori_giornalieri() {
		return valori_giornalieri;
	}
	
	
	public void setValori_giornalieri(double[] valori_giornalieri) {
		this.valori_giornalieri = valori_giornalieri;
	}

	public void inserimento_valore(int giorno, double valore_polvere_sottile) throws IllegalArgumentException {
		if (giorno < 0 || giorno > valori_giornalieri.length - 1)
			throw new IllegalArgumentException("Valori non permessi");
		valori_giornalieri[giorno] = valore_polvere_sottile;
	}
	
	public double get_valore_massimo_polveri_sottili() {
		return CalcoliMatematici.valore_massimo(valori_giornalieri);
	}
	
	public double get_valore_medio_polveri_sottili() {
		return CalcoliMatematici.valore_medio(valori_giornalieri);
	}
	
	public boolean siamoInAllarmeValoreAssoluto() {
		return get_valore_massimo_polveri_sottili() > VALORE_MASSIMO_ASSOLUTO_POLVERI_SOTTILI;
	}
	
	public String messaggio_valore_massimo() {
		if(siamoInAllarmeValoreAssoluto())
			return String.format("Il valore %2.2f supera la soglia (%2.2f)",
					get_valore_massimo_polveri_sottili(), VALORE_MASSIMO_ASSOLUTO_POLVERI_SOTTILI);
		else
			return "";
	}
	
	public boolean siamoInAllarmeValoreMedio() {
		return get_valore_medio_polveri_sottili() > VALORE_MASSIMO_MEDIO_POLVERI_SOTTILI;
	}
	
	public String messaggio_valore_medio() {
		if(siamoInAllarmeValoreMedio())
			return String.format("Il valore medio %2.2f supera la soglia (%2.2f)", get_valore_medio_polveri_sottili(), VALORE_MASSIMO_MEDIO_POLVERI_SOTTILI);
		else
			return "";
	}

	public String toString() {
		String descrizione = String.format("Anno %d\n", anno_solare);
		descrizione += String.format("Settimana %d\n", n_settimana);
		
		for (int i = 0; i < valori_giornalieri.length; i++) {
			descrizione += String.format("  Giorno %d -> %2.2f \n", i+1, valori_giornalieri[i]);
		}
		
		descrizione += String.format("\n  Valore medio: %2.2f\n\n", get_valore_medio_polveri_sottili());
		
		descrizione += messaggio_valore_massimo() + "\n";
		descrizione += messaggio_valore_medio();
		
		return descrizione;
	}
}

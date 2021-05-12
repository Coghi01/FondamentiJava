package it.unibs.polverisottili;

import java.util.ArrayList;
import java.util.List;

import it.unibs.fdp.mylib.Tastiera;


public class InterfacciamentoCLI {
	
	private List<ControlloSettimanalePolveriSottili> settimane = new ArrayList<ControlloSettimanalePolveriSottili>();
	
	private ControlloSettimanalePolveriSottili current;
	
	
	public int flussoCLI() {
		inserimento_valori();
		controllo_allarmi();
		while (true) {
			menu();
		}
	}
	
	private void menu() {
		System.out.println(""
				+ "N -> Inserisci nuovi dati\n"
				+ "V -> Visualizza lo storico\n"
				+ "E -> Esci dal programma...");
		char scelta = Tastiera.carattereDaTastiera("-> ");
		
		switch (scelta) {
		case 'N':
		case 'n': 
			inserimento_valori();
			controllo_allarmi();
			break;
		case 'V':
		case 'v': 
			visualizza_storico();
			break;
		case 'E':
		case 'e': 
			System.out.println("Arrivederci!");
			break;
		default:
			throw new IllegalArgumentException("Unexpected value: " + scelta);
		}
		System.out.println("\n====================\n");
	}
	
	private void inserimento_valori() {
		int anno_solare = Tastiera.intDaTastiera("° Inserire l'anno °");
		int n_settimana = Tastiera.intDaTastieraCompresoTra(ControlloSettimanalePolveriSottili.PRIMA_SETTIMANA, ControlloSettimanalePolveriSottili.ULTIMA_SETTIMANA, "° Inserisci il numero della settimana °");
		double[] valori = new double[ControlloSettimanalePolveriSottili.N_GIORNI_ALLA_SETTIMANA];
		for (int i = 0; i < valori.length; i++) {
			valori[i] = Tastiera.doubleDaTastiera(String.format("° Qual è il valore di polveri sottili del giorno %d °", i+1));		
		}
		current = new ControlloSettimanalePolveriSottili(anno_solare, n_settimana);
		current.setValori_giornalieri(valori);
		settimane.add(current);
	}
	
	public void controllo_allarmi() {
		if(current.siamoInAllarmeValoreAssoluto() || current.siamoInAllarmeValoreMedio()) {			
		String messaggi_allarme = "Attenzione, pericolo polveri sottili in eccesso!!!\n";
			messaggi_allarme += current.messaggio_valore_massimo() + "\n";
			messaggi_allarme += current.messaggio_valore_medio();
			System.out.println(messaggi_allarme);
		}
	}
	
	public void visualizza_storico() {
		settimane.forEach(settimana -> {
			System.out.println(settimana);
			System.out.println("\n------------------\n");
		});
	}
}


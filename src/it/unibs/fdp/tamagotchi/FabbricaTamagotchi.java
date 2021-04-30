package it.unibs.fdp.tamagotchi;

import it.unibs.fdp.mylib.Tastiera;

public class FabbricaTamagotchi {

	public static Tamagotchi creaTamagotchiDaTastiera() {
		String name = Tastiera.stringaDaTastiera("Inserire un nome per il Tamagotchi:\n-> ");
		return new Tamagotchi(name);
	}
	
	public static void dareBiscottiDaTastiera(Tamagotchi t) {
		int nBiscotti = Tastiera.intDaTastieraCompresoTra(Tamagotchi.MIN_BISCOTTI, Tamagotchi.MAX_BISCOTTI, 
				String.format("Quanti biscotti vuoi dare a %s?\n-> ", t.getName()));
		t.riceveBiscotti(nBiscotti);
	}
	
	public static void dareCarezzeDaTastiera(Tamagotchi t) {
		int nCarezze = Tastiera.intDaTastieraCompresoTra(Tamagotchi.MIN_CAREZZE, Tamagotchi.MAX_BISCOTTI, 
				String.format("Quante carezze vuoi dare a %s?\n-> ", t.getName()));
		t.riceveCarezze(nCarezze);
	}
	
}

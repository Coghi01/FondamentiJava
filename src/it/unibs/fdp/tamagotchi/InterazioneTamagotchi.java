package it.unibs.fdp.tamagotchi;

import it.unibs.fdp.mylib.Tastiera;

public class InterazioneTamagotchi {
	
	private Tamagotchi t;
	
	private boolean interazioneCLIrealizzata = false;
	private boolean interazioneGUIrealizzata = false;
	
	private InterazioneTamagotchi(String modalita) throws Exception {
		if(modalita == "CLI") {
			System.out.println("Benvenuto/a nel mondo dei tamagotchi");
			System.out.println("Innanzitutto, che nome vuoi dare al tuo primo tamagotchi?");
			this.t = new Tamagotchi(Tastiera.stringaDaTastiera(
					"Inserire un nome per il Tamagotchi:\n-> "));
			interazioneCLIrealizzata = true;
		}
		else if(modalita == "GUI") {
			throw new Exception("Gui non ancora implementata");
//			interazioneGUIrealizzata = true;
		}
		else
			throw new Exception(String.format("La modalità %s non è valida", modalita));
	}
	
	public static InterazioneTamagotchi generaInterazioneCLI() {
		try {
			return new InterazioneTamagotchi("CLI");
		} catch (Exception e) {
			System.err.println(e.getMessage());
		}
		return null;
	}
	
	private final void dareBiscottiCLI() {
		int nBiscotti = Tastiera.intDaTastieraCompresoTra(Tamagotchi.MIN_BISCOTTI, Tamagotchi.MAX_BISCOTTI, 
				String.format("Quanti biscotti vuoi dare a %s?\n-> ", t.getName()));
		t.riceveBiscotti(nBiscotti);
	}
	
	private final void dareCarezzeCLI() {
		int nCarezze = Tastiera.intDaTastieraCompresoTra(Tamagotchi.MIN_CAREZZE, Tamagotchi.MAX_BISCOTTI, 
				String.format("Quante carezze vuoi dare a %s?\n-> ", t.getName()));
		t.riceveCarezze(nCarezze);
	}
	
	public final boolean interazioneCLI() {
		System.out.println(String.format("Cosa vuoi fare con %s?", t.getName()));
		System.out.println("A -> voglio accarezzarlo/a\n"
				+          "B -> voglio dargli/darle un biscotto\n"
				+          "R -> voglio vedere il suo resoconto\n"
				+          "N -> non voglio farci nulla");
		char scelta = Tastiera.carattereDaTastiera("-> ");
		switch (scelta) {
		case 'a':
		case 'A':
			dareCarezzeCLI();
			return true;
		case 'b':
		case 'B':
			dareBiscottiCLI();
			return true;
		case 'r':
		case 'R':
			System.out.println(t);
			return true;
		case 'n':
		case 'N':
			System.out.println(String.format("%s sentirà la tua mancanza", t.getName()));
			return false;
		default:
			System.err.println("Scelta non valida");
			return true;

//			if(!t.isAlive()) {
//				System.out.println(String.format("R.I.P. %s", t.getName()));
//			}
//			System.out.println("--------------------------\n");
		}
	}

}

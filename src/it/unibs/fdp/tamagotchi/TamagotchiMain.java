package it.unibs.fdp.tamagotchi;

import it.unibs.fdp.mylib.Tastiera;

public class TamagotchiMain {

	public static void main(String[] args) {
		System.out.println("Benvenuto/a nel mondo dei tamagotchi");
		System.out.println("Innanzitutto, che nome vuoi dare al tuo primo tamagotchi?");
		Tamagotchi t = FabbricaTamagotchi.creaTamagotchiDaTastiera();
		while(true) {
			System.out.println(String.format("Vuoi accarezzare o sfamare %s?", t.getName()));
			System.out.println("A -> accarezza\n"
					+          "B -> dai biscotti\n"
					+          "E -> esci dal programma");
			char scelta = Tastiera.carattereDaTastiera("-> ");
			switch (scelta) {
			case 'a':
			case 'A':
				FabbricaTamagotchi.dareCarezzeDaTastiera(t);
				break;
			case 'b':
			case 'B':
				FabbricaTamagotchi.dareBiscottiDaTastiera(t);
				break;
			case 'e':
			case 'E':
				System.out.println(String.format("%s sentirà la tua mancanza", t.getName()));
				System.exit(0);
			default:
				System.err.println("Scelta non valida");
			}
			System.out.println("\n" + t);
			System.out.println("--------------------------\n");
			
			if(!t.isAlive()) {
				System.out.println(String.format("R.I.P. %s", t.getName()));
				System.exit(0);
			}
		}
	}

}

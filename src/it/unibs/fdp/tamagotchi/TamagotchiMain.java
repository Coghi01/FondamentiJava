package it.unibs.fdp.tamagotchi;

public class TamagotchiMain {

	public static void main(String[] args) {
//		new Thread(() -> launchCLI()).start();
		launchCLI();
	}
	
	private static void launchCLI() {
		InterazioneTamagotchi it = InterazioneTamagotchi.generaInterazioneCLI();
		flussoEsecuzioneCLI(it);
	}

	private static void flussoEsecuzioneCLI(InterazioneTamagotchi it) {
		while(it.interazioneCLI());
	}
}

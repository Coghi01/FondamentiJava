package it.unibs.fdp.mylib;

import java.util.Arrays;


public class CalcoliMatematici {
	
	public static double valore_massimo(double[] valori) {
		return Arrays.stream(valori).max().getAsDouble();
	}
	
	public static double valore_minimo(double[] valori) {
		return Arrays.stream(valori).min().getAsDouble();
	}
	
	public static double valore_medio(double[] valori) {
		return Arrays.stream(valori).average().getAsDouble();
	}
	
	
}

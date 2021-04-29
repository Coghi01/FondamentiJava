package it.unibs.fdp.mylib;

import java.util.Scanner;

public class Tastiera {
     public static double doubletastiera (String message) {
    	 System.out.println(message);
    	 Scanner sc= new Scanner(System.in);
    	 return sc.nextDouble();
     }
}

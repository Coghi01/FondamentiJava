package it.unibs.fdp.mylib;

import java.util.Scanner;

public class Tastiera {
	
     public static double doubleDaTastiera (String message) {
    	 while(true) {
    		 try {
		    	 System.out.println(message);
		    	 Scanner sc = new Scanner(System.in);
		    	 double insertion = sc.nextDouble();
		//    	 sc.close();
		    	 return insertion;
    		 } catch (Exception e) {
    			 System.err.println("Sei sicuro/a di aver inserito un numero?");
    		 }
    	 }
     }
     
     //TODO: public static double doubleDaTastieraCompresoTra(double min, double max, String message) {}
     
     public static int intDaTastiera (String message) {
    	 while(true ) {
    		 try {
		    	 System.out.println(message);
		    	 Scanner sc = new Scanner(System.in);
		    	 int insertion = sc.nextInt();
		//    	 sc.close();
		    	 return insertion;
    		 } catch (Exception e) {
    			 System.err.println("Sei sicuro/a di aver inserito un numero intero?");
    		 }
    	 }
     }
     
     public static int intDaTastieraCompresoTra(int min, int max, String message) {
    	 if(min > max) {
    		 int tmp = min;
    		 min = max;
    		 max = tmp;
    	 }
    	 
    	 while(true) {
    		 int n = intDaTastiera(message);
    		 if(n >= min && n <= max) 
    			 return n;
    		 System.err.println(String.format("Hai inserito %d, e non è compreso tra %d e %d", n, min, max));
    	 }
     }
     
     public static String stringaDaTastiera (String message) {
    	 while(true) {
    		 try {
		    	 System.out.println(message);
		    	 Scanner sc = new Scanner(System.in);
		    	 String insertion = sc.next();
		//    	 sc.close();
		    	 return insertion;
    		 } catch (Exception e) {
    			 System.err.println("Sei sicuro/a di aver inserito una stringa valida?");
    		 }
    	 }
     }
     
     public static char carattereDaTastiera (String message) {
    	 while(true) {
    		 try {
		    	 System.out.println(message);
		    	 Scanner sc = new Scanner(System.in);
		    	 char insertion = sc.next().charAt(0);
		//    	 sc.close();
		    	 return insertion;
    		 } catch (Exception e) {
    			 System.err.println("Sei sicuro/a di aver inserito una lettera?");
    		 }
    	 }
     }
     
     //TODO: numeri casuali compresi tra min e max
}

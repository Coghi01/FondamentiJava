package it.unibs.fdp.mylib;

import java.util.Scanner;

public class Tastiera {
	
     public static double doubleDaTastiera (String message) {
    	 System.out.println(message);
    	 Scanner sc = new Scanner(System.in);
    	 double insertion = sc.nextDouble();
//    	 sc.close();
    	 return insertion;
     }
     
     //TODO: public static double doubleDaTastieraCompresoTra(double min, double max, String message) {}
     
     public static int intDaTastiera (String message) {
    	 System.out.println(message);
    	 Scanner sc = new Scanner(System.in);
    	 int insertion = sc.nextInt();
//    	 sc.close();
    	 return insertion;
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
    		 System.err.println("Scelta non valida");
    	 }
     }
     
     public static String stringaDaTastiera (String message) {
    	 System.out.println(message);
    	 Scanner sc = new Scanner(System.in);
    	 String insertion = sc.next();
//    	 sc.close();
    	 return insertion;
     }
     
     public static char carattereDaTastiera (String message) {
    	 System.out.println(message);
    	 Scanner sc = new Scanner(System.in);
    	 char insertion = sc.next().charAt(0);
//    	 sc.close();
    	 return insertion;
     }
     
     //TODO: numeri casuali compresi tra min e max
}

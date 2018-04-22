package calc;

// @ Copyright 
// Ingeniero Juan Jos� Puello Fuentes.
import javax.swing.*;
public class Leer {
       public static String cadena(String mensaje){
       		  boolean error; 
		      String s = null;
		      do{
				  error = false; 
		      	     s = JOptionPane.showInputDialog(null,mensaje+':',"Entrada de datos",JOptionPane.QUESTION_MESSAGE);
				     System.out.println("\n"+mensaje+':'+s);
				     if(s == null || s.length()< 1){
				     	error = true;
				     	System.out.println("\nError, No ha digitado datos..!");
				     }		
		      }while(error);    
		      return s;      	
       }
       public static char caracter(String mensaje){ 
       	      boolean error; 
		      String s = null;
		      char c = ' ';
		      do{
				  error = false; 
	      	      s = JOptionPane.showInputDialog(mensaje+':');
				  System.out.println("\n"+mensaje+':'+s);
				  if(s == null || s.length()!=1){
				   	error = true;
				   	System.out.println("\nError, No es un caracter..!");
				  }else	
				    c = s.charAt(0);
		      }while(error);    
		      return c;      	
       }
       public static double real(String mensaje){
       	      boolean error;
       	      String s = null;
       	      double r = 0.0;
       	      do{
				  error = false; 
	       	      try{
	       	      	s = JOptionPane.showInputDialog(mensaje+':');
					System.out.println("\n"+mensaje+':'+s);
					r = Double.parseDouble(s);
	       	      }catch(Exception e){
	       	      	error = true;
	       	      	System.out.println("\nError, no es un numero valido..!");
	       	      }
       	      }while(error);    
       	      return r;
       }
	   public static int entero(String mensaje){
			  boolean error;
			  String s = null;
			  int i = 0;
			  do{
				  error = false; 
				  try{
				  	s = JOptionPane.showInputDialog(mensaje+':');
					System.out.println("\n"+mensaje+':'+s);
					i = Integer.parseInt(s);
				  }catch(Exception e){
					error = true;
					System.out.println("\nError, no es un numero entero..!");
				  }
			  }while(error);    
			  return i;
	   }
}

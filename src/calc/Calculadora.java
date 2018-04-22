package calc;

public class Calculadora{
	  public static void main(String arg[]){
			String expInfija = Leer.cadena("Digite exprsion aritmetica a calcular");
			String expPosfija = infijaApostfija(expInfija);
			System.out.println("El resultado es : "+calcular(expPosfija));
	  }

      public static String infijaApostfija(String exp){
        char c;
   	    int i,prioridadCima=0,prioridadOper;
   	    String expPos = null;
	    Pila <Character> med = new Pila();
		Pila <Character> pos = new Pila();
       	if(exp != null){
           expPos = new String();
		   for(i=0;i<exp.length();i++){
			     c = exp.charAt(i);
			     if(c == '('){
					med.poner(c);
			     }else if(c == ')'){
					while(med.cima() != '(')
						  pos.poner(med.quitar());
					med.quitar();
				 }else if(operador(c)){
 					      prioridadCima = prioridad(med.cima());
					  	  prioridadOper = prioridad(c);
						  while(!med.vacia() && (prioridadOper <= prioridadCima)){
								pos.poner(med.quitar());
								prioridadCima = prioridad(med.cima());
						  }
						  med.poner(c);
				 }else
				    pos.poner(c);
		   }
	       while(!pos.vacia())
			     med.poner(pos.quitar());
			    
		   while(!med.vacia())
			     expPos += med.quitar();

		}
   	    return expPos;
      }
      public static boolean operando(char c){
      	   return Character.isLetterOrDigit(c);

      }
      public static boolean operador(char c){
      	   char operadores[] = {'+','-','*','/','^'};
      	   boolean op = false;
      	   for(int i=0;(i<5) && (!op);i++)
      	       if(operadores[i] == c)
      	          op = true;
      	   return op;
      }
      private static int prioridad(Character op){
  		   int r = 4;
		   if (op != null)
			   switch(op){
					case ')' : r = 0;
					case '(' : r = 0; break;
					case '+' : r = 1;
					case '-' : r = 1; break;
					case '*' : r = 2;
					case '/' : r = 2; break;
					case '^' : r = 3;
			   }
		   return r;
      }
      
      public static double calcular(String expPosfija){
      	double resultado = 0.0;
      	//Colocar aqu� las instrucciones
      	return resultado;
      }
}
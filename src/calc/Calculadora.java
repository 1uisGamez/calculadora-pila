package calc;

public class Calculadora{
	  public static void main(String arg[]){
			String expInfija = Leer.cadena("Digite expresion aritmetica a calcular");
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
      
      //NUEVO
      private static boolean esOperador(char letra){
          if(letra == '*' || letra == '/' || letra == '+' || letra == '-' ||
                  letra == '(' || letra == ')' || letra == '^'){
              return true;
          }
              return false;
      }
      
      private static int prioridadExpresion(char operador){
          if (operador == '^') return 4;
          if (operador == '*' || operador == '/') return 2;
          if (operador == '+' || operador == '-') return 1;
          if (operador == '(') return 5;
          return 0;
      }
      
      private static int prioridadPila(char operador){
          if (operador == '^') return 3;
          if (operador == '*' || operador == '/') return 2;
          if (operador == '+' || operador == '-') return 1;
          if (operador == '(') return 0;
          return 0;
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
      	//double resultado = 0.0;
        Pila pila = new Pila();
          for (int i = 0; i < expPosfija.length(); i++) {
              char letra = expPosfija.charAt(i);
              if(!operador(letra)){
                  
                  double num = new Double(letra + "");
                  pila.poner(num);
              }else{
                  double num2 = (double)pila.quitar();
                  double num1 = (double)pila.quitar();
                  double num3 = operacion(letra , num1, num2);
                  pila.poner(num3);
              }
          }
      	//Colocar aqu� las instrucciones
        String Posfija = conva(expPosfija);
          System.out.println(expPosfija);  
      	return (double)pila.cima();
      }
      private static String conva(String expPofija){
          String posfijaa = "";
                  Pila pila = new Pila();
                  for(int i = 0; i<expPofija.length();i++){
                      char letra = expPofija.charAt(i);
                      if(operador(expPofija.charAt(i))){
                          if(pila.vacia()){
                              pila.poner(letra);
                          }else{
                              int pe = prioridadExpresion(letra);
                              int pp = prioridadPila((char)pila.cima());
                              if(pe > pp){
                                  pila.poner(letra);
                              }else{
                                  posfijaa += pila.quitar();
                                  pila.poner(letra);
                              }
                          }
                          
                      }else{
                          posfijaa += letra;
                      }
                  }
                  
                  while(!pila.vacia()){
                      posfijaa += pila.quitar();
                  }
             return posfijaa;     
      }

    private static double operacion(char letra, double num1, double num2) {
        if(letra == '*') return num1 * num2;
        if(letra == '/') return num1 / num2;
        if(letra == '+') return num1 + num2;
        if(letra == '-') return num1 - num2;
        if(letra == '^') return Math.pow(num2, num1);
            
        return 0;
    }
      
      
}
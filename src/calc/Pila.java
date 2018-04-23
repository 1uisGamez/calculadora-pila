package calc;

public class Pila <T>{
    private T v[];
    private int tope, max;
    public Pila(){
        max = 100;
        v = (T[]) new Object[max];
        tope = -1;
    }
    public Pila(int max){
        this.max = max;
        v = (T[]) new Object[max];
        tope = -1;
    }
    public boolean vacia(){
        return tope == -1;
    }
    public boolean llena(){
        return tope == max-1;
    }
    public void poner(T dato){
        if(!llena())
           v[++tope] = dato;
        else
           System.out.println("Pila Llena...!");
    }
    public T quitar(){
        T dato = null;
        if(!vacia())
           dato = v[tope--];
        else
           System.out.println("Pila Vacia...!");
        return dato;
    }
    public T cima(){
    	if(!vacia())
    	   return v[tope];
    	else
    	   return null;   
    }	
    
    public T elementoTope(){
        return v[tope -1];
    }
}

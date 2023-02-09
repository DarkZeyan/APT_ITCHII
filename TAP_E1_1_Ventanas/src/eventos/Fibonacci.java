package eventos;

public class Fibonacci {
    public Fibonacci(byte numeroTerminos) {
        setNumeroTerminos(numeroTerminos);
    }

    byte numeroTerminos;
    public byte getNumeroTerminos() {
        return numeroTerminos;
    }
    public void setNumeroTerminos(byte numeroTerminos) {
        this.numeroTerminos = numeroTerminos;
    }
    private static long calculateFibonacci(long n){
        if(n==0) 
            return 0;
        if(n==1)
            return 1;
        else
            return calculateFibonacci(n-1)+calculateFibonacci(n-2);
    }

    public String getFibonacciString(){
        String fiboString="";
        for(byte i=0; i<numeroTerminos; i++){
            fiboString+=(calculateFibonacci(i))+" ";
            if(i>0 && i%5==0) fiboString+="\n";
        }
        return fiboString;
    }
    

   
}

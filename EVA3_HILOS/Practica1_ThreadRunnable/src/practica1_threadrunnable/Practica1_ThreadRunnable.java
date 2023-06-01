package practica1_threadrunnable;
/**
 *
 * @author Jorge Eduardo Escobar Bugarini - ISC - 21550317
 */
public class Practica1_ThreadRunnable {
    public static void main(String[] args) {
        new NewThread();

        try{
            for(int i=5; i>0; i--){
                System.out.println("Hilo principal: "+i);
                Thread.sleep(1100); // Suspender el hilo principal por 1.1s
            }
        }catch(InterruptedException e){
            System.out.println("Hilo principal interrumpido");
        }
        System.out.println("Saliendo del hilo principal");
    }
    
}

class NewThread implements Runnable{
    Thread t;


    public NewThread(){
        t = new Thread(this,"Hilo de demostracion");
        System.out.println("Hilo hijo: "+t);
        t.start(); // Iniciar el hilo.
    }

    //Este es el punto de entrada para el segundo hilo.

    public void run() {
        try {
            for(int i=5; i>0; i--){
                System.out.println("Hilo hijo: "+i);
                Thread.sleep(500);// Dormir el hilo por 500 ms. 
            }
        } catch (InterruptedException e) {
            System.out.println("Hilo hijo interrumpido");
            
        }
        System.out.println("Saliendo del hilo hijo");
    }
}
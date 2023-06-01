package practica1_currentthread;
/**
 *
 * @author Jorge Eduardo Escobar Bugarini - ISC - 21550317
 */
public class Practica1_CurrentThread {

    public static void main(String[] args) {
          
        Thread hilo = Thread.currentThread();
        
        System.out.println("Hilo actual: "+hilo);
        
        // Renombrar hilo

        hilo.setName("Mi hilo");
        System.out.println("Hilo actual: "+hilo);

        try {
            for (int i = 5; i >= 0; i--) {
                System.out.println(i);
                Thread.sleep(1000); //Dormir el hilo por 1 segundo;

            }
        } catch (InterruptedException e) {
                System.out.println("Hilo principal interrumpido");
        }
    }
    
}

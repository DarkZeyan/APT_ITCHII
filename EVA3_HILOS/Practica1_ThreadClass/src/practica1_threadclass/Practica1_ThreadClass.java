 package practica1_threadclass;

/**
 *
 * @author Jorge Eduardo Escobar Bugarini - ISC - 21550317
 */
 
 class NewThread extends Thread{
     //Constructor para la clase.
      public NewThread(){
          super("Hilo nuevo");
          System.out.println("Hilo hijo: "+this);
          start(); //Iniciar el hilo.
      }
      public void run(){
          
        try {
            for(int i=5; i>0; i--){
                System.out.println("Hilo hijo: "+ i);
                Thread.sleep(500*i); //Dormir el hilo por 500ms multiplicado por i.
            }
        } catch (InterruptedException e) {
                System.out.println("Hilo hijo interrumpido");
        }
          System.out.println("Saliendo del hilo hijo");
      }
     
 }
 
public class Practica1_ThreadClass {
   public static void main(String[] args) {
        NewThread hijo = new NewThread();
        try {
            for(int i=5; i>0; i--){
                System.out.println("Hilo principal: "+i);
                Thread.sleep(1000); //Dormir el hilo principal por 1 seg.
            }
        } catch (InterruptedException e) {
            System.out.println("Hilo principal interrumpido");
        }
        System.out.println("Abandonando el hilo principal.");
    }
    
}

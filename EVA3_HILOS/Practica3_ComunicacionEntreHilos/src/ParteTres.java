class NewThread implements Runnable{
    
    String name;
    Thread t;
    boolean suspendedFlag;


    NewThread(String threadName){
        name = threadName;
        t = new Thread(this,name);
        System.out.println("Nuevo hilo: "+t);
        suspendedFlag=false;
        t.start();
    }


    public void run(){
        try{
            for(int i=15; i>0; i--){
                System.out.println(name+":"+i);
                Thread.sleep(200);
                synchronized(this){
                    while(suspendedFlag){
                        wait();
                    }
                }
            }
        }catch(InterruptedException e){
            System.out.println(name+" interrumpido");
        }
    }
    synchronized void suspender(){
        suspendedFlag = true;
    }
    synchronized void reactivar(){
        suspendedFlag = false;
        notify();
    }
}


public class ParteTres {
    public static void main(String[] args) {
        NewThread hilo1 = new NewThread("Uno");
        NewThread hilo2 = new NewThread("Dos");

        try {
            Thread.sleep(1000);
            hilo1.suspender();
            System.out.println("Suspendiendo hilo Uno");
            Thread.sleep(1000);
            hilo1.reactivar();
            System.out.println("Reactivando hilo Uno");
            hilo2.suspender();
            System.out.println("Suspendiendo hilo Dos");
            Thread.sleep(1000);
            hilo2.reactivar();
            System.out.println("Reactivando hilo Dos");
        } catch (InterruptedException e) {
            System.out.println("Hilo principal interrumpido");
        }
    }
}

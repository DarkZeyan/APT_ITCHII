// ISC - 21550317 - Jorge Eduardo Escobar Bugarini.


public class ParteDos {
    public static void main(String[] args) {
        CallMe target = new CallMe();
        Caller call1 = new Caller(target,"Hello");
        Caller call2 = new Caller(target,"Synchronized");
        Caller call3 = new Caller(target,"World");
        // Esperar a que los hilos finalicen.

        try{
            call1.t.join();
            call2.t.join();
            call3.t.join();
        }catch(InterruptedException e){
            System.out.println("Interrumpido");
        }
    }
}

class CallMe{
    void call(String msg){
        System.out.print("["+msg);
        try{
            Thread.sleep(1000);
        }catch(InterruptedException ex){
            ex.printStackTrace();
        }
        System.out.println("]");
    }
}
class Caller implements Runnable{
    String msg;
    CallMe target;
    Thread t;

    public Caller(CallMe target, String msg){
        this.target=target;
        this.msg=msg;
        t = new Thread(this);
        t.start();

    }
    public void run(){
        // Utilizando synchronized
        synchronized(target){
            target.call(msg);
        }

    }
}
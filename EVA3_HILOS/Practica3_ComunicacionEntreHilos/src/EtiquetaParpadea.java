import javax.swing.JLabel;

public class EtiquetaParpadea implements Runnable{
    private JLabel etiqueta;
    private boolean suspendedFlag;

    @Override
    public void run() {
        while(true){
            if(etiqueta.isVisible())
                etiqueta.setVisible(false);
            else
                etiqueta.setVisible(true);
            try{
                Thread.sleep(300);

            }catch(InterruptedException e){
                e.printStackTrace();
            }
            synchronized(this){
                while(suspendedFlag){
                    try{
                        wait();
                    }catch(InterruptedException e){
                        e.printStackTrace();
                    }
                }
            }
        }
    }
    
    public EtiquetaParpadea(JLabel aux){
        etiqueta = aux;
        suspendedFlag = false;
    }

    //Crear metodos que controlan la bandera.
    synchronized void mySuspend(){
        suspendedFlag=true;
    }
    synchronized void myResume(){
        suspendedFlag = false;
        notify();
    }
}

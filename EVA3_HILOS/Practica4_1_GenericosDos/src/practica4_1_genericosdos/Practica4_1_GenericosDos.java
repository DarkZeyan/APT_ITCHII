/*
 * 
 * 
 */
package practica4_1_genericosdos;

/**
 *
 * @author Jorge Eduardo Escobar Bugarini - ISC - 21550317
 */
public class Practica4_1_GenericosDos {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        TwoGen<Integer,String> tgObj = new TwoGen<Integer,String>(88,"Generics");
        tgObj.showTypes();
        int v = tgObj.getObj1();
        System.out.println("Valor del primero: "+v);
        String str = tgObj.getObj2();
        System.out.println("Valor del segundo: "+str);
    }
    
}

class TwoGen<T,V>{
    T obj1;
    V obj2;
    
    TwoGen(T o1, V o2){
        obj1 = o1;
        obj2 = o2;
    }

    public T getObj1() {
        return obj1;
    }

    public void setObj1(T obj1) {
        this.obj1 = obj1;
    }

    public V getObj2() {
        return obj2;
    }

    public void setObj2(V obj2) {
        this.obj2 = obj2;
    }
    
     void showTypes(){
         System.out.println("Tipo de T: "+obj1.getClass().getName());
         System.out.println("Tipo de V: "+obj2.getClass().getName());
     }
}

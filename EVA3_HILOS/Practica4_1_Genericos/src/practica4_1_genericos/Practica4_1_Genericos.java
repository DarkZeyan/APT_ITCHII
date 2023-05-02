/*
 * 
 * 
 */
package practica4_1_genericos;

/**
 *
 * @author Jorge Eduardo Escobar Bugarini - ISC - 21550317
 */
public class Practica4_1_Genericos {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Gen<Integer> iObj;
        iObj = new Gen<Integer>(88);
        
        iObj.showType();
        
        int v = iObj.getObj();
        System.out.println("Valor: "+v+"\n");
        Gen<String> strObj = new Gen<String>("Prueba de Genericos");
        strObj.showType();
        String str = strObj.getObj();
        System.out.println("Valor: "+str);
    }
    
}


class Gen<T>{
    T obj;
    Gen(T o){
        obj = o;
    }
    T getObj(){
        return obj;
    }
    void showType(){
        System.out.println("El tipo de T es: "+obj.getClass().getName());
    }
}
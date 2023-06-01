/*
 * 
 * 
 */
package practica4_2_linkedlist;

import java.util.LinkedList;

/**
 *
 * @author Jorge Eduardo Escobar Bugarini - ISC - 21550317
 */
public class Practica4_2_LinkedList {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        LinkedList<String> ll = new LinkedList<String>();
        
        ll.add("F");
        ll.add("B");
        ll.add("D");
        ll.add("E");
        ll.add("C");
        ll.addLast("Z");
        ll.addFirst("A");
        ll.add(1,"A2");
        System.out.println("Contenido original de la lista: "+ll);
        
        ll.remove("F");
        ll.remove(2);
        System.out.println("Contenido despues del borrado: "+ll);
        
        
        ll.removeFirst();
        ll.removeLast();
        System.out.println("Contenido despues del borrado del primero y ultimo: "+ll);
        
        String value =  ll.get(2);
        ll.set(2,value+"Cambiado");
        System.out.println("Contenido despues de los cambios"+ll);
    }
    
}

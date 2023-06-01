/*
 * 
 * 
 */
package practica4_2_arraylist;

/**
 *
 * @author Jorge Eduardo Escobar Bugarini - ISC - 21550317
 */

import java.util.ArrayList;
public class Practica4_2_ArrayList {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        ArrayList<String> al = new ArrayList<String>();
        
        System.out.println("Tamaño inicial de la lista: "+al.size());
        
        
        al.add("C");
        al.add("A");
        al.add("E");
        al.add("B");
        al.add("D");
        al.add("F");
        al.add(1,"A2");
        System.out.println("El tamaño de la lsita despues de agregar elementos: "+al.size());
        System.out.println("El contenido de la lista es: "+al);
        al.remove("F");
        al.remove(2);
        System.out.println("Tamaño de la lista despues de eliminar elementos: "+al.size());
        System.out.println("El contenido de la lista es: "+al);
    }
    
}

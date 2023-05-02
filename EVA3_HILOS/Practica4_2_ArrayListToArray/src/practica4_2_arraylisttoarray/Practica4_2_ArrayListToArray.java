/*
 * 
 * 
 */
package practica4_2_arraylisttoarray;

import java.util.ArrayList;

/**
 *
 * @author Jorge Eduardo Escobar Bugarini - ISC - 21550317
 */
public class Practica4_2_ArrayListToArray {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        ArrayList<Integer> al = new ArrayList<Integer>();
        al.add(1);
        al.add(2);
        al.add(3);
        al.add(4);
        
        System.out.println("Contenido de la lista: "+al);
        Integer ia[] = new Integer[al.size()];
        ia = al.toArray(ia);
        int suma=0;
        for(int i:ia) suma+=i;
        System.out.println("La suma es: "+suma);
        
    }
    
}

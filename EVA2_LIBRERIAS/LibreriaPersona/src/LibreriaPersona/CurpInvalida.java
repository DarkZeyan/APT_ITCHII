/*
JORGE EDUARDO ESCOBAR BUGARINI - ISC - 21550317
 */
package LibreriaPersona;

/**
 *
 * @author user
 */

public class CurpInvalida extends Exception {
   
    public CurpInvalida(String msg){
        super(msg);
    }
    
    public CurpInvalida() {
        super("La CURP insertada no es valida para esta persona");
    }
}

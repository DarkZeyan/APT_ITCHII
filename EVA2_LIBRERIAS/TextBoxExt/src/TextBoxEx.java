
import java.awt.Color;


/**
 *
 * @author JORGE EDUARDO ESCOBAR BUGARINI ISC - 21550317
 */
public class TextBoxEx  extends javax.swing.JTextField{

    public TextBoxEx() {
        super();
        
        java.awt.event.FocusAdapter fa = new java.awt.event.FocusAdapter() {
            @Override
            public void focusGained(java.awt.event.FocusEvent evt){
                jtfTextBoxExFocusGained(evt);
            }
            @Override
            public void focusLost(java.awt.event.FocusEvent evt){
                jtfTextBoxExFocusLost(evt);
            }
        };
        addFocusListener(fa);
    }
    
    private Boolean CambiarColor = false;

    
    public Boolean isCambiarColor() {
        return CambiarColor;
    }

    public void setCambiarColor(Boolean CambiarColor) {
        this.CambiarColor = CambiarColor;
    }
    private java.awt.Color colorOriginal = Color.white;
    private void  jtfTextBoxExFocusGained(java.awt.event.FocusEvent evt){
        if(isCambiarColor()){
            colorOriginal = getBackground();
            setBackground(Color.blue);
        }
        else
            setBackground(colorOriginal);
    } 
    private void  jtfTextBoxExFocusLost(java.awt.event.FocusEvent evt){
        setBackground(colorOriginal);
    }
}

package eventos;
public class FormulaGeneral{
    
    byte cTC;
    byte cTL;
    byte cTI;

    public FormulaGeneral(byte cTC, byte cTL, byte cTI){
        setCTC(cTC);
        setCTL(cTL);
        setCTI(cTI);
    }

    public byte getCTC() {
        return cTC;
    }

    public void setCTC(byte cTC) {
        this.cTC = cTC;
    }

    public byte getCTL() {
        return cTL;
    }

    public void setCTL(byte cTL) {
        this.cTL = cTL;
    }

    public byte getCTI() {
        return cTI;
    }

    public void setCTI(byte cTI) {
        this.cTI = cTI;
    }

    public double x1(){
        return (((-cTL)+Math.sqrt(Math.pow(cTL,2))-(4*cTC*cTI))/(2*cTC));
    }
    public double x2(){
        return (((-cTL)-Math.sqrt(Math.pow(cTL,2))-(4*cTC*cTI))/(2*cTC));
    }
}
package quebrados;

public class OpQuebrados {
    private Quebrado quebrado1;
    private Quebrado quebrado2;
    public OpQuebrados(Quebrado quebrado1, Quebrado quebrado2) {
        setQuebrado1(quebrado1);
        setQuebrado2(quebrado2);
    }
    public Quebrado getQuebrado1() {
        return quebrado1;
    }
    public void setQuebrado1(Quebrado quebrado1) {
        this.quebrado1 = quebrado1;
    }
    public Quebrado getQuebrado2() {
        return quebrado2;
    }
    public void setQuebrado2(Quebrado quebrado2) {
        this.quebrado2 = quebrado2;
    }
    public Quebrado suma(){
        if(quebrado1.getDenominador()==quebrado2.getDenominador()){
            int numerador = quebrado1.getNumerador()+quebrado2.getNumerador();
            int denominador =quebrado1.getDenominador();
            return new Quebrado(numerador,denominador);
        }else{
            int numerador = (quebrado1.getNumerador()*quebrado2.getDenominador())+(quebrado1.getDenominador()*quebrado2.getNumerador());
            int denominador =   quebrado1.getDenominador()*quebrado2.getDenominador();
            return new Quebrado(numerador,denominador);
        }
    }
    public Quebrado resta(){
        if(quebrado1.getDenominador()==quebrado2.getDenominador()){
            int numerador = quebrado1.getNumerador()-quebrado2.getNumerador();
            int denominador =quebrado1.getDenominador();
            return new Quebrado(numerador,denominador);
        }else{
            int numerador = (quebrado1.getNumerador()*quebrado2.getDenominador())-(quebrado1.getDenominador()*quebrado2.getNumerador());
            int denominador =   quebrado1.getDenominador()*quebrado2.getDenominador();
            return new Quebrado(numerador,denominador);
        }
    }
    public Quebrado multiplicacion(){
        
        int numerador = quebrado1.getNumerador()*quebrado2.getNumerador();
        int denominador = quebrado1.getDenominador()*quebrado2.getDenominador();
        
        return new Quebrado(numerador,denominador);
    }
    public Quebrado division(){
        int numerador = quebrado1.getNumerador()*quebrado2.getDenominador();
        int denominador = quebrado2.getNumerador()*quebrado1.getDenominador();
        return new Quebrado(numerador,denominador);
    }
    
}

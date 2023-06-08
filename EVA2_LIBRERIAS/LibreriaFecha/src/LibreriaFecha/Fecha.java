package LibreriaFecha;

import LibreriaFecha.excepciones.DiaInvalido;

/**
 *
 * @author Jorge Eduardo Escobar Bugarini
 */
public class Fecha {
    int dia, mes, año;
    
    
    
    public Fecha(int dia, int mes, int año) throws DiaInvalido {
        setDia(dia);
        setMes(mes);
        setAño(año);

        if(dia>28 && mes==2 && !isBisiesto()) throw new DiaInvalido();
        if(año<0) throw new DiaInvalido();
        if(mes<0 || mes>12) throw new DiaInvalido();

    }

    public int getDia() {
        return dia;
    }

    public void setDia(int dia) {
        this.dia = dia;
    }

    public int getMes() {
        return mes;
    }

    public void setMes(int mes) {
        this.mes = mes;
    }

    public int getAño() {
        return año;
    }

    public void setAño(int año) {
        this.año = año;
    }
    
    public boolean isBisiesto(){
        return año%4==0;
    }

    public void restarSumarDias(int x){
        if(x<0) x=1;
        else if(x>28){
            if(mes==2){
                if(isBisiesto()) x=29;
                else x=28;
            }
        }else if(x>31){
            if(mes == 1 || mes == 3 || mes == 5 || mes == 7 || mes == 8 || mes == 10 || mes == 11) x=31;
            else{
              x=30;
            }
        } 
      
    }
    
    public void restarSumarMeses(int x){
      if(x>12) x=12;
      else if(x<0) x=1;

    }
    
    public void restarSumarAños(int x){
        if(x<0) x=2023;

    }
    
    public String toString() {
        return "año"+"-"+mes+"-"+dia;
    }
    
}

package LibreriaPersona;

import java.util.Arrays;

import LibreriaFecha.*;
public class Persona {
    private String curp;
    private String paterno;
    private String materno;
    private String nombre;
    private String celular;
    private Fecha fechadeNacimiento;
    private String estadoDeNacimiento;
    private char sexo;

    public Persona() {

    }
    
    
    
    
    public Persona(String curp, String paterno, String materno, String nombre, String celular, Fecha fechadeNacimiento,
            String estadoDeNacimiento, char sexo) {
        this.curp = curp;
        this.paterno = paterno;
        this.materno = materno;
        this.nombre = nombre;
        this.celular = celular;
        this.fechadeNacimiento = fechadeNacimiento;
        this.estadoDeNacimiento = estadoDeNacimiento;
        this.sexo = sexo;
    }




    public String getCurp() {
        return curp;
    }

    public void setCurp(String curp) throws CurpInvalida {

        if (curpValida(curp))
            this.curp = curp;
        else
            throw new CurpInvalida();

    }

    public String getPaterno() {
        return paterno;
    }

    public void setPaterno(String paterno) {
        this.paterno = paterno;
    }

    public String getMaterno() {
        return materno;
    }

    public void setMaterno(String materno) {
        this.materno = materno;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getCelular() {
        return celular;
    }

    public void setCelular(String celular) {
        this.celular = celular;
    }

    public String getEstadoDeNacimiento() {
        return estadoDeNacimiento;
    }

    public void setEstadoDeNacimiento(String estadoDeNacimiento) {
        this.estadoDeNacimiento = estadoDeNacimiento;
    }

    public char getSexo() {
        return sexo;
    }

    public void setSexo(char sexo) {
        this.sexo = sexo;
    }

    private boolean curpValida(String curp) {
        char[] vocales = { 'A', 'E', 'I', 'O', 'U' };
        char[] consonantes  = {'B', 'C', 'D', 'F', 'G', 'H', 'J', 'K', 'L', 'M', 'N', 'Ñ', 'P', 'Q', 'R', 'S', 'T', 'V', 'X', 'Z', 'W', 'Y'};

        final String[] estados = {
                "AGUASCALIENTES",
                "BAJA CALIFORNIA",
                "BAJA CALIFORNIA SUR",
                "CAMPECHE",
                "COAHUILA",
                "COLIMA",
                "CHIAPAS",
                "CHIHUAHUA",
                "DISTRITO FEDERAL",
                "DURANGO",
                "GUANAJUATO",
                "GUERRERO",
                "HIDALGO",
                "JALISCO",
                "MEXICO",
                "MICHOACAN",
                "MORELOS",
                "NAYARIT",
                "NUEVO LEON",
                "OAXACA",
                "PUEBLA",
                "QUERETARO",
                "QUINTANA ROO",
                "SAN LUIS POTOSI",
                "SINALOA",
                "SONORA",
                "TABASCO",
                "TAMAULIPAS",
                "TLAXCALA",
                "VERACRUZ",
                "YUCATAN",
                "ZACATECAS",
                "SERV. EXTERIOR MEXICANO",
                "EXTRANJERO"
        };

        String claveEstado;
        

        if(Arrays.asList(estados).contains(estadoDeNacimiento.toUpperCase())){
            switch(estadoDeNacimiento.toUpperCase()){
                case "AGUASCALIENTES": claveEstado="AS";
                case "BAJA CALIFORNIA": claveEstado="BC";
                case "BAJA CALIFORNIA SUR": claveEstado="BS";
                case "CAMPECHE": claveEstado="CC";
                case "COAHUILA": claveEstado="CL";
                case "COLIMA": claveEstado="CM";
                case "CHIAPAS": claveEstado="CS";
                case "CHIHUAHUA": claveEstado="CH";
                case "DISTRITO FEDERAL": claveEstado="DF";
                case "DURANGO": claveEstado="DG";
                case "GUANAJUATO": claveEstado="GT";
                case "GUERRERO": claveEstado="GR";
                case "HIDALGO": claveEstado="HG";
                case "JALISCO": claveEstado="JC";
                case "MEXICO": claveEstado="MC";
                case "MICHOACAN": claveEstado="MN";
                case "MORELOS": claveEstado="MS";
                case "NAYARIT": claveEstado="NT";
                case "NUEVO LEON": claveEstado="NL";
                case "OAXACA": claveEstado="OC";
                case "PUEBLA": claveEstado="PL";
                case "QUERETARO": claveEstado="QT";
                case "QUINTANA ROO": claveEstado="QR";
                case "SAN LUIS POTOSI": claveEstado="SP";
                case "SINALOA": claveEstado="SL";
                case "SONORA": claveEstado="SR";
                case "TABASCO": claveEstado="TC";
                case "TAMAULIPAS": claveEstado="TS";
                case "TLAXCALA": claveEstado="TL";
                case "VERACRUZ": claveEstado="VZ";
                case "YUCATAN": claveEstado="YN";
                case "ZACATECAS": claveEstado="ZS";
                case "SERV. EXTERIOR MEXICANO": claveEstado="NA";
                case "EXTRANJERO":claveEstado="SI";
            }
        }else{
            return false;
        }

        String añoNacimiento = Integer.toString(fechadeNacimiento.getAño());
        añoNacimiento = añoNacimiento.substring(añoNacimiento.length()-2);
        String diaNacimiento =  Integer.toString(fechadeNacimiento.getDia());
        if(fechadeNacimiento.getDia()<10){
            diaNacimiento =  "0"+diaNacimiento;
        }
        
        String mesNacimiento = Integer.toString(fechadeNacimiento.getMes());
        if(fechadeNacimiento.getMes()<10){
            mesNacimiento =  "0"+mesNacimiento;
        }
        
        char primerLetra = paterno.charAt(0);
        char segundaLetra;
        char tercerLetra = materno.charAt(0);
        for(int i=1; i<paterno.length(); i++){
            if(Arrays.asList(vocales).contains(paterno.charAt(i))){
                segundaLetra = paterno.charAt(i);
                break;
            }else{
                continue;
            }
        }
        
        

        if(!(sexo=='H' || sexo=='M')) return false;


        if (curp.length() != 18)
            return false;
        
        return false;
    }




    public Fecha getFechadeNacimiento() {
        return fechadeNacimiento;
    }




    public void setFechadeNacimiento(Fecha fechadeNacimiento) {
        this.fechadeNacimiento = fechadeNacimiento;
    }

}

class CurpInvalida extends Exception {
    public CurpInvalida() {
        super("La CURP insertada no es valida para esta persona");
    }
}
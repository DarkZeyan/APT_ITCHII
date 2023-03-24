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
        final char[] vocales = { 'A', 'E', 'I', 'O', 'U' };
        final char[] consonantes = { 'B', 'C', 'D', 'F', 'G', 'H', 'J', 'K', 'L', 'M', 'N', 'Ñ', 'P', 'Q', 'R', 'S',
                'T', 'V', 'X', 'Z', 'W', 'Y' };
        final String[] preposiciones = { "DA", "DAS", "DE", "DEL", "DER", "DI", "DIE", "DD", "EL", "LA", "LOS", "LAS",
                    "LE", "LES", "MAC", "MC", "VAN", "VON", "Y" };
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

        // Evaluar si el estado capturado es perteneciente a los estados registrados, si
        // es asi, capturar la clave del estado, si no retornar falso
        if (Arrays.asList(estados).contains(estadoDeNacimiento.toUpperCase())) {
            switch (estadoDeNacimiento.toUpperCase()) {
                case "AGUASCALIENTES":
                    claveEstado = "AS";
                case "BAJA CALIFORNIA":
                    claveEstado = "BC";
                case "BAJA CALIFORNIA SUR":
                    claveEstado = "BS";
                case "CAMPECHE":
                    claveEstado = "CC";
                case "COAHUILA":
                    claveEstado = "CL";
                case "COLIMA":
                    claveEstado = "CM";
                case "CHIAPAS":
                    claveEstado = "CS";
                case "CHIHUAHUA":
                    claveEstado = "CH";
                case "DISTRITO FEDERAL":
                    claveEstado = "DF";
                case "DURANGO":
                    claveEstado = "DG";
                case "GUANAJUATO":
                    claveEstado = "GT";
                case "GUERRERO":
                    claveEstado = "GR";
                case "HIDALGO":
                    claveEstado = "HG";
                case "JALISCO":
                    claveEstado = "JC";
                case "MEXICO":
                    claveEstado = "MC";
                case "MICHOACAN":
                    claveEstado = "MN";
                case "MORELOS":
                    claveEstado = "MS";
                case "NAYARIT":
                    claveEstado = "NT";
                case "NUEVO LEON":
                    claveEstado = "NL";
                case "OAXACA":
                    claveEstado = "OC";
                case "PUEBLA":
                    claveEstado = "PL";
                case "QUERETARO":
                    claveEstado = "QT";
                case "QUINTANA ROO":
                    claveEstado = "QR";
                case "SAN LUIS POTOSI":
                    claveEstado = "SP";
                case "SINALOA":
                    claveEstado = "SL";
                case "SONORA":
                    claveEstado = "SR";
                case "TABASCO":
                    claveEstado = "TC";
                case "TAMAULIPAS":
                    claveEstado = "TS";
                case "TLAXCALA":
                    claveEstado = "TL";
                case "VERACRUZ":
                    claveEstado = "VZ";
                case "YUCATAN":
                    claveEstado = "YN";
                case "ZACATECAS":
                    claveEstado = "ZS";
                case "SERV. EXTERIOR MEXICANO":
                    claveEstado = "NA";
                case "EXTRANJERO":
                    claveEstado = "SI";
            }
        } else {
            return false;
        }

        String añoNacimiento = Integer.toString(fechadeNacimiento.getAño());
        añoNacimiento = añoNacimiento.substring(añoNacimiento.length() - 2);
        String diaNacimiento = Integer.toString(fechadeNacimiento.getDia());

        if (fechadeNacimiento.getDia() < 10) {
            diaNacimiento = "0" + diaNacimiento;
        }

        String mesNacimiento = Integer.toString(fechadeNacimiento.getMes());
        if (fechadeNacimiento.getMes() < 10) {
            mesNacimiento = "0" + mesNacimiento;
        }

        // Extraer primer letra del apellido paterno
        char primerLetra = paterno.toUpperCase().charAt(0);
        char segundaLetra;

        // Extraer primer letra del apellido materno
        char tercerLetra;

        //Evaluar si hay apellido materno, si lo hay, entonces extraer primer letra, sino asignar X;
        if(!materno.equals("")){
            tercerLetra= materno.toUpperCase().charAt(0);
        }else{
            tercerLetra = 'X';
        }
        
        // Asignar segunda letra, vocal interna de apellido paterno
        

        String[] paternoDiv =  paterno.toUpperCase().split(" ");
        if(paternoDiv.length>1){
            
            for(String paternoTemp:paternoDiv){
                if (Arrays.asList(preposiciones).contains(paternoTemp)) {
                    continue;
                for (int i = 1; i < paterno.length(); i++) {
                  if (Arrays.asList(vocales).contains(paternoTemp.toUpperCase().charAt(i))) {
                    segundaLetra = paternoTemp.toUpperCase().charAt(i);
                    break;
                    } else {
                        // Si ya fueron recorridas todas las letras y no hay vocal interna, entonces
                        // asignar la vocal como X
                        if (i == paternoTemp.length() - 1)
                            segundaLetra = 'X';
                        else
                            continue;
                    }
                }
            }
        }
        }else{
            for (int i = 1; i < paterno.length(); i++) {
            if (Arrays.asList(vocales).contains(paterno.toUpperCase().charAt(i))) {
                segundaLetra = paterno.toUpperCase().charAt(i);
                break;
            } else {
                // Si ya fueron recorridas todas las letras y no hay vocal interna, entonces
                // asignar la vocal como X
                if (i == paterno.length() - 1)
                    segundaLetra = 'X';
                else
                    continue;
            }
        }
        }
        

        // Si la primer letra de uno de los apellidos y/o del nombre es ñ cambiar a X
        if (primerLetra == 'Ñ')
            primerLetra = 'X';
        if (tercerLetra == 'Ñ')
            tercerLetra = 'X';

        char primerLetraNombre;

        // Verificar si el nombre es compuesto
        String[] nombres = nombre.toUpperCase().split(" ");

        // Validar si la cantidad de nombres es mayor 1
        if (nombres.length > 1) {
            String[] nombresVetados = { "MARIA", "MA.", "MA", "JOSE", "J.", "J" };

            for (String nom : nombres) {
                // Si el nombre es compuesto y es uno de los vetados, entonces considerar el
                // segundo nombre
                // si la siguiente cadena es preposicion, saltar.
                if (Arrays.asList(nombresVetados).contains(nom) || Arrays.asList(preposiciones).contains(nom)) {
                    continue;
                } else {
                    primerLetraNombre = nom.charAt(0);
                    if (primerLetraNombre == 'Ñ')
                    primerLetraNombre = 'X';
                    break;
                }

            }

        } else {
            // sino, se evalua con el nombre normal.
            primerLetraNombre = nombre.toUpperCase().charAt(0);
        }

       
        // apartado de las consonantes

        // Consonante 1, apellido paterno.

        char consonante1='-';

        if(paternoDiv.length>1){
            
            for(String paternoTemp:paternoDiv){
                if (Arrays.asList(preposiciones).contains(paternoTemp)) {
                    continue;
                for (int i = 1; i < paterno.length(); i++) {
                  if (Arrays.asList(consonantes).contains(paternoTemp.toUpperCase().charAt(i))) {
                    consonante1 = paternoTemp.toUpperCase().charAt(i);
                    break;
                    } else {
                        // Si ya fueron recorridas todas las letras y no hay vocal interna, entonces
                        // asignar la vocal como X
                        if (i == paternoTemp.length() - 1)
                            consonante1 = 'X';
                        else
                            continue;
                    }
                }
            }
        }
        }else{
            for (int i = 1; i < paterno.length(); i++) {
            if (Arrays.asList(consonantes).contains(paterno.toUpperCase().charAt(i))) {
                consonante1 = paterno.toUpperCase().charAt(i);
                break;
            } else {
                // Si ya fueron recorridas todas las letras y no hay vocal interna, entonces
                // asignar la vocal como X
                if (i == paterno.length() - 1)
                    consonante1 = 'X';
                else
                    continue;
            }
        }
        }
        


        //Si el sexo es digitado con otra cosa, retornar falso.
        if (!(sexo == 'H' || sexo == 'M'))
            return false;

        if (curp.length() != 18)
            return false;

        return true;
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
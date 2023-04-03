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
            String estadoDeNacimiento, char sexo) throws CurpInvalida {

        setPaterno(paterno);
        setMaterno(materno);
        setNombre(nombre);
        setCelular(celular);
        setFechadeNacimiento(fechadeNacimiento);
        setEstadoDeNacimiento(estadoDeNacimiento);
        setSexo(sexo);
        setCurp(curp);

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

    private boolean curpValida(String curp) throws CurpInvalida{
        final char[] vocales = { 'A', 'E', 'I', 'O', 'U' };
        final char[] consonantes = { 'B', 'C', 'D', 'F', 'G', 'H', 'J', 'K', 'L', 'M', 'N', '\u00d1', 'P', 'Q', 'R', 'S',
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
        final String[] nombresVetados = { "MARIA", "MA.", "MA", "JOSE", "J.", "J" };
        final String[] palabrasAltisonantes = { "BACA",

                "BAKA",

                "BUEI",

                "BUEY",

                "CACA",

                "CACO",

                "CAGA",

                "CAGO",

                "CAKA",

                "CAKO",

                "COGE",

                "COGI",

                "COJA",

                "COJE",

                "COJI",

                "COJO",

                "COLA",

                "CULO",

                "FALO",

                "FETO",

                "GETA",

                "GUEI",

                "GUEY",

                "JETA",

                "JOTO",

                "KACA",

                "KACO",

                "KAGA",

                "KAGO",

                "KAKA",

                "KAKO",

                "KOGE",

                "KOGI",

                "KOJA",

                "KOJE",

                "KOJI",

                "KOJO",

                "KOLA",

                "KULO",

                "LILO",

                "LOCA",

                "LOCO",

                "LOKA",

                "LOKO",

                "MAME",

                "MAMO",

                "MEAR",

                "MEAS",

                "MEON",

                "MIAR",

                "MION",

                "MOCO",

                "MOKO",

                "MULA",

                "MULO",

                "NACA",

                "NACO",

                "PEDA",

                "PEDO",

                "PENE",

                "PIPI",

                "PITO",

                "POPO",

                "PUTA",

                "PUTO",

                "QULO",

                "RATA",

                "ROBA",

                "ROBE",

                "ROBO",

                "RUIN",

                "SENO",

                "TETA",

                "VACA",

                "VAGA",

                "VAGO",

                "VAKA",

                "VUEI",

                "VUEY",

                "WUEI",

                "WUEY"};
        String claveEstado = "";

        // Evaluar si el estado capturado es perteneciente a los estados registrados, si
        // es asi, capturar la clave del estado, si no retornar falso
        if (Arrays.asList(estados).contains(estadoDeNacimiento.toUpperCase())) {
            switch (estadoDeNacimiento.toUpperCase()) {
                case "AGUASCALIENTES":
                    claveEstado = "AS";
                    break;
                case "BAJA CALIFORNIA":
                    claveEstado = "BC";
                    break;
                case "BAJA CALIFORNIA SUR":
                    claveEstado = "BS";
                    break;
                case "CAMPECHE":
                    claveEstado = "CC";
                    break;
                case "COAHUILA":
                    claveEstado = "CL";
                    break;
                case "COLIMA":
                    claveEstado = "CM";
                    break;
                case "CHIAPAS":
                    claveEstado = "CS";
                    break;
                case "CHIHUAHUA":
                    claveEstado = "CH";
                    break;
                case "DISTRITO FEDERAL":
                    claveEstado = "DF";
                    break;
                case "DURANGO":
                    claveEstado = "DG";
                    break;
                case "GUANAJUATO":
                    claveEstado = "GT";
                    break;
                case "GUERRERO":
                    claveEstado = "GR";
                    break;
                case "HIDALGO":
                    claveEstado = "HG";
                    break;
                case "JALISCO":
                    claveEstado = "JC";
                    break;
                case "MEXICO":
                    claveEstado = "MC";
                    break;
                case "MICHOACAN":
                    claveEstado = "MN";
                    break;
                case "MORELOS":
                    claveEstado = "MS";
                    break;
                case "NAYARIT":
                    claveEstado = "NT";
                    break;
                case "NUEVO LEON":
                    claveEstado = "NL";
                    break;
                case "OAXACA":
                    claveEstado = "OC";
                    break;
                case "PUEBLA":
                    claveEstado = "PL";
                    break;
                case "QUERETARO":
                    claveEstado = "QT";
                    break;
                case "QUINTANA ROO":
                    claveEstado = "QR";
                    break;
                case "SAN LUIS POTOSI":
                    claveEstado = "SP";
                    break;
                case "SINALOA":
                    claveEstado = "SL";
                    break;
                case "SONORA":
                    claveEstado = "SR";
                    break;
                case "TABASCO":
                    claveEstado = "TC";
                    break;
                case "TAMAULIPAS":
                    claveEstado = "TS";
                    break;
                case "TLAXCALA":
                    claveEstado = "TL";
                    break;
                case "VERACRUZ":
                    claveEstado = "VZ";
                    break;
                case "YUCATAN":
                    claveEstado = "YN";
                    break;
                case "ZACATECAS":
                    claveEstado = "ZS";
                    break;
                case "SERV. EXTERIOR MEXICANO":
                    claveEstado = "NA";
                    break;
                case "EXTRANJERO":
                    claveEstado = "SI";
                    break;
                default:
                    claveEstado = "NA";
                    break;
            }
        } else {
            throw new CurpInvalida("El estado de nacimiento especificado no es el correcto");
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
        char primerLetra='-';

        char segundaLetra = 'x';

        // Extraer primer letra del apellido materno
        char tercerLetra = 'X';

        // Evaluar si hay apellido materno, si lo hay, entonces extraer primer letra,
        // sino asignar X;
        if (!materno.equals("")) {
            tercerLetra = materno.toUpperCase().charAt(0);
        } else {
            tercerLetra = 'X';
        }

        // Asignar segunda letra, vocal interna de apellido paterno

        String[] paternoDiv = paterno.toUpperCase().split(" ");
        if (paternoDiv.length > 1) {
            boolean bandera=false;
            for (String paternoTemp : paternoDiv) {
                if (containsString(preposiciones, paternoTemp)) {
                   continue;
                }
                primerLetra=paternoTemp.charAt(0);
                for (int i = 1; i < paternoTemp.length(); i++) {
                   
                    if (containsChar(vocales, paternoTemp.charAt(i))) {
                    
                        segundaLetra = paternoTemp.toUpperCase().charAt(i);
                        bandera=true;
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
                if(bandera=true) break;

            }
        } else {
            
            primerLetra=paterno.charAt(0);
            for (int i = 1; i < paterno.length(); i++) {
                if (containsChar(vocales, paterno.charAt(i))) {
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
        char primerLetraNombre = 'X';
        char consonanteNombre = 'X';
        // Verificar si el nombre es compuesto
        String[] nombres = nombre.toUpperCase().split(" ");
        // Validar si la cantidad de nombres es mayor 1

        if (nombres.length > 1) {
            boolean bandera=false;
            int c=0;
            for (String nombreTemp : nombres) {
                c++;
                if ((Arrays.asList(nombresVetados).contains(nombreTemp)|| Arrays.asList(preposiciones).contains(nombreTemp)) && c<nombres.length)
                    continue;      
                
                primerLetraNombre = nombreTemp.charAt(0);
                if (primerLetraNombre == 'Ñ')
                    primerLetraNombre = 'X';

                // Extraer consonante.
                for (int i = 1; i < nombreTemp.length(); i++) {
                    if (containsChar(consonantes, nombreTemp.charAt(i))) {
                        
                        consonanteNombre = nombreTemp.toUpperCase().charAt(i);
                        bandera=true;
                        break;
                    }
                }
                if(bandera) break;
                }
            

        } else {
            // sino, se evalua con el nombre normal.
            primerLetraNombre = nombre.toUpperCase().charAt(0);
            for (int i = 1; i < nombre.length(); i++) {
                if (containsChar(consonantes, nombre.charAt(i))) {

                    consonanteNombre = nombre.toUpperCase().charAt(i);
                    break;
                }
            }
        }

        // apartado de las consonantes
        // Consonante 1, apellido paterno.

        char consonantePaterno = 'X';

        if (paternoDiv.length > 1) {

            for (String paternoTemp : paternoDiv) {
                if (containsString(preposiciones, paternoTemp)) {
                    continue;
                }
                for (int i = 1; i < paternoTemp.length(); i++) {
                    if (containsChar(consonantes, paternoTemp.toUpperCase().charAt(i))) {
                        
                        consonantePaterno = paternoTemp.toUpperCase().charAt(i);
                        if(consonantePaterno=='\u00d1') consonantePaterno='X';
                        break;
                    } else {
                        // Si ya fueron recorridas todas las letras y no hay vocal interna, entonces
                        // asignar la vocal como X
                        if (i == paternoTemp.length() - 1)
                            consonantePaterno = 'X';
                        else
                            continue;
                    }
                }
            }
        } else {
            for (int i = 1; i < paterno.length(); i++) {
                if (containsChar(consonantes, paterno.toUpperCase().charAt(i))) {
                    
                    consonantePaterno = paterno.toUpperCase().charAt(i);
                       if(consonantePaterno=='\u00d1') consonantePaterno='X';
                    break;
                } else {
                    // Si ya fueron recorridas todas las letras y no hay vocal interna, entonces
                    // asignar la vocal como X
                    if (i == paterno.length() - 1)
                        consonantePaterno = 'X';
                    else
                        continue;
                }
            }
        }

        // Consonante 2, Consonante del apellido materno.
        char consonanteMaterno = 'X';
        if (materno.equals("")) {
            consonanteMaterno = 'X';
        } else {
            String[] apMaterno = materno.toUpperCase().split(" ");
            for (String materno1 : apMaterno) {

                if (containsString(preposiciones, materno1))
                    continue;
                else {
                    for (int i = 1; i < materno1.length(); i++) {

                        if (containsChar(consonantes, materno1.charAt(i))) {
                            consonanteMaterno = materno1.toUpperCase().charAt(i);
                            break;
                        }
                    }
                }
            }
        }

        // Si el sexo es digitado con otra cosa, retornar falso.
        if (!(getSexo() == 'H' || getSexo() == 'M')){
            throw new CurpInvalida("El sexo debe ser digitado con H o M");
        }
        if (curp.length() != 18)
            throw new CurpInvalida("La longitud de la curp debe ser de 18 caracteres");

        
        if(curp.charAt(0)!=primerLetra) throw new CurpInvalida("La curp introducida no es correcta para el apellido paterno especificado");
        if(curp.charAt(1)!=segundaLetra) throw new CurpInvalida("La curp introducida no es correcta en la segunda posicion");
        if(curp.charAt(2)!=tercerLetra) throw new CurpInvalida("La curp introducida no es correcta para el apellido materno");
        if(curp.charAt(3)!=primerLetraNombre) throw new CurpInvalida("La curp introducida no es valida para el  nombre especificado ");
       
        if(!curp.substring(4,6).equals(añoNacimiento)) throw new CurpInvalida("El año de nacimiento introducido en la curp es incorrecto");
        if(!curp.substring(6,8).equals(mesNacimiento)) throw new CurpInvalida("El mes de nacimiento introducido en la curp es incorrecto");
        if(!curp.substring(8,10).equals(diaNacimiento)) throw new CurpInvalida("El dia de nacimiento introducido en la curp es incorrecto");
        if(curp.charAt(13)!=consonantePaterno) throw new CurpInvalida("Consonante paterna incorrecta");
        if(curp.charAt(14)!=consonanteMaterno) throw new CurpInvalida("Consonante materna incorrecta");
        if(curp.charAt(15)!=consonanteNombre) throw new CurpInvalida("Consonante del nombre incorrecta");

        String discriminante=""+primerLetra+""+segundaLetra+""+tercerLetra+""+primerLetraNombre+"";
        System.out.println(discriminante);
        if(containsString(palabrasAltisonantes, discriminante)) segundaLetra='X';

        String cuttedCurp = curp.substring(0, curp.length() - 2);
        System.out.println("Curp digitada sin homoclave: " + cuttedCurp);
        String curpVerifier = primerLetra + "" + segundaLetra + "" + tercerLetra + "" + primerLetraNombre
                + añoNacimiento + mesNacimiento + diaNacimiento + getSexo() + claveEstado + consonantePaterno
                + consonanteMaterno + consonanteNombre;
        System.out.println("Curp con datos introducidos: " + curpVerifier);
        if (curpVerifier.equals(cuttedCurp))
            return true;
        return false;
    }

    public Fecha getFechadeNacimiento() {
        return fechadeNacimiento;
    }

    public void setFechadeNacimiento(Fecha fechadeNacimiento) {
        this.fechadeNacimiento = fechadeNacimiento;
    }

    private static boolean containsChar(char[] charArray, char c) {
        for (char x : charArray) {
            if (x == c)
                return true;
        }
        return false;
    }

    private static boolean containsString(String[] arr, String s) {
        for (String x : arr) {
            if (x.equals(s))
                return true;
        }
        return false;
    }
}

class CurpInvalida extends Exception {
   
    public CurpInvalida(String msg){
        super(msg);
    }
    
    public CurpInvalida() {
        super("La CURP insertada no es valida para esta persona");
    }
}

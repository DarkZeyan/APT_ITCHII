package ejemplo_jtable;

import java.util.ArrayList;

public class DatosPersonas {
    private ArrayList<Persona> personas;

    public void getDatos(){
        personas = new ArrayList<Persona>();
        personas.add(new Persona("EOBJ030327HCHSGRA2","JORGE EDUARDO","ESCOBAR BUGARINI","+526143513346",20,true));
        personas.add(new Persona("CAMC030110MCCHSRRA9","MARIA DEL CARMEN","CASTILLO MARQUEZ","+526144689986",20,true));
        personas.add(new Persona("TORJ031219HCHRSA1","JESUS ALEJANDRO","TORRES RAMIREZ","+526144683206",19,true));
    }

    public DatosPersonas(ArrayList<Persona> personas) {
        setPersonas(personas);
    }
    

    public DatosPersonas() {
        getDatos();
    }

    public ArrayList<Persona> getPersonas() {
        return personas;
    }

    public void setPersonas(ArrayList<Persona> personas) {
        this.personas = personas;
    }

    public void deployDataOnConsole(){
        System.out.println("CURP: \t\t NOMBRE: \t\t APELLIDO: \t\t CELULAR: \t EDAD: \t SOLTERO:");
        for(Persona persona: personas){
            System.out.println(persona.getCurp()+ "\t"+persona.getNombre()+"\t\t"+persona.getApellido()+
            "\t\t"+persona.getCelular() + "\t"+persona.getEdad()+"\t"+persona.isSoltero()
            );
            
        }
        System.out.println("\n\n");
    }

}

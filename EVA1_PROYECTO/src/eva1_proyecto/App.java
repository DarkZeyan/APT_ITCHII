/*
 * 
 * 
 */
package eva1_proyecto;

/**
 *
 * @author Jorge Eduardo Escobar Bugarini - ISC - 21550317
 * @author Edgar Gerardo Delgado Cerrillo - ISC - 21550297
 * @author Luis Antonio Garcia Colunga - ISC - 21550740
 * @author Diego Gael Martin del Campo Loa - ISC - 21550321
 * @author Sebastian Emilio Murillo Andrade - ISC - 21550384
 */

//Imports para el manejo de archivos
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
 //Base imports

import java.util.ArrayList;
import modelo.Usuario;
import vistas.*;
public class App {

    
    public static void main(String[] args) {
        ArrayList<Usuario>  usuarios = getUsuarios();
        
        try {
           LoginScreen ls = new LoginScreen(usuarios);    
           ls.setVisible(true);
        } catch (Exception e) {

        }  finally{
            saveUsers(usuarios);
        }
        
    }
    
    public static void saveUsers(Object usuarios) {
        try {
            //Crear el directorio en caso de que no exista (Caso poco probable ya que es entorno local)
            String route = "src/resources/";
            File directory = new File(route);
            if (!directory.exists()) {
                directory.mkdir();
            }
            FileOutputStream openUsersFile = new FileOutputStream(route + "users.bancony");
            ObjectOutputStream saveUsersFile = new ObjectOutputStream(openUsersFile);
            saveUsersFile.writeObject(usuarios);
            saveUsersFile.flush();
            saveUsersFile.close();

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    @SuppressWarnings("unchecked")
    private static ArrayList<Usuario> getUsuarios(){
        ArrayList<Usuario> usuarios = new ArrayList<Usuario>();
        
        try {

            FileInputStream openUsersFile = new FileInputStream("src/resources/users.bancony");
            ObjectInputStream readUsuarios = new ObjectInputStream(openUsersFile);
            usuarios = (ArrayList<Usuario>) readUsuarios.readObject();

            return usuarios;
        } catch (FileNotFoundException e) {
            // No se pudieron encontrar usuarios.  -> Crear nuevos usuarios.
            e.printStackTrace();
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }
        return usuarios;
    }
    
}

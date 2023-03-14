package controlador;

import vistas.*;
import javax.swing.JFrame;
public class Controller {
    MainMenu menuPrincipalView;
    RegistrarTarjetaMenu newCardView;
    UsuariosInactivosMenu inactiveClientView;
    NuevoClienteMenu newClientView;
    ModificarClienteMenu modifyClientView;
  
    public Controller(MainMenu menuPrincipalView, RegistrarTarjetaMenu newCardView,
            UsuariosInactivosMenu inactiveClientView, NuevoClienteMenu newClientView,
            ModificarClienteMenu modifyClientView) {
        this.menuPrincipalView = menuPrincipalView;
        this.newCardView = newCardView;
        this.inactiveClientView = inactiveClientView;
        this.newClientView = newClientView;
        this.modifyClientView = modifyClientView;
    }
    public MainMenu getMenuPrincipalView() {
        return menuPrincipalView;
    }
    public void setMenuPrincipalView(MainMenu menuPrincipalView) {
        this.menuPrincipalView = menuPrincipalView;
    }

    public RegistrarTarjetaMenu getNewCardView() {
        return newCardView;
    }
    public void setNewCardView(RegistrarTarjetaMenu newCardView) {
        this.newCardView = newCardView;
    }
    public UsuariosInactivosMenu getInactiveClientView() {
        return inactiveClientView;
    }
    public void setInactiveClientView(UsuariosInactivosMenu inactiveClientView) {
        this.inactiveClientView = inactiveClientView;
    }
    public NuevoClienteMenu getNewClientView() {
        return newClientView;
    }
    public void setNewClientView(NuevoClienteMenu newClientView) {
        this.newClientView = newClientView;
    }
    public ModificarClienteMenu getModifyClientView() {
        return modifyClientView;
    }
    public void setModifyClientView(ModificarClienteMenu modifyClientView) {
        this.modifyClientView = modifyClientView;
    }

    public void callNewWindow(JFrame previousWindow, JFrame newWindow){
        previousWindow.setVisible(false);
        newWindow.setVisible(true);
    }

    
}

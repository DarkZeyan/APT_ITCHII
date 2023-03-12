package controlador;

import vistas.*;

public class Controller {
    MainMenu menuPrincipalView;
    MovimientosMenu movementsView;
    RegistrarTarjetaMenu newCardView;
    UsuariosInactivosMenu inactiveClientView;
    NuevoClienteMenu newClientView;
    ModificarClienteMenu modifyCLientView;
    public Controller(MainMenu menuPrincipalView, MovimientosMenu movementsView, RegistrarTarjetaMenu newCardView,
            UsuariosInactivosMenu inactiveClientView, NuevoClienteMenu newClientView,
            ModificarClienteMenu modifyCLientView) {
        this.menuPrincipalView = menuPrincipalView;
        this.movementsView = movementsView;
        this.newCardView = newCardView;
        this.inactiveClientView = inactiveClientView;
        this.newClientView = newClientView;
        this.modifyCLientView = modifyCLientView;
    }
    public MainMenu getMenuPrincipalView() {
        return menuPrincipalView;
    }
    public void setMenuPrincipalView(MainMenu menuPrincipalView) {
        this.menuPrincipalView = menuPrincipalView;
    }
    public MovimientosMenu getMovementsView() {
        return movementsView;
    }
    public void setMovementsView(MovimientosMenu movementsView) {
        this.movementsView = movementsView;
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
    public ModificarClienteMenu getModifyCLientView() {
        return modifyCLientView;
    }
    public void setModifyCLientView(ModificarClienteMenu modifyCLientView) {
        this.modifyCLientView = modifyCLientView;
    }
    
    
}

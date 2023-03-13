package modelo;
import java.util.ArrayList;
import javax.swing.table.AbstractTableModel;
public class ActiveClientsModel extends AbstractTableModel{
    private ArrayList<Cliente> clientes;
    private String[] columnsNames = {"Cliente","Número de tarjeta"};
    public ActiveClientsModel(ArrayList<Cliente> clientes){
        this.clientes =  clientes;
    }

    @Override
    public int getRowCount() {
       return clientes.size();
    }

    @Override
    public int getColumnCount() {
       return columnsNames.length;
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        Cliente cliente = clientes.get(rowIndex);

        switch(columnIndex){
            case 0: cliente.getCurp();
            case 1: cliente.getTarjetasCliente().get(rowIndex).getNumeroTarjeta();
        }
        return null;
    }
    @Override
    public String getColumnName(int column){
        return columnsNames[column];
    }

    
//    @Override
//    public Class<?> getColumnClass(int columnIndex) {
//        return getValueAt(0,columnIndex).getClass();
//    }
//
//    @Override
//    public boolean isCellEditable(int rowIndex, int columnIndex) {
//        return false;
//    }

    
}

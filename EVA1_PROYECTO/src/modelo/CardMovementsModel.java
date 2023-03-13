package modelo;
import java.util.ArrayList;
import javax.swing.table.AbstractTableModel;
public class CardMovementsModel extends AbstractTableModel{
    
    private ArrayList<Movimiento> movimientos;
    private String[] columnsNames = {"Clave", "Fecha de Movimiento", "Tipo de Movimiento", "Cantidad"};
    public CardMovementsModel(ArrayList<Movimiento> movimientos){
        this.movimientos = movimientos;
    }

    @Override
    public int getRowCount() {
       return movimientos.size();
    }

    @Override
    public int getColumnCount() {
       return columnsNames.length;
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        Movimiento movimiento = movimientos.get(rowIndex);

        switch(columnIndex){
            case 0: movimiento.getClave();
            case 1: movimiento.getFechaMovimiento().toString();
            case 2: movimiento.getTipoMovimiento();
            case 3: movimiento.getCantidad();
        }
        return null;
    }
    @Override
    public String getColumnName(int column){
        return columnsNames[column];
    }

    
    @Override
    public Class<?> getColumnClass(int columnIndex) {
        return getValueAt(0,columnIndex).getClass();
    }

    @Override
    public boolean isCellEditable(int rowIndex, int columnIndex) {
        return false;
    }

}

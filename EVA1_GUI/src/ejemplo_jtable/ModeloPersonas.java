package ejemplo_jtable;
import java.util.ArrayList;

import javax.swing.table.AbstractTableModel;
public class ModeloPersonas extends AbstractTableModel{
    private ArrayList<Persona> data;
    private String[] columnsName = {"CURP","NOMBRE","APELLIDO","CELULAR","EDAD","SOLTERO/A"};

    DatosPersonas datos = new DatosPersonas();
    public ModeloPersonas(){
        data = datos.getPersonas();
    }
    @Override
    public int getRowCount(){
        return data.size();
    }
    @Override
    public int getColumnCount(){
        return columnsName.length;
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex){
        Persona persona = data.get(rowIndex);

        switch(columnIndex){
            case 0: return persona.getCurp();
            case 1: return persona.getNombre();
            case 2: return persona.getApellido();
            case 3: return persona.getCelular();
            case 4: return persona.getEdad();
            case 5: return persona.isSoltero(); 
            
        }
        return null;
    }
    @Override
    public String getColumnName(int column){
        return columnsName[column];
    }

    
    @Override
    public Class<?> getColumnClass(int columnIndex) {
        return getValueAt(0,columnIndex).getClass();
    }

    @Override
    public boolean isCellEditable(int rowIndex, int columnIndex) {
        return true;
    }

    @Override
    public void setValueAt(Object aValue, int rowIndex, int columnIndex) {
        Persona persona = data.get(rowIndex);
        switch(columnIndex){
            case 0: persona.setCurp((String)aValue);
            case 1: persona.setNombre((String)aValue);
            case 2: persona.setApellido((String)aValue);
            case 3: persona.setCelular((String)aValue);
            case 4: persona.setEdad((Integer)aValue);
            case 5: persona.setSoltero((Boolean)aValue); 
            
        }
        fireTableCellUpdated(rowIndex, columnIndex);
    }

}

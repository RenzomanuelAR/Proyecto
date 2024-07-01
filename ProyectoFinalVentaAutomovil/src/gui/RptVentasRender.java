package gui;

import java.awt.Color;
import java.awt.Component;
import java.awt.Font;

import javax.swing.JTable;
import javax.swing.SwingConstants;
import javax.swing.table.DefaultTableCellRenderer;

public class RptVentasRender extends DefaultTableCellRenderer {
    private static final long serialVersionUID = 1L;

    
    public RptVentasRender() {

    }
    
    @Override
    public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected, boolean hasFocus, int row, int column) {
        Component cell = super.getTableCellRendererComponent(table, value, isSelected, hasFocus, row, column);


        // Alinear la segunda columna al centro (columna indexada en 1)
        if (column >=0 && column <= 2 || column == 4 || column == 6) {
            setHorizontalAlignment(SwingConstants.CENTER);
        } else if (column > 6 && column <=11) { // Alinear la quinta columna a la derecha (columna indexada en 4)
            setHorizontalAlignment(SwingConstants.RIGHT);
        } else {
            // Alinear las otras columnas a la izquierda (o según el alineamiento predeterminado)
            setHorizontalAlignment(SwingConstants.LEFT);
        }
        
        // Aplicar formato solo a las columnas
        if (column > 6 && column <= 11) {
            cell.setFont(cell.getFont().deriveFont(Font.BOLD)); // Poner en negrita
            cell.setBackground(Color.GRAY); // Cambiar color de fondo
        } else {
            cell.setFont(cell.getFont().deriveFont(Font.PLAIN)); // Quitar negrita
            cell.setBackground(Color.WHITE); // Color de fondo normal
        }
        
        // Obtener el número total de filas en la tabla
        int rowCount = table.getModel().getRowCount();

        // Aplicar formato solo a la última fila
        if (row == rowCount - 1) {
            cell.setFont(cell.getFont().deriveFont(Font.BOLD)); // Poner en negrita
            cell.setBackground(Color.LIGHT_GRAY); // Cambiar color de fondo
        } else {
            cell.setFont(cell.getFont().deriveFont(Font.PLAIN)); // Quitar negrita
            cell.setBackground(Color.WHITE); // Color de fondo normal
        }

        return cell;
    }

}



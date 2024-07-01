package gui;

import java.awt.Color;
import java.awt.Component;
import java.awt.Font;

import javax.swing.JTable;
import javax.swing.SwingConstants;
import javax.swing.table.DefaultTableCellRenderer;

public class RptProductoAcmRender extends DefaultTableCellRenderer {
    private static final long serialVersionUID = 1L;

    
    public RptProductoAcmRender() {

    }
    
    @Override
    public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected, boolean hasFocus, int row, int column) {
        Component cell = super.getTableCellRendererComponent(table, value, isSelected, hasFocus, row, column);


        // Alinear la segunda columna al centro (columna indexada en 1)
        if (column == 0 || column == 2) {
            setHorizontalAlignment(SwingConstants.CENTER);
        } else {
            // Alinear las otras columnas a la izquierda (o según el alineamiento predeterminado)
            setHorizontalAlignment(SwingConstants.LEFT);
        }
        

        
        // Obtener el número total de filas en la tabla
        int rowCount = table.getModel().getRowCount();

        // Aplicar formato solo a la última fila
        if (row == rowCount - 1) {
            cell.setFont(cell.getFont().deriveFont(Font.BOLD)); // Poner en negrita
            cell.setBackground(Color.LIGHT_GRAY); // Cambiar color de fondo
        } else {
            // Aplicar formato solo a las columnas
            if (column == 2) {
                cell.setFont(cell.getFont().deriveFont(Font.BOLD)); // Poner en negrita
                cell.setBackground(Color.LIGHT_GRAY); // Cambiar color de fondo
            } else {
                cell.setFont(cell.getFont().deriveFont(Font.PLAIN)); // Quitar negrita
                cell.setBackground(Color.WHITE); // Color de fondo normal
            }
        }

        return cell;
    }
}

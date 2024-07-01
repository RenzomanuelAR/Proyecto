package gui;

import java.awt.Color;
import java.awt.Component;
import java.awt.Font;

import javax.swing.JTable;
import javax.swing.SwingConstants;
import javax.swing.table.DefaultTableCellRenderer;

public class VentasRenderer extends DefaultTableCellRenderer {
    private static final long serialVersionUID = 1L;

    
    public VentasRenderer() {

    }
    
    @Override
    public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected, boolean hasFocus, int row, int column) {
        Component cell = super.getTableCellRendererComponent(table, value, isSelected, hasFocus, row, column);


        // Alinear centro
        if (column == 0 || column == 3 || column == 5) {
            setHorizontalAlignment(SwingConstants.CENTER);
        } else if (column == 4 || column >= 6 && column <= 9) { // Alinear las columnas a la derecha
            setHorizontalAlignment(SwingConstants.RIGHT);
        } else {
            // Alinear las otras columnas a la izquierda (o según el alineamiento predeterminado)
            setHorizontalAlignment(SwingConstants.LEFT);
        }


        // Aplicar formato solo a las columnas
        if (column >= 6 && column <= 9) {
            cell.setFont(cell.getFont().deriveFont(Font.BOLD)); // Poner en negrita
            cell.setBackground(Color.LIGHT_GRAY); // Cambiar color de fondo
        } else {
            cell.setFont(cell.getFont().deriveFont(Font.PLAIN)); // Quitar negrita
            cell.setBackground(Color.WHITE); // Color de fondo normal
        }

        return cell;
    }
}

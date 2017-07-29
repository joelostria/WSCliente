/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package metodos;
import java.awt.Color;
import java.awt.Component;
import javax.swing.JTable;
import javax.swing.table.DefaultTableCellRenderer;

/**
 *
 * @author joel
 */
public class PintarFila extends DefaultTableCellRenderer {
    private int columna ;
    private String cond;
    
    public PintarFila(int Colpatron,String numero)
    {
        this.columna = Colpatron;
        this.cond=numero;
    }
    
    @Override
    public Component getTableCellRendererComponent (JTable table, Object value, boolean selected, boolean focused, int row, int column)
    {        
        setBackground(Color.white);
        table.setForeground(Color.black);
        super.getTableCellRendererComponent(table, value, selected, focused, row, column);
        if(table.getValueAt(row,columna).equals(cond))
        {
            this.setForeground(Color.RED);
        }else{
            this.setForeground(Color.BLACK);
        }
        return this;
      }
    
}

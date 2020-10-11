
import java.awt.Color;
import java.awt.Component;
import javax.swing.JLabel;
import javax.swing.JTable;
import javax.swing.table.DefaultTableCellRenderer;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author 心里的潇洒情
 */
public class MyTableReander extends DefaultTableCellRenderer {
    @Override
    public Component getTableCellRendererComponent(JTable table, Object value,boolean isSelected, boolean hasFocus, int row, int column){
        JLabel label = new JLabel();
        label.setOpaque(true);
        if (isSelected) {//点击表格的时候改变点击的行的背景色
            label.setBackground(new Color(135, 206, 250));
        } 
        else {
            if (row % 2 == 0) {
                    label.setBackground(new Color(240, 250, 250));
            } else {
                    label.setBackground(table.getBackground());
            }
        }
        label.setText(value != null ? value.toString() : "");
        return label;
    }
}

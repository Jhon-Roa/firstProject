package com.firstproject.farmacia.infrastructure.in;

import java.awt.Component;
import java.awt.Image;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JTable;
import javax.swing.table.DefaultTableCellRenderer;

public class ImageCellRenderer extends DefaultTableCellRenderer {
    private int width;
    private int height;

    public ImageCellRenderer(int width, int height) {
        this.width = width;
        this.height = height;
    }

    @Override
    public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected, boolean hasFocus, int row, int column) {
        JLabel label = new JLabel();

        if (value instanceof ImageIcon) {
            ImageIcon imageIcon = (ImageIcon) value;
            // Redimensionar la imagen al tamaño deseado
            Image image = imageIcon.getImage().getScaledInstance(width, height, Image.SCALE_SMOOTH);
            label.setIcon(new ImageIcon(image));
        }

        return label;
    }
}

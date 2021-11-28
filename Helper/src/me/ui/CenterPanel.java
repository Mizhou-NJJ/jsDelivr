package me.ui;

import javax.swing.*;
import java.awt.*;

public class CenterPanel extends HelperJPanel {
    public static JTextArea area;
    private static JScrollPane scrollPane;
    public CenterPanel(){
        super();
        init();
    }
    private void init(){
        setLayout(new BorderLayout());
        area = new JTextArea();
        add(area);
    }

    public static JTextArea getArea() {
        return area;
    }
}

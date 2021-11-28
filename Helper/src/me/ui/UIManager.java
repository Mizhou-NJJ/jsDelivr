package me.ui;

import com.sun.scenario.effect.impl.prism.PrImage;

import javax.swing.*;
import java.awt.*;
import java.io.File;
import java.io.IOException;
import java.util.HashMap;

public class UIManager {

   public static  HashMap<String, Component> mapComponent = new HashMap<>();
   public static final String KEY_ALL = "ALL";
   public static final String KEY_BUTTON = "JBUTTON";
   public static final String KEY_LABEL = "JLABEL";
   public static final String KEY_TEXTAREA = "JTEXTAREA";
   public static final String KEY_JPANEL = "JPANEL";


   private static int keyIdButton =0;
   private static int keyIdLabel = 0;
   private static int keyIdTextArea = 0;
   private static int keyIdJpanel = 0;
   private static int keyIdAll = 0;

   public static void put(Component c){
       mapComponent.put(KEY_ALL+keyIdAll++,c);
   }
    public static JButton newButton(String text){
        JButton button = new JButton(text);
        String key = KEY_BUTTON+keyIdButton;
        mapComponent.put(key,button);

        keyIdButton++;
        return button;
    }
    public static JTextArea newJTextArea(){
        JTextArea area = new JTextArea();
        String key = KEY_TEXTAREA+keyIdTextArea;
        keyIdTextArea++;
        mapComponent.put(key,area);

        return area;
    }

    public static JLabel newJLabel(){
        JLabel l = new JLabel();
        String key = KEY_LABEL+keyIdLabel;
        keyIdLabel++;
        mapComponent.put(key,l);

        return l;

    }
    public static JScrollPane newJScrollPanel(Component c){
       JScrollPane scrollPane = new JScrollPane(c);
       put(scrollPane);
       return scrollPane;
    }
    public static JPanel newJPanel(){
        JPanel jPanel = new JPanel();
        String key = KEY_JPANEL+keyIdJpanel;
        keyIdJpanel++;
        mapComponent.put(key,jPanel);
        return jPanel;
    }
    public static Container getContainer(JFrame frame){
        mapComponent.put("container",frame.getContentPane());
        return frame.getContentPane();
    }

    private static Font font;
    public static Font jfOpenTTF(){
        if (font==null){
            File f=new File("jf-open.ttf");
            if (!f.exists()) f=new File("/jf-open.ttf");
            try {
                font= Font.createFont(Font.TRUETYPE_FONT,f);
            } catch (FontFormatException | IOException e) {
                e.printStackTrace();
            }
        }
        return font;
    }
    public static void loadIndyFont(Font font){
        javax.swing.UIManager.put("CheckBox.font",font);
        javax.swing.UIManager.put("Tree.font", font);
        javax.swing.UIManager.put("Viewport.font", font);
        javax.swing.UIManager.put("ProgressBar.font", font);
        javax.swing.UIManager.put("RadioButtonMenuItem.font", font);
        javax.swing.UIManager.put("FormattedTextField.font", font);
        javax.swing.UIManager.put("Panel.font",font);
        javax.swing.UIManager.put("Panel.background",Style.WHITE);
        javax.swing.UIManager.put("TextArea.font",font);
        javax.swing.UIManager.put("TextArea.background", Style.WHITE);
        javax.swing.UIManager.put("Menu.background", Style.WHITE);
        javax.swing.UIManager.put("Menu.font", font);
        javax.swing.UIManager.put("RadioButtonMenuItem.acceleratorFont",font);
        javax.swing.UIManager.put("Menu.acceleratorFont",font);
        javax.swing.UIManager.put("CheckBoxMenuItem.acceleratorFont",font);
        javax.swing.UIManager.put("TableHeader.font", font);
        javax.swing.UIManager.put("TextField.font", font);
        javax.swing.UIManager.put("OptionPane.font", font);
        javax.swing.UIManager.put("MenuBar.font", font);
        javax.swing.UIManager.put("MenuBar.background", Style.WHITE);
//        javax.swing.UIManager.put("Button.font", font);
        javax.swing.UIManager.put("Label.font", font);
        javax.swing.UIManager.put("PasswordField.font",font);
        javax.swing.UIManager.put("OptionPane.buttonFont", font);
        javax.swing.UIManager.put("ScrollPane.font", font);
        javax.swing.UIManager.put("MenuItem.font", font);
        javax.swing.UIManager.put("ToolTip.font", font);
        javax.swing.UIManager.put("List.font", font);
        javax.swing.UIManager.put("OptionPane.messageFont",font);
        javax.swing.UIManager.put("EditorPane.font", font);
        javax.swing.UIManager.put("Table.font", font);
        javax.swing.UIManager.put("TabbedPane.font",font);
        javax.swing.UIManager.put("RadioButton.font", font);
        javax.swing.UIManager.put("CheckBoxMenuItem.font",font);
        javax.swing.UIManager.put("TextPane.font", font);
        javax.swing.UIManager.put("PopupMenu.font", font);
        javax.swing.UIManager.put("TitledBorder.font", font);
        javax.swing.UIManager.put("ComboBox.font", font);
    }


}

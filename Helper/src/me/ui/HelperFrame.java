package me.ui;

import me.conf.Conf;
import me.conf.FileR;
import me.conf.RWConf;
import me.util.Util;

import javax.swing.*;
import javax.swing.plaf.ScrollPaneUI;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public class HelperFrame extends JFrame {
    public static HelperFrame currentHF;
    private Container container;

    private MenuBar menuBar;
    private Menu menuFile,menuEditor,menuTheme;


    private JPanel pNorth,pWest,pEast,pSouth,pCenter;
    /*
    *
    *
    * */
    public static FileR currentFile; // 保存当前打开的文件路径,
    public static byte [] currentFileByte;
    public HelperFrame(String title){
        super(title);
        currentHF = this;
        init();
    }
    void init(){
        Font font= UIManager.jfOpenTTF().deriveFont(12f);
        UIManager.loadIndyFont(font);
        setSize(Conf.APP_DEFAULT_WIDTH,Conf.APP_DEFAULT_HEIGHT);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        ui();

    }
    void ui(){
       container = UIManager.getContainer(this);
       container.setLayout(new BorderLayout());
       container.setBackground(Style.WHITE);

       pCenter = new CenterPanel();
       JScrollPane scrollPane = UIManager.newJScrollPanel(pCenter);
       WestPanel wp = new WestPanel();
       EastPanel es = new EastPanel();
       pSouth = new SouthPanel();
       container.add(pSouth,BorderLayout.SOUTH);
       container.add(es,BorderLayout.EAST);
       container.add(wp,BorderLayout.WEST);
       container.add(scrollPane,BorderLayout.CENTER);
       menu();
//       CenterPanel.getArea().setText(RWConf.readBinaryFile("d:\\OS\\tmp\\main.tmp").toString());
//       CenterPanel.getArea().setBackground(Style.DRACULA_ORCHID);
//       CenterPanel.getArea().setForeground(Style.EMERALD);

//       areaMain.setText(RWConf.open(this).toString());
        for(String key: UIManager.mapComponent.keySet()){
            Component c = UIManager.mapComponent.get(key);
            if (c instanceof JPanel){
                c.setBackground(Style.WHITE);
            }
            if (c instanceof JButton){
                c.setBackground(Style.LIGHT_RED);
            }
        }

    }

    void menu(){
        menuBar = new MenuBar();

        menuFile = new Menu("File");
        menuEditor = new Menu("Editor");
        menuTheme = new Menu("Theme");
        MenuItem itemOpenFile = new MenuItem("Open-File");
        MenuItem itemSave = new MenuItem("Save");
        MenuItem itemSaveAs = new MenuItem("SaveAs");
        itemOpenFile.addActionListener(new ItemMenuAc());
        menuFile.add(itemOpenFile);
        menuFile.add(itemSave);
        menuFile.add(itemSaveAs);
        menuBar.add(menuFile);
        menuBar.add(menuEditor);
        menuBar.add(menuTheme);
        setMenuBar(menuBar);
    }
    class ItemMenuAc implements ActionListener{

        @Override
        public void actionPerformed(ActionEvent e) {
            if (e.getActionCommand().equals("Open-File")){
                
              currentFile =  RWConf.openToString(HelperFrame.currentHF);
              if (currentFile!=null) {
                  currentFileByte = RWConf.readFileToBinary(currentFile.folder+currentFile.fileName);
                  CenterPanel.getArea().setText(Util.toTerminalString(currentFileByte).toString());
              }
            }
        }
    }

}

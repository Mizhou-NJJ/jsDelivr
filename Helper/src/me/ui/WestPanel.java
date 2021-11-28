package me.ui;

import me.util.Util;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.nio.ByteOrder;

public class WestPanel extends HelperJPanel {
    private JPanel panelItem1,panelItem2;
    private int piw = 100,pih=50; // panelItem size;
    private JButton btnFillByn;
    private JButton btnFillTon;

    public WestPanel(){

        setLayout(new GridLayout(6,1,10,10));

        init();
    }
    void init(){
        panelItem1 = UIManager.newJPanel();
        panelItem2 =UIManager.newJPanel();
        panelItem1.setLayout(new FlowLayout(FlowLayout.LEFT,10,10));
        panelItem2.setLayout(new FlowLayout(FlowLayout.LEFT,10,10));
        btnFillByn = UIManager.newButton("从末尾填充N个字节");
        btnFillByn.setActionCommand("btnfillbyn");
        btnFillTon = UIManager.newButton("从末尾填充至N");
//        JButton jButton2 = UIManager.newButton("gcc-s");
//        JButton jButton3 = UIManager.newButton("gcc -c");
//        jButton1.setAlignmentX(1.3f);
        panelItem1.add(btnFillByn);
        btnFillByn.addActionListener(new BtnClickL());
        panelItem2.add(btnFillTon);
//        panelItem1.add(jButton2);
//        panelItem2.add(jButton3);
        add(panelItem1);
        add(panelItem2);

        // -------------Add -this -----

    }
    class BtnClickL implements ActionListener{

        @Override
        public void actionPerformed(ActionEvent e) {
            if (e.getActionCommand().equals("btnfillbyn")){ // 从末尾填充N个字节
//                JPanel p = UIManager.newJPanel();
//                p.setLayout(new BorderLayout());
                JPanel panel = UIManager.newJPanel();
                panel.setLayout(new GridLayout(2,2));
                JTextField fOffset = new JTextField();
                JTextField fByte = new JTextField();
                JLabel flabel = new JLabel("offset");
                JLabel blabel = new JLabel("byte");
//                flabel.setBounds(10,10,50,50);
                panel.add(flabel);
//                fOffset.setBounds(70,10,100,50);
                panel.add(fOffset);
//                blabel.setBounds(10,70,50,50);
                panel.add(blabel);
//                fByte.setBounds(70,70,100,50);
                panel.add(fByte);
//                panel.setSize(new Dimension(200,200));
                int c=JOptionPane.showConfirmDialog(HelperFrame.currentHF,panel);
               if (c==0){
                   String offset = fOffset.getText();
                   String cbyte = fByte.getText();
                   int pv = 0;
                   int pbyte=0;
                   try {
                       pv = Integer.parseInt(offset);
                       pbyte = Integer.parseInt(cbyte);
                   }catch (Exception ee){
//                       try {
//                           pv = Integer.parseInt(offset,16);
//                           pbyte = Integer.parseInt(cbyte,16);
//                       }catch (NumberFormatException eee){
                           JOptionPane.showMessageDialog(HelperFrame.currentHF,"Error input!");
//                       }
                   }
                   if (pbyte>255){
                       JOptionPane.showMessageDialog(HelperFrame.currentHF,"Error input! Byte>255");

                   }else{
                       if (HelperFrame.currentFileByte==null) JOptionPane.showMessageDialog(HelperFrame.currentHF,"Please open file only!");
                       else {
                           byte [] wb =Util.fillByteByN(HelperFrame.currentFileByte,pv,pbyte);
                           CenterPanel.getArea().setText(Util.toTerminalString(wb).toString());
                       }
                   }


               }
               
//
            }
        }
    }
}

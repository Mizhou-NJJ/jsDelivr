package me.ui;

import me.Main;
import me.conf.FileR;
import me.conf.RWConf;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class SouthPanel extends HelperJPanel {
    private JPanel panelItemWest;
    private JButton btnArchiveHeader;
    private JButton btnFullContent;
    public SouthPanel(){
        setLayout(new BorderLayout());
        init();
    }
    void init(){
        panelItemWest = UIManager.newJPanel();

        panelItemWest.setLayout(new GridLayout(6,6,10,10));
        btnArchiveHeader = UIManager.newButton("填充字节");
        btnFullContent = UIManager.newButton("从末尾填充");
        btnArchiveHeader.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                FileR r = RWConf.open(HelperFrame.currentHF);
//                HelperFrame.areaMain.setText(Main.exeCmd("make "+r.folder+r.fileName).toString());
            }
        });
        panelItemWest.add(btnArchiveHeader);
        panelItemWest.add(btnFullContent);
        add(panelItemWest,BorderLayout.WEST);
    }
}

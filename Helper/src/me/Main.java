package me;

import me.conf.RWConf;
import me.ui.HelperFrame;

import javax.swing.*;
import java.awt.*;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.nio.charset.Charset;

public class Main{
    public static void main(String[] args) {

        HelperFrame hf = new HelperFrame("Helper");
//        FileDialog fileDialog = new FileDialog(hf);
        hf.setVisible(true);
//        fileDialog.setVisible(true);
       // RWConf.readBinaryFile("d:\\OS\\tmp\\main.bin");
    }

    public static StringBuilder exeCmd(String commandStr) {
        BufferedReader br = null;
        StringBuilder sb = new StringBuilder();
        boolean isError = false;
        try {
            Process p = Runtime.getRuntime().exec(commandStr);

            br = new BufferedReader(new InputStreamReader(p.getInputStream(), Charset.forName("GBK")));
            String line = null;
            while ((line = br.readLine()) != null) {

                sb.append(line + "\n");
            }

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (br != null){
                try {
                    br.close();
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }
        return sb;
    }
}
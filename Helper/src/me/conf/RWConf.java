package me.conf;

import me.util.Util;

import java.awt.*;
import java.io.*;
import java.util.ArrayList;
import java.util.HashMap;

public class RWConf {
    public RWConf(){

    }

    void readConf() throws IOException {
        File file = new File(Conf.CONF_DEFAULT_PATH);
        BufferedReader br = null;
        FileReader fr = null;
        if (file.exists()){
            fr = new FileReader(file);
            br = new BufferedReader(fr);
            String line = null;
            String [] kv;
            HashMap<String,String> hm = new HashMap<>();
            while ((line = br.readLine())!=null){
                kv = line.split("=");
                hm.put(kv[0],kv[1]);
            }
        }else {

        }
    }
    public static FileR openToString(Frame jf){
        FileDialog fdopen = new FileDialog(jf, "打开", FileDialog.LOAD);
        String s;
        FileR fileR =null;
        fdopen.setVisible(true);

        if (fdopen.getDirectory()==null||fdopen.getFile()==null) return null;
        else {
            fileR = new FileR();
            fileR.folder = fdopen.getDirectory();
            fileR.fileName = fdopen.getFile();
        }
        return fileR;
    }
    public static FileR open(Frame jf) {
        FileDialog fdopen = new FileDialog(jf, "打开", FileDialog.LOAD);
        FileR fileR = new FileR();
        fdopen.setVisible(true);
        StringBuilder sb = new StringBuilder();
        BufferedReader in =null;
        try {
            in= new BufferedReader(new FileReader(fdopen.getDirectory() + fdopen.getFile()));

            String str = null;
            while((str = in.readLine()) != null) {
                sb.append(str+"\n");
            }
            fileR.stringBuilder = sb;
            fileR.folder = fdopen.getDirectory();
            fileR.fileName = fdopen.getFile();

        }catch (Exception e){
            System.out.println(e);

        }finally {
            try {
                if (in!=null) in.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        return fileR;
    }
    public static byte[] readFileToBinary(String fp){

        File file = new File(fp);
        FileInputStream fis = null;
        BufferedInputStream bif = null;
        byte [] bs = new byte[(int) file.length()];
        try {
            fis = new FileInputStream(file);
            bif = new BufferedInputStream(fis);
            int temp;
            int index=0;
            System.out.println();
            while ((temp=bif.read())!=-1){
                if (temp>127){
                    /*
                    *  如果 temp>127 说明temp的第8位为1,而java的byte范围为 -128-127
                    *
                    * */
                    temp&=0b0111_1111;
//                    System.out.print(temp);
//                    System.out.print("-");
                    bs[index] = Byte.parseByte(Integer.toString(temp));
                    bs[index]|= 0b1000_0000;
                }
                else {
                    bs[index] = Byte.parseByte(Integer.toString(temp));
                }

                ++index;
            }


        }catch (Exception e){
            e.printStackTrace();
        }finally {
            try {
                assert bif != null;
                bif.close();
                fis.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        return bs;
    }
//    public static StringBuilder readBinaryFile(String fp){
//        File file = new File(fp);
//        FileInputStream fis = null;
//
//        BufferedInputStream bif = null;
//        StringBuilder sb = null;
//        try {
//
//            fis = new FileInputStream(file);
//            bif = new BufferedInputStream(fis);
//            int temp;
//            sb = new StringBuilder();
//            int wrapCount = 0;
//            int [] ts = new int[16];
//            int i=0;
//            String blank = "     ";
//            String s ="";
//            int offset = 0;
//            int offssetlen = 8;
//            while ((temp=bif.read())!=-1){
//                ts[i++] = temp;
//
//                if (wrapCount%4==0){
//                    s+= blank;
//                }
//                wrapCount++;
//                s+=Util.toLenHex(2,temp);
////                sb.append(Util.toLenHex(2,temp));
//                if (wrapCount>15){
//                    wrapCount = 0;
//                    sb.append(Util.toLenHex(8,offset));
//                    offset+=16;
//                    sb.append(s);
//                    sb.append(blank);
//                    sb.append(Util.toAsciis(ts,i));
//                    sb.append("\n");
//                    s="";
//                    i=0;
//                }
//            }
//            sb.append(Util.toLenHex(offssetlen,offset));
//            sb.append(s);
//            sb.append(blank);
//            int bc= (32+blank.length()*4)-((i%4)*blank.length()+i*2);
//            for (int x=0;x<bc;x++){
//                sb.append("  ");
//            }
//            sb.append(Util.toAsciis(ts,i));
//        }catch (Exception e){
//            e.printStackTrace();
//        }finally {
//            try {
//                assert bif != null;
//                bif.close();
//                fis.close();
//            } catch (IOException e) {
//                e.printStackTrace();
//            }
//        }
//        return sb;
//    }

}

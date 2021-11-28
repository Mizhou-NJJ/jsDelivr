package me.util;

public class Util {
    public static String toLenHex(int len,int v){
        String s = Integer.toHexString(v);
        if (s.length()<len){
            for (int i=s.length();i<len;i++){
                s = "0" + s;
            }
        }
//        if (s.length()<2) s = "0" +s;
//        byte [] bs = new byte[10];

        return s.toUpperCase();
    }

    public static String toAscii(int b) {
        String s;
        if (b>=32&&b<=126){
            s = Character.toString((char)b);
        }else {
            s=" . ";
        }
        return s;
    }
    public static String toAsciis(int [] sbs,int offset){
        StringBuilder s = new StringBuilder();
        for (int i=0;i<offset;i++){
            s.append(toAscii(sbs[i]));
        }
        return s.toString();
    }

    public static StringBuilder toTerminalString(byte []bytes){
        String s ="";
        StringBuilder builder = new StringBuilder();
        builder.append("---------------------------Size: "+bytes.length+" Byte---------------------------\n\n\n");
        int offset = 0;
        int offset_len = 8;
        int [] ts = new int[16];
        int to = 0;
        int soff =0;
        String blank = "     ";

        for (int i=0;i<bytes.length;i++) {

            if (to>15){
               builder.append(toLenHex(offset_len,offset));
               builder.append(blank);
               builder.append(s);
               builder.append(blank);
               builder.append(toAsciis(ts,to));
               offset+=16;
               soff = 0;
               to=0;
               builder.append("\n");
               s="";
            }

            s+=toLenHex(2,bytes[i]&0b1111_1111);
            soff+=2;
            ts[to] = bytes[i];
            ts[to]&=0b1111_1111;
            to++;
            if (to%4==0){
                s += blank;
                soff+=blank.length();
            }

        }
        builder.append(Util.toLenHex(offset_len,offset));
        builder.append(blank);
        builder.append(s);
        builder.append(blank);
        int bc= (32+blank.length()*4)-((to/4)*blank.length()+to*2);
        for (int x=0;x<bc;x++){
            builder.append("  ");
        }
        builder.append(Util.toAsciis(ts,to));
        return builder;
    }

    public static byte[] fillByteByN(byte [] obs,int n,int b){
        byte newb [] = new byte[obs.length+n];
        int i=0;
        for (i=0;i<obs.length;i++){
            newb[i] = obs[i];
        }
        for (int v=0;v<n;v++,i++){
            if (b>127){
                b&=0b0111_1111;
                newb[i] = (byte) b;
                newb[i]|=0b1000_0000;
            }else {
                newb[i]= (byte) b;
                System.out.print(b&1111_1111);
            }
        }
        return newb;
    }
}

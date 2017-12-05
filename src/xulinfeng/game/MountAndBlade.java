package xulinfeng.game;

import java.io.*;
import java.net.SocketTimeoutException;
import java.util.LinkedList;
import java.util.List;

/**
 * Created by xujiahong on 2017/11/22.
 * ======================功能列表======================
 */
public class MountAndBlade {

    public static void main(String[] args) throws Exception {

        List<String> list = new LinkedList<String>();

        String filePath = "C:\\Users\\xujiahong\\Desktop\\temp\\troops.txt";
        String outPath = "C:\\Users\\xujiahong\\Desktop\\temp\\troops.txt";
        BufferedReader br = new BufferedReader(new InputStreamReader
                (new FileInputStream(new File(filePath)),"UTF-8"));

        String lineTxt = null;
        while ((lineTxt = br.readLine()) != null) {
            list.add(lineTxt);
        }

        br.close();

        int npcs = 0;

        try {
            BufferedWriter bw = new BufferedWriter(new OutputStreamWriter
                    (new FileOutputStream(new File(outPath)),"UTF-8"));

            int flag = 0;
            for(String s : list){
                if(s.contains("trp_npc") || s.contains("trp_caravan_master")
                        || s.contains("trp_player")){
                    flag++;
//                    System.out.println("【"+flag+"】"+s);
                }else{
                    if(flag!=0){
                        flag++;
//                        System.out.println("【"+flag+"】"+s);
                    }
                }
                if(flag==3){
                    npcs++;
                    flag = 0;
                    s = "  666 66 1 666 1";
                }

                bw.write(s);
                bw.newLine();
            }
            bw.close();
        } catch (Exception e) {
            System.err.println("write errors :" + e);
        }

        System.out.println(npcs+"条数据已修改===============");
    }
}

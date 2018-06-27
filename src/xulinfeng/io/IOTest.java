package xulinfeng.io;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;

/**
 * Created by xujiahong on 2017/12/26.
 * ======================功能列表======================
 */
public class IOTest {
    public static void main(String[] args) throws Exception {
        File file = new File("C:\\Users\\xujiahong\\Desktop\\temp\\iotest.txt");
        InputStream in  = new FileInputStream(file);
        System.out.println(file);
        System.out.println(in);
    }
}

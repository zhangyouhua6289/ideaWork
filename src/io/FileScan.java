package io;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

/**
 * @author zyh
 * @date 2020/6/18
 */
public class FileScan {
    private static List<String> fileNames = new ArrayList<String>();

    public static void main(String[] args) {
        String filePath = "D:\\交易文件\\20200529";
        scan(new File(filePath), 0);
        fileNames.stream().forEach(s -> print(s));
        // System.out.println(String.format("%0" + 1 + "s", "0"));

    }

    public static void scan(File file, int num) {
        if (file.exists()) {
            if (file.isDirectory()) {
                add(num, file);
                num++;
                File[] files = file.listFiles();
                for (File f : files) {
                    scan(f, num);
                }
            } else if (file.isFile()) {
                add(num, file);
            }
        }
    }

    public static void add(int num, File f) {
        if (num == 0) {
            fileNames.add("*" + f.getName());
        } else {
            if (f.isDirectory()) {
                fileNames.add(String.format("%0" + (5 * num + 1) + "d", 0) + "*" + f.getName());
            } else {
                fileNames.add(String.format("%0" + (5 * num + 1) + "d", 0) + "*" + f.getName());
            }

        }
    }

    public static void print(String s) {
        int index = s.indexOf("*");
        String repStr = s.substring(0, index);
        System.out.println(repStr.replaceAll("0", "-").concat(s.substring(index + 1)));
    }
}

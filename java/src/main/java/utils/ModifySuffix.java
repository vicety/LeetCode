package utils;

import java.io.File;

public class ModifySuffix {
    public static void main(String[] args) {
        String basePath = "F:\\Pictures\\HACG\\琉璃神社壁纸包 2019年12月号\\";
        String suffix = ".bc!";
        int cnt = 0;
        File dir = new File(basePath);
        if (!dir.isDirectory()) {
            System.out.println("not dir");
            return;
        }
        File[] files = dir.listFiles();
        System.getProperties().getProperty("user.dir", basePath);
        for (File file : files) {
            String fileName = file.getName();
            if (fileName.endsWith(suffix)) {
                fileName = fileName.replace(suffix, "");
                file.renameTo(new File(basePath + fileName));
                cnt++;
            }
        }
        System.out.println(String.format("Processed %d files.", cnt));
    }
}

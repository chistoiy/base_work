package com.test.fileOperate_09;

/*
   listFiles()有一个带过滤器的方法，该过滤器是对当前所有的路径校验，不包含关键字的返回false，该路径就不会放置于file[]内
* */
import java.io.File;
import java.io.FileFilter;

public class DiGuiFileFilter02 {
    public static void main(String[] args) {
        System.out.println(nCal(10));
        System.out.println(nMul(3));

        File file = new File("D:\\workplace\\for_java\\base_work\\fun_test\\src\\com\\test");

        //dirFile(file);
        //dirFileSeacher(file,"Test");
        //dirFileSeacherAdvance(file);
        dirFileSeacherAdvance02(file);
    }

    static int nCal(int num) {
        if (num == 1) {
            return num;
        }

        return num + nCal(num - 1);
    }

    static int nMul(int num) {
        if (num == 1) {
            return 1;
        }
        return num * nMul(num - 1);
    }

    static void dirFile(File file) {
        //File[] files = file.listFiles();
        for (File f : file.listFiles()) {
            if (f.isDirectory()) {
                dirFile(f);
            } else {
                System.out.println(f.getName());

            }
        }


    }

    static void dirFileSeacher(File file, String name) {
        //File[] files = file.listFiles();
        for (File f : file.listFiles()) {
            if (f.isDirectory()) {
                dirFileSeacher(f, name);
            } else {
                if (f.getName().contains(name)) {
                    System.out.println(f.getParent() + ":");
                    System.out.println("      " + f.getName());
                }
            }
        }
    }

    static void dirFileSeacherAdvance(File file) {
        //File[] files = file.listFiles();
        File[] files = file.listFiles(new FileFilterImpl());
        for (File f : files) {
            if (f.isDirectory()) {
                dirFileSeacherAdvance(f);
            } else {
                System.out.println(f.getParent() + ":");
                System.out.println("      " + f.getName());
            }
        }
    }

    static void dirFileSeacherAdvance02(File file) {
        //File[] files = file.listFiles();
        File[] files = file.listFiles((pathname)-> pathname.isDirectory()|| pathname.getName().contains("Test") );
        for (File f : files) {
            if (f.isDirectory()) {
                dirFileSeacherAdvance02(f);
            } else {
                System.out.println(f.getParent() + ":");
                System.out.println("      " + f.getName());
            }
        }
    }


}

class FileFilterImpl implements FileFilter {

    @Override
    public boolean accept(File pathname) {
        //System.out.println(pathname);
        if(pathname.isDirectory()){
            return true;
        }
        if (pathname.getName().contains("Test")) {
            //System.out.println(pathname);
            return true;
        }
        return false;

    }
}

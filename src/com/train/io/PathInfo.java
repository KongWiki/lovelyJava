package com.train.io;

import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

/**
 * @Time: 19-12-6下午8:37
 * @Author: kongwiki
 * @Email: kongwiki@163.com
 */
public class PathInfo {
    static void show(String id, Object p){
        System.out.println(id + ": " + p);
    }

    static void info(Path p){
        show("toString", p);
        show("Exists", Files.exists(p));
        show("RegularFile", Files.isRegularFile(p));
        show("Directory", Files.isDirectory(p));
        show("Absolute", p.isAbsolute());
        show("FileName", p.getParent());
        show("Parent", p.getParent());
        show("Root", p.getRoot());
        System.out.println("***************************");
    }

    public static void main(String[] args) {
        System.out.println(System.getProperty("os.name"));
//        info(Paths.get(""));
//        info(Paths.get("/home", "kongweikun","IdeaProjects", "JavaTrain"));
        Path p = Paths.get("PathInfo.java");
        info(p);
    }

}

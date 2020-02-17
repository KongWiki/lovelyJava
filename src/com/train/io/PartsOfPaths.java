package com.train.io;

import java.nio.file.Path;
import java.nio.file.Paths;

/**
 * @Time: 19-12-6下午9:10
 * @Author: kongwiki
 * @Email: kongwiki@163.com
 */
public class PartsOfPaths {
    public static void main(String[] args) {
        System.out.println(System.getProperty("os.name"));
        Path p = Paths.get("PartsOfPaths.java").toAbsolutePath();
        for(int i=0; i<p.getNameCount(); i++){
            System.out.print(p.getName(i) + " ");
        }
        System.out.println("ends with '.java': " + p.endsWith(".java"));
        for (Path path : p) {
            System.out.print(path + ": ");
            System.out.print(p.startsWith(path) + " : ");
            System.out.println(p.endsWith(path));

        }
        System.out.println("starts with" + p.getRoot() + " " + p.startsWith(p.getRoot()));

    }
}

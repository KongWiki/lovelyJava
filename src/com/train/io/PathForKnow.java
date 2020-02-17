package com.train.io;

import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

/**
 * @Time: 19-12-28下午12:23
 * @Author: kongwiki
 * @Email: kongwiki@163.com
 */
public class PathForKnow {
    public static void main(String[] args) {
        Path absolute = Paths.get("/home", "kongweikun", "IdeaProjects", "JavaTrain", "src/com/tran/io/PathForKnow.java");
        Path parent = absolute.getParent();
        Path file= absolute.getFileName();
        Path root = absolute.getRoot();
        System.out.println("parent=" + parent + " file=" + file + " root=" + root);
        System.out.println(Files.exists(absolute));

    }
}

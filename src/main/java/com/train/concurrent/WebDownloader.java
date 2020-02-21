package com.train.concurrent;

import org.apache.commons.io.FileUtils;

import java.io.File;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;

/**
 * @Time: 20-2-21上午11:53
 * @Author: kongwiki
 * @Email: kongwiki@163.com
 */
public class WebDownloader {
    public void downloader(String url, String file){
        try {
            FileUtils.copyURLToFile(new URL(url), new File(file));
        } catch (IOException e) {
            e.printStackTrace();
            System.out.println("IO异常 downloader方法出现问题");
        }
    }
}

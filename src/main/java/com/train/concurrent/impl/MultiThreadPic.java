package com.train.concurrent.impl;

import com.train.concurrent.WebDownloader;

/**
 * @Time: 20-2-21上午11:50
 * @Author: kongwiki
 * @Email: kongwiki@163.com
 */
public class MultiThreadPic extends Thread {
    public String name;
    public String url;

    public MultiThreadPic(String url, String name) {
        this.url = url;
        this.name = name;
    }

    @Override
    public void run() {
        WebDownloader downloader = new WebDownloader();
        downloader.downloader(url, name);
        System.out.println("文件" + name + "下载完成");
    }

    public static void main(String[] args) {
        MultiThreadPic threadPic1 = new MultiThreadPic("https://image.baidu.com/search/detail?ct=503316480&z=undefined&tn=baiduimagedetail&ipn=d&word=%E5%9B%BE%E7%89%87&step_word=&ie=utf-8&in=&cl=2&lm=-1&st=undefined&hd=undefined&latest=undefined&copyright=undefined&cs=1035415831,1465727770&os=2036467054,2328224179&simid=4030878874,470441821&pn=0&rn=1&di=8140&ln=1682&fr=&fmq=1582258073341_R&fm=&ic=undefined&s=undefined&se=&sme=&tab=0&width=undefined&height=undefined&face=undefined&is=0,0&istype=0&ist=&jit=&bdtype=0&spn=0&pi=0&gsm=0&objurl=http%3A%2F%2Fa3.att.hudong.com%2F68%2F61%2F300000839764127060614318218_950.jpg&rpstart=0&rpnum=0&adpicid=0&force=undefined&ctd=1582258074697^3_1351X636%1", "1.jpg");
        MultiThreadPic threadPic2 = new MultiThreadPic("https://image.baidu.com/search/detail?ct=503316480&z=undefined&tn=baiduimagedetail&ipn=d&word=%E5%9B%BE%E7%89%87&step_word=&ie=utf-8&in=&cl=2&lm=-1&st=undefined&hd=undefined&latest=undefined&copyright=undefined&cs=1035415831,1465727770&os=2036467054,2328224179&simid=4030878874,470441821&pn=0&rn=1&di=8140&ln=1682&fr=&fmq=1582258073341_R&fm=&ic=undefined&s=undefined&se=&sme=&tab=0&width=undefined&height=undefined&face=undefined&is=0,0&istype=0&ist=&jit=&bdtype=0&spn=0&pi=0&gsm=0&objurl=http%3A%2F%2Fa3.att.hudong.com%2F68%2F61%2F300000839764127060614318218_950.jpg&rpstart=0&rpnum=0&adpicid=0&force=undefined&ctd=1582258074697^3_1351X636%1", "2.jpg");
        MultiThreadPic threadPic3 = new MultiThreadPic("https://image.baidu.com/search/detail?ct=503316480&z=undefined&tn=baiduimagedetail&ipn=d&word=%E5%9B%BE%E7%89%87&step_word=&ie=utf-8&in=&cl=2&lm=-1&st=undefined&hd=undefined&latest=undefined&copyright=undefined&cs=1035415831,1465727770&os=2036467054,2328224179&simid=4030878874,470441821&pn=0&rn=1&di=8140&ln=1682&fr=&fmq=1582258073341_R&fm=&ic=undefined&s=undefined&se=&sme=&tab=0&width=undefined&height=undefined&face=undefined&is=0,0&istype=0&ist=&jit=&bdtype=0&spn=0&pi=0&gsm=0&objurl=http%3A%2F%2Fa3.att.hudong.com%2F68%2F61%2F300000839764127060614318218_950.jpg&rpstart=0&rpnum=0&adpicid=0&force=undefined&ctd=1582258074697^3_1351X636%1", "3.jpg");
        threadPic1.start();
        threadPic2.start();
        threadPic3.start();
    }
}

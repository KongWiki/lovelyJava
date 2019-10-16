package com.tran.Timer;

import sun.rmi.runtime.Log;

import java.awt.*;
import java.awt.event.*;
import java.util.*;
import javax.swing.*;
import javax.swing.Timer;
import java.util.Date;
import java.util.logging.Logger;

/**
 * @Time: 19-10-15下午7:40
 * @Author: kongwiki
 * @Email: kongwiki@163.com
 */
public class TimerTest {
    public static void main(String[] args) {
        ActionListener listener = new TimePrinter();

        Timer t = new Timer(1000, listener);
        t.start();
        Logger.getGlobal().info("write a alarm");
        JOptionPane.showMessageDialog(null, "quit program?");
        System.exit(0);
    }
}

class TimePrinter implements ActionListener{

    @Override
    public void actionPerformed(ActionEvent e) {
        System.out.println("At the tone, the time is" +  new Date());
        Toolkit.getDefaultToolkit().beep();
    }
}

package com.company.window;

import com.company.util.Util;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.IOException;

public class Window {
    public static void createWindow() {

        JFrame frame = new JFrame("Simple GUI");
        JButton button = new JButton("run");
        JTextField jTextField = new JTextField();
        JTextArea area = new JTextArea();
        button.setSize(100, 100);
        frame.add(area, BorderLayout.CENTER);
        button.addActionListener(new ActionListener() {


            @Override
            public void actionPerformed(ActionEvent e) {
                System.out.println("run run run!");
                String progName = jTextField.getText();
                System.out.println(progName);
                Util.directory(new File("C:\\Program Files (x86)"), progName);
                if (Util.programFile == null) {
                    Util.directory(new File("C:\\Program Files"), progName);
                    if (Util.programFile == null) {
                        Util.directory(new File("D:\\"), progName);
                       /* if (Util.programFile == null) {
                            Util.directory((new File("C:\\Users")), progName);
                        }*/
                    }

                }

                if (Util.programFile != null) {

                    try {
                        Runtime.getRuntime().exec(Util.programFile.getAbsolutePath());
                        Util.programFile = null;
                    } catch (IOException ex) {
                        ex.printStackTrace();
                    }
                    jTextField.setText(null);
                } else {
                    System.out.println("not found");
                    area.setText("File is not found");
                    jTextField.setText(null);
                }
            }
        });
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(500, 300);
        frame.add(button, BorderLayout.CENTER);
        frame.add(jTextField, BorderLayout.SOUTH);
        frame.setVisible(true);


    }
}

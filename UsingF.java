package com.company;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class UsingF extends JFrame {
    private Container A;
    private JPanel JP = new JPanel();
    private JMenuBar JMB = new JMenuBar();
    private JMenu JMF = new JMenu("File");
    private JMenu JMG = new JMenu("Game");
    private JMenu JMT = new JMenu("Tool");
    private JMenu JMH = new JMenu("Help");
    private JMenuItem JIO = new JMenuItem("Open");
    private JMenuItem JIC = new JMenuItem("Close");
    private JMenuItem JIE = new JMenuItem("Exit");
    private JMenuItem JIOX = new JMenuItem("O and X");
    private JMenuItem JIEn = new JMenuItem("Encrypt");
    public UsingF(){
        King();
    }
    private void King(){
        A = this.getContentPane();
        this.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);

        A.setLayout(new BorderLayout(9,9));
        A.setBounds(500,200,500,600);
        this.setBounds(500,200,500,600);

        A.add(JMB,BorderLayout.NORTH);
        A.add(JP,BorderLayout.CENTER);

        JMB.add(JMF);
        JMB.add(JMG);
        JMB.add(JMT);
        JMB.add(JMH);

        JMF.add(JIO);
        JMF.add(JIC);
        JMF.add(JIE);

        JMG.add(JIOX);
        JMT.add(JIEn);

        JIE.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.exit(0);
            }
        });
        JIOX.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
            Ex20180920_CircleF CF = new Ex20180920_CircleF(UsingF.this);
                setVisible(false);
                CF.setVisible(true);
            }
        });
        JIEn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                EncryptF EF = new EncryptF(UsingF.this);
                setVisible(false);
                EF.setVisible(true);
            }
        });
    }
}

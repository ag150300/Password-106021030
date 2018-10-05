package com.company;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

public class EncryptF extends JFrame {
    private Container A;
    private JPanel JP = new JPanel();
    private JTextArea JTAL = new JTextArea("幾個："+"\n"+"加多少："+"\n"+"加密文字："+"\n"+"<<上方請刪除>>");
    private JTextArea JTAR = new JTextArea("");
    String[] inJCB = {"Caesar","DES"};
    private JComboBox JCB = new JComboBox(inJCB);
    private JScrollPane JSPL = new JScrollPane(JTAL);
    private JScrollPane JSPR = new JScrollPane(JTAR);
    private JRadioButton Encrypt = new JRadioButton("Encrypt");
    private JRadioButton Decrypt = new JRadioButton("Decrypt");
    private ButtonGroup BG = new ButtonGroup();
    private JLabel Method = new JLabel("Method");
    private JLabel Password = new JLabel("Password");
    private JTextField inPassword = new JTextField("");
    private JButton Run = new JButton("Run");
    private JButton Close = new JButton("Close");

    public EncryptF(UsingF UF){
        Ruwen(UF);
    }
    private void Ruwen(UsingF UF){
        A = this.getContentPane();
        this.setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);

        this.addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
                UsingF UF = new UsingF();
                setVisible(false);
                UF.setVisible(true);
            }
        });

        A.setLayout(new BorderLayout(3,3));
        A.setBounds(500,200,500,600);
        this.setBounds(500,200,500,600);

        BG.add(Encrypt);
        BG.add(Decrypt);

        A.add(JSPL,BorderLayout.WEST);
        A.add(JP,BorderLayout.CENTER);
        A.add(JSPR,BorderLayout.EAST);

        JP.setLayout(new GridLayout(9,1));
        JP.add(Method);
        JP.add(JCB);
        JP.add(Password);
        JP.add(inPassword);
        JP.add(Encrypt);
        JP.add(Decrypt);
        JP.add(Run);
        JP.add(Close);

        JSPL.setPreferredSize(new Dimension(200,600));
        JSPR.setPreferredSize(new Dimension(200,600));
        JP.setPreferredSize(new Dimension(100,600));



        Run.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JTAR.setText("");
                if(JCB.getSelectedIndex() == 0) {
                    if (Encrypt.isSelected()) {
                        String[] n = JTAL.getText().split("\n");
                        int count = Integer.valueOf(n[0]);
                        int plus = Integer.valueOf(n[1]);
                        for (int i = 0; i < count; i++) {
                            for (int j = 0; j < n[i + 2].length(); j++) {
                                char[] depot = new char[n[i + 2].length()];
                                depot = n[i + 2].toCharArray();
                                int dept = Integer.valueOf(depot[j]);
                                dept = dept + plus;
                                String change = new Character((char) dept).toString();
                                JTAR.append(change);
                            }
                            JTAR.append("\n");
                        }
                    } else if (Decrypt.isSelected()) {
                        String[] n = JTAL.getText().split("\n");
                        int count = Integer.valueOf(n[0]);
                        int plus = Integer.valueOf(n[1]);
                        for (int i = 0; i < count; i++) {
                            for (int j = 0; j < n[i + 2].length(); j++) {
                                char[] depot = new char[n[i + 2].length()];
                                depot = n[i + 2].toCharArray();
                                int dept = Integer.valueOf(depot[j]);
                                dept = dept - plus;
                                String change = new Character((char) dept).toString();
                                JTAR.append(change);
                            }
                            JTAR.append("\n");
                        }
                    }
                }else{
                    System.out.println("Nothing here");
                }
            }
        });
        Close.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                UsingF UF = new UsingF();
                setVisible(false);
                UF.setVisible(true);
            }
        });
    }
}

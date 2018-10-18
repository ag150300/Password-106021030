package com.company;

import javax.crypto.spec.DESedeKeySpec;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class EncryptF extends JFrame {
    private Container A;
    private JPanel JP = new JPanel();
    private JTextArea JTAL = new JTextArea("");
    private JTextArea JTAR = new JTextArea("");
    String[] inJCB = {"Caesar","DES","AES","XOR"};
    private JComboBox JCB = new JComboBox(inJCB);
    private JScrollPane JSPL = new JScrollPane(JTAL);
    private JScrollPane JSPR = new JScrollPane(JTAR);
    private JRadioButton Encrypt = new JRadioButton("Encrypt");
    private JRadioButton Decrypt = new JRadioButton("Decrypt");
    private ButtonGroup BG = new ButtonGroup();
    private JLabel Method = new JLabel("Method");
    private JLabel Password = new JLabel("Password");
    private JTextField inPassword = new JTextField("");
    private JButton Clear = new JButton("Clear");
    private JButton Run = new JButton("Run");
    private JButton Close = new JButton("Close");
    private JMenuBar JMB = new JMenuBar();
    private JMenu JF = new JMenu("File");
    private JMenu JO = new JMenu("Option");
    private JMenuItem JMO = new JMenuItem("Open");
    private JMenuItem JMS = new JMenuItem("Save");
    private JMenuItem JME = new JMenuItem("Exit");
    private JFileChooser JFC = new JFileChooser();

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
        Encrypt.setSelected(true);

        A.add(JMB,BorderLayout.NORTH);
        JMB.add(JF);
        JMB.add(JO);
        JF.add(JMO);
        JF.add(JMS);
        JF.add(JME);

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
        JP.add(Clear);
        JP.add(Run);
        JP.add(Close);

        JSPL.setPreferredSize(new Dimension(200,600));
        JSPR.setPreferredSize(new Dimension(200,600));
        JP.setPreferredSize(new Dimension(100,600));

        JME.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                UsingF UF = new UsingF();
                setVisible(false);
                UF.setVisible(true);
            }
        });

        JMO.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    if (JFC.showOpenDialog(null) == JFC.APPROVE_OPTION) {
                        FileReader fr = new FileReader(JFC.getSelectedFile());
                        BufferedReader bfr = new BufferedReader(fr);
                        String str = "";
                        JTAL.setText("");
                        while((str = bfr.readLine()) != null){
                            JTAL.setText(JTAL.getText() + str);
                            JTAL.setText(JTAL.getText() + "\n");
                        }
                    }
                }catch (FileNotFoundException exp){
                    JOptionPane.showMessageDialog(EncryptF.this,"File cannot found!");
                }catch (IOException exp1){

                }
            }
        });

        Run.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                boolean wrong = false;
                try {
                    int check = Integer.valueOf(inPassword.getText());
                }catch (NumberFormatException exp){
                    JOptionPane.showMessageDialog(EncryptF.this,"Password is not a Integer");
                    wrong = true;
                }
                if(JCB.getSelectedIndex() == 0 && wrong == false) {
                    if (Encrypt.isSelected()) {
                            int plus = Integer.valueOf(inPassword.getText());
                        for (int q = 0; q < JTAL.getText().length(); q++) {
                            char[] depot = new char[JTAL.getText().length()];
                            depot = JTAL.getText().toCharArray();
                            String n = String.valueOf(depot);
                            int dept = Integer.valueOf(depot[q]);
                            if(dept == 10){
                                String change = new Character((char) dept).toString();
                                JTAR.append(change);
                            }else{
                                dept = dept + plus;
                                String change = new Character((char) dept).toString();
                                JTAR.append(change);
                            }
                        }
                    } else if (Decrypt.isSelected()) {
                        int plus = Integer.valueOf(inPassword.getText());
                        for (int q = 0; q < JTAR.getText().length(); q++) {
                            char[] depot = new char[JTAR.getText().length()];
                            depot = JTAR.getText().toCharArray();
                            int dept = Integer.valueOf(depot[q]);
                            if (dept == 10) {
                                String change = new Character((char) dept).toString();
                                JTAL.append(change);
                            } else {
                                dept = dept + plus;
                                String change = new Character((char) dept).toString();
                                JTAL.append(change);
                            }
                        }
                    }
                }else if(JCB.getSelectedIndex() == 3 && wrong == false){
                    if (Encrypt.isSelected()) {
                        //調整長度
                        if(inPassword.getText().length() > JTAL.getText().length()){
                            String[] depotAll = new String[JTAL.getText().length()];
                            for(int i = 0;i < JTAL.getText().length();i++){
                                char[] depot = new char[JTAL.getText().length()];
                                depot = JTAL.getText().toCharArray();
                                depotAll[i] = String.valueOf(depot);
                            }
                            for(int j = 0;j < inPassword.getText().length() - JTAL.getText().length();j++){
                                JTAL.setText(JTAL.getText() + depotAll[j]);
                            }
                        }else if(JTAL.getText().length() > inPassword.getText().length()){
                            String[] depotAll = new String[inPassword.getText().length()];
                            for(int i = 0;i < inPassword.getText().length();i++){
                                char[] depot = new char[JTAL.getText().length()];
                                depot = inPassword.getText().toCharArray();
                                depotAll[i] = String.valueOf(depot);
                            }
                            for(int j = 0;j < JTAL.getText().length() - inPassword.getText().length();j++){
                                inPassword.setText(inPassword.getText() + depotAll[j]);
                            }
                        }

                        int length = JTAL.getText().length();
                        for(int i = 0;i < length;i++){
                            char[] depot = new char[length];
                            depot = JTAL.getText().toCharArray();
                            int[] depotchange = new int[length];
                            int dept = Integer.valueOf(depot[i]);
                            while(dept == 0){
                                depotchange[0] = dept % 2;
                            }
                        }
                    }else if(Decrypt.isSelected()){
                        int key = Integer.valueOf(inPassword.getText());
                    }
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

        Clear.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JTAL.setText("");
                JTAR.setText("");
            }
        });
    }
}

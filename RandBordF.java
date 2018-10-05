package com.company;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Random;

public class RandBordF extends JFrame {
    private Container A;
    private JPanel JP = new JPanel(new GridLayout(4,3,10,10));
    private JButton[] JB = new JButton[12];
    private JLabel JL = new JLabel("");
    private Font fon = new Font(null,Font.BOLD,20);
    private Random ran = new Random(System.currentTimeMillis());

    public RandBordF(String c){
        Ruwen(c);
    }

   private void Ruwen(String c){

        A = this.getContentPane();
        this.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        A.setLayout(new BorderLayout(10,10));
        JL.setFont(fon);

        A.setBounds(100,500,1000,500);
        this.setBounds(100,500,1000,500);

        A.add(JP,BorderLayout.CENTER);
        A.add(JL,BorderLayout.NORTH);

            int z = 0;
            while(z < 10) {
                int a = ran.nextInt(10);
                JB[z] = new JButton(String.valueOf(a));
                int j = 0;
                boolean flag = true;
                while(j < z) {
                    if (JB[z].getText().equals(JB[j].getText())) {
                        flag = false;
                    }
                    j++;
                }
                if (flag) {
                    z++;
                }
            }
        for(int i = 0; i < 10;i++) {
            JP.add(JB[i]);
            JB[i].addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    JButton jbt = (JButton) e.getSource();
                    JL.setText(JL.getText() + jbt.getText());
                }
            });
        }
        for(int i = 0; i < 12;i++) {
            if (i == 10) {
                JB[i] = new JButton();
                JB[i].setText("Submit");
                JB[i].addActionListener(new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        new LoginF(JL.getText(),c).setVisible(true);
                        setVisible(false);
                    }
                });

                JP.add(JB[i]);
            } else if (i == 11) {
                JB[i] = new JButton();
                JB[i].setText("Exit");
                JB[i].addActionListener(new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        setVisible(false);

                    }
                });
                JP.add(JB[i]);
            }
        }
    }
}

package com.company;

import javafx.scene.control.PasswordField;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class PassWordFrame extends JFrame {
    private Container A;
    private JPasswordField PF = new JPasswordField(8);
    private JPanel Pl = new JPanel(new GridLayout(3,4,3,3));
    private JButton[][] JB = new JButton[3][4];
    private JLabel Under = new JLabel("     ");
    int count = 0;

    public PassWordFrame(){
        LZ();
    }
    private void LZ(){
        A = this.getContentPane();
        this.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        A.setLayout(new BorderLayout(3,3));
        A.add(PF,BorderLayout.NORTH);
        A.add(Pl,BorderLayout.CENTER);
        A.add(Under,BorderLayout.SOUTH);


        this.setBounds(100,100,1000,500);
        A.setBounds(100,100,1000,500);

        PF.setFont(new Font(null,Font.BOLD,30));
        Under.setFont(new Font(null,Font.BOLD,30));

        for(int i = 0;i < 3;i++){
            for(int j = 0;j < 4;j++) {
                String change = String.valueOf(count);
                JB[i][j] = new JButton();
                JB[i][j].setFont(new Font(null,Font.BOLD,20));
                if(i == 2 && j == 2){
                    JB[i][j].setText("Submit");
                    JB[i][j].addActionListener(new ActionListener() {
                        @Override
                        public void actionPerformed(ActionEvent e) {
                            String depot = String.valueOf(PF.getPassword());
                            if(depot.equals("23323456")){
                                Under.setText("成功");
                            }else{
                                Under.setText("密碼錯誤");
                                PF.setText("");
                            }
                        }
                    });
                }else if(i == 2 && j == 3){
                    JB[i][j].setText("Exit");
                    JB[i][j].addActionListener(new ActionListener() {
                        @Override
                        public void actionPerformed(ActionEvent e) {
                            System.exit(0);
                        }
                    });
                }else{
                    JB[i][j].setText(change);
                    count++;
                    JB[i][j].addActionListener(new ActionListener() {
                        @Override
                        public void actionPerformed(ActionEvent e) {
                            JButton jbt = (JButton) e.getSource();
                            String depot = String.valueOf(PF.getPassword());
                            PF.setText(depot + jbt.getText());
                        }
                    });
                }
                Pl.add(JB[i][j]);
            }
        }
    }
}

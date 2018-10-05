package com.company;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class Ex20180920_CircleF extends JFrame {
    public Container A;
    private JLabel up = new JLabel("O and X");
    private JPanel pan = new JPanel(new GridLayout(3,3,3,3));
    private JButton[][] JB = new JButton[3][3];
    int count = 0;
    int end = 0;


    public Ex20180920_CircleF(UsingF frm){
        option(frm);
    }

    private void option(UsingF frm){
    A = this.getContentPane();
    this.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
    A.setLayout(new BorderLayout(3,3));

    this.setBounds(0,0,1000,1000);
    A.setBounds(0,0,1000,1000);
    up.setOpaque(true);
    up.setBackground(new Color(255,0,255));
    up.setFont(new Font(null, Font.BOLD, 35));
        A.add(up,BorderLayout.NORTH);
        A.add(pan,BorderLayout.CENTER);

      this.addWindowListener(new WindowAdapter() {
          @Override
          public void windowClosing(WindowEvent e) {
              UsingF use = new UsingF();
              setVisible(false);
              use.setVisible(true);
          }
      });


        //JB基礎設定
        for(int i =0;i< 3;i++){
            for(int j = 0;j <3;j++) {
                JB[i][j]  = new JButton();
                JB[i][j].setText("");
                JB[i][j].setFont(new Font(null, Font.BOLD, 36));
                pan.add(JB[i][j]);
                JB[i][j].addActionListener(new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        JButton jbt = (JButton) e.getSource();

                        if (count % 2 == 0) {
                            jbt.setText("O");
                        } else {
                            jbt.setText("X");
                        }
                        jbt.setEnabled(false);
                        end++;
                        count++;
                        content();
                    }
                });
            }
        }
    }

    public void content(){
        if(JB[0][0].getText().equals(JB[0][1].getText()) && JB[0][1].getText().equals(JB[0][2].getText()) && !JB[0][0].getText().equals("")){
            if(JB[0][0].getText().equals("O")){
                P1W();
            }else if(JB[0][0].getText().equals("X") ) {
                P2W();
            }
            //clear
        }else if(JB[0][0].getText().equals(JB[1][0].getText()) && JB[0][0].getText().equals(JB[2][0].getText()) && !JB[0][0].getText().equals("")){
            if(JB[0][0].getText().equals("O")){
                P1W();
            }else if(JB[0][0].getText().equals("X") ) {
                P2W();
            }//clear
        }else if(JB[0][0].getText().equals(JB[1][1].getText()) && JB[1][1].getText().equals(JB[2][2].getText()) && !JB[0][0].getText().equals("")){
            if(JB[0][0].getText().equals("O")){
                P1W();
            }else if(JB[0][0].getText().equals("X") ) {
                P2W();
            }
            //clear
        }else if(JB[0][1].getText().equals(JB[1][1].getText()) && JB[0][1].getText().equals(JB[2][1].getText()) && !JB[0][1].getText().equals("")){
            if(JB[0][1].getText().equals("O")){
                P1W();
            }else if(JB[0][1].getText().equals("X") ) {
                P2W();
            }
            //clear
        }else if(JB[0][2].getText().equals(JB[1][2].getText()) && JB[0][2].getText().equals(JB[2][2].getText()) && !JB[0][2].getText().equals("")){
            if(JB[0][2].getText().equals("O")){
                P1W();
            }else if(JB[0][2].getText().equals("X") ) {
                P2W();
            }
            //clear
        }else if(JB[0][2].getText().equals(JB[1][1].getText()) && JB[0][2].getText().equals(JB[2][0].getText()) && !JB[0][2].getText().equals("")){
            if(JB[0][2].getText().equals("O")){
                P1W();
            }else if(JB[0][2].getText().equals("X") ) {
                P2W();
            }
            //clear
        }else if(JB[1][0].getText().equals(JB[1][1].getText()) && JB[1][1].getText().equals(JB[1][2].getText()) && !JB[1][0].getText().equals("")){
            if(JB[1][0].getText().equals("O")){
                P1W();
            }else if(JB[1][0].getText().equals("X") ) {
                P2W();
            }
            //clear
        }else if(JB[2][0].getText().equals(JB[2][1].getText()) && JB[2][0].getText().equals(JB[2][2].getText()) && !JB[2][0].getText().equals("")){
            if(JB[2][0].getText().equals("O")){
                P1W();
            }else if(JB[2][0].getText().equals("X") ) {
                P2W();
            }
            //clear
        }else if(end == 9){
            JOptionPane.showMessageDialog(Ex20180920_CircleF.this,"No one win");
            UsingF use = new UsingF();
            use.setVisible(true);
            dispose();
            setVisible(false);
        }
    }
    public void P1W(){
        up.setText("Player 1 Win");
        JOptionPane.showMessageDialog(Ex20180920_CircleF.this,"Player 1 Win");
        UsingF use = new UsingF();
        use.setVisible(true);
        dispose();
        setVisible(false);
    }
    public void P2W(){
        up.setText("Player 2 Win");
        JOptionPane.showMessageDialog(Ex20180920_CircleF.this,"Player 2 Win");
        UsingF use = new UsingF();
        use.setVisible(true);
        dispose();
        setVisible(false);
    }
}


package com.company;

import javax.swing.*;
import java.awt.*;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

public class EncryptFileF extends JFrame {
    private Container A;
    private JPanel JPU = new JPanel();
    private JPanel JPC = new JPanel();
    private JPanel JPD = new JPanel();
    private JPanel JPW = new JPanel();
    private JPanel JPE = new JPanel();
    private JLabel orgin = new JLabel("Orginal");
    private JLabel Encrypt = new JLabel("Encrypt");
    private JButton orginB = new JButton("Choose");
    private JButton EncryptB = new JButton("Choose");
    private JTextField JTAU = new JTextField("");
    private JTextField JTAD = new JTextField("");
    String[] inJCB = {"Caesar","DES","AES","XOR"};
    private JComboBox JCB = new JComboBox(inJCB);
//    private JScrollPane JSPL = new JScrollPane(JTAL);
//    private JScrollPane JSPR = new JScrollPane(JTAR);
//    private JRadioButton Encrypt = new JRadioButton("Encrypt");
//    private JRadioButton Decrypt = new JRadioButton("Decrypt");
//    private ButtonGroup BG = new ButtonGroup();
    private JLabel method = new JLabel("Method");
    private JLabel key = new JLabel("Key");
    private JTextField inPassword = new JTextField("");
    private JButton Run = new JButton("Run");
    private JButton Close = new JButton("Close");
//    private JMenuBar JMB = new JMenuBar();
//    private JMenu JF = new JMenu("File");
//    private JMenu JO = new JMenu("Option");
//    private JMenuItem JMO = new JMenuItem("Open");
//    private JMenuItem JMS = new JMenuItem("Save");
//    private JMenuItem JME = new JMenuItem("Exit");
    private JFileChooser JFC = new JFileChooser();
    private Dimension screen = Toolkit.getDefaultToolkit().getScreenSize();
    private JProgressBar JPB = new JProgressBar();

    public EncryptFileF(UsingF UF){
        Ruwen(UF);
    }
    private void Ruwen(UsingF UF){
        int sw = screen.width;
        int sh = screen.height;
        int w = 1000;
        int h = 300;
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
        A.setBounds(sw/2-w/2,sh/2-h/2,w,h);
        this.setBounds(sw/2-w/2,sh/2-h/2,w,h);

//        BG.add(Encrypt);
//        BG.add(Decrypt);
//        Encrypt.setSelected(true);

//        A.add(JMB,BorderLayout.NORTH);
//        JMB.add(JF);
//        JMB.add(JO);
//        JF.add(JMO);
//        JF.add(JMS);
//        JF.add(JME);

        A.add(JPU,BorderLayout.NORTH);
        A.add(JPC,BorderLayout.CENTER);
        A.add(JPD,BorderLayout.SOUTH);
        A.add(JPW,BorderLayout.WEST);
        A.add(JPE,BorderLayout.EAST);
        JPU.setLayout(new GridLayout(1,6));
        JPU.add(method);
        JPU.add(JCB);
        JPU.add(key);
        JPU.add(inPassword);
        JPU.add(Run);
        JPU.add(Close);

        JPC.setLayout(new GridLayout(2,3,10,10));
        JPC.add(JTAU);
        JPC.add(JTAD);

        JPD.add(JPB);

        JPW.setLayout(new GridLayout(2,1));
        JPW.add(orgin);
        JPW.add(Encrypt);

        JPE.setLayout(new GridLayout(2,1));
        JPE.add(EncryptB);
        JPE.add(orginB);

        JPU.setPreferredSize(new Dimension(w,50));
        JPC.setPreferredSize(new Dimension(w,200));
        JPB.setPreferredSize(new Dimension(w-20,40));
    }
}

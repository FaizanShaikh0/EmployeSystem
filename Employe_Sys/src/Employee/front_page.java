package Employee;


import java.awt.*;
import javax.swing.*;
import java.lang.Thread;
import java.awt.event.*;


class front_page implements ActionListener {
    JFrame frame;
    JLabel id;
    JButton button;

    public front_page() {
        frame = new JFrame("Employee Management System");
        frame.setBackground(Color.red);
        frame.setLayout(null);

        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("Employee/eduford_img/banner2.jpg"));
        Image i2  = i1.getImage().getScaledInstance(1200,700,Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel l1 = new JLabel(i3);
        l1.setBounds(0,105,1360,530);
        frame.add(l1);

        button = new JButton("Click here to Continue");
        button.setBackground(Color.black);
        button.setForeground(Color.white);


        button.setBounds(500,600,300,70);
        button.addActionListener(this);

        id = new JLabel();
        id.setBounds(0,0,1360,750);
        id.setLayout(null);

        JLabel label_id = new JLabel("Employee Management System");
        label_id.setBounds(235,10,1500,100);
        label_id.setFont(new Font("serif",Font.PLAIN,70));
        label_id.setForeground(Color.red);
        id.add(label_id);

        id.add(button);
        frame.add(id);

        frame.getContentPane().setBackground(Color.white);
        frame.setVisible(true);
        frame.setSize(1360,750);
        frame.setLocation(100,50);

        while (true){
            label_id.setVisible(false);
            try{
                Thread.sleep(500);
            }catch (Exception e){}
            label_id.setVisible(true);
            try {
                Thread.sleep(500);
            }catch (Exception e){}
        }
    }
    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource()==button){
            frame.setVisible(false);
            login button = new login();
        }
    }

    public static void main(String[] args) {
        front_page frame = new front_page();
    }

}

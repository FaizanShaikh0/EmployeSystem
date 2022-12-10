package Employee;

import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
import java.sql.*;


public class login implements ActionListener {
    JFrame frame;
    JLabel username,password;
    JTextField namefield;
    JPasswordField pfpassword;
    JButton loginbtn,cancelbtn;

    public login() {
        frame = new JFrame("Login");

        frame.setBackground(Color.black);
        frame.setLayout(null);

        username = new JLabel("Username");
        username.setBounds(40,25,100,30);
        frame.add(username);

        password = new JLabel("Password");
        password.setBounds(40,75,100,30);
        frame.add(password);

        namefield = new JTextField();
        namefield.setBounds(150,30,150,20);
        frame.add(namefield);

        pfpassword = new JPasswordField();
        pfpassword.setBounds(150,80,150,20);
        frame.add(pfpassword);

        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource(""));
        Image i2  = i1.getImage().getScaledInstance(150,150,Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel l3 = new JLabel(i3);
        l3.setBounds(350,20,150,150);
        frame.add(l3);

        loginbtn  = new JButton("Login");
        loginbtn.setBounds(40,140,120,30);
        loginbtn.setFont(new Font("serif",Font.BOLD,15));
        loginbtn.addActionListener(this);
        loginbtn.setBackground(Color.black);
        loginbtn.setForeground(Color.white);
        frame.add(loginbtn);

        cancelbtn  = new JButton("Cancel");
        cancelbtn.setBounds(180,140,120,30);
        cancelbtn.setFont(new Font("serif",Font.BOLD,15));
        cancelbtn.setBackground(Color.black);
        cancelbtn.setForeground(Color.white);
        frame.add(cancelbtn);

        cancelbtn.addActionListener(this);

        frame.getContentPane().setBackground(Color.white);

        frame.setVisible(true);
        frame.setSize(600,300);
        frame.setLocation(400,300);
    }
    @Override
    public void actionPerformed(ActionEvent e) {
        String username = namefield.getText();
        String password  = pfpassword.getText();
        try {
            connection c1  =new connection();
            String query = "Select * from login where username = '"+username+"' and password  ='"+password+"'";

            ResultSet rs = c1.s.executeQuery(query);
            if (rs.next()){
                new home().frame.setVisible(true);
                frame.setVisible(false);
            }else {
                JOptionPane.showMessageDialog(null, "Invalid login");
                frame.setVisible(false);
            }
        } catch (Exception ae) {
            throw new RuntimeException(ae);
        }
    }

    public static void main(String[] args) {
        new login();
    }
}

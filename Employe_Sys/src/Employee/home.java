package Employee;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;

public class home implements ActionListener {
    JFrame frame;
    JLabel l1,l2;
    JButton addbtn,removebtn,viewbtn,updatebtn;

    public home() {
        frame = new JFrame("Employee Details");
        frame.setBackground(Color.white);
        frame.setLayout(null);

        l1 = new JLabel();
        l1.setBounds(0,0,700,500);
        l1.setLayout(null);
        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("Employee/Icons/details.jpg"));
        l1.setIcon(i1);
        frame.add(l1);

        l2 = new JLabel("Add Employee");
        l2.setBounds(440,20,200,40);
        l2.setFont(new Font("serif",Font.BOLD,25));
        l2.setForeground(Color.darkGray);
        l1.add(l2);

        addbtn = new JButton("Add");
        addbtn.setBounds(420,80,100,40);
        addbtn.setFont(new Font("serif",Font.BOLD,15));
        addbtn.addActionListener(this);
        l1.add(addbtn);

        viewbtn = new JButton("View");
        viewbtn.setBounds(530,80,100,40);
        viewbtn.setFont(new Font("serif",Font.BOLD,15));
        viewbtn.addActionListener(this);
        l1.add(viewbtn);

        removebtn = new JButton("Remove");
        removebtn.setBounds(420,140,100,40);
        removebtn.setFont(new Font("serif",Font.BOLD,15));
        removebtn.addActionListener(this);
        l1.add(removebtn);

        updatebtn = new JButton("Update");
        updatebtn.setBounds(530,140,100,40);
        updatebtn.setFont(new Font("serif",Font.BOLD,15));
        updatebtn.addActionListener(this);
        l1.add(updatebtn);

        frame.setVisible(true);
        frame.setSize(700,500);
        frame.setLocation(400,150);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == addbtn) {
            frame.setVisible(false);
            new Add_Employee();
        } else if (e.getSource() == viewbtn) {
            frame.setVisible(false);
            new view();
        } else if (e.getSource() == removebtn) {
            frame.setVisible(false);
            new Remove_Employee();
        } else if (e.getSource() == updatebtn) {
            frame.setVisible(false);
            new search_Employee();
        }
    }

    public static void main(String[] args) {
        home frame = new home();
    }
}

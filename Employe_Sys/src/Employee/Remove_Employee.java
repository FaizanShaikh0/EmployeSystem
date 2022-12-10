package Employee;

import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
import java.sql.*;

public class Remove_Employee implements ActionListener {

    JFrame frame;
    JButton search, back, remove, cancel;
    JLabel EmployeeId, bgimg, Name, phoneNo, email_id, namefield, phoneNoField, email_idField ;
    JTextField employeeField;

    public Remove_Employee() {

        frame = new JFrame("Remove Employee");
        frame.setBackground(Color.white);
        frame.setLayout(null);

        bgimg = new JLabel();
        bgimg.setBounds(0,0,500,500);
        bgimg.setLayout(null);
        ImageIcon img = new ImageIcon(ClassLoader.getSystemResource("Employee/Icons/remove.jpg"));
        bgimg.setIcon(img);

        EmployeeId = new JLabel("Employee-Id");
        EmployeeId.setVisible(true);
        EmployeeId.setBounds(40,60,250,30);
        EmployeeId.setForeground(Color.white);
        EmployeeId.setFont(new Font("serif",Font.BOLD,30));
        bgimg.add(EmployeeId);
        frame.add(bgimg);

        employeeField = new JTextField();
        employeeField.setBounds(230,60,220,30);
        bgimg.add(employeeField);

        search = new JButton("Search");
        search.setBounds(240,140,100,30);
        search.addActionListener(this);
        bgimg.add(search);

        back = new JButton("Back");
        back.setBounds(350,140,100,30);
        back.addActionListener(this);
        bgimg.add(back);

        Name = new JLabel("Name:");
        Name.setBounds(100,200,250,30);
        Name.setForeground(Color.white);
        Name.setFont(new Font("serif",Font.BOLD,20));
        bgimg.add(Name);

        namefield = new JLabel();
        namefield.setBounds(230,200,350,30);
        namefield.setForeground(Color.white);
        namefield.setFont(new Font("serif",Font.BOLD,20));
        bgimg.add(namefield);

        phoneNo = new JLabel("Phone-No:");
        phoneNo.setBounds(100,250,250,30);
        phoneNo.setForeground(Color.white);
        phoneNo.setFont(new Font("serif",Font.BOLD,20));
        bgimg.add(phoneNo);

        phoneNoField = new JLabel();
        phoneNoField.setBounds(230,250,350,30);
        phoneNoField.setForeground(Color.white);
        phoneNoField.setFont(new Font("serif",Font.BOLD,20));
        bgimg.add(phoneNoField);

        email_id = new JLabel("Email-id:");
        email_id.setBounds(100,300,250,30);
        email_id.setForeground(Color.white);
        email_id.setFont(new Font("serif",Font.BOLD,20));
        bgimg.add(email_id);

        email_idField = new JLabel();
        email_idField.setBounds(230,300,350,30);
        email_idField.setForeground(Color.white);
        email_idField.setFont(new Font("serif",Font.BOLD,20));
        bgimg.add(email_idField);

        remove = new JButton("Remove");
        remove.setBounds(120,350,100,30);
        remove.addActionListener(this);
        bgimg.add(remove);

        cancel = new JButton("Cancel");
        cancel.setBounds(300,350,100,30);
        cancel.addActionListener(this);
        bgimg.add(cancel);

        Name.setVisible(false);
        phoneNo.setVisible(false);
        email_id.setVisible(false);
//        namefield.setVisible(false);
//        phoneNoField.setVisible(false);
//        email_idField.setVisible(false);
        remove.setVisible(false);
        cancel.setVisible(false);

        frame.setVisible(true);
        frame.setSize(500,500);
        frame.setLocation(500,150);
    }

    @Override
    public void actionPerformed(ActionEvent e) {

        if (e.getSource()==search) {
            try {
                connection con = new connection();
                String str = "select name,phone,email from employee where emp_id = '" + employeeField.getText() + "'";
                ResultSet rs = con.s.executeQuery(str);

                int i = 0;
                if (rs.next()) {
                    String name = rs.getString(1);
                    String mob = rs.getString(2);
                    String email = rs.getString(3);

                    Name.setVisible(true);
                    phoneNo.setVisible(true);
                    email_id.setVisible(true);
                    remove.setVisible(true);
                    cancel.setVisible(true);
                    i = 1;
                    namefield.setText(name);
                    phoneNoField.setText(mob);
                    email_idField.setText(email);
                }
                if (i == 0)
                    JOptionPane.showMessageDialog(null, "Id not Found");
            } catch (Exception ex) {}
        }
            if (e.getSource()==remove){
                try{
                    connection con = new connection();

                    String str = "delete from employee where emp_id = '"+employeeField.getText()+"'";
                    con.s.executeUpdate(str);
                    JOptionPane.showMessageDialog(null,"deleted Successfully");

                    Name.setVisible(false);
                    phoneNo.setVisible(false);
                    email_id.setVisible(false);
                    namefield.setVisible(false);
                    phoneNoField.setVisible(false);
                    email_idField.setVisible(false);
                    remove.setVisible(false);
                    cancel.setVisible(false);

                } catch (SQLException ex) {
                    JOptionPane.showMessageDialog(null,"Exception occured while deleting record"+ex);
                }
            }
            if (e.getSource()==cancel) {
            frame.setVisible(false);
            new home();
        }
            if (e.getSource()==back) {
            frame.setVisible(false);
            new home();
        }
    }
    public static void main(String[] args) {
        Remove_Employee frame = new Remove_Employee();
    }
}

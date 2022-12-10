package Employee;

import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
import java.sql.*;

public class Print_Data implements ActionListener {
    static JFrame frame;
    JLabel  bckGroundImg, heading, Name, fatherName,Address, phoneNo, email_id, Qualification, employee_id, aadhaarNO,emp1_id,lblname,fName,lbladdress,lblphone,lblqualification,lblemail;
    String emp_id,name,father,address,phone,email,age,DOB,qualification,aadhaar;
    JButton print, cancel;

    public Print_Data(String e_id) {
        try {
            connection con = new connection();
            String str = "select * from employee where emp_id = '"+e_id+"'";
            ResultSet rs = con.s.executeQuery(str);

            while (rs.next()){

                name = rs.getString("name");
                emp_id = rs.getString("emp_id");
                father = rs.getString("fname");
                address = rs.getString("address");
                phone = rs.getString("phone");
                email = rs.getString("email");
                age = rs.getString("age");
                DOB = rs.getString("dob");
                qualification = rs.getString("qualification");
                aadhaar = rs.getString("aadhar");

            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

            frame = new JFrame("Print Data");
            frame.setSize(595,642);
            frame.setLocation(450,100);
            frame.setBackground(Color.white);
            frame.setLayout(null);

            bckGroundImg = new JLabel();
            bckGroundImg.setLayout(null);
            bckGroundImg.setBounds(0,0,900,645);
            ImageIcon img = new ImageIcon(ClassLoader.getSystemResource("Employee/Icons/print.jpg"));
            bckGroundImg.setIcon(img);

            heading = new JLabel("Employee Details");
            heading.setBounds(200,10,250,30);
            heading.setFont(new Font("serif",Font.ITALIC,25));
            heading.setForeground(Color.black);
            bckGroundImg.add(heading);
            frame.add(bckGroundImg);

            employee_id = new JLabel("Employee-id");
            employee_id.setBounds(50,70,120,30);
            employee_id.setFont(new Font("serif",Font.BOLD,20));
            bckGroundImg.add(employee_id);

            emp1_id = new JLabel(emp_id);
            emp1_id.setBounds(200,70,200,30);
            emp1_id.setFont(new Font("serif",Font.BOLD,20));
            bckGroundImg.add(emp1_id);

            Name = new JLabel("Name");
            Name.setBounds(50,120,100,30);
            Name.setFont(new Font("serif",Font.BOLD,20));
            bckGroundImg.add(Name);

            lblname = new JLabel(name);
            lblname.setBounds(200,120,300,30);
            lblname.setFont(new Font("serif",Font.BOLD,20));
            bckGroundImg.add(lblname);

            fatherName = new JLabel("Father's Name");
            fatherName.setBounds(50,170,200,30);
            fatherName.setFont(new Font("serif",Font.BOLD,20));
            bckGroundImg.add(fatherName);

            fName = new JLabel(father);
            fName.setBounds(200,170,300,30);
            fName.setFont(new Font("serif",Font.BOLD,20));
            bckGroundImg.add(fName);

            Address = new JLabel("Address");
            Address.setBounds(50,220,100,30);
            Address.setFont(new Font("serif",Font.BOLD,20));
            bckGroundImg.add(Address);

            lbladdress = new JLabel(address);
            lbladdress.setBounds(200,220,300,30);
            lbladdress.setFont(new Font("serif",Font.BOLD,20));
            bckGroundImg.add(lbladdress);

            phoneNo = new JLabel("Mobile No");
            phoneNo.setBounds(50,270,100,30);
            phoneNo.setFont(new Font("serif",Font.BOLD,20));
            bckGroundImg.add(phoneNo);

            lblphone = new JLabel(phone);
            lblphone.setBounds(200,270,300,30);
            lblphone.setFont(new Font("serif",Font.BOLD,20));
            bckGroundImg.add(lblphone);

            email_id = new JLabel("Email-id");
            email_id.setBounds(50,320,100,30);
            email_id.setFont(new Font("serif",Font.BOLD,20));
            bckGroundImg.add(email_id);

            lblemail = new JLabel(email);
            lblemail.setBounds(200,320,300,30);
            lblemail.setFont(new Font("serif",Font.BOLD,20));
            bckGroundImg.add(lblemail);

            Qualification = new JLabel("Qualification");
            Qualification.setBounds(50,370,100,30);
            Qualification.setFont(new Font("serif",Font.BOLD,20));
            bckGroundImg.add(Qualification);

            lblqualification = new JLabel(qualification);
            lblqualification.setBounds(200,370,200,30);
            lblqualification.setFont(new Font("serif",Font.BOLD,20));
            bckGroundImg.add(lblqualification);

            print = new JButton("Print");
            print.setBounds(100,520,100,30);
            print.setBackground(Color.black);
            print.setForeground(Color.white);
            print.addActionListener(this);
            bckGroundImg.add(print);

            cancel = new JButton("Cancel");
            cancel.setBounds(250,520,100,30);
            cancel.setBackground(Color.black);
            cancel.setForeground(Color.white);
            cancel.addActionListener(this);
            bckGroundImg.add(cancel);

            frame.setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent ae) {

        if (ae.getSource()==print){
            JOptionPane.showMessageDialog(null,"Printed Successfully");
            frame.setVisible(false);
            home d = new home();
        } if (ae.getSource()==cancel) {
            frame.setVisible(false);
            new view();
        }
    }

    public static void main(String[] args) {
        Print_Data frame = new Print_Data("Print data");
    }
}

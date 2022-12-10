package Employee;

import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
import java.sql.*;

public class update_Employee implements ActionListener {

    JFrame frame;
    JLabel bckGroundImg, heading, Name, FatherName, age, DateOfBirth, Address, Phone_No, Email_Id, Qualification, Employee_Id, AadhaarNO;
    JTextField namefield, fatherNamefield, agefield, DOBfield, addressfield, phoneNoField, email_idField, qualificationField, employee_idField, aadhaarNoField;
    JButton updatebtn, cancelbtn;
    String id_emp;

    public update_Employee(String id_emp) {

        this.id_emp = id_emp;
        frame = new JFrame("Update Employee Details");
        frame.setBackground(Color.white);
        frame.setLayout(null);

        bckGroundImg = new JLabel();
        bckGroundImg.setLayout(null);
        bckGroundImg.setBounds(0, 0, 900, 500);
        ImageIcon img = new ImageIcon(ClassLoader.getSystemResource("Employee/Icons/add_employee.jpg"));
        bckGroundImg.setIcon(img);

        heading = new JLabel("Update Employee Details");
        heading.setBounds(50, 10, 500, 50);
        heading.setFont(new Font("serif", Font.ITALIC, 40));
        heading.setForeground(Color.black);
        bckGroundImg.add(heading);
        frame.add(bckGroundImg);

        Name = new JLabel("Name:");
        Name.setBounds(50, 100, 100, 30);
        Name.setFont(new Font("serif", Font.BOLD, 20));
        bckGroundImg.add(Name);

        namefield = new JTextField();
        namefield.setBounds(200, 100, 150, 30);
        bckGroundImg.add(namefield);

        FatherName = new JLabel("Father's Name:");
        FatherName.setBounds(400, 100, 200, 30);
        FatherName.setFont(new Font("serif", Font.BOLD, 20));
        bckGroundImg.add(FatherName);

        fatherNamefield = new JTextField();
        fatherNamefield.setBounds(600, 100, 150, 30);
        bckGroundImg.add(fatherNamefield);

        age = new JLabel("Age");
        age.setBounds(50, 150, 100, 30);
        age.setFont(new Font("serif", Font.BOLD, 20));
        bckGroundImg.add(age);

        agefield = new JTextField();
        agefield.setBounds(200, 150, 150, 30);
        bckGroundImg.add(agefield);

        DateOfBirth = new JLabel("Date of Birth");
        DateOfBirth.setBounds(400, 150, 100, 30);
        DateOfBirth.setFont(new Font("serif", Font.BOLD, 20));
        bckGroundImg.add(DateOfBirth);

        DOBfield = new JTextField();
        DOBfield.setBounds(600, 150, 150, 30);
        bckGroundImg.add(DOBfield);

        Address = new JLabel("Address");
        Address.setBounds(50, 200, 100, 30);
        Address.setFont(new Font("serif", Font.BOLD, 20));
        bckGroundImg.add(Address);

        addressfield = new JTextField();
        addressfield.setBounds(200, 200, 150, 30);
        bckGroundImg.add(addressfield);

        Phone_No = new JLabel("Phone-No");
        Phone_No.setBounds(400, 200, 100, 30);
        Phone_No.setFont(new Font("serif", Font.BOLD, 20));
        bckGroundImg.add(Phone_No);

        phoneNoField = new JTextField();
        phoneNoField.setBounds(600, 200, 150, 30);
        bckGroundImg.add(phoneNoField);

        Email_Id = new JLabel("Email-id");
        Email_Id.setBounds(50, 250, 100, 30);
        Email_Id.setFont(new Font("serif", Font.BOLD, 20));
        bckGroundImg.add(Email_Id);

        email_idField = new JTextField();
        email_idField.setBounds(200, 250, 150, 30);
        bckGroundImg.add(email_idField);

        Qualification = new JLabel("Qualification");
        Qualification.setBounds(400, 250, 100, 30);
        Qualification.setFont(new Font("serif", Font.BOLD, 20));
        bckGroundImg.add(Qualification);

        qualificationField = new JTextField();
        qualificationField.setBounds(600, 250, 150, 30);
        bckGroundImg.add(qualificationField);

        AadhaarNO = new JLabel("Aadhaar-No");
        AadhaarNO.setBounds(50, 300, 100, 30);
        AadhaarNO.setFont(new Font("serif", Font.BOLD, 20));
        bckGroundImg.add(AadhaarNO);

        aadhaarNoField = new JTextField();
        aadhaarNoField.setBounds(200, 300, 150, 30);
        bckGroundImg.add(aadhaarNoField);

        Employee_Id = new JLabel("Employee-id");
        Employee_Id.setBounds(400, 300, 100, 30);
        Employee_Id.setFont(new Font("serif", Font.BOLD, 20));
        bckGroundImg.add(Employee_Id);

        employee_idField = new JTextField();
        employee_idField.setBounds(600, 300, 150, 30);
        bckGroundImg.add(employee_idField);

        updatebtn = new JButton("Update");
        updatebtn.setBounds(250, 400, 100, 30);
        updatebtn.setBackground(Color.black);
        updatebtn.setForeground(Color.white);
        updatebtn.addActionListener(this);
        bckGroundImg.add(updatebtn);

        cancelbtn = new JButton("Cancel");
        cancelbtn.setBounds(450, 400, 100, 30);
        cancelbtn.setBackground(Color.black);
        cancelbtn.setForeground(Color.white);
        cancelbtn.addActionListener(this);
        bckGroundImg.add(cancelbtn);

        try{
            connection con = new connection();
            String str = "select * from employee where emp_id = '" + id_emp + "'";
            ResultSet rs = con.s.executeQuery(str);

            while (rs.next()) {
                frame.setVisible(true);

                namefield.setText(rs.getString("name"));
                fatherNamefield.setText(rs.getString(2));
                agefield.setText(rs.getString(3));
                DOBfield.setText(rs.getString(4));
                addressfield.setText(rs.getString(5));
                phoneNoField.setText(rs.getString(6));
                email_idField.setText(rs.getString(7));
                qualificationField.setText(rs.getString(8));
                aadhaarNoField.setText(rs.getString(9));
                employee_idField.setText(rs.getString(10));
            }
        }catch (Exception e) {
            e.printStackTrace();
        }
        frame.setVisible(true);
        frame.setSize(900, 500);
        frame.setLocation(350, 150);
    }

//    int i = 0;

//    public update_Employee(String text) {
//    }

//    void showData(String id) {

//            if (i == 0)
//                JOptionPane.showMessageDialog(null, "Id not Found");
//            new search_Employee();
//        }

//    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == updatebtn) {
            String name = namefield.getText();
            String fname = fatherNamefield.getText();
            String age = agefield.getText();
            String dob = DOBfield.getText();
            String address = addressfield.getText();
            String phone = phoneNoField.getText();
            String email = email_idField.getText();
            String qualification = qualificationField.getText();
            String aadhar = aadhaarNoField.getText();
            String emp_id = employee_idField.getText();
            try {
                connection con = new connection();
                String str = "update employee set name = '" + name + "',fname = '" + fname + "',age = '" + age + "',dob = '" + dob + "', address = '" + address + "', phone = '" + phone + "', email = '" + email + "', qualification = '" + qualification + "', emp_id = '" + emp_id + "', aadhar = '" + aadhar +"'";
                con.s.executeUpdate(str);
                JOptionPane.showMessageDialog(null, "Details Successfully Updated");
                frame.setVisible(false);
                new search_Employee();
            } catch (Exception ex) {
                ex.printStackTrace();
            }
        } else if (e.getSource() == cancelbtn) {
            frame.setVisible(false);
            new search_Employee();
        }
    }

    public static void main(String[] args) {
        new update_Employee("");
    }

}


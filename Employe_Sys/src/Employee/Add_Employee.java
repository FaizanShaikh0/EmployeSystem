package Employee;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.*;
import java.awt.*;
import java.awt.Image;

import javax.swing.*;

public class Add_Employee implements ActionListener {

    JFrame frame;
    JLabel bckGroundImg, heading, Name, FatherName, age, DateOfBirth, Address, Phone_No, Email_Id, Qualification, Employee_Id, AadhaarNO;
    JTextField namefield, fatherNamefield, agefield, DOBfield, addressfield, phoneNoField, email_idField, qualificationField, employee_idField, aadhaarNoField;
    JButton submitbtn, cancelbtn;
    public int count = 0;
    public static InputStream is , is1;

    public static File file,compressedImageFile;
    public static Image scaled;
    private File chooseFile;
    private String imageString;
    public static ByteArrayInputStream boas;

    public Add_Employee(int i) {
    }

    public Add_Employee() {
        frame = new JFrame("Add Employee");
        frame.setBackground(Color.white);
        frame.setLayout(null);


        bckGroundImg = new JLabel();
        bckGroundImg.setLayout(null);
        bckGroundImg.setBounds(0,0,900,645);

        heading = new JLabel("New Employee Details");
        heading.setBounds(320,30,500,50);
        heading.setFont(new Font("serif",Font.ITALIC,25));
        heading.setForeground(Color.black);
        bckGroundImg.add(heading);
        frame.add(bckGroundImg);

        Name = new JLabel("Name");
        Name.setBounds(50,150,100,30);
        Name.setFont(new Font("serif",Font.BOLD,20));
        bckGroundImg.add(Name);

        namefield = new JTextField();
        namefield.setBounds(200,150,150,30);
        bckGroundImg.add(namefield);

        FatherName = new JLabel("Father's Name");
        FatherName.setBounds(400,150,200,30);
        FatherName.setFont(new Font("serif",Font.BOLD,20));
        bckGroundImg.add(FatherName);

        fatherNamefield = new JTextField();
        fatherNamefield.setBounds(600,150,150,30);
        bckGroundImg.add(fatherNamefield);

        age = new JLabel("Age");
        age.setBounds(50,200,100,30);
        age.setFont(new Font("serif",Font.BOLD,20));
        bckGroundImg.add(age);

        agefield = new JTextField();
        agefield.setBounds(200,200,150,30);
        bckGroundImg.add(agefield);

        DateOfBirth = new JLabel("Date of Birth");
        DateOfBirth.setBounds(400,200,200,30);
        DateOfBirth.setFont(new Font("serif",Font.BOLD,20));
        bckGroundImg.add(DateOfBirth);

        DOBfield = new JTextField();
        DOBfield.setBounds(600,200,150,30);
        bckGroundImg.add(DOBfield);

        Address = new JLabel("Address");
        Address.setBounds(50,250,100,30);
        Address.setFont(new Font("serif",Font.BOLD,20));
        bckGroundImg.add(Address);

        addressfield = new JTextField();
        addressfield.setBounds(200,250,150,30);
        bckGroundImg.add(addressfield);

        Phone_No = new JLabel("Phone-No");
        Phone_No.setBounds(400,250,200,30);
        Phone_No.setFont(new Font("serif",Font.BOLD,20));
        bckGroundImg.add(Phone_No);

        phoneNoField = new JTextField();
        phoneNoField.setBounds(600,250,150,30);
        bckGroundImg.add(phoneNoField);

        Email_Id = new JLabel("Email-id");
        Email_Id.setBounds(50,300,100,30);
        Email_Id.setFont(new Font("serif",Font.BOLD,20));
        bckGroundImg.add(Email_Id);

        email_idField = new JTextField();
        email_idField.setBounds(200,300,150,30);
        bckGroundImg.add(email_idField);

        Qualification = new JLabel("Qualification");
        Qualification.setBounds(400,300,200,30);
        Qualification.setFont(new Font("serif",Font.BOLD,20));
        bckGroundImg.add(Qualification);

        qualificationField = new JTextField();
        qualificationField.setBounds(600,300,150,30);
        bckGroundImg.add(qualificationField);

        AadhaarNO = new JLabel("Aadhaar-No");
        AadhaarNO.setBounds(50,350,100,30);
        AadhaarNO.setFont(new Font("serif",Font.BOLD,20));
        bckGroundImg.add(AadhaarNO);

        aadhaarNoField = new JTextField();
        aadhaarNoField.setBounds(200,350,150,30);
        bckGroundImg.add(aadhaarNoField);

        Employee_Id = new JLabel("Employee-id");
        Employee_Id.setBounds(400,350,200,30);
        Employee_Id.setFont(new Font("serif",Font.BOLD,20));
        bckGroundImg.add(Employee_Id);

        employee_idField = new JTextField();
        employee_idField.setBounds(600,350,150,30);
        bckGroundImg.add(employee_idField);

        submitbtn = new JButton("Submit");
        submitbtn.setBounds(250,500,150,40);
        submitbtn.setBackground(Color.black);
        submitbtn.setForeground(Color.white);
        submitbtn.addActionListener(this);
        bckGroundImg.add(submitbtn);

        cancelbtn = new JButton("Cancel");
        cancelbtn.setBounds(450,500,150,40);
        cancelbtn.setBackground(Color.black);
        cancelbtn.setForeground(Color.white);
        cancelbtn.addActionListener(this);
        bckGroundImg.add(cancelbtn);

        frame.setVisible(true);
        frame.setSize(900,700);
        frame.setLocation(300,50);

        count++;


    }
    @Override
    public void actionPerformed(ActionEvent e) {
        String a  = namefield.getText();
        String b = fatherNamefield.getText();
        String c = agefield.getText();
        String d = DOBfield.getText();
        String ee = addressfield.getText();
        String f = phoneNoField.getText();
        String g = email_idField.getText();
        String h  =qualificationField.getText();
        String i = aadhaarNoField.getText();
        String j = employee_idField.getText();

        if (e.getSource()==submitbtn){
            try {
                connection cc = new connection();
                String query = "insert into employee values('"+a+"','"+b+"','"+c+"','"+d+"','"+ee+"','"+f+"','"+g+"','"+h+"','"+i+"','"+j+"')";
                cc.s.executeUpdate(query);
                JOptionPane.showMessageDialog(null,"Details Successfully Inserted");
                frame.setVisible(false);
                new home();
            } catch (Exception k) {
                System.out.println("The error is:"+k);
            }
        } else if (e.getSource()==cancelbtn) {
            frame.setVisible(false);
            new home();
        }

    }
    public static void main(String[] args) {
        Add_Employee frame = new Add_Employee();
    }
}

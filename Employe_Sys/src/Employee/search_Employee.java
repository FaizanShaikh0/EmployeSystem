package Employee;

import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
import java.sql.ResultSet;
import java.sql.SQLException;

public class search_Employee implements ActionListener {

    JFrame frame;
    JButton search, cancel;
    JLabel EmployeeId, bgimg;
    JTextField employeeField;

    public search_Employee() {

        frame = new JFrame("Search Employee");
        frame.setBackground(Color.white);
        frame.setLayout(null);

        bgimg = new JLabel();
        bgimg.setBounds(0,0,500,270);
        bgimg.setLayout(null);
        ImageIcon img = new ImageIcon(ClassLoader.getSystemResource("Employee/Icons/view.jpg"));
        bgimg.setIcon(img);

        EmployeeId = new JLabel("Employee-Id");
        EmployeeId.setVisible(true);
        EmployeeId.setBounds(40,55,250,30);
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

        cancel = new JButton("Cancel");
        cancel.setBounds(350,140,100,30);
        cancel.addActionListener(this);
        bgimg.add(cancel);

        frame.setVisible(true);
        frame.setSize(500,270);
        frame.setLocation(450,250);


        int i=1;
        if ( i == 0){
            JOptionPane.showMessageDialog(null, "Id not Found");
        }
    }

    @Override
    public void actionPerformed(ActionEvent e) {

       /* try {
        connection con = new connection();
        String query = "select * from employee where emp_id = '"+employeeField+"'";
            ResultSet rs = con.s.executeQuery(query);*/

            if (e.getSource()==search ) {
            new update_Employee(employeeField.getText());
            frame.setVisible(false);
        }
            /*else {
            JOptionPane.showMessageDialog(null, "Invalid login");
            frame.setVisible(false);
        }*/

        if (e.getSource()==cancel) {
            frame.setVisible(false);
            home d = new home();
        }
        }/* catch (SQLException ex) {
            System.out.println("id not found");
        }*/
//    }
    public static void main(String[] args) {
        search_Employee frame = new search_Employee();
    }
}

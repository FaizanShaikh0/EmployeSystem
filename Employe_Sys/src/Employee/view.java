package Employee;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.ResultSet;
import java.sql.SQLException;

public class view implements ActionListener {

    JFrame frame;
    JButton search, camcel;
    JLabel EmployeeId, bgimg;
    JTextField employeeField;

    public view() {
        frame = new JFrame("View");
        frame.setBackground(Color.white);
        frame.setLayout(null);

        bgimg = new JLabel();
        bgimg.setBounds(0,0,500,270);
        bgimg.setLayout(null);
        ImageIcon img = new ImageIcon(ClassLoader.getSystemResource("Employee/Icons/view.jpg"));
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

        camcel = new JButton("Cancel");
        camcel.setBounds(350,140,100,30);
        camcel.addActionListener(this);
        bgimg.add(camcel);

        frame.setSize(500,270);
        frame.setLocation(450,250);
        frame.setVisible(true);

    }
    @Override
    public void actionPerformed(ActionEvent e) {



        try {
            connection con = new connection();
            String c = employeeField.getText();
            String query = "select * from employee where emp_id = '"+c+"'";

            ResultSet rs = con.s.executeQuery(query);
            if (rs.next()){
               new Print_Data(employeeField.getText()).frame.setVisible(true);
               frame.setVisible(false);
            }else if(e.getSource()==camcel) {
                frame.setVisible(false);
                home d = new home();
            }
            else {
                JOptionPane.showMessageDialog(null, "ID NOT FOUND");
            }

        } catch (SQLException ex) {
            throw new RuntimeException(ex);
        }
          /*  if (employeeField.getText().isEmpty()){
                JOptionPane.showMessageDialog(null, "Invalid ID");
                frame.setVisible(false);
                }
            } catch (SQLException ex) {
            throw new RuntimeException(ex);

            if (e.getSource()==search ){
                    frame.setVisible(false);
                    Print_Data p =  new Print_Data(employeeField.getText());
                }
                else if(e.getSource()==camcel) {
                    frame.setVisible(false);
                    home d = new home();
                }*/
    }

    public static void main(String[] args) {
        view frame = new view();
    }
}

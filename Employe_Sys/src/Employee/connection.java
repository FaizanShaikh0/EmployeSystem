package Employee;

import java.sql.*;
public class connection {
            public Connection c;
            public Statement s;

        public connection(){
            try{
                    Class.forName("com.mysql.cj.jdbc.Driver");
                    c = DriverManager.getConnection("jdbc:mysql:///learn","root","root");
                    s = c.createStatement();
             }
                 catch (Exception e){
                 e.printStackTrace();
        }
    }
}

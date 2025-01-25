package BankManagementSystem;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;

public class Conn {
    // 3.4 - Creating a Connection Object
    Connection connection;
    // 3.4.3 - Creating Statement Object.
    Statement statement;
    // 3. First Import Mysql-connector to lib.
    // 3.2 - Creating a constructor
    Conn(){
        // 3.3 Our code will be in Try/Catch Block, because it can throw some errors.
        try {
            // 3.4.2
            connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/BankSys","root","1234");
            //3.4.4
            statement = connection.createStatement();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}

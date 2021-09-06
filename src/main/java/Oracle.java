
import oracle.jdbc.OracleDriver;

import java.sql.*;
import java.util.Properties;

public class Oracle {

    public void run() {

        String url = "jdbc:oracle:thin:@//localhost:1521/XEPDB1";

        try {
            DriverManager.registerDriver(new OracleDriver());
            String userName = "dafur";
            String password = "dafur";
            Connection conn = null;
            Properties connectionProps = new Properties();
            connectionProps.put("user", userName);
            connectionProps.put("password", password);
            conn = DriverManager.getConnection(url, userName, password);
            String query = "select * from dafur.person";
            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery(query);
            while(rs.next()){
                System.out.println("####" + rs.getString("personid") + " - " + rs.getString("personage"));
            }
            System.out.println("isvalid = " + conn.isValid(1000));
            conn.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }

    }
}

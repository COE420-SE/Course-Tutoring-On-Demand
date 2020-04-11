package JDBC;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class DBConnection {
	String DBURL = "jdbc:oracle:thin:@coeoracle.aus.edu:1521:orcl";
    String DBUSER = "G00071029";
    String DBPASS = "G00071029";

    boolean validLogin = false;

    Connection con;
    Statement statement;
    PreparedStatement prepStatement;
    ResultSet rs;

    public DBConnection()
    {
        try {
            // Load Oracle JDBC Driver
            Class.forName("oracle.jdbc.driver.OracleDriver");
            // Connect to Oracle Database
            con = DriverManager.getConnection(DBURL, DBUSER, DBPASS);
            System.out.println("Connected to the database");

        } catch (ClassNotFoundException | SQLException e) {
        	System.out.println("SQL ErroR - Retreiving usename/password.");
        }

    }

    public ResultSet executeStatement(String strSQL) throws SQLException {
        // make the result set scrolable forward/backward updatable
        statement = con.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_UPDATABLE);
        // populate valid mgr numbers 
        rs = statement.executeQuery(strSQL);
        return rs;
    }

    public int executePrepared(String strSQL) throws SQLException {
        prepStatement = con.prepareStatement(strSQL);
        return prepStatement.executeUpdate();
    }
}

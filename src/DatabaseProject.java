import javax.xml.transform.Result;
import java.sql.*;
import java.util.logging.Level;
import java.util.logging.Logger;

public class DatabaseProject {
    public static void main(String[] args) {
    DatabaseProject pro= new DatabaseProject();
    pro.createConnection();
    }
    void createConnection(){
       try{
           Class.forName("com.mysql.jdbc.Driver");
           Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/mydb","root","Arsenal.232312");
           Statement stmt= con.createStatement();
           ResultSet rs = stmt.executeQuery("SELECT * FROM USERS");
          while (rs.next()){
              String name = rs.getNString("name");
              System.out.println(name);
          }




           System.out.println("DataBase connection");
       } catch (ClassNotFoundException ex) {
           Logger.getLogger(DatabaseProject.class.getName()).log(Level.SEVERE, null, ex);
       }
       catch (SQLException ex) {
           Logger.getLogger(DatabaseProject.class.getName()).log(Level.SEVERE, null, ex);
       }

    }
}

import javax.xml.transform.Result;
import java.sql.*;
import java.util.logging.Level;
import java.util.logging.Logger;

public class DatabaseProject {
    
    Connection con;
    public static void main(String[] args) {
    DatabaseProject pro= new DatabaseProject();
    pro.createConnection();
    pro.createTable();
    }
    void createTable()
   
    {
        try{
           String g= "CREATE TABLE DB1("
                   + "name varchar(100),"
                   + "age int," 
                   + "salary float"
                   + ");";
           Statement stmt= con.createStatement();
           stmt.execute(g);
           System.out.println("Successful");
           stmt.close();
        }catch(SQLException ex){
            Logger.getLogger(DatabaseProject.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }
    void createConnection(){
       try{
           Class.forName("com.mysql.jdbc.Driver");
            con = DriverManager.getConnection("jdbc:mysql://localhost:3306/mydb","Username","Password"); //Enter your database and username and password
           Statement stmt= con.createStatement();
           ResultSet rs = stmt.executeQuery("SELECT * FROM USERS2");
          while (rs.next()){
              String name = rs.getNString("name");
              int age = rs.getInt("age");
              System.out.println(name + "    age = "+age);
          }
            stmt.close();
           System.out.println("DataBase connection");
       } catch (ClassNotFoundException ex) {
           Logger.getLogger(DatabaseProject.class.getName()).log(Level.SEVERE, null, ex);
       }
       catch (SQLException ex) {
           Logger.getLogger(DatabaseProject.class.getName()).log(Level.SEVERE, null, ex);
       }

    }
}

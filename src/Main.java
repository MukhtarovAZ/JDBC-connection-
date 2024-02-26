import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

// Press Shift twice to open the Search Everywhere dialog and type `show whitespaces`,
// then press Enter. You can now see whitespace characters in your code.
public class Main {
    static String userName="root";
    static String password="1453";
    static String dbUrl="jdbc:mysql://localhost:3306/world";
   public static void main(String[] args) throws SQLException {
       Connection connection = null;
       try{
           connection = DriverManager.getConnection(dbUrl,userName,password);
           System.out.println("Connection is done.");
       }catch (SQLException exception){
           System.out.println(exception.getMessage());

       }finally {
           connection.close();
       }

    }
}
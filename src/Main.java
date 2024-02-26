import java.sql.*;

// Press Shift twice to open the Search Everywhere dialog and type `show whitespaces`,
// then press Enter. You can now see whitespace characters in your code.
public class Main {

   public static void main(String[] args) throws SQLException {
       Connection connection = null;
       DbHelper helper =new DbHelper();
       Statement statement=null;
       ResultSet resultSet;
       try{

           connection = helper.getConnection();
           statement = connection.createStatement();
           resultSet = statement.executeQuery("SELECT code,name,Continent,region FROM country");
           while(resultSet.next()){
               System.out.println(resultSet.getString("name"));
           }
       }catch (SQLException exception){
           helper.showErrorMessage(exception);

       }finally {
           connection.close();
       }

    }
}
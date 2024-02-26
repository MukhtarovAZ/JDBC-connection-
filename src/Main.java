import java.sql.*;
import java.util.ArrayList;

// Press Shift twice to open the Search Everywhere dialog and type `show whitespaces`,
// then press Enter. You can now see whitespace characters in your code.
public class Main {

    public static void main(String[] args) throws SQLException {
        Connection connection = null;
        DbHelper helper = new DbHelper();
        /**
         *PrepareStatment--Crate a SQL to insert
         */
        PreparedStatement statement = null;
        ResultSet resultSet;
        try {
            connection = helper.getConnection();
            String sql = "delete from city  where id=4082";
            statement = connection.prepareStatement(sql);
            statement.setInt(1,4082);

           //Start button for code||
           int result =  statement.executeUpdate();
            System.out.println("Info deleted : ");

        } catch (SQLException exception) {
            helper.showErrorMessage(exception);

        } finally {
            statement.close();
            connection.close();
        }


    }


    public static void selectDemo() throws SQLException {
        Connection connection = null;
        DbHelper helper = new DbHelper();
        Statement statement = null;
        ResultSet resultSet;
        try {

            connection = helper.getConnection();
            statement = connection.createStatement();
            resultSet = statement.executeQuery("SELECT code,name,Continent,region FROM country");
            ArrayList<Country> countries = new ArrayList<Country>();
            while (resultSet.next()) {
                countries.add(new Country(
                        resultSet.getString("Code"),
                        resultSet.getString("Name"),
                        resultSet.getString("Continent"),
                        resultSet.getString("Region")));
            }
            System.out.println(countries.size());
        } catch (SQLException exception) {
            helper.showErrorMessage(exception);

        } finally {
            connection.close();
        }

    }
    public static void insertData() throws SQLException{
        Connection connection = null;
        DbHelper helper = new DbHelper();
        /**
         *PrepareStatment--Crate a SQL to insert
         */
        PreparedStatement statement = null;

        try {

            connection = helper.getConnection();
            String sql = "insert into city (Name,CountryCode,District,Population) values(?,?,?,?)";
            statement = connection.prepareStatement
                    (sql);
            statement.setString(1,"Sahil 2");
            statement.setString(2,"AZE");
            statement.setString(3,"Azerbaijan");
            statement.setInt(4,50000);
            //Start button for code||
            int result =  statement.executeUpdate();
            System.out.println("Info added : ");

        } catch (SQLException exception) {
            helper.showErrorMessage(exception);

        } finally {
            statement.close();
            connection.close();
        }

    }
    public void updateData() throws SQLException{
        Connection connection = null;
        DbHelper helper = new DbHelper();
        /**
         *PrepareStatment--Crate a SQL to insert
         */
        PreparedStatement statement = null;
        ResultSet resultSet;
        try {
            connection = helper.getConnection();
            String sql = "update city set population = 800000 ,district='Azerbaijan' where id=4082";
            statement = connection.prepareStatement(sql);
            statement.setInt(1,4082);
            //Start button for code||
            int result =  statement.executeUpdate();
            System.out.println("Info updated : ");

        } catch (SQLException exception) {
            helper.showErrorMessage(exception);

        } finally {
            statement.close();
            connection.close();
        }

    }

}
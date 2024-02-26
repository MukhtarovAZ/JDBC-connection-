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

        try {

            connection = helper.getConnection();
            statement = connection.prepareStatement
                    ("insert into city (Name,CountryCode,District,Population) values('Sahil','AZE','Sahil',50000)");
           //Start button for code||
            statement.executeUpdate();
            System.out.println("Info added ; ");
        } catch (SQLException exception) {
            helper.showErrorMessage(exception);

        } finally {
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
}
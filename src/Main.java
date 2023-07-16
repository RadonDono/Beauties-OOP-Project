import java.sql.*;

public class Main {
    public static void main(String[] args) {
        try {
        Connection connection= DriverManager.getConnection("jdbc:mysql:///Snapfood","root","Parsa@30");
            Statement st=connection.createStatement();
            String query="select * from Snapfood.loginorsignup";
            ResultSet rs=st.executeQuery(query);
            while (rs.next())
            {
                System.out.println(rs.getString(1)+rs.getString(2));
            }
            connection.close();
        }
        catch (SQLException e)
        {
            System.out.println("Error");
        }
    catch (Exception e)
    {

    }
    }
}
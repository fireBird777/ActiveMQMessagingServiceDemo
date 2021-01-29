import javax.jms.TextMessage;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;

public class CrudOperations {


    DatabaseConnector dbCon = new DatabaseConnector();
    Connection con = dbCon.connect();

    public void insertMessage(String textMessage)
    {
        try {
            String sql = "INSERT INTO messages VALUES (?)";
            PreparedStatement stmt = con.prepareStatement(sql);
            stmt.setString(1, String.valueOf(textMessage));
            stmt.executeUpdate();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }
}

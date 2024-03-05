import java.sql.*;

public class DatabaseActions {
    private final String url = "jdbc:mysql://localhost:3306/";
    private final String user = "root";
    private final String password = "root";
    protected Connection connection = DriverManager.getConnection(this.url, this.user, this.password);

    protected String databaseName;

    public DatabaseActions() throws Exception {
    }

    public DatabaseActions(String databaseName) throws Exception {
        this.databaseName = databaseName;
    }

    protected void executeStatement(String sql) throws SQLException {
        Statement statement = connection.createStatement();
        statement.executeUpdate(sql);
        statement.close();
    }
}

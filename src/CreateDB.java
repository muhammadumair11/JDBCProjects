import java.sql.*;


public class CreateDB extends DatabaseActions {

    public CreateDB(String databaseName) throws Exception {
        super(databaseName);
    }

    public Connection getConnection() {
        return this.connection;
    }

    public void initalizeDB() throws Exception {
        String sql = "CREATE DATABASE " + databaseName + ";";
        this.executeStatement(sql);
    }
    
    public void dropDB() throws Exception {
        String sql = "DROP DATABASE " + databaseName + ";";
        this.executeStatement(sql);
    }

}

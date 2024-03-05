
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.util.ArrayList;
import java.util.HashMap;

public class CreateTable extends DatabaseActions {
    private String tableName;
    private HashMap<String , String> tableColumns = new HashMap<String , String>();
    
    public CreateTable(String tableName, String databaseName, HashMap<String , String> tableColumns) throws Exception {
        super(databaseName);
        this.tableName = tableName;
        this.tableColumns.putAll(tableColumns); 
    }

    public void initalizeTable() throws Exception {
        StringBuilder sql = new StringBuilder();
        sql.append("CREATE TABLE")
            .append(" ")
            .append(this.databaseName)
            .append(".")
            .append(this.tableName)
            .append(" (id INT PRIMARY KEY AUTO_INCREMENT, ");


        tableColumns.forEach((key, value) -> {
            sql.append(key).append(" ").append(value).append(",");
        });

        // Removes the comma after last entry
        sql.setLength(sql.length() - 1);
        sql.append( ");");

        System.out.println(sql.toString());
        this.executeStatement(sql.toString());
    }

    public void insertData(ArrayList insertData) throws Exception {

        StringBuilder sql = new StringBuilder();
        sql.append("INSERT INTO ")
            .append(this.databaseName)
            .append(".")
            .append(this.tableName)
            .append(" (");
            
            tableColumns.forEach((key, value) -> {
                sql.append(key).append(",");
            });
            // Removes the comma after last entry
            sql.setLength(sql.length() - 1);
            sql.append(") ");
            
            sql.append("VALUES (");
            
            for (Object object : insertData) {
                sql.append("?,");
            }

            sql.setLength(sql.length() - 1);
            sql.append(") ");
            
            PreparedStatement statement = connection.prepareStatement(sql.toString());

            for (int i = 0; i < insertData.size(); i++) {             
                int parameterIndex = i + 1;

                if(insertData.get(i) instanceof Integer)
                    statement.setInt(parameterIndex, (int)insertData.get(i));
                else 
                    statement.setString(parameterIndex, insertData.get(i).toString());
                
            }

            statement.executeUpdate();
    }

}

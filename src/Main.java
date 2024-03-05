import java.sql.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;

public class Main {
    public static void main(String[] args) {
        try {
            CreateDB db = new CreateDB("testDB");
            // db.initalizeDB();

            HashMap<String, String> tableColumns = new HashMap<String, String>();

            tableColumns.put("title", "Varchar(255)");
            tableColumns.put("author", "Varchar(255)");
            tableColumns.put("quantity", "INT");

            CreateTable testtable = new CreateTable("simple", db.databaseName, tableColumns);


            // testtable.initalizeTable();

            // ArrayList<Object> insertdata = new ArrayList<Object>();
            // insertdata.add("something");
            // insertdata.add("something else");
            // insertdata.add(1);

            // testtable.insertData(insertdata);


            // db.dropDB(db.getConnection());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}

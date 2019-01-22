import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class GarbageDao {
    private Connection connection;
    private Statement statement;
    private ResultSet resultSet;

    public GarbageDao() {
        Class.forName("org.sqlite.JDBC");
        connection = DriverManager.getConnection("jdbc:sqlite:garbageData.db");
        connection.setAutoCommit(false);
        createTableIfDataFileIsEmpty();
    }

	public Garbage getByID(int index){
		return new Garbage(1, "test", 0, 0, 0, 0, 0 );
	}

	public List<Garbage> getAll(){
		return new ArrayList<Garbage>();
	}

	public void removeByID(int id) {
        String removeGarbageQuery =
                "DELETE FROM GARBAGEDATA\n" +
                "WHERE ID = "+ String.valueOf(id) +";";
        statement.executeUpdate(removeGarbageQuery);
    }

	public void updateByID(int id, Garbage item) {
        String updateGarbageQuery =
            "UPDATE GarbageData\n" +
            "SET\n" +
            "    Name = '" + garbageToAdd.getName() +"',\n" +
            "    SMELL = " + garbageToAdd.getSmell() + ",\n" +
            "    DESIGN = " + garbageToAdd.getDesign() + ",\n" +
            "    RECYCLINGTIME = " + garbageToAdd.getRecyclingTime() + ",\n" +
            "    JUNKVALUE = " + garbageToAdd.getJunkValue() + ",\n" +
            "    WEIGHT = " + garbageToAdd.getWeight() + "\n" +
            "WHERE\n" +
            "    ID = " + String.valueOf(id) + ";";
        statement.executeUpdate(updateGarbageQuery);
	}

    public void add(Garbage garbageToAdd) {
        String addGarbageQuery =
                "INSERT INTO GarbageData (NAME,SMELL,DESIGN,RECYCLINGTIME,JUNKVALUE,WEIGHT)\n" +
                "VALUES (\n" +
                "'"+ garbageToAdd.getName() +"',\n" +
                "'"+ garbageToAdd.getSmell() +"',\n" +
                "'"+ garbageToAdd.getDesign() +"',\n" +
                "'"+ garbageToAdd.getRecyclingTime() +"',\n" +
                "'"+ garbageToAdd.getJunkValue() +"',\n" +
                "'"+ garbageToAdd.getWeight() +"'\n" +
                ");";
        statement.executeUpdate(addGarbageQuery);
    };

	private void selectById(int id) {
	    String selectByIdQuery =
                "SELECT * FROM GarbageData\n" +
                "WHRE ID = " + String.valueOf(id);
	    resultSet = statement.executeQuery(selectByIdQuery);
    }

	private void createTable() {
        String createTableSqlQuery =
                "CREATE TABLE GarbageData (\n" +
                "ID INTEGER PRIMARY KEY AUTOINCREMENT,\n" +
                "NAME TEXT,\n" +
                "SMELL INT,\n" +
                "DESIGN INT,\n" +
                "RECYCLINGTIME INT,\n" +
                "JUNKVALUE INT,\n" +
                "WEIGHT INT\n" +
                ");";
        statement.executeUpdate(createTableSqlQuery);
    }

	private void createTableIfDataFileIsEmpty() {
        resultSet = statement.executeQuery("SELECT * FROM GarbageData");
        if(resultSet == null) {
            createTable();
        }
    }
}

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

    public void add(Garbage toAdd) {  }

	public Garbage getByID(int index){
		return new Garbage(1, "test", 0, 0, 0, 0, 0 );
	}

	public List<Garbage> getAll(){
		return new ArrayList<Garbage>();
	}

	public boolean removeByID(int index) { return false; }

	public boolean updateByID(int id, Garbage item) {
		return false;
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
        if(resultSet.next() == false) {

        }
    }
}

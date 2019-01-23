import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class GarbageDao {
    private Connection connection;
    private Statement statement;
    private ResultSet resultSet;

    public GarbageDao() {
        try {
            Class.forName("org.sqlite.JDBC");
            connection = DriverManager.getConnection("jdbc:sqlite:garbageData.db");
            connection.setAutoCommit(false);
            statement = connection.createStatement();
        } catch(Exception e) {
            e.printStackTrace();
        }
        createTableIfDataFileIsEmpty();
    }

	public Garbage getByID(int id){
        String getByIdQuery =
                "SELECT * FROM GARBAGEDATA\n" +
                "WHERE ID = " + String.valueOf(id) + ";";
        setResultSetByQuery(getByIdQuery);
		return garbageByCurrentResultSet();
	}

	public List<Garbage> getAll(){
<<<<<<< HEAD
		List<Garbage> devList = new ArrayList<>();
		devList.add(new Garbage("Fifth", 44, 44, 44, 44));
		devList.add(new Garbage("Second", 22, 22, 22, 22));
		devList.add(new Garbage("First", 99, 99, 99, 99));
		devList.add(new Garbage("Third", 99, 33, 33, 33));
		devList.add(new Garbage("Fourth", 44, 44, 44, 44));
//		devList.add(new Garbage("Sixth", 44, 44, 44, 44));
		return devList;
=======
        setResultSetByQuery("SELECT * FROM GARBAGEDATA");
        List<Garbage> garbageListFromDataBase = new ArrayList<Garbage>();
        try {
            while(resultSet.next()) {
                garbageListFromDataBase.add(
                        garbageByCurrentResultSet()
                );
            }
        } catch(Exception e) {
            e.printStackTrace();
        }
        return garbageListFromDataBase;
>>>>>>> 116b4f77ecc3ae57c2c7ede485b286513b21e363
	}

	public void removeByID(int id) {
        String removeGarbageQuery =
                "DELETE FROM GARBAGEDATA\n" +
                "WHERE ID = "+ String.valueOf(id) +";";
        executeUpdateAndCommit(removeGarbageQuery);
    }

	public void updateByID(int id, Garbage garbageToAdd) {
        String updateGarbageQuery =
            "UPDATE GarbageData\n" +
            "SET\n" +
            "    Name = '" + garbageToAdd.getName() +"',\n" +
            "    SMELL = " + garbageToAdd.getSmell() + ",\n" +
            "    RECYCLINGTIME = " + garbageToAdd.getRecyclingTime() + ",\n" +
            "    JUNKVALUE = " + garbageToAdd.getJunkValue() + ",\n" +
            "    WEIGHT = " + garbageToAdd.getWeight() + "\n" +
            "WHERE\n" +
            "    ID = " + String.valueOf(id) + ";";
        executeUpdateAndCommit(updateGarbageQuery);
	}

    public void add(Garbage garbageToAdd) {
        String addGarbageQuery =
                "INSERT INTO GarbageData (NAME,SMELL,RECYCLINGTIME,JUNKVALUE,WEIGHT)\n" +
                "VALUES (\n" +
                "'"+ garbageToAdd.getName() +"',\n" +
                "'"+ garbageToAdd.getSmell() +"',\n" +
                "'"+ garbageToAdd.getRecyclingTime() +"',\n" +
                "'"+ garbageToAdd.getJunkValue() +"',\n" +
                "'"+ garbageToAdd.getWeight() +"'\n" +
                ");";
        executeUpdateAndCommit(addGarbageQuery);
    }

    private Garbage garbageByCurrentResultSet() {
        try {
            return new Garbage(
                    resultSet.getInt("ID"),
                    resultSet.getString("NAME"),
                    resultSet.getInt("SMELL"),
                    resultSet.getInt("RECYCLINGTIME"),
                    resultSet.getInt("JUNKVALUE"),
                    resultSet.getInt("WEIGHT")
            );
        } catch(Exception e) {
            e.printStackTrace();
        }
        return new Garbage(-1, "error", -1, -1, -1, -1);
    }

	private void createTable() {
        String createTableSqlQuery =
                "CREATE TABLE GarbageData (\n" +
                "ID INTEGER PRIMARY KEY AUTOINCREMENT,\n" +
                "NAME TEXT,\n" +
                "SMELL INT,\n" +
                "RECYCLINGTIME INT,\n" +
                "JUNKVALUE INT,\n" +
                "WEIGHT INT\n" +
                ");";
        executeUpdateAndCommit(createTableSqlQuery);
    }

	private void createTableIfDataFileIsEmpty() {
        setResultSetByQuery("SELECT * FROM GarbageData");
        if(resultSet == null) {
            System.out.println("GarbageData table not found in database, creating GarbageData...");
            createTable();
        }
    }

    private void executeUpdateAndCommit(String sqlCommand) {
        try {
            statement.executeUpdate(sqlCommand);
            connection.commit();
        } catch(Exception e) {
            e.printStackTrace();
        }
    }

    private void setResultSetByQuery(String query) {
        try {
            resultSet = statement.executeQuery(query);
        } catch(Exception e) {
            e.printStackTrace();
        }
    }
}

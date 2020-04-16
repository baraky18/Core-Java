import java.sql.*;

/*
 * to use JDBC you need to follow the following steps:
 * 1. import java.sql.*
 * 2. load and register the driver -> com.mysql.jdbc.Driver
 * 3. create connection
 * 4. create statement
 * 5. execute query
 * 6. process the results
 * 7. close
 */
public class JdbcMain {

	public static void main(String[] args) throws ClassNotFoundException, SQLException{
		String url = "jdbc:mysql://localhost:3307/aliens";
		String userName = "root";
		String password = "";
		/*
		 * when doing Class.forName() we are actually executing the static methods in the class without initializing it,
		 * which means that the Driver will be registered
		 */
		Class.forName("com.mysql.jdbc.Driver");
		Connection con = DriverManager.getConnection(url, userName, password);
		Statement st = con.createStatement();
		
		//fetch single row from DB
		fetchSingleRowFromDb(st);
		
		//fetch multiple rows from DB
		fetchMultipleRowsFromDb(st);
		
		//insert rows
		insertRowToDb(st);
		
		//query using parameters
		insertRowToDbUsingParams(con);
		
		st.close();
		con.close();
	}

	private static void insertRowToDbUsingParams(Connection con) throws SQLException {
		int userIdParam = 5;
		String userNameParam = "Oz";
		String query4 = "insert into student values (?,?)";
		PreparedStatement prepareSt = con.prepareStatement(query4);
		prepareSt.setInt(1, userIdParam);
		prepareSt.setString(2, userNameParam);
		int rowsUpdatedParam = prepareSt.executeUpdate();
		System.out.println(rowsUpdatedParam + " rows effected");
	}

	private static void insertRowToDb(Statement st) throws SQLException {
		String query3 = "insert into student values (4, Ronnie)";
		int rowsUpdated = st.executeUpdate(query3);
		System.out.println(rowsUpdated + " rows effected");
	}

	private static void fetchMultipleRowsFromDb(Statement st) throws SQLException {
		String query2 = "select * from student";
		String userData = "";
		ResultSet rs2 = st.executeQuery(query2);
		while(rs2.next()){
			userData = rs2.getInt(1) + " : " + rs2.getString(2);
		}
		System.out.println(userData);
	}

	private static void fetchSingleRowFromDb(Statement st) throws SQLException {
		String query1 = "select username from student where userid=3";
		ResultSet rs1 = st.executeQuery(query1);
		rs1.next();
		String name = rs1.getString("username");
		System.out.println(name);
	}
}

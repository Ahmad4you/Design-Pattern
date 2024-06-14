package strategy;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

//Strategy interface
interface DatabaseConnectionStrategy {
	Connection getConnection() throws SQLException;
}

//Concrete strategies
class MySQLConnectionStrategy implements DatabaseConnectionStrategy {
	private String url;
	private String username;
	private String password;

	public MySQLConnectionStrategy(String url, String username, String password) {
		this.url = url;
		this.username = username;
		this.password = password;
	}

	@Override
	public Connection getConnection() throws SQLException {
		return DriverManager.getConnection(url, username, password);
	}
}

class PostgreSQLConnectionStrategy implements DatabaseConnectionStrategy {
	private String url;
	private String username;
	private String password;

	public PostgreSQLConnectionStrategy(String url, String username, String password) {
		this.url = url;
		this.username = username;
		this.password = password;
	}

	@Override
	public Connection getConnection() throws SQLException {
		return DriverManager.getConnection(url, username, password);
	}
}

//Context
class DatabaseManager {
	private DatabaseConnectionStrategy connectionStrategy;

	public void setConnectionStrategy(DatabaseConnectionStrategy connectionStrategy) {
		this.connectionStrategy = connectionStrategy;
	}

	public Connection getConnection() throws SQLException {
		return connectionStrategy.getConnection();
	}
}

public class StrategyDataBaseCalling {

	public static void main(String[] args) {
		DatabaseManager databaseManager = new DatabaseManager();
		Connection mysqlConnection = null, postgresConnection = null;

		// MySQL connection
		databaseManager.setConnectionStrategy(
				new MySQLConnectionStrategy("jdbc:mysql://localhost:3306/mydatabase", "username", "password"));
		// PostgreSQL connection
		databaseManager.setConnectionStrategy(new PostgreSQLConnectionStrategy(
				"jdbc:postgresql://localhost:5432/mydatabase", "username", "password"));

		try {
			mysqlConnection = databaseManager.getConnection();
			postgresConnection = databaseManager.getConnection();
		} catch (SQLException e) {
			e.printStackTrace();
		
		} finally {
			try {
				mysqlConnection.close();
				postgresConnection.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}

	}
}

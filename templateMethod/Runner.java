package templateMethod;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.List;

public class Runner {

	public static void main(String[] args) {
		
		// Establish a database connection
		Connection connection = null;
		try {
			connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/mydatabase", "username", "password");
		
			// Execute a SELECT query
			JDBCTemplate selectQuery = new SelectQuery(connection);
			List<Object> result = selectQuery.executeQuery("SELECT * FROM users WHERE age > ?", 30);
			// Process the result list

			// Execute an UPDATE query
			JDBCTemplate updateQuery = new UpdateQuery(connection);
			updateQuery.executeQuery("UPDATE users SET email = ? WHERE id = ?", "newemail@example.com", 1);
			
			
			// Execute an INSERT query
			JDBCTemplate insertQuery = new InsertQuery(connection);
			List<Object> generatedKeys = insertQuery.executeQuery("INSERT INTO users (name, email) VALUES (?, ?)", "John Doe", "john@example.com");
			// Process the generated keys

			// Execute a DELETE query
			JDBCTemplate deleteQuery = new DeleteQuery(connection);
			List<Object> deletedRows = deleteQuery.executeQuery("DELETE FROM users WHERE id = ?", 1);
			// Process the number of deleted rows
			
			
		} catch (SQLException e) {
			
			throw new RuntimeException("Error executing query: " , e);
		}
		
		

	}

}

package strategy;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

//Strategy interface
interface SQLStatementStrategy {
	ResultSet execute(Connection connection, String sql) throws SQLException;
}

//Concrete strategies
class SelectStatementStrategy implements SQLStatementStrategy {
	@Override
	public ResultSet execute(Connection connection, String sql) throws SQLException {
		Statement statement = connection.createStatement();
		return statement.executeQuery(sql);
	}
}

class UpdateStatementStrategy implements SQLStatementStrategy {
	@Override
	public ResultSet execute(Connection connection, String sql) throws SQLException {
		Statement statement = connection.createStatement();
		statement.executeUpdate(sql);
		return null; // Update statements don't return a ResultSet
	}
}

//Context
class JDBCExecutor {
	private SQLStatementStrategy statementStrategy;

	public void setStatementStrategy(SQLStatementStrategy statementStrategy) {
		this.statementStrategy = statementStrategy;
	}

	public ResultSet executeStatement(Connection connection, String sql) throws SQLException {
		return statementStrategy.execute(connection, sql);
	}
}

public class JdbcExecutorStrategy {
	public static void main(String[] args) {
		JDBCExecutor jdbcExecutor = new JDBCExecutor();

		// Establish a database connection
		Connection connection = null;
		ResultSet resultSet = null;
		try {
			connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/mydatabase", "username",
					"password");
		
			// Execute a SELECT statement
			jdbcExecutor.setStatementStrategy(new SelectStatementStrategy());
		    resultSet = jdbcExecutor.executeStatement(connection, "SELECT * FROM users");
			// Process the resultSet

			// Execute an UPDATE statement
			jdbcExecutor.setStatementStrategy(new UpdateStatementStrategy());
			jdbcExecutor.executeStatement(connection, "UPDATE users SET email = 'new@example.com' WHERE id = 1");
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				connection.close();
				resultSet.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}

		
	}
}

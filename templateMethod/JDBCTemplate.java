package templateMethod;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

// Abstract class defining the template method
abstract class JDBCTemplate {
	private final Connection connection;

	public JDBCTemplate(Connection connection) {
		this.connection = connection;
	}

	public final List<Object> executeQuery(String query, Object... params) {
		try {
			// Step 1: Prepare the statement
			PreparedStatement statement = prepareStatement(query, params);

			// Step 2: Execute the query (implemented by subclasses)
			ResultSet resultSet = executeQuery(statement);

			// Step 3: Process the result set (implemented by subclasses)
			List<Object> result = processResultSet(resultSet);

			// Step 4: Clean up resources
			cleanUp(statement, resultSet);

			return result;
		} catch (SQLException e) {
			throw new RuntimeException("Error executing query: " + query, e);
		}
	}

	// Template method with a default implementation
	private PreparedStatement prepareStatement(String query, Object... params) throws SQLException {
		PreparedStatement statement = connection.prepareStatement(query);
		for (int i = 0; i < params.length; i++) {
			statement.setObject(i + 1, params[i]);
		}
		return statement;
	}

	// Abstract method to be implemented by subclasses
	protected abstract ResultSet executeQuery(PreparedStatement statement) throws SQLException;

	// Abstract method to be implemented by subclasses
	protected abstract List<Object> processResultSet(ResultSet resultSet) throws SQLException;

	// Template method with a default implementation
	private void cleanUp(PreparedStatement statement, ResultSet resultSet) {
		try {
			if (resultSet != null) {
				resultSet.close();
			}
			if (statement != null) {
				statement.close();
			}
		} catch (SQLException e) {
			// Handle exception
		}
	}
}

// Concrete subclass for executing SELECT queries
class SelectQuery extends JDBCTemplate {
	public SelectQuery(Connection connection) {
		super(connection);
	}

	@Override
	protected ResultSet executeQuery(PreparedStatement statement) throws SQLException {
		return statement.executeQuery();
	}

	@Override
	protected List<Object> processResultSet(ResultSet resultSet) throws SQLException {
		List<Object> result = new ArrayList<>();
		while (resultSet.next()) {
			// Process each row of the result set
			// and add the result to the list
			result.add(resultSet.getObject(1));
		}
		return result;
	}
}

// Concrete subclass for executing UPDATE/INSERT/DELETE queries
class UpdateQuery extends JDBCTemplate {
	public UpdateQuery(Connection connection) {
		super(connection);
	}

	@Override
	protected ResultSet executeQuery(PreparedStatement statement) throws SQLException {
		statement.executeUpdate();
		return null; // No result set for UPDATE/INSERT/DELETE queries
	}

	@Override
	protected List<Object> processResultSet(ResultSet resultSet) {
		return null; // No result set to process for UPDATE/INSERT/DELETE queries
	}
}

// Concrete subclass for executing INSERT queries
class InsertQuery extends JDBCTemplate {
	public InsertQuery(Connection connection) {
		super(connection);
	}

	@Override
	protected ResultSet executeQuery(PreparedStatement statement) throws SQLException {
		statement.executeUpdate();
		return statement.getGeneratedKeys(); // Return generated keys (if any)
	}

	@Override
	protected List<Object> processResultSet(ResultSet resultSet) throws SQLException {
		List<Object> generatedKeys = new ArrayList<>();
		while (resultSet.next()) {
			generatedKeys.add(resultSet.getObject(1)); // Assuming a single generated key column
		}
		return generatedKeys;
	}
}

// Concrete subclass for executing DELETE queries
class DeleteQuery extends JDBCTemplate {
	public DeleteQuery(Connection connection) {
		super(connection);
	}

	@Override
	protected ResultSet executeQuery(PreparedStatement statement) throws SQLException {
		return statement.executeQuery();
	}

	@Override
	protected List<Object> processResultSet(ResultSet resultSet) throws SQLException {
		List<Object> deletedRows = new ArrayList<>();
		while (resultSet.next()) {
			deletedRows.add(resultSet.getObject(1)); // Assuming a single column with deleted row count
		}
		return deletedRows;
	}
}

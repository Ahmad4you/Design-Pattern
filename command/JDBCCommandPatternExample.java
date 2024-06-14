package command;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;


//Command interface
interface SQLCommand {
 void execute();
}

//Concrete Command implementations
class SelectCommand implements SQLCommand {
 private Connection connection;
 private String query;

 public SelectCommand(Connection connection, String query) {
     this.connection = connection;
     this.query = query;
 }

 @Override
 public void execute() {
     try (Statement statement = connection.createStatement();
          ResultSet resultSet = statement.executeQuery(query)) {
         while (resultSet.next()) {
             // Process the result set
             System.out.println(resultSet.getString(1));
         }
     } catch (SQLException e) {
    	 throw new RuntimeException(e);
     }
 }
}

class UpdateCommand implements SQLCommand {
 private Connection connection;
 private String query;

 public UpdateCommand(Connection connection, String query) {
     this.connection = connection;
     this.query = query;
 }

 @Override
 public void execute() {
     try (Statement statement = connection.createStatement()) {
         int rowsAffected = statement.executeUpdate(query);
         System.out.println("Rows affected: " + rowsAffected);
     } catch (SQLException e) {
         e.printStackTrace();
     }
 }
}

//Invoker
class SQLCommandExecutor {
 private SQLCommand command;

 public void setCommand(SQLCommand command) {
     this.command = command;
 }

 public void executeCommand() {
     command.execute();
 }
}

public class JDBCCommandPatternExample {

	public static void main(String[] args) {
		  // Establish a database connection
        Connection connection;
		try {
			connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/mydatabase", "username", "password");

        SQLCommandExecutor executor = new SQLCommandExecutor();

        // Execute a SELECT statement
        SQLCommand selectCommand = new SelectCommand(connection, "SELECT * FROM users");
        executor.setCommand(selectCommand);
        executor.executeCommand();

        // Execute an UPDATE statement
        SQLCommand updateCommand = new UpdateCommand(connection, "UPDATE users SET email = 'newemail@example.com' WHERE id = 1");
        executor.setCommand(updateCommand);
        executor.executeCommand();
        
		} catch (SQLException e) {
			throw new RuntimeException("SQLException: ", e);
		}
	}
}

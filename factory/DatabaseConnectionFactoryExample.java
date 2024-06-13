package factory;

/**
 * 
 * @author Ahmad Alrefai
 */
//Product interface
interface DatabaseConnection {
 void connect();
 void disconnect();
}

//Concrete products
class MySQLConnection implements DatabaseConnection {
 @Override
 public void connect() {
     System.out.println("Connecting to MySQL database.");
 }

 @Override
 public void disconnect() {
     System.out.println("Disconnecting from MySQL database.");
 }
}

class PostgreSQLConnection implements DatabaseConnection {
 @Override
 public void connect() {
     System.out.println("Connecting to PostgreSQL database.");
 }

 @Override
 public void disconnect() {
     System.out.println("Disconnecting from PostgreSQL database.");
 }
}

//Factory class
class DatabaseConnectionFactory {
 public static DatabaseConnection createConnection(String type) {
     if (type.equalsIgnoreCase("mysql")) {
         return new MySQLConnection();
     } else if (type.equalsIgnoreCase("postgresql")) {
         return new PostgreSQLConnection();
     } else {
         throw new IllegalArgumentException("Invalid database type.");
     }
 }
}

public class DatabaseConnectionFactoryExample {

	public static void main(String[] args) {
        DatabaseConnection mysqlConnection = DatabaseConnectionFactory.createConnection("mysql");
        mysqlConnection.connect();
        mysqlConnection.disconnect();

        DatabaseConnection postgresConnection = DatabaseConnectionFactory.createConnection("postgresql");
        postgresConnection.connect();
        postgresConnection.disconnect();
    }
}

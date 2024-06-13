package singleton;

import java.sql.Connection;
import java.sql.DriverManager;

public class DatabaseConnection {
    private static volatile DatabaseConnection instance;
    private static Object lock = new Object();
    private Connection connection;

    private DatabaseConnection() {
        try {
            // Simulate establishing a database connection
            Thread.sleep(1000); // Simulating a time-consuming operation
            connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/mydb", "username", "password");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static DatabaseConnection getInstance() {
        if (instance == null) {
            synchronized (lock) {
                if (instance == null) {
                    instance = new DatabaseConnection();
                }
            }
        }
        return instance;
    }

    public Connection getConnection() {
        return connection;
    }

    public static void main(String[] args) {
        Thread thread1 = new Thread(() -> {
            DatabaseConnection connection1 = DatabaseConnection.getInstance();
            System.out.println("Thread 1: " + connection1.getConnection());
        });

        Thread thread2 = new Thread(() -> {
            DatabaseConnection connection2 = DatabaseConnection.getInstance();
            System.out.println("Thread 2: " + connection2.getConnection());
        });

        thread1.start();
        thread2.start();
        
        /*
         * Thread 1: com.mysql.cj.jdbc.ConnectionImpl@6d6f6e28
		       Thread 2: com.mysql.cj.jdbc.ConnectionImpl@6d6f6e28
         * 
         */
    }
}

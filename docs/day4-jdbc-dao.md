# Day 4: JDBC Data Access Layer

## Project Name
**LifePilot AI – Personal Task and Decision Assistant**

## 1. Objective

The objective of Day 4 was to implement the JDBC Data Access Object (DAO) layer to connect the Java application with the MySQL database and perform database operations on goals.

## 2. Database Connection

A utility class named `DBConnection` was created in the `com.lifepilot.dao` package.

The class contains a static `getConnection()` method that establishes a connection between the Java application and the `lifepilot_db` MySQL database using JDBC.

The method returns a `Connection` object and throws `SQLException` if a database connection error occurs.

## 3. Goal Data Access Object

A class named `GoalDAO` was created to handle database operations related to goals.

### 3.1 Save Goal

The `saveGoal(Goal goal)` method inserts a new goal into the `goals` table.

The method uses:
- `PreparedStatement` to execute a parameterized SQL INSERT statement.
- Getters from the `Goal` model class to obtain goal details.
- `java.sql.Date` to convert `LocalDate` into a database-compatible date.
- SQL NULL handling when the target date is not provided.
- `executeUpdate()` to execute the insertion and check the number of affected rows.

The method returns `true` when one row is inserted successfully and `false` if a SQL exception occurs.

### 3.2 Retrieve All Goals

The `getAllGoals()` method retrieves all records from the `goals` table.

The method uses:
- A SQL SELECT statement to retrieve goal details.
- `PreparedStatement` to execute the query.
- `ResultSet` to process the retrieved records.
- `ArrayList<Goal>` to store the retrieved goals.
- Getters and setters from the `Goal` model class to map database values to Java objects.

The method returns a list of `Goal` objects. If a SQL exception occurs, it prints an error message and returns the list containing any records processed before the error, or an empty list if no records were processed.

## 4. Resource Management

Try-with-resources was used to automatically close the JDBC connection, prepared statement, and result set after the operations are completed. This helps prevent database resource leaks.

## 5. Model Class Enhancement

The `Goal` model class was enhanced with a `toString()` method to display goal information in a readable format.

This makes it easier to verify retrieved records by printing the list of goal objects to the console.

## 6. Testing and Verification

The following operations were tested:

1. Establishing a JDBC connection to MySQL.
2. Inserting goal details into the `goals` table.
3. Retrieving all stored goals using the SELECT query.
4. Mapping database records to Java `Goal` objects.
5. Displaying retrieved goal information in the console.

The database query confirmed that goal records were stored successfully. The Java application retrieved and displayed seven existing goal records during verification.

Repeated test executions of `saveGoal()` created additional records because the method currently inserts a new row for each call.

## 7. Outcome

The JDBC data access layer was implemented successfully. The application can now connect to MySQL, insert goal records, and retrieve saved goals. This establishes the database access foundation for the next development stages of LifePilot AI.

## 8. Technologies Used

- Java 21
- JDBC
- MySQL
- Apache NetBeans 24
- Maven

## 9. Next Step

The next development stage will continue building the application's data access functionality and prepare the foundation for managing tasks and their associated goals.
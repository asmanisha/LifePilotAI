# Day 5: Goal CRUD Operations Using JDBC

## Project Name
**LifePilot AI – Personal Task and Decision Assistant**

## 1. Objective

The objective of Day 5 was to implement and test the Update and Delete operations for goal records using Java Database Connectivity (JDBC). These operations extend the existing data access layer and complete the basic Create, Read, Update, and Delete (CRUD) functionality for goals.

## 2. Technologies Used

- Java 21
- JDBC
- MySQL
- Apache NetBeans 24
- Maven

## 3. Update Goal Operation

A method named `updateGoal(int goalId, String newTitle)` was implemented in the `GoalDAO` class.

### Functionality

The method updates the title of an existing goal using its unique goal ID.

### Implementation Details

- Uses an SQL `UPDATE` statement to modify the goal title.
- Uses `PreparedStatement` to pass the new title and goal ID as parameters.
- Uses `executeUpdate()` to execute the query and obtain the number of affected rows.
- Returns `true` when exactly one row is updated; otherwise, it returns `false`.
- Handles `SQLException` and uses try-with-resources to close database resources automatically.

### Test Result

Goal ID 1 was updated with the title `Learn basic java`.

The update operation returned `true`, confirming that the existing goal was updated successfully.

## 4. Delete Goal Operation

A method named `deleteGoal(int goalId)` was implemented in the `GoalDAO` class.

### Functionality

The method deletes an existing goal record from the `goals` table using its unique goal ID.

### Implementation Details

- Uses an SQL `DELETE` statement with a `WHERE` condition.
- Uses `PreparedStatement` to pass the goal ID as a parameter.
- Uses `executeUpdate()` to determine the number of affected rows.
- Returns `true` when exactly one row is deleted; otherwise, it returns `false`.
- Handles `SQLException` and automatically closes database resources using try-with-resources.

### Test Result

Goal ID 4 had already been deleted during an earlier test. When the program attempted to delete it again, the method returned `false` because no matching record existed.

This verified the method's behavior when the specified goal ID does not exist.

## 5. Integration with Existing Methods

The `GoalDAO` class now supports all four basic CRUD operations:

| Operation | Method | Purpose |
|---|---|---|
| Create | `saveGoal()` | Inserts a new goal |
| Read | `getAllGoals()` | Retrieves all goals |
| Update | `updateGoal()` | Updates an existing goal title |
| Delete | `deleteGoal()` | Deletes a goal by ID |

## 6. Resource Management and Error Handling

Try-with-resources was used to manage database connections and prepared statements. This ensures that resources are closed automatically after each operation.

SQL exceptions are caught and reported with error messages. The update and delete methods return boolean values to indicate whether exactly one database record was affected.

## 7. Outcome

The Update and Delete operations were implemented and tested successfully. Together with the Create and Read operations completed earlier, the goal data access layer now supports basic CRUD functionality.

This provides a foundation for the next stages of LifePilot AI, including task management, business logic, and the desktop user interface.

## 8. Next Step

The next development stage will continue implementing the data access functionality needed to manage tasks and associate them with goals.
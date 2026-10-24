# Day 3 — Java Model Classes

## Objective
Create Java model classes to represent goals and tasks in LifePilot AI.

## Technologies
- Java 21
- Apache NetBeans 24
- Maven

## Implementation
- Created the `Goal` class in `com.lifepilot.model`.
- Added fields for goal ID, title, description, target date, status, and creation timestamp.
- Implemented a constructor, getters, setters, and a display method.
- Created the `Task` class in `com.lifepilot.model`.
- Added fields for task ID, optional goal ID, title, description, task type, priority, optional duration, optional deadline, status, and creation timestamp.
- Implemented a constructor, getters, setters, and a display method.
- Used `LocalDate` and `LocalDateTime` for date-related fields.
- Set default task status to `PENDING` and priority to `MEDIUM`.

## Testing
- Created a sample goal and task.
- Verified that their details were printed to the console.
- Verified that optional goal, duration, and deadline values can be `null`.
- Verified that the task creation timestamp is generated automatically.

## Outcome
The initial Java model classes are implemented and tested. They will be used in later stages of the application.

## Next Steps
Develop the data access layer to perform database operations using JDBC.
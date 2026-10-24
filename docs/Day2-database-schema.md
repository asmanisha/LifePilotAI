# LifePilot AI — Day 2 Database Schema

## Objective

Design a relational MySQL schema for tasks, goals, recurrence rules, and individual recurring task occurrences.

## Database

- Database name: lifepilot_db
- Database engine: MySQL
- Application connectivity: JDBC

## Tables Created

### 1. goals

Purpose: Store long-term goals and optional target dates.

Columns implemented:
- [Fill in after creating the table]

Primary key:
- [Fill in]

### 2. tasks

Purpose: Store individual tasks and their status.

Columns implemented:
- [Fill in after creating the table]

Primary key:
- [Fill in]

Foreign keys:
- [Fill in]

### 3. recurrence_rules

Purpose: Store recurrence settings for recurring tasks.

Implementation status: Not started.

### 4. task_occurrences

Purpose: Track individual scheduled instances of recurring tasks.

Implementation status: Not started.

## Design Decisions

1. Deadlines are optional.
2. Tasks can exist without belonging to a goal.
3. Recurrence rules are separate from individual occurrences.
4. Duplicate occurrences must be prevented.
5. Relationships must be protected by appropriate foreign-key constraints.

## Testing Results

Record the SQL statements executed and their actual results.

- Database selected:
- Tables created:
- Foreign keys verified:
- Errors encountered:
- Fixes applied:

## Current Status

Update this section after testing. Do not mark unimplemented or untested tables as complete.
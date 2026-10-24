# LifePilot AI — Database Design

## 1. Project Overview

LifePilot AI is a personal productivity application that helps users manage daily tasks, recurring activities, long-term goals, and schedules.

The application will initially be developed as a Java Swing desktop application using MySQL and JDBC. In Phase 2, it will be extended into a web application using Spring Boot and React.js.

## 2. Purpose of the Database

The database stores tasks, goals, recurrence rules, and individual task occurrences.

It allows users to close and reopen the application without losing their saved information. It also supports task completion tracking and progress monitoring.

## 3. Task Categories

### 3.1 One-Time Tasks

One-time tasks are activities that the user expects to perform once.

Example: Submit my resume.

A task can have an optional deadline, duration, priority, and completion status.

### 3.2 Recurring Tasks

Recurring tasks repeat according to a schedule.

Examples:
- Practice Java every day.
- Study SQL every Monday and Wednesday.

The recurrence rule defines when an activity repeats. Each individual occurrence represents a particular scheduled instance of that activity.

Completing one occurrence must not permanently complete the recurring activity.

### 3.3 Long-Term Goals

Long-term goals represent outcomes that require multiple smaller activities.

Example: Learn SQL.

A goal can contain multiple tasks that contribute to its progress. A target date is optional.

### 3.4 Flexible Tasks

Flexible tasks remain in a backlog until the user decides when to schedule them.

Example: Read about Spring Boot.

A flexible task does not need a scheduled date or deadline.

## 4. Optional Deadlines

Deadlines are optional for tasks and goals.

If a task has no deadline, it must not be marked overdue merely because time has passed.

The application must distinguish between a missing deadline and a deadline that has passed.

## 5. Main Data Entities

The initial database design will consider these entities:

- Tasks: Stores task details, status, duration, priority, and optional dates.
- Goals: Stores long-term goals and their progress information.
- Recurrence Rules: Stores the repeat frequency and selected weekdays for recurring activities.
- Task Occurrences: Stores individual instances of recurring activities and their completion status.

The exact columns, primary keys, foreign keys, and relationships will be finalized before the database tables are created.

## 6. Data Relationships

A goal may contain multiple tasks.

A recurring activity may have one recurrence rule and multiple individual task occurrences.

Each occurrence belongs to its recurring activity. Completing an occurrence changes that occurrence's status, not the recurrence rule itself.

Tasks that do not belong to a long-term goal can exist independently.

## 7. Validation Rules

1. Every saved task must have a valid task name.
2. A deadline is optional.
3. A task without a deadline must never be marked overdue.
4. Task duration, when provided, must be greater than zero.
5. Completing a recurring occurrence must not permanently complete future occurrences.
6. Each recurring occurrence must belong to a valid recurring activity.
7. Task and goal records must maintain valid relationships.
8. Proposed plans must be reviewed and approved by the user before they are saved.

## 8. Security and Data Integrity

Database operations must use prepared statements when using JDBC.

Database credentials must not be committed to a public GitHub repository.

The application must handle database errors without silently losing user data.

## 9. Current Scope and Limitations

This document describes the planned database design. The database schema and its relationships must be implemented and tested before they are considered complete.

Advanced authentication and multi-user data isolation are not part of the initial desktop milestone.

## 10. Document Status

Status: Initial design draft.

The schema will be updated as implementation and testing reveal necessary changes.
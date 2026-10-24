package com.lifepilot.dao;

import com.lifepilot.model.Task;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.time.LocalDateTime;
import java.sql.Timestamp;
import java.sql.SQLException;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class TaskDAO {
    
    // save the task using insert statement
    public boolean saveTask(Task task){
        
        String sql = "INSERT INTO tasks (goal_id, title, description, task_type, priority, duration_minutes, deadline, status) "
                   + "VALUES (?, ?, ?, ?, ?, ?, ?, ?)";

        // try-with-resources closes both connection and statement
        try (Connection conn = DBConnection.getConnection();
             PreparedStatement ps = conn.prepareStatement(sql)) {

            // Read values from the Goal object via getters
            Integer goalId = task.getGoalId();
            if (goalId != null) {
                ps.setInt(1, task.getGoalId());
            } else {
                ps.setNull(1, java.sql.Types.INTEGER);
            }
            ps.setString(2, task.getTitle());
            ps.setString(3, task.getDescription());
            ps.setString(4, task.getTaskType());
            ps.setString(5, task.getPriority());

            Integer durationMinutes = task.getDurationMinutes();
            if (durationMinutes != null) {
                ps.setInt(6, task.getDurationMinutes());
            } else {
                ps.setNull(6, java.sql.Types.INTEGER);
            }
            // Convert LocalDate -> java.sql.Timestamp; null -> SQL NULL
            LocalDateTime deadline = task.getDeadline();
            if (deadline != null) {
                ps.setTimestamp(7, java.sql.Timestamp.valueOf(deadline));
            } else {
                ps.setNull(7, java.sql.Types.TIMESTAMP);
            }

            ps.setString(8, task.getStatus());

            // executeUpdate() returns rows affected
            return ps.executeUpdate() == 1;
                 
            

        } catch (SQLException e) {
            // development-time error reporting; caller just gets false
            System.err.println("Failed to save task: " + e.getMessage());
            return false;
        }
    }
    
    //Fetch all goals    
    public List<Task> getAllTasks(){
        
        String sql = "SELECT task_id, goal_id, title, description, task_type, priority, duration_minutes, deadline, status, created_at FROM tasks";
        List<Task> tasks = new ArrayList<>();
        try(Connection conn = DBConnection.getConnection();
             PreparedStatement ps = conn.prepareStatement(sql);
             ResultSet rs = ps.executeQuery()){
             
            while(rs.next()){
              Task t = new Task(
                rs.getString("title"),
                rs.getString("description"),
                rs.getString("task_type")
            );
            t.setTaskId(rs.getInt("task_id"));
            // goal_id is nullable — getObject with Integer.class preserves null
            t.setGoalId(rs.getObject("goal_id", Integer.class));
            t.setPriority(rs.getString("priority"));
            
            // duration_minutes is nullable
            t.setDurationMinutes(rs.getObject("duration_minutes", Integer.class));
            
            Timestamp deadlineTs = rs.getTimestamp("deadline");
                if (deadlineTs != null) {
                    t.setDeadline(deadlineTs.toLocalDateTime());
                }   // else leave null (constructor didn't set it, so still null)

            t.setStatus(rs.getString("status"));
            // created_at
            java.sql.Timestamp ts = rs.getTimestamp("created_at");
            if (ts != null) {
                t.setCreatedAt(ts.toLocalDateTime());
            }
            tasks.add(t);
            }
           
        }
        catch (SQLException e) {
            System.err.println("Failed to fetch tasks: " + e.getMessage());
        }
        return tasks;
    }
    
    public static void main (String[] args){
        Task task = new Task(
                "Practice Java",
                "Practice Java model Classes",
                "ONE_TIME"  
        );
        TaskDAO tdao = new TaskDAO();
        //System.out.println(tdao.saveTask(task));
         System.out.println(tdao.getAllTasks());
        
    }
}

package com.lifepilot.dao;

import com.lifepilot.model.Goal;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.time.LocalDate;
import java.sql.SQLException;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class GoalDAO {
    
    // save the goal using insert statement
    public boolean saveGoal(Goal goal){
        
        String sql = "INSERT INTO goals (title, description, target_date, status) "
                   + "VALUES (?, ?, ?, ?)";

        // try-with-resources closes both connection and statement
        try (Connection conn = DBConnection.getConnection();
             PreparedStatement ps = conn.prepareStatement(sql)) {

            // Read values from the Goal object via getters
            ps.setString(1, goal.getTitle());
            ps.setString(2, goal.getDescription());

            // Convert LocalDate -> java.sql.Date; null -> SQL NULL
            LocalDate targetDate = goal.getTargetDate();
            if (targetDate != null) {
                ps.setDate(3, java.sql.Date.valueOf(targetDate));
            } else {
                ps.setNull(3, java.sql.Types.DATE);
            }

            ps.setString(4, goal.getStatus());

            // executeUpdate() returns rows affected
            return ps.executeUpdate() == 1;
                 
            

        } catch (SQLException e) {
            // development-time error reporting; caller just gets false
            System.err.println("Failed to save goal: " + e.getMessage());
            return false;
        }
    }
    
    //Fetch all goals    
    public List<Goal> getAllGoals(){
        
        String sql = "SELECT goal_id, title, description, target_date, status, created_at FROM goals";
        List<Goal> goals = new ArrayList<>();
        try(Connection conn = DBConnection.getConnection();
             PreparedStatement ps = conn.prepareStatement(sql);
             ResultSet rs = ps.executeQuery()){
             
            while(rs.next()){
              Goal g = new Goal(
                rs.getString("title"),
                rs.getString("description"),
                rs.getDate("target_date") == null ? null : rs.getDate("target_date").toLocalDate()
            );
            g.setGoalId(rs.getInt("goal_id"));
            g.setStatus(rs.getString("status"));
            // created_at
            java.sql.Timestamp ts = rs.getTimestamp("created_at");
            if (ts != null) {
                g.setCreatedAt(ts.toLocalDateTime());
            }
            goals.add(g);
            }
           
        }
        catch (SQLException e) {
            System.err.println("Failed to fetch goals: " + e.getMessage());
        }
        return goals;
    }
    
    // Update the Goal using goal_id
    public boolean updateGoal(int goalId, String newTitle){
        String sql = "UPDATE goals SET title = ? WHERE goal_id = ?";
        
        try (Connection conn = DBConnection.getConnection();
             PreparedStatement ps = conn.prepareStatement(sql)) {

            // Read values from the Goal object via getters
             ps.setString(1, newTitle);
        ps.setInt(2, goalId);
        
            return ps.executeUpdate()==1;
            
        }
        
        catch (SQLException e) {
            // development-time error reporting; caller just gets false
            System.err.println("Failed to update goal: " + e.getMessage());
            return false;
        }
    }
    
    public boolean deleteGoal(int goalId){
        String sql = "DELETE FROM goals WHERE goal_id = ?";
        
        try (Connection conn = DBConnection.getConnection();
             PreparedStatement ps = conn.prepareStatement(sql)) {

               ps.setInt(1, goalId);
            
            return ps.executeUpdate()== 1;
            
            
            
        }
        
        catch (SQLException e) {
            // development-time error reporting; caller just gets false
            System.err.println("Failed to delete goal: " + e.getMessage());
            return false;
        }
    }
    
    
    public static void main (String[] args){
        Goal goal = new Goal(
                "Learn Java",
                "Complete Java fundamentals",
                LocalDate.parse("2026-12-31")   // String -> LocalDate
        );
        GoalDAO gdao = new GoalDAO();
        //System.out.println(gdao.saveGoal(goal));
        boolean updateResult = gdao.updateGoal(1, "Learn basic java");
System.out.println("Update result: " + updateResult);

boolean deleteResult = gdao.deleteGoal(4);
System.out.println("Delete result: " + deleteResult);

        System.out.println(gdao.getAllGoals());
        
    }
    
}

package com.lifepilot.model;

import java.time.LocalDate;
import java.time.LocalDateTime;

public class Goal {
    
    private int goalId;
    private String title;
    private String description;
    private LocalDate targetDate;
    private String status;
    private LocalDateTime createdAt;
    
    public Goal(String title,String description,LocalDate targetDate){
        this.title=title;
        this.description=description;
        this.targetDate=targetDate;
        this.status = "ACTIVE";
        this.createdAt = LocalDateTime.now();
        
    }
    
     // ---- Getters ----
    public int getGoalId()            { return goalId; }
    public String getTitle()          { return title; }
    public String getDescription()    { return description; }
    public LocalDate getTargetDate()  { return targetDate; }
    public String getStatus()         { return status; }
    public LocalDateTime getCreatedAt(){ return createdAt; }

    // ---- Setters ----
    public void setGoalId(int goalId)                 { this.goalId = goalId; }
    public void setTitle(String title)                { this.title = title; }
    public void setDescription(String description)    { this.description = description; }
    public void setTargetDate(LocalDate targetDate)   { this.targetDate = targetDate; }
    public void setStatus(String status)              { this.status = status; }
    public void setCreatedAt(LocalDateTime createdAt) { this.createdAt = createdAt; }

    // ---- Display ----
    public void displayGoal() {
        System.out.println("Goal ID     : " + goalId);
        System.out.println("Title       : " + title);
        System.out.println("Description : " + description);
        System.out.println("Target Date : " + targetDate);
        System.out.println("Status      : " + status);
        System.out.println("Created At  : " + createdAt);
    }
@Override
public String toString() {
    return "Goal ID: " + goalId
            + ", Title: " + title
            + ", Description: " + description
            + ", Target Date: " + targetDate
            + ", Status: " + status;
}
    public static void main(String[] args) {
        Goal g = new Goal(
                "Learn Java",
                "Complete Java fundamentals",
                LocalDate.parse("2026-12-31")   // String -> LocalDate
        );
        g.displayGoal();
        g.toString();
    }
}

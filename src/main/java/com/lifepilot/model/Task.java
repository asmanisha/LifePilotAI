package com.lifepilot.model;

import java.time.LocalDateTime;

public class Task {
    
    private int taskId;
    private Integer goalId;
    private String title;
    private String description;
    private String taskType;
    private String priority;
    private Integer durationMinutes;
    private LocalDateTime deadline;
    private String status;
    private LocalDateTime createdAt;
    
    public Task(String title, String description,String taskType ){
        this.title = title;
        this.description = description;
        this.taskType = taskType;
        this.priority = "MEDIUM";
        this.status = "PENDING";
        this.createdAt = LocalDateTime.now();
    }
    
    // getter methods
    public int getTaskId()              { return taskId; }
    public Integer getGoalId()          { return goalId; }
    public String getTitle()            { return title; }
    public String getDescription()      { return description; }
    public String getTaskType()         { return taskType; }
    public String getPriority()         { return priority; }
    public Integer getDurationMinutes() { return durationMinutes; }
    public LocalDateTime getDeadline()  { return deadline; }
    public String getStatus()           { return status; }
    public LocalDateTime getCreatedAt() { return createdAt; }
    
    //Setter methods
    public void setTaskId(int taskId)                       { this.taskId = taskId; }
    public void setGoalId(Integer goalId)                   { this.goalId = goalId; }
    public void setTitle(String title)                      { this.title = title; }
    public void setDescription(String description)          { this.description = description; }
    public void setTaskType(String taskType)                { this.taskType = taskType; }
    public void setPriority(String priority)                { this.priority = priority; }
    public void setDurationMinutes(Integer durationMinutes) { this.durationMinutes = durationMinutes; }
    public void setDeadline(LocalDateTime deadline)         { this.deadline = deadline; }
    public void setStatus(String status)                    { this.status = status; }
    public void setCreatedAt(LocalDateTime createdAt)       { this.createdAt = createdAt; }
    
    //Display Method
    public void displayTask(){
        System.out.println ( "Task ID           :" + taskId );
        System.out.println ( "Goal ID           :" + goalId );
        System.out.println ( "Title             :" + title );
        System.out.println ( "Description       :" + description );
        System.out.println ( "Task Type         :" + taskType );
        System.out.println ( "Priority          :" + priority );
        System.out.println ( "Duration Minutes  :" + durationMinutes );
        System.out.println ( "Deadline          :" + deadline );
        System.out.println ( "Status            :" + status );
        System.out.println ( "CreatedAt         :" + createdAt );
    
    }
    
    @Override
public String toString() {
    return "Task ID :" + taskId
            +", Goal ID: " + goalId
            + ", Title: " + title
            + ", Description: " + description
            + ", Task Type: " + taskType
            +", Priority:" + priority 
            +", Duration Minutes :" + durationMinutes
            +", Deadline :" + deadline 
            + ", Status: " + status
            +"CreatedAt :" + createdAt;
}
    
    public static void main(String[] args) {
        Task t = new Task(
                "Practice Java",
                "Practice Java model Classes",
                "ONE_TIME"   
        );
        t.displayTask();
    }
}

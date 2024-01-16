package ch.cern.todo.requestDto;

import ch.cern.todo.model.TaskCategories;

import java.util.Date;

public class TaskDto {
    private Integer id;
    private String taskName;
    private String taskDescription;
    private String deadline;
    private TaskCategories taskCategories;

    public String getTaskName() {
        return taskName;
    }

    public void setTaskName(String taskName) {
        this.taskName = taskName;
    }

    public String getTaskDescription() {
        return taskDescription;
    }

    public void setTaskDescription(String taskDescription) {
        this.taskDescription = taskDescription;
    }

    public void setDeadline(String deadline) {
        this.deadline = deadline;
    }

    public String getDeadline() {
        return deadline;
    }

    public void setTaskCategories(TaskCategories taskCategories) {
        this.taskCategories = taskCategories;
    }

    public TaskCategories getTaskCategories() {
        return taskCategories;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getId() {
        return id;
    }
}

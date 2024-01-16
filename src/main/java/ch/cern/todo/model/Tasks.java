package ch.cern.todo.model;

import jakarta.persistence.*;

import java.util.Date;

@Entity
@Table(name = "TASKS")
public class Tasks {

    @Id
    @Column(name = "TASK_ID")
    private Integer taskId;
    @Column(name = "TASK_NAME",length = 100)
    private String taskName;
    @Column(name = "TASK_DESCRIPTION",length = 500)
    private String taskDescription;
    @Column(name = "DEADLINE")
    private Date deadline;

//    @OneToOne(targetEntity = TaskCategories.class,cascade= CascadeType.ALL)
//    @JoinColumn(name = "CATEGORY_ID")
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "CATEGORY_ID")
    private TaskCategories categories;

    public Integer getTaskId() {
        return taskId;
    }

    public void setTaskId(Integer taskId) {
        this.taskId = taskId;
    }

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

    public void setDeadline(Date deadline) {
        this.deadline = deadline;
    }

    public Date getDeadline() {
        return deadline;
    }

    public void setCategories(TaskCategories categories) {
        this.categories = categories;
    }

    public TaskCategories getCategories() {
        return categories;
    }
}

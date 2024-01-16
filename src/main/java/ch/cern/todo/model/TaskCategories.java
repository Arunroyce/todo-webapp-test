package ch.cern.todo.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "TASKS_CATEGORIES")
public class TaskCategories {


    @Id
    @Column(name = "CATEGORY_ID")
    private Integer categoryId;
    @Column(name = "CATEGORY_NAME" ,length = 100)
    private String categoryName;
    @Column(name = "CATEGORY_DESCRIPTION" ,length = 500)
    private String categoryDescription;

    public Integer getCategoryId() {
        return categoryId;
    }

    public void setCategoryId(Integer categoryId) {
        this.categoryId = categoryId;
    }

    public String getCategoryName() {
        return categoryName;
    }

    public void setCategoryName(String categoryName) {
        this.categoryName = categoryName;
    }

    public String getCategoryDescription() {
        return categoryDescription;
    }

    public void setCategoryDescription(String categoryDescription) {
        this.categoryDescription = categoryDescription;
    }
}

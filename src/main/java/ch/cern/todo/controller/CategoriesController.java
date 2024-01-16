package ch.cern.todo.controller;

import ch.cern.todo.model.TaskCategories;
import ch.cern.todo.repo.TaskCategoriesRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/categoriesController")
public class CategoriesController {

    @Autowired
    TaskCategoriesRepo taskCategoriesRepo;

    @PostMapping(value = "/persistListOfTaskCategories")
    public void persistCategories(@RequestBody List<TaskCategories> categoriesList) {
        taskCategoriesRepo.saveAll(categoriesList);
    }
}

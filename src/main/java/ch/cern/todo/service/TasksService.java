package ch.cern.todo.service;

import ch.cern.todo.model.Tasks;
import ch.cern.todo.repo.TaskRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.config.Task;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class TasksService {

    @Autowired
    TaskRepo taskRepo;

    public Tasks saveTasks(Tasks tasks) {
        return taskRepo.save(tasks);
    }

    public List<Tasks> fetchTasksList() {
        return (List<Tasks>)
                taskRepo.findAll();
    }

    public Tasks updateTask(Tasks tasks,Integer id) {
        Optional<Tasks> updateTask = taskRepo.findById(id);
        if(updateTask.isPresent()) {
            if (tasks.getTaskName() != null && !tasks.getTaskName().isEmpty()) {
                updateTask.get().setTaskName(tasks.getTaskName());
            }
            if(tasks.getTaskDescription() != null && !tasks.getTaskDescription().isEmpty()) {
                updateTask.get().setTaskDescription(tasks.getTaskDescription());
            }
            if(tasks.getDeadline() != null) {
                updateTask.get().setDeadline(tasks.getDeadline());
            }
            return taskRepo.save(updateTask.get());
        }else {
            return null;
        }
    }

    public void deleteByTaskId(Integer taskId){
        taskRepo.deleteById(taskId);
    }
}

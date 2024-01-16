package ch.cern.todo.controller;

import ch.cern.todo.model.Tasks;
import ch.cern.todo.repo.TaskRepo;
import ch.cern.todo.requestDto.TaskDto;
import ch.cern.todo.requestDto.UpdateTask;
import ch.cern.todo.responseDto.Response;
import ch.cern.todo.service.TasksService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Locale;
import java.util.TimeZone;

@RestController
@RequestMapping("/tasksController")
public class TasksController {


    @Autowired
    TasksService tasksService;

    @PostMapping("/createTask")
    public Response createTask(@RequestBody TaskDto taskDto) {
        Response response = new Response();
        if(taskDto != null) {
            Tasks tasks = new Tasks();
            tasks.setTaskId(taskDto.getId());
            tasks.setTaskName(taskDto.getTaskName());
            tasks.setTaskDescription(taskDto.getTaskDescription());
            tasks.setDeadline(formatStringToDate(taskDto.getDeadline()));
            tasks.setCategories(taskDto.getTaskCategories());
            tasksService.saveTasks(tasks);
            response.setCode(200);
            response.setStatus("Created");
            return response;
        }else {
            response.setCode(500);
            response.setStatus("Failed ::: Input data is null");
            return response;
        }
    }

    @PutMapping("/editTaskDeadline")
    public Response editTaskDeadline(@RequestBody UpdateTask updateTask,@RequestParam("taskId") Integer taskId) {
        Response response = new Response();
        if(updateTask != null) {
            Tasks tasks = new Tasks();
            tasks.setTaskName(updateTask.getTaskName());
            tasks.setTaskDescription(updateTask.getTaskDescription());
            tasks.setDeadline(formatStringToDate(updateTask.getDeadline()));
            Tasks updatedTasks = tasksService.updateTask(tasks, taskId);
            if(updatedTasks != null) {
                response.setCode(200);
                response.setStatus("Updated Successfully");
                return response;
            }else {
                response.setCode(500);
                response.setStatus("Update Failed");
                return response;
            }
        }else {
            response.setCode(500);
            response.setStatus("Failed ::: update task is null");
            return response;
        }

    }
    @DeleteMapping("/deleteTask")
    public Response deleteTaskByTaskName(@RequestParam("taskId") Integer taskId) {
        Response response = new Response();
        if(taskId != null) {
            tasksService.deleteByTaskId(taskId);
            response.setCode(200);
            response.setStatus("Deleted Successfully");
            return response;
        }else {
            response.setCode(500);
            response.setStatus("Failed ::: taskId is null");
            return response;
        }
    }

    public static Date formatStringToDate(String strDate) {
        SimpleDateFormat formatter = new SimpleDateFormat("dd-M-yyyy hh:mm:ss", Locale.ENGLISH);
        formatter.setTimeZone(TimeZone.getTimeZone("Asia/Kolkata"));
        Date date;
        try {
            date = formatter.parse(strDate);
        } catch (ParseException e) {
            throw new RuntimeException(e);
        }
        return date;
    }
}

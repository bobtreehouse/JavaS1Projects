package com.trilogyed.tasker.controller;

import com.netflix.discovery.DiscoveryClient;
import com.netflix.discovery.converters.Auto;
import com.trilogyed.tasker.dao.TaskerDao;
import com.trilogyed.tasker.exception.NotFoundException;
import com.trilogyed.tasker.model.TaskViewModel;
import com.trilogyed.tasker.service.TaskerServiceLayer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

import javax.validation.Valid;
import java.util.List;

@RestController
@RefreshScope
public class TaskerController {

    @Autowired
    TaskerServiceLayer service;

    public TaskerController(TaskerServiceLayer service) {
        this.service = service;
    }

    @RequestMapping(value = "/tasks/{id}", method = RequestMethod.DELETE)
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteTask(@PathVariable int id) {
        service.deleteTask(id);
    }


    @RequestMapping (value = "/tasks/{id}", method = RequestMethod.GET)
    @ResponseStatus(HttpStatus.OK)
    public TaskViewModel getTask(@PathVariable int id)  {
        TaskViewModel taskViewModel = service.fetchTask(id);
        if (taskViewModel == null)
            throw new NotFoundException("error: task not found");
        return taskViewModel;
    }

    @RequestMapping (value = "/tasks", method = RequestMethod.GET)
    @ResponseStatus(HttpStatus.OK)
    public List<TaskViewModel> getAllTasks()  {

        return service.fetchAllTasks();
    }

    @RequestMapping (value = "/tasks/category/{category}", method = RequestMethod.GET)
    @ResponseStatus(HttpStatus.OK)
    public List<TaskViewModel> getTasksByCategory(@PathVariable String category)  {

        return service.fetchTasksByCategory(category);
    }

    @RequestMapping(value = "/tasks", method = RequestMethod.POST)
    @ResponseStatus(value = HttpStatus.CREATED)
    public TaskViewModel createTask(@RequestBody @Valid TaskViewModel task) {
        service.saveTask(task);

        return task;
    }

    @RequestMapping(value = "/tasks/{id}", method = RequestMethod.PUT)
    @ResponseStatus(HttpStatus.OK)
    public void updateTask(@RequestBody TaskViewModel task, @PathVariable int id) {
        if(id!=task.getId()){
            throw new IllegalArgumentException();
        }
        service.updateTask(task);
    }
}
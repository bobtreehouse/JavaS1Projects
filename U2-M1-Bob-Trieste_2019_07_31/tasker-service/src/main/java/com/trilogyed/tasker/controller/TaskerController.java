package com.trilogyed.tasker.controller;

import com.trilogyed.tasker.service.TaskerServiceLayer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;


@RestController
@RefreshScope
public class TaskerController {

    @Autowired
    TaskerServiceLayer service;

    public TaskerController(TaskerServiceLayer service) {
        this.service = service;
    }

    @RequestMapping(value = "/tasks{id}", method = RequestMethod.DELETE)
    @ResponseStatus(HttpStatus.OK)
    public void deleteTask(@PathVariable int id) {
        service.deleteTask(id);
    }


    @RequestMapping (value = "/tasks{id}", method = RequestMethod.GET)
    @ResponseStatus(HttpStatus.OK)
    public void getTask(@PathVariable int id)  {
        service.getTask(id);
    }

    @RequestMapping (value = "/tasks{id}", method = RequestMethod.GET)
    @ResponseStatus(HttpStatus.OK)
    public void getAllTasks(@PathVariable int id)  {
        service.getTask(id);
    }

    @RequestMapping (value = "/tasks{id}", method = RequestMethod.GET)
    @ResponseStatus(HttpStatus.OK)
    public void getTasksByCategory(@PathVariable int id)  {
        service.getTask(id);
    }

}
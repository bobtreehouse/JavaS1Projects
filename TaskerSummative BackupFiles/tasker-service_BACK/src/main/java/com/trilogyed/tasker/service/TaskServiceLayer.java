package com.trilogyed.tasker.service;

import com.trilogyed.tasker.dao.TaskerDao;
import com.trilogyed.tasker.model.Task;
import com.trilogyed.tasker.model.TaskViewModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.List;

@Component
public class TaskServiceLayer {

    TaskerDao taskerDao;

    @Autowired
    private DiscoveryClient discoveryClient;

    private RestTemplate restTemplate = new RestTemplate();

    @Value("${randomAdService}")
    private String randomAdService;

    @Value("${serviceProtocol}")
    private String serviceProtocol;

    @Value("${servicePath}")
    private String servicePath;


    @Autowired
    public TaskServiceLayer(TaskerDao dao) {this.taskerDao = taskerDao;}

    public TaskViewModel findTask (int id) {
        Task task = taskerDao.getTask(id);
        if (task == null) {
            return null;
        }else {
            return buildTaskViewModel(task);
        }
    }

    public String serveAd(){

        List<ServiceInstance> instances = discoveryClient.getInstances(randomAdService);
        String randomAdServiceUri = serviceProtocol + instances.get(0).getHost() + ":" + instances.get(0).getPort() + servicePath;
        System.out.println(instances.get(0).getHost());
        String ad = restTemplate.getForObject(randomAdServiceUri, String.class);
         return ad;
    }


    public TaskViewModel fetchTask(int id) {

        Task task = taskerDao.getTask(id);
        TaskViewModel tvm = new TaskViewModel();

        tvm.setId(task.getId());
        tvm.setDescription(task.getDescription());
        tvm.setCreateDate(task.getCreateDate());
        tvm.setDueDate(task.getDueDate());
        tvm.setCategory(task.getCategory());

        tvm.setAdvertisement(serveAd());
        // TODO - get ad from Adserver and put in tvm

        return tvm;
    }
    @Transactional
    public List<TaskViewModel> fetchAllTasks() {
        List<Task> taskList = taskerDao.getAllTasks();
        List<TaskViewModel> tskList = new ArrayList<>();
        taskList.stream()
                .forEach(task -> {
                    TaskViewModel tsk = buildTaskViewModel(task);
                    tskList.add(tsk);
                });
        return tskList;
    }
    @Transactional
    public List<TaskViewModel> fetchTasksByCategory(String category) {
        List<Task> taskList = taskerDao.getTasksByCategory(category);
        List<TaskViewModel> tskList = new ArrayList<>();
        taskList.stream()
                .forEach(task -> {
                    TaskViewModel tsk = buildTaskViewModel(task);
                    tskList.add(tsk);
                });
        return tskList;
    }

    public TaskViewModel addTask (TaskViewModel taskViewModel) {

        Task task = new Task();
        task.setDescription(task.getDescription());
        task.setCreateDate(taskViewModel.getCreateDate());
        task.setDueDate(taskViewModel.getDueDate());
        task.setCategory(taskViewModel.getCategory());


        task = taskerDao.createTask(task);
        taskViewModel.setId(task.getId());

        // TODO - get ad from Adserver and put in taskViewModel
        return taskViewModel;
    }
    @Transactional
    public void removeTask(int id) {

        taskerDao.deleteTask(id);
    }


    public void updateTask(TaskViewModel taskViewModel) {
        Task task = new Task();
        task.setDescription(task.getDescription());
        task.setCreateDate(taskViewModel.getCreateDate());
        task.setDueDate(taskViewModel.getDueDate());
        task.setCategory(taskViewModel.getCategory());

        taskerDao.updateTask(task);

    }


    //HELPER METHODS
    private TaskViewModel buildTaskViewModel (Task task) {
        TaskViewModel taskViewModel = new TaskViewModel();
        taskViewModel.setId(task.getId());
        taskViewModel.setDescription(task.getDescription());
        taskViewModel.setCategory(task.getCategory());
        taskViewModel.setCreateDate(task.getCreateDate());
        taskViewModel.setDueDate(task.getDueDate());
        taskViewModel.setAdvertisement(serveAd());

        return taskViewModel;
    }

}

package com.trilogyed.tasker.service;
import com.trilogyed.tasker.dao.TaskerDao;
import com.trilogyed.tasker.dao.TaskerDaoJdbcTemplateImpl;
import com.trilogyed.tasker.model.Task;
import com.trilogyed.tasker.model.TaskViewModel;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.web.client.RestTemplate;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import static junit.framework.TestCase.assertEquals;
import static org.junit.Assert.*;
import static org.mockito.Mockito.doReturn;
import static org.mockito.Mockito.mock;

public class TaskerServiceLayerTest {

    TaskerServiceLayer service;
    TaskerDao taskerDao;
    RestTemplate restTemplate = new RestTemplate();
    DiscoveryClient discoveryClient;


    @Value("${randomAdService}")
    private String randomAdService = "adserver-service";

    @Value("${serviceProtocol}")
    private String serviceProtocol = "http://";

    @Value("${servicePath}")
    private String servicePath = "/ad";

    @Before
    public void setUp() throws Exception {
//        setUpDiscoveryClientMock();
//        setUpRestTemplateMock();
//        setUpDaoMock();
        service = new TaskerServiceLayer(taskerDao,
                restTemplate,discoveryClient,randomAdService,serviceProtocol,servicePath);
    }
    @Test
    public void saveAndFetchTask() {

        TaskViewModel tvm = new TaskViewModel();
        tvm.setId(1);
        tvm.setDescription("Schooling");
        tvm.setCreateDate(LocalDate.of(1971, 3, 01));
        tvm.setDueDate(LocalDate.of(2019, 10, 01));
        tvm.setCategory("Red");

        TaskViewModel fromService = service.fetchTask(tvm.getId());
        assertEquals(tvm, fromService);
    }



    @Test
    public void fetchAllTasks() {
        TaskViewModel tvm = new TaskViewModel();
        tvm.setId(1);
        tvm.setDescription("Schooling");
        tvm.setCreateDate(LocalDate.of(1971, 3, 01));
        tvm.setDueDate(LocalDate.of(2019, 10, 01));
        tvm.setCategory("Red");

        List<TaskViewModel> taskViewModels = service.fetchAllTasks();
        assertEquals(1, taskViewModels.size());
        assertEquals(tvm, taskViewModels.get(0));
    }
    @Test
    public void fetchTasksByCategory() {

        TaskViewModel tvm = new TaskViewModel();
        tvm.setId(1);
        tvm.setDescription("Schooling");
        tvm.setCreateDate(LocalDate.of(1971, 3, 01));
        tvm.setDueDate(LocalDate.of(2019, 10, 01));
        tvm.setCategory("Red");

        tvm.setId(2);
        tvm.setDescription("Learn Job");
        tvm.setCreateDate(LocalDate.of(1993, 3, 01));
        tvm.setDueDate(LocalDate.of(2019, 10, 01));
        tvm.setCategory("Blue");

        List<TaskViewModel> taskViewModels = service.fetchTasksByCategory("Blue");
        assertEquals(1, taskViewModels.size());
        assertEquals(tvm, taskViewModels.get(0));
    }




    public String serveAd(){

        List<ServiceInstance> instances = discoveryClient.getInstances(randomAdService);
        String randomAdServiceUri = serviceProtocol + instances.get(0).getHost() + ":" + instances.get(0).getPort() + servicePath;
        System.out.println(instances.get(0).getHost());
        String ad = restTemplate.getForObject(randomAdServiceUri, String.class);
        return ad;
    }

    // Helper methods
    private void setUpdaoMock() {
        taskerDao = mock(TaskerDaoJdbcTemplateImpl.class);
        Task Task = new Task();
        Task.setId(1);
        Task.setDescription("Schooling");
        Task.setCreateDate(LocalDate.of(1971, 3, 01));
        Task.setDueDate(LocalDate.of(2019, 10, 01));
        Task.setCategory("Red");

        Task Task2 = new Task();
        Task.setId(2);
        Task.setDescription("learn job");
        Task.setCreateDate(LocalDate.of(1993, 6, 6));
        Task.setDueDate(LocalDate.of(2017, 4, 01));
        Task.setCategory("Blue");

        List<Task> Tasks = new ArrayList<>();

        Tasks.add(Task);

        doReturn(Task).when(taskerDao).createTask(Task2);
        doReturn(Task).when(taskerDao).getTask(1);
        doReturn(Tasks).when(taskerDao).getAllTasks();
    }



}
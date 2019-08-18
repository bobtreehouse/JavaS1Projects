package com.trilogyed.tasker.service;

import com.trilogyed.tasker.dao.TaskerDao;
import com.trilogyed.tasker.dao.TaskerDaoJdbcTemplateImpl;
import com.trilogyed.tasker.model.Task;
import com.trilogyed.tasker.model.TaskViewModel;
import org.junit.Before;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.client.DefaultServiceInstance;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.web.client.RestTemplate;

import java.time.LocalDate;
//import javax.xml.ws.Service;
//import java.math.BigDecimal;
//import java.math.RoundingMode;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

import static org.junit.Assert.*;
import static org.mockito.Mockito.doReturn;
import static org.mockito.Mockito.mock;

public class TaskerServiceLayerTest {


    TaskerServiceLayer service;
    TaskerDao taskerDao;
    RestTemplate restTemplate;
    DiscoveryClient discoveryClient;


    private String myAdServiceName = "adserver-service";

    private String serviceProtocol = "http://";

    private String servicePath = "/ad";


    @Before
    public void setUp() throws Exception {
        setUpDiscoveryClientMock();
        setUpRestTemplateMock();
        setUpDaoMock();
        service = new TaskerServiceLayer(taskerDao, discoveryClient,
                restTemplate,
                myAdServiceName,
                serviceProtocol,
                servicePath);
    }

    @Test
    public void fetchAllTasks() {
        List<TaskViewModel> tasks = service.fetchAllTasks();
        assertEquals(tasks.size(), 1);
    }

    @Test
    public void fetchTasksByCategory() {
        List<TaskViewModel> tasks = service.fetchTasksByCategory("tasks");
        assertEquals(tasks.size(), 1);
    }

    @Test
    public void newAndFetchTask() {
        TaskViewModel task = new TaskViewModel();
        task.setCategory("EarlyStage");
        task.setCreateDate(LocalDate.of(1971, 3, 01));
        task.setDescription("Learning");
        task.setDueDate(LocalDate.of(1994, 1, 31));
        task = service.saveTask(task);
        TaskViewModel fromService = service.fetchTask(01);
        assertEquals(task,fromService);



    }

    private void setUpDaoMock() {
        taskerDao = mock(TaskerDaoJdbcTemplateImpl.class);
        Task taskMock = new Task();
        taskMock.setCategory("EarlyStage");
        taskMock.setCreateDate(LocalDate.of(1971, 3, 01));
        taskMock.setDescription("Learning");
        taskMock.setDueDate(LocalDate.of(1994, 1, 31));
        taskMock.setId(01);
        Task task = new Task();
        task.setCategory("MidStage");
        task.setCreateDate(LocalDate.of(1994, 1, 31));
        task.setDescription("Working");
        task.setDueDate(LocalDate.of(2017, 3, 31));
        List<Task> list = new ArrayList<>();
        list.add(taskMock);
        doReturn(taskMock).when(taskerDao).createTask(task);
        doReturn(taskMock).when(taskerDao).getTask(01);
        doReturn(list).when(taskerDao).getTasksByCategory("tasks");
        doReturn(list).when(taskerDao).getAllTasks();
    }

    private void setUpRestTemplateMock() {
        restTemplate = mock(RestTemplate.class);
        doReturn("Stages").when(restTemplate).getForObject("http://localhost:6107/ad", String.class);
    }

    private void setUpDiscoveryClientMock() {
        discoveryClient = mock(DiscoveryClient.class);
        List<ServiceInstance> instances = new LinkedList<>();
        DefaultServiceInstance defaultServiceInstance = new DefaultServiceInstance("", "", "localhost", 6107, true);
        instances.add(defaultServiceInstance);
        doReturn(instances).when(discoveryClient).getInstances("adserver-service");
    }


    public String makeeAd() {

        List<ServiceInstance> instances = discoveryClient.getInstances(myAdServiceName);
        String randomAdServiceUri = serviceProtocol + instances.get(0).getHost() + ":" + instances.get(0).getPort() + servicePath;
        System.out.println(instances.get(0).getHost());
        String ad = restTemplate.getForObject(randomAdServiceUri, String.class);
        return ad;
    }
}

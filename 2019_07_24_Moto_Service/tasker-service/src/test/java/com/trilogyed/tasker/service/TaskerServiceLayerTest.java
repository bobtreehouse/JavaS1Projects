package com.trilogyed.tasker.service;
import com.trilogyed.tasker.dao.TaskerDao;
import com.trilogyed.tasker.dao.TaskerDaoJdbcTemplateImpl;
import com.trilogyed.tasker.model.Task;
import com.trilogyed.tasker.model.TaskViewModel;
import org.junit.Before;
import org.junit.Test;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import static junit.framework.TestCase.assertEquals;
import static org.junit.Assert.*;
import static org.mockito.Mockito.doReturn;
import static org.mockito.Mockito.mock;

public class TaskerServiceLayerTest {

    TaskerServiceLayer service;
    TaskerDao dao;

    @Before
    public void setUp() throws Exception {
        setUpdaoMock();
        service = new TaskerServiceLayer(dao);
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
    public void getAllTasks() {
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

    // Helper methods
    private void setUpdaoMock() {
        dao = mock(TaskerDaoJdbcTemplateImpl.class);
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

        doReturn(Task).when(dao).createTask(Task2);
        doReturn(Task).when(dao).getTask(1);
        doReturn(Tasks).when(dao).getAllTasks();
    }
}
package com.trilogyed.tasker.dao;

import com.trilogyed.tasker.model.Task;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.time.LocalDate;
import java.util.List;

import static org.junit.Assert.*;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest
public class TaskerDaoTest {

    @Autowired
    protected TaskerDao taskerDao;

    @Before
    public void setUp() throws Exception {

        List<Task> tList = taskerDao.getAllTasks();

        tList.stream()
                .forEach(task -> taskerDao.deleteTask(task.getId()));
    }

    @Test
    public void createGetDeleteTask() {
        Task task = new Task();
        task.setDescription("Early life");
        task.setCreateDate(LocalDate.of(1971, 3, 01));
        task.setDueDate(LocalDate.of(1989, 6, 20));
        task.setCategory("Blue");

        task = taskerDao.createTask(task);

        Task task2 = taskerDao.getTask(task.getId());
        assertEquals(task, task2);

        taskerDao.deleteTask(task.getId());

        task2 = taskerDao.getTask(task.getId());

        assertNull(task2);

    }

    @Test
    public void getAllTasks() {
        Task task = new Task();
        task.setDescription("Early life");
        task.setCreateDate(LocalDate.of(1971, 3, 01));
        task.setDueDate(LocalDate.of(1989, 6, 20));
        task.setCategory("Blue");

        taskerDao.createTask(task);

        task = new Task();
        task.setDescription("Work life");
        task.setCreateDate(LocalDate.of(1993, 10, 01));
        task.setDueDate(LocalDate.of(2017, 03, 31));
        task.setCategory("Red");

        taskerDao.createTask(task);
        List<Task> taskList = taskerDao.getAllTasks();

        assertEquals(taskList.size(), 2);

    }

    @Test
    public void getTasksByCategory() {
        Task task = new Task();
        task.setDescription("Early life");
        task.setCreateDate(LocalDate.of(1971, 3, 01));
        task.setDueDate(LocalDate.of(1989, 6, 20));
        task.setCategory("Blue");

        taskerDao.createTask(task);

        task = new Task();
        task.setDescription("College life");
        task.setCreateDate(LocalDate.of(1989, 9, 01));
        task.setDueDate(LocalDate.of(1993, 5, 20));
        task.setCategory("Blue");

        taskerDao.createTask(task);

        task = new Task();
        task.setDescription("Work life");
        task.setCreateDate(LocalDate.of(1993, 10, 01));
        task.setDueDate(LocalDate.of(2017, 03, 31));
        task.setCategory("Red");

        taskerDao.createTask(task);

        List<Task> tList = taskerDao.getTasksByCategory("Blue");
        assertEquals(2, tList.size());

        tList = taskerDao.getTasksByCategory("Red");
        assertEquals(1, tList.size());
    }

    @Test
    public void updateTask() {
        Task task = new Task();
        task.setId(01);
        task.setDescription("Early life");
        task.setCreateDate(LocalDate.of(1973, 3, 01));
        task.setDueDate(LocalDate.of(1989, 6, 20));
        task.setCategory("Blue");

        task = taskerDao.createTask(task);

        task = new Task();
        task.setId(02);
        task.setDescription("Growing up");
        task.setCreateDate(LocalDate.of(1971, 3, 01));
        task.setDueDate(LocalDate.of(1994, 1, 31));
        task.setCategory("Green");

        task = taskerDao.createTask(task);

        taskerDao.updateTask(task);
        Task task2 =  taskerDao.getTask(task.getId());
        assertEquals(task2, task);
    }
}
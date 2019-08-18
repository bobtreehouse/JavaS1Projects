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
        task.setDescription("Very hard");
        task.setCreateDate(LocalDate.of(1990, 9, 11));
        task.setDueDate(LocalDate.of(2018, 9, 11));
        task.setCategory("Pink");

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
        task.setDescription("Some Description");
        task.setCreateDate(LocalDate.of(1990, 9, 11));
        task.setDueDate(LocalDate.of(2018, 9, 11));
        task.setCategory("Green");

        taskerDao.createTask(task);

        task = new Task();
        task.setDescription("A Description");
        task.setCreateDate(LocalDate.of(1989, 6, 6));
        task.setDueDate(LocalDate.of(2018, 6, 6));
        task.setCategory("Red");

        taskerDao.createTask(task);
        List<Task> taskList = taskerDao.getAllTasks();

        assertEquals(taskList.size(), 2);

    }

    @Test
    public void getTasksByCategory() {
        Task task = new Task();
        task.setDescription("Something Hot");
        task.setCreateDate(LocalDate.of(2005, 9, 21));
        task.setDueDate(LocalDate.of(2010, 9, 18));
        task.setCategory("Green");

        taskerDao.createTask(task);

        task = new Task();
        task.setDescription("IDK anymore");
        task.setCreateDate(LocalDate.of(2009, 8, 21));
        task.setDueDate(LocalDate.of(2010, 9, 18));
        task.setCategory("Green");

        taskerDao.createTask(task);

        task = new Task();
        task.setDescription("what is life");
        task.setCreateDate(LocalDate.of(2009, 2, 9));
        task.setDueDate(LocalDate.of(2014, 3, 19));
        task.setCategory("Pink");

        taskerDao.createTask(task);

        List<Task> tList = taskerDao.getTasksByCategory("Green");
        assertEquals(2, tList.size());

        tList = taskerDao.getTasksByCategory("Pink");
        assertEquals(1, tList.size());
    }

    @Test
    public void updateTask() {
        Task task = new Task();
        task.setId(22);
        task.setDescription("Some Description");
        task.setCreateDate(LocalDate.of(2011, 11, 15));
        task.setDueDate(LocalDate.of(2015, 4, 12));
        task.setCategory("Green");

        task = taskerDao.createTask(task);

        task = new Task();
        task.setId(32);
        task.setDescription("Good Description");
        task.setCreateDate(LocalDate.of(2000, 3, 19));
        task.setDueDate(LocalDate.of(2018, 6, 6));
        task.setCategory("Pink");

        task = taskerDao.createTask(task);

        taskerDao.updateTask(task);
        Task task2 =  taskerDao.getTask(task.getId());
        assertEquals(task2, task);
    }
}
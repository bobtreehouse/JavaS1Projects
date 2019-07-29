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
public class TaskerDaoJdbcTemplateImplTest {

    @Autowired
    protected TaskerDao dao;

    @Before
    public void setUp() throws Exception {
        List<Task> tList = dao.getAllTasks();

        tList.stream()
                .forEach(task -> dao.deleteTask(task.getId()));
    }

    @Test
    public void createGetDeleteTask() {
        Task task = new Task();
        task.setDescription("Challenging");
        task.setCreateDate(LocalDate.of(1971, 9, 01));
        task.setDueDate(LocalDate.of(2019, 9, 01));
        task.setCategory("Red");

        task = dao.createTask(task);

        Task task2 = dao.getTask(task.getId());
        assertEquals(task, task2);

        dao.deleteTask(task.getId());

        task2 = dao.getTask(task.getId());

        assertNull(task2);

    }

    @Test
    public void getAllTasks() {
        Task task = new Task();
        task.setDescription("Moderate Challenge");
        task.setCreateDate(LocalDate.of(1971, 9, 01));
        task.setDueDate(LocalDate.of(2019, 9, 01));
        task.setCategory("Blue");

        dao.createTask(task);

        task = new Task();
        task.setDescription("A Description");
        task.setCreateDate(LocalDate.of(1989, 6, 6));
        task.setDueDate(LocalDate.of(2019, 6, 6));
        task.setCategory("Red");

        dao.createTask(task);
        List<Task> taskList = dao.getAllTasks();

        assertEquals(taskList.size(), 2);

    }

    @Test
    public void getTasksByCategory() {
        Task task = new Task();
        task.setDescription("Lower Difficulty");
        task.setCreateDate(LocalDate.of(2005, 9, 21));
        task.setDueDate(LocalDate.of(2010, 9, 18));
        task.setCategory("Blue");

        dao.createTask(task);

        task = new Task();
        task.setDescription("Review Notes ");
        task.setCreateDate(LocalDate.of(2009, 8, 21));
        task.setDueDate(LocalDate.of(2010, 9, 18));
        task.setCategory("Blue");

        dao.createTask(task);

        task = new Task();
        task.setDescription("daily study");
        task.setCreateDate(LocalDate.of(2009, 2, 9));
        task.setDueDate(LocalDate.of(2014, 3, 19));
        task.setCategory("Red");

        dao.createTask(task);

        List<Task> tList = dao.getTasksByCategory("Blue");
        assertEquals(2, tList.size());

        tList = dao.getTasksByCategory("Red");
        assertEquals(1, tList.size());
    }

    @Test
    public void updateTask() {
        Task task = new Task();
        task.setId(22);
        task.setDescription("Moderate Challenge");
        task.setCreateDate(LocalDate.of(2001, 01, 15));
        task.setDueDate(LocalDate.of(2015, 4, 12));
        task.setCategory("Blue");

        task = dao.createTask(task);

        task = new Task();
        task.setId(32);
        task.setDescription("Good Description");
        task.setCreateDate(LocalDate.of(2000, 3, 19));
        task.setDueDate(LocalDate.of(2019, 6, 6));
        task.setCategory("Red");

        dao.updateTask(task);
        Task task2 =  dao.getTask(task.getId());
        assertEquals(task2, task);
    }


}

package com.kodilla.hibernate.tasklist.dao;

import com.kodilla.hibernate.tasklist.TaskList;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;
@SpringBootTest
public class TaskListDaoTestSuite {
    @Autowired
    TaskListDao taskListDao;

    @Test
    void testFindByListName(){
        TaskList taskList = new TaskList("lista zadań","opis");
        taskListDao.save(taskList);
        List<TaskList> taskListTest = taskListDao.findByListName("lista zadań");
        System.out.println(taskList.getListName());
        Assertions.assertEquals(taskListTest.get(0).getListName(), "lista zadań" );
        int id = taskList.getId();
        taskListDao.deleteById(id);
    }
}

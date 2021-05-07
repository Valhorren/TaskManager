package ru.konkov.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.konkov.DAO.TaskDAO;
import ru.konkov.model.Task;

import javax.transaction.Transactional;
import java.util.List;

@Service
public class TaskService implements CrudService{
    TaskDAO taskDAO;

    @Autowired
    public TaskService(TaskDAO taskDAO) {
        this.taskDAO = taskDAO;
    }

    @Override
    @Transactional
    public Task get(int id) {
        return taskDAO.get(id);
    }

    @Override
    @Transactional
    public List<Task> getAll() {
        return taskDAO.getAll();
    }

    @Override
    @Transactional
    public void create(Task task) {
        taskDAO.create(task);
    }

    @Override
    @Transactional
    public void update(int id, Task task) {
        taskDAO.update(id, task);
    }

    @Override
    @Transactional
    public void delete(int id) {
        taskDAO.delete(id);
    }
}

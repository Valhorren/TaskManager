package ru.konkov.service;

import ru.konkov.model.Task;

import java.util.List;


public interface CrudService {
    Task get(int id);
    List<Task> getAll();
    void create(Task task);
    void update(int id, Task task);
    void delete(int id);
}

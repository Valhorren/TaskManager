package ru.konkov.DAO;

import ru.konkov.model.Task;

import java.io.Serializable;
import java.util.List;

public interface CrudDAO extends Serializable {
    Task get(int id);
    List<Task> getAll();
    void create(Task task);
    void update(int id, Task task);
    void delete(int i);
}

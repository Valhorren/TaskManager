package ru.konkov.dao;
import ru.konkov.model.Task;
import java.io.Serializable;
import java.util.List;

//Crud DAO interface
public interface CrudDAO extends Serializable {
    Task get(int id);
    List<Task> getAll();
    void create(Task task);
    void update(int id, Task task);
    void delete(int i);
}

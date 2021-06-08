package ru.konkov.dao;


import org.hibernate.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import ru.konkov.model.Task;
import java.util.List;


@Repository
public class TaskDAO implements CrudDAO {

    SessionFactory factory;

    @Autowired
    public TaskDAO(SessionFactory factory) {
        this.factory = factory;
    }

    @Override
    public Task get(int id) {
        Session session = factory.getCurrentSession();
        try {
            session.beginTransaction();
            Task task = session.get(Task.class, id);
            session.getTransaction().commit();
            return task;
        } finally {
            session.close();
        }

    }


    @Override
    public List<Task> getAll() {
        Session session = factory.getCurrentSession();

        try {
            session.beginTransaction();
            return session.createQuery("FROM Task", Task.class)
                    .getResultList();
        } finally {
            session.close();
        }
    }

    @Override
    public void update(int id, Task task) {
        Session session = factory.getCurrentSession();
        try {
            session.beginTransaction();
            Task updatedTask = session.get(Task.class, id);
            updatedTask.setName(task.getName());
            updatedTask.setDescription(task.getDescription());
            session.saveOrUpdate(updatedTask);
            session.getTransaction().commit();
        } finally {
            session.close();
        }
    }

    @Override
    public void create(Task task) {
            Session session = factory.getCurrentSession();
        try {
            session.beginTransaction();
            session.saveOrUpdate(task);
            session.getTransaction().commit();
        } finally {
            session.close();
        }

    }

    @Override
    public void delete(int id) {
        Session session = factory.getCurrentSession();
        try {
            session.beginTransaction();
            session.delete(session.get(Task.class, id));
            session.getTransaction().commit();
        } finally {
            session.close();
        }
    }
}

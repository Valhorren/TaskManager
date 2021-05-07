package ru.konkov.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import ru.konkov.model.Task;
import ru.konkov.service.TaskService;
import java.util.List;


@Controller
@RequestMapping("/tasks")
public class TasksController {

    TaskService taskService;

    @Autowired
    public TasksController(TaskService taskService) {
        this.taskService = taskService;
    }

    @GetMapping("/{id}")
    public String getTask(Model model, @PathVariable("id") int id){
        model.addAttribute("task",taskService.get(id));

        return "tasks/task";
    }

    @RequestMapping()
    public String getAll(Model model){
        List<Task> tasks = taskService.getAll();
        model.addAttribute("tasks", tasks);
        return "/tasks/allTasks";
    }

    @GetMapping("/new")
    public String newTask(Model model){
        Task task = new Task();
        model.addAttribute("task",task);
        return "/tasks/newTask";
    }

    @PostMapping
    public String createTask(@ModelAttribute("task") Task task){
        taskService.create(task);
        return "redirect:/tasks";
    }

    @GetMapping("/{id}/edit")
    public String editTask(@PathVariable("id") int id, Model model) {
        model.addAttribute("task",taskService.get(id));
        return "tasks/updateTask";
    }

    @PatchMapping("/{id}")
    public String updateTask(@ModelAttribute("task") Task task,
                             @PathVariable("id") int id){
        taskService.update(id, task);
        return "redirect:/tasks";
    }

    @DeleteMapping("/{id}")
    public String delete(@PathVariable("id") int id){
        taskService.delete(id);
        return "redirect:/tasks";
    }




}

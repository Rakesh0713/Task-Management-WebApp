package com.task.taskManagement.controller;

import com.task.taskManagement.model.Task;
import com.task.taskManagement.repository.TaskRepository;
import jakarta.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
public class TaskController {

    @Autowired
    private TaskRepository taskRepo;

    @GetMapping("/dashboard")
    public String dashboard(HttpSession session, Model model) {
        String userEmail = (String) session.getAttribute("username");
        List<Task> tasks = taskRepo.findByUserEmail(userEmail);
        model.addAttribute("tasks", tasks);
        model.addAttribute("task", new Task());
        return "add";
    }

    @PostMapping("/addTask")
    public String addTask(@ModelAttribute Task task, HttpSession session) {
        task.setUserEmail((String) session.getAttribute("username"));
        taskRepo.save(task);
        return "redirect:/dashboard";
    }

    @PostMapping("/updateTask")
    public String updateTask(@RequestParam Integer id, @RequestParam String status) {
        Task task = taskRepo.findById(id).orElse(null);
        if (task != null) {
            task.setStatus(status);
            taskRepo.save(task);
        }
        return "redirect:/dashboard";
    }

    @GetMapping("/deleteTask/{id}")
    public String deleteTask(@PathVariable Integer id) {
        taskRepo.deleteById(id);
        return "redirect:/dashboard";
    }

    @GetMapping("/viewTasks")
    public String viewTasks(HttpSession session, Model model) {
        String userEmail = (String) session.getAttribute("username");
        List<Task> tasks = taskRepo.findByUserEmail(userEmail);
        model.addAttribute("tasks", tasks);
        return "tasklist";
    }

    // 👇 These routes are specifically for operations done in tasklist.html
    @PostMapping("/updateTaskFromList")
    public String updateTaskFromList(@RequestParam Integer id, @RequestParam String status) {
        Task task = taskRepo.findById(id).orElse(null);
        if (task != null) {
            task.setStatus(status);
            taskRepo.save(task);
        }
        return "redirect:/viewTasks";
    }

    @GetMapping("/addTaskPage")
    public String showAddTaskPage(HttpSession session, Model model) {
        String userEmail = (String) session.getAttribute("username");
        List<Task> tasks = taskRepo.findByUserEmail(userEmail);
        model.addAttribute("tasks", tasks);
        model.addAttribute("task", new Task());
        return "add";
    }

    @GetMapping("/deleteTaskFromList/{id}")
    public String deleteTaskFromList(@PathVariable Integer id) {
        taskRepo.deleteById(id);
        return "redirect:/viewTasks";
    }
}

package de.hegmanns.training.adventofcodeservice.service;

import de.hegmanns.training.adventofcodeservice.model.Task;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDate;
import java.util.List;

@RestController
@RequestMapping("/tasks")
public class TaskController {

    @GetMapping("/")
    public List<Task> getAllTasks() {
        return null;
    }

    @GetMapping("/{$datum}")
    public List<Task> getTasksForDate(@PathVariable("datum") LocalDate date) {
        return null;
    }
}

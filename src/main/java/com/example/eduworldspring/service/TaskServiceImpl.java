package com.example.eduworldspring.service;

import com.example.eduworldspring.model.Task;
import com.example.eduworldspring.pattern.factory.TaskProcessorFactory;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class TaskServiceImpl implements TaskService {

    private final TaskProcessorFactory taskProcessorFactory;
    public void handleTask(Task task) {
        String type = task.getTypeTask().getTitle();
        taskProcessorFactory.getProcessor(type).process(task);
    }
}

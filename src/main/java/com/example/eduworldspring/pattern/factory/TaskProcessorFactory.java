package com.example.eduworldspring.pattern.factory;

import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Component
public class TaskProcessorFactory {
    private final Map<String, TaskProcessor> processorMap;

    public TaskProcessorFactory(List<TaskProcessor> processors) {
        processorMap = new HashMap<>();
        for (TaskProcessor processor : processors) {
            processorMap.put(processor.getClass().getAnnotation(Component.class).value(), processor);
        }
    }

    public TaskProcessor getProcessor(String type) {
        return processorMap.getOrDefault(type, task -> System.out.println("Unknown task type"));
    }
}

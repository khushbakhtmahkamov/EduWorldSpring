package com.example.eduworldspring.pattern.factory;

import com.example.eduworldspring.model.Task;
import org.springframework.stereotype.Component;

@Component("MULTIPLE_CHOICE")
public class MultipleChoiceTaskProcessor implements TaskProcessor {
    public void process(Task task) {
        System.out.println("Processing multiple choice task");
    }
}
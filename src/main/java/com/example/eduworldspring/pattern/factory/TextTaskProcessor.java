package com.example.eduworldspring.pattern.factory;

import com.example.eduworldspring.model.Task;
import org.springframework.stereotype.Component;

@Component("TEXT")
public class TextTaskProcessor implements TaskProcessor {
    public void process(Task task) {
        System.out.println("Processing TEXT task");
    }
}
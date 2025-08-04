package com.example.eduworldspring.pattern.observer;

import com.example.eduworldspring.model.Lesson;
import com.example.eduworldspring.model.User;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class LessonPublisher {
    private final List<LessonObserver> observers;

    public LessonPublisher(List<LessonObserver> observers) {
        this.observers = observers;
    }

    public void publishLesson(Lesson lesson, User user) {
        observers.forEach(observer -> observer.notify(user, lesson));
    }
}

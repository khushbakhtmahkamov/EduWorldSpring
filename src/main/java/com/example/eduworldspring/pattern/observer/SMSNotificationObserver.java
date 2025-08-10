package com.example.eduworldspring.pattern.observer;

import com.example.eduworldspring.model.Lesson;
import com.example.eduworldspring.model.User;
import org.springframework.stereotype.Component;

@Component
public class SMSNotificationObserver implements LessonObserver {
    public void notify(User user, Lesson lesson) {
        System.out.println("SMS sent to " + user.getEmail() + " about new lesson: " + lesson.getName());
    }
}

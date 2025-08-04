package com.example.eduworldspring.pattern.observer;

import com.example.eduworldspring.model.Lesson;
import com.example.eduworldspring.model.User;

public interface LessonObserver {
    void notify(User user, Lesson lesson);
}

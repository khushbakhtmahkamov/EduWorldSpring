package com.example.eduworldspring.service;


import com.example.eduworldspring.model.TypeTask;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
@Service
public class TypeTaskServiceImpl implements TypeTaskService{
    List<TypeTask> typeTasks = new ArrayList<>();
    @Override
    public TypeTask create(TypeTask typeTask) {
        if (typeTask != null && typeTask.getTitle() != null) {
            typeTasks.add(typeTask);
            return typeTask;
        }
        return null;
    }

    @Override
    public boolean deleteById(Long id) {
        for (int i = 0; i < typeTasks.size(); i++) {
            if (typeTasks.get(i).getId().equals(id)) {
                typeTasks.remove(i);
                return true;
            }
        }
        return false;
    }

    @Override
    public TypeTask update(TypeTask typeTask) {
        if (typeTask != null && typeTask.getId() != null) {
            for (int i = 0; i < typeTasks.size(); i++) {
                if (typeTasks.get(i).getId().equals(typeTask.getId())) {
                    typeTasks.set(i, typeTask);
                    return typeTask;
                }
            }
        }
        return null;
    }

    @Override
    public TypeTask getById(Long id) {
        for (TypeTask typeTask : typeTasks) {
            if (typeTask.getId().equals(id)) {
                return typeTask;
            }
        }
        return null;
    }

    @Override
    public List<TypeTask> getAll() {
        return new ArrayList<>(typeTasks);
    }
}

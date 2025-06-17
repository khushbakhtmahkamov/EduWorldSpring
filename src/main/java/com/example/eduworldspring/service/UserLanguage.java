package com.example.eduworldspring.service;

import java.util.List;

public interface UserLanguage {
    void setLanguage(String language);
    String getLanguage();

    void setLanguages(List<String> languages);
    List<String> getLanguages();

    boolean addLanguage(String language);
    boolean removeLanguage(String language);




}

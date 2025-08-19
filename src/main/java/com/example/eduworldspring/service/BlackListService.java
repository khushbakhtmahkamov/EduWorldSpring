package com.example.eduworldspring.service;

import com.example.eduworldspring.model.BlackList;

import java.util.List;

public interface BlackListService {
        void addToken(BlackList blackList);
        void deleteTokenByEmail(String email);
        List<BlackList> getTokens();
        BlackList getTokenByEmail(String email);
        boolean isNotInList(String email);
    }


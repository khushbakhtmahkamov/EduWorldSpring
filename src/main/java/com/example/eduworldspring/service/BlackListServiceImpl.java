package com.example.eduworldspring.service;

import com.example.eduworldspring.config.JwtUtil;
import com.example.eduworldspring.model.BlackList;
import com.example.eduworldspring.repository.BlackListRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@RequiredArgsConstructor
@Service
public class BlackListServiceImpl implements BlackListService{
    private final BlackListRepository blackListRepository;
    private final JwtUtil jwtUtil;
    @Override
    public void addToken(BlackList blackList) {
        blackListRepository.save(blackList);
    }

    @Override
    public void deleteTokenByEmail(String email) {
        List<BlackList> listTokens = blackListRepository.findAll();
        for (int i = 0; i < listTokens.size(); i++) {
            if(jwtUtil.extractUsername(listTokens.get(i).getName()).equals(email)){
                BlackList blackList = listTokens.get(i);
                blackListRepository.delete(blackList);
                break;
            }
        }
    }

    @Override
    public List<BlackList> getTokens() {
        return blackListRepository.findAll();
    }

    @Override
    public BlackList getTokenByEmail(String email) {
        String token = "";
        List<BlackList> listTokens = blackListRepository.findAll();
        for (int i = 0; i < listTokens.size(); i++) {
            if(jwtUtil.extractUsername(listTokens.get(i).getName()).equals(email)){
                token += jwtUtil.extractUsername(listTokens.get(i).getName());
                break;
            }
        }
        return blackListRepository.findByName(jwtUtil.extractUsername(token));
    }

    @Override
    public boolean isNotInList(String email) {
        List<BlackList> listTokens = blackListRepository.findAll();
        for (int i = 0; i < listTokens.size(); i++) {
            if(jwtUtil.extractUsername(listTokens.get(i).getName()).equals(email)){
                return false;
            }
        }
        return true;
    }


}

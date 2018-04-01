package com.service;

import com.dao.UserDao;
import com.pojo.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {

    @Autowired
    private UserDao userDao;

    public List<User> selectUserList(){
        return userDao.selectUserList();
    }

    public void insert(User user){
        userDao.insert(user);
    }
}

package com.dao;

import com.pojo.User;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UserDao {
    List<User> selectUserList();

    void insert(User user);

}

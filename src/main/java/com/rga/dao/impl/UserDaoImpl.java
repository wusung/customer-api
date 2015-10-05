package com.rga.dao.impl;

import com.rga.dao.UserDao;
import com.rga.model.User;
import org.springframework.stereotype.Service;

import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;

/**
 * @author Green
 * @since 2015/10/04
 */
@Service("userDao")
public class UserDaoImpl implements UserDao {

    private ConcurrentMap<String, User> users = new ConcurrentHashMap<>();

    public UserDaoImpl() {

        {
            User user = new User();
            user.setEmail("twkoci@gmail.com");
            user.setPassword("franky");
            insert(user);
        }

        {
            User user = new User();
            user.setEmail("franky@gmail.com");
            user.setPassword("1234");
            insert(user);
        }
    }

    @Override
    public boolean insert(User user) {
        if (user == null)
            throw new IllegalArgumentException("user is null");

        users.put(user.getEmail(), user);
        return true;
    }

    @Override
    public User query(String userName) {
        if (users.containsKey(userName)) {
            return users.get(userName);
        }
        return null;
    }

    @Override
    public boolean update(User user) {
        if (user != null) {
            if (users.containsKey(user.getEmail())) {
                User existedUser = users.get(user.getEmail());
                existedUser.setIsLogin(user.isLogin());
                existedUser.setName(user.getName());
                return true;
            }
        }

        return false;
    }
}

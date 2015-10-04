package com.rga.dao;

import com.rga.model.User;

/**
 * @author Green
 * @since 2015/10/04
 */
public interface UserDao {
    boolean insert(User user);
    User query(String userName);
    boolean update(User user);
}

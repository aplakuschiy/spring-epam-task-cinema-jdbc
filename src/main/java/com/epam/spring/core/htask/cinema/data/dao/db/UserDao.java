package com.epam.spring.core.htask.cinema.data.dao.db;

import com.epam.spring.core.htask.cinema.models.User;


public interface UserDao {
    int create (User item);
    User get(int id);
}
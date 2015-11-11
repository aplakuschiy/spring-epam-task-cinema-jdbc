package com.epam.spring.core.htask.cinema.data.dao.db;

import com.epam.spring.core.htask.cinema.models.Event;

public interface EventDao {
    int create(Event item);
    Event get(int id);
}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.epam.spring.core.htask.cinema.data.dao;

import com.epam.spring.core.htask.cinema.data.DataMapStore;
import com.epam.spring.core.htask.cinema.models.Event;
import java.util.concurrent.ConcurrentSkipListMap;

/**
 *
 * @author home
 */
public class EventDao extends DataMapStore<Event>{

    public EventDao() {
        super.storage= new ConcurrentSkipListMap<>();
    }

    public EventDao(ConcurrentSkipListMap<Integer, Event> storage) {
        super(storage);
    }
    
    public Event getByName(String name)
    {
        for(Event event : storage.values())
            if(event.getName().equals(name))
                return event;
        return null;
    }
    
}

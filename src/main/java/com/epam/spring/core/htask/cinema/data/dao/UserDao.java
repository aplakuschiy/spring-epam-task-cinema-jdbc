/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.epam.spring.core.htask.cinema.data.dao;

import com.epam.spring.core.htask.cinema.data.DataMapStore;
import com.epam.spring.core.htask.cinema.models.Ticket;
import com.epam.spring.core.htask.cinema.models.User;
import java.util.List;
import java.util.concurrent.ConcurrentSkipListMap;
import java.util.concurrent.CopyOnWriteArrayList;

/**
 *
 * @author home
 */
public class UserDao extends DataMapStore<User>{

    public UserDao() {
        super.storage= new ConcurrentSkipListMap<>();
    }

    public UserDao(ConcurrentSkipListMap<Integer, User> storage) {
        super(storage);
    }
    
    //история покупок
    public List<Ticket> getBookedTickets(User user, List<Ticket> tickets) {
        List<Ticket> userTickets = new CopyOnWriteArrayList<>();
        for(Ticket ticket : tickets)
        {
            if(ticket.getUser()==null && user==null) //для незарегистрированных пользователей
                userTickets.add(ticket);
            else 
                if(ticket.getUser()!=null && user!=null && ticket.getUser().equals(user))
                    userTickets.add(ticket);
        }
        return userTickets;
    }    
}

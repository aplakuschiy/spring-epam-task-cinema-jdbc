/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.epam.spring.core.htask.cinema.data.dao;

import com.epam.spring.core.htask.cinema.data.DataMapStore;
import com.epam.spring.core.htask.cinema.models.Auditorium;
import java.util.Collection;
import java.util.concurrent.ConcurrentSkipListMap;

/**
 *
 * @author home
 */
public class AuditoriumDao extends DataMapStore<Auditorium>{

    public AuditoriumDao() {
        super.storage= new ConcurrentSkipListMap<>();
    }

    public AuditoriumDao(ConcurrentSkipListMap<Integer, Auditorium> storage) {
        super(storage);
    }
    
    //вернуть коллекцию номеров VIP мест
    public Collection<Integer> getVipSeats(Integer key)
    {
          Auditorium auditorium = storage.get(key);
          if(auditorium!=null)
              return auditorium.getVipSeats();
        return null;
    }
    public Collection<Integer> getVipSeats(Auditorium auditorium)
    {
          for(Auditorium audit : storage.values())
            if(audit.equals(auditorium))
                return audit.getVipSeats();
        return null;
    }
    //вернуть количество мест
    public Integer getSeatsNumber(Integer key)
    {
          Auditorium auditorium = storage.get(key);
          if(auditorium!=null)
              return auditorium.getCountSeats();
        return null;
    }
    public Integer getSeatsNumber(Auditorium auditorium)
    {
          for(Auditorium audit : storage.values())
            if(audit.equals(auditorium))
                return audit.getCountSeats();
        return null;
    }
}

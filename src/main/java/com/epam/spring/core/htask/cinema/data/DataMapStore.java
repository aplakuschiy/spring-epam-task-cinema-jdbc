/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.epam.spring.core.htask.cinema.data;

import java.util.Collection;

import java.util.concurrent.ConcurrentSkipListMap;
import java.util.concurrent.atomic.AtomicInteger;

/**
 *
 * @author Oleksandr_Plakushchy
 */
public class DataMapStore<T> implements IDataAdapter<T>{

    protected ConcurrentSkipListMap<Integer, T> storage;
    
    public DataMapStore() {
        this.storage = null;
    }
    
    public DataMapStore(ConcurrentSkipListMap<Integer, T> storage) {
        this.storage = storage;
    }
        
    @Override
    public Collection<T> getAll() {
        return (storage==null) ? null : storage.values();
    }

    @Override
    public T get(Integer id) {
        return (storage==null) ? null : storage.get(id);
    }

    @Override
    public int create(T item) {
        AtomicInteger lastKey;
        if(storage==null)
            storage = new ConcurrentSkipListMap<Integer, T>();
        lastKey = (storage.size()==0) ? new AtomicInteger(0) : new AtomicInteger(storage.lastKey());
        storage.put(lastKey.incrementAndGet(), item);
        return lastKey.get();
    }

    @Override
    public boolean update(Integer id, T item) {
        if(storage == null)
            return false;
        storage.put(id, item);
        return true;
     }

    @Override
    public boolean delete(Integer id) {
        if(storage == null)
            return false;
        return (storage.remove(id)!=null);
    }

    @Override
    public boolean deleteAll() {
         if(storage == null)
             return false;
        storage.clear();
        return true;
    }
    
}

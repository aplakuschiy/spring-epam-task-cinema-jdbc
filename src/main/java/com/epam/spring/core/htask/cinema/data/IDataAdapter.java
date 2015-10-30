/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.epam.spring.core.htask.cinema.data;

import java.util.Collection;

/**
 *
 * @author Oleksandr_Plakushchy
 */
public interface IDataAdapter<T> {
    Collection<T> getAll();
    T get(Integer id);
    int create (T item);
    boolean update (Integer id, T item);
    boolean delete (Integer id);
    boolean deleteAll();
}

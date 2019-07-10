/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package service;

import java.util.List;

/**
 *
 * @author wyouness
 */
public interface IService<T> {
    
    void insertPS(T t);
    void update(T t);
    List<T>readAll();
    T readById(Object id);
    void delete(T t);
    
}

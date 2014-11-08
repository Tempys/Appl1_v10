package com.dubovskiy.movc.dao.common;

import com.dubovskiy.movc.entity.User;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created by mikhail on 24.09.14.
 */

public interface DaoUser {

public List<User> findNameInList(String name) ;
public List<User> findAll();
public void delete(String name);
public void create(User user);
public void update(User user);
public User find(String name);
public Long GetPageNumber();
public List<User> GetPageList(int page);
}

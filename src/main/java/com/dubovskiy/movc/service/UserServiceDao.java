package com.dubovskiy.movc.service;

import com.dubovskiy.movc.dao.DaoUserImp;
import com.dubovskiy.movc.dao.common.DaoUser;
import com.dubovskiy.movc.entity.User;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by mikhail on 24.09.14.
 */

@Service
public class UserServiceDao {

    private final Logger log = LoggerFactory.getLogger(getClass());
    @Autowired
    DaoUserImp daoUserImp;

    public List<User> findNameInList(String name) {
        return daoUserImp.findNameInList(name);
    }

    public void delete(String name) {
        daoUserImp.delete(name);
    }

    public void create(User user)  {

       daoUserImp.create(user);

    }

    public void update(User user) {
        daoUserImp.update(user);
    }

    public List<User> findAll() {
        return daoUserImp.findAll();
    }

    public User find(String name) {
        return daoUserImp.find(name);
    }

    public int GetPageNumber() {
        int pageNumber = daoUserImp.GetPageNumber().intValue();
        int number=0;
        if (pageNumber % daoUserImp.PAGE_SIZE == 0) {
            number = (pageNumber/ DaoUserImp.PAGE_SIZE);
            log.trace("data1:::::::::::::::::::   " + String.valueOf(number));
        } else {
            log.trace("data for calculate:::::::::::::::::::   " + String.valueOf(pageNumber)+" "+String.valueOf(DaoUserImp.PAGE_SIZE) );

            number = (pageNumber/DaoUserImp.PAGE_SIZE) + 1;
            log.trace("data2:::::::::::::::::::   " + String.valueOf(number));
        }


      return number;

    }

    public List<User> GetPageList(int page) {

        return daoUserImp.GetPageList(page);

    }

    public boolean findBoolean(User user){
        if (findNameInList(user.getName()).size()==0)
            return false;
        else
            return  true;
    }
}

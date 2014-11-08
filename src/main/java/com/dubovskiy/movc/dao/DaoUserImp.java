package com.dubovskiy.movc.dao;

import com.dubovskiy.movc.dao.common.DaoUser;
import com.dubovskiy.movc.entity.User;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.hibernate.Query;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;


/**
 * Created by mikhail on 24.09.14.
 */

@Repository

public class DaoUserImp implements DaoUser {

    private final Logger log = LoggerFactory.getLogger(getClass());
    @Autowired
    private SessionFactory sessionFactory;

    public static final int PAGE_SIZE = 5;



    @Override
    public List<User> findNameInList(String name) {
         Session session = sessionFactory.openSession();
         Query query = session.createQuery("from User where name  = :login ");
         query.setParameter("login",name);
         List<User> UserList = query.list();
        return UserList;
    }

    @Override
    public List<User> findAll() {
        Session session = sessionFactory.openSession();

        List<User> UserList = session.createQuery("from User")
                .list();
        session.close();

        return UserList;
    }

    @Override
    public void delete(String name) {
        Session session = sessionFactory.openSession();
        Transaction tx = session.beginTransaction();
        User user =  find(name);
        session.delete(user);
        tx.commit();
        session.clear();
        session.close();
    }

    @Override
    public void create(User user) {
          Session session = sessionFactory.openSession();
          session.beginTransaction();
          session.save(user);
          session.getTransaction().commit();
          session.flush();
          session.close();
    }

    @Override
    public void update(User user) {
        Session session = sessionFactory.openSession();
        Transaction tx = session.beginTransaction();
        session.update(user);
        tx.commit();
        session.close();
    }

    @Override
    public User find(String name) {
        Session session = sessionFactory.openSession();
        Transaction tx = session.beginTransaction();
        Query query = session.createQuery("from User where name  = :login ");
        query.setParameter("login",name);
        List<User> UserList = query.list();
        tx.commit();
        session.close();
        return UserList.get(0);



    }


    @Override
    public Long GetPageNumber() {
        Session session = sessionFactory.openSession();
        Transaction tx = session.beginTransaction();
        String countQ = "Select count (user.id) from User user";
        Query countQuery = session.createQuery(countQ);
        Long countResults = (Long) countQuery.uniqueResult();
        tx.commit();
        session.close();

        return countResults;
    }

    @Override
    public List<User> GetPageList(int page) {
        Session session = sessionFactory.openSession();
        Transaction tx = session.beginTransaction();
        Query selectQuery = session.createQuery("From User");
        if(page==1){
            selectQuery.setFirstResult(0);
        }
        else{
            selectQuery.setFirstResult((page*DaoUserImp.PAGE_SIZE)-DaoUserImp.PAGE_SIZE);
        }

        selectQuery.setMaxResults(PAGE_SIZE);
        List<User> pageList = selectQuery.list();
        tx.commit();
        session.close();
        log.trace("DATA DAO::::::::::::::::::::::::::::::::::::::::::::::"+String.valueOf(pageList.size()));
        return pageList;
    }


}

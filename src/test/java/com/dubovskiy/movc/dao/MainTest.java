package com.dubovskiy.movc.dao;


import com.dubovskiy.movc.service.UserServiceDao;
import junit.framework.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.transaction.annotation.Transactional;

/**
 * Created by mikhail on 25.09.14.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = { "file:src/main/webapp/WEB-INF/mvc-dispatcher-servlet.xml" })
public class MainTest {

    private final Logger log = LoggerFactory.getLogger(getClass());

    @Autowired
    UserServiceDao userServiceDao;

    @Test
    @Transactional
    public void selectListNumberTest(){

        int number = userServiceDao.findAll().size();
        log.trace("number ="+number);
        Assert.assertTrue(number==0);

    }


}

package com.dubovskiy.movc.controller;

import com.dubovskiy.movc.entity.User;
import com.dubovskiy.movc.service.UserServiceDao;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.google.gson.Gson;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;

import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import javax.annotation.PostConstruct;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
public class HelloController {

    private final Logger log = LoggerFactory.getLogger(getClass());

    @PostConstruct
    private void testRunController(){
        log.debug("testRunController");
    }

    @Autowired
    private UserServiceDao userServiceDao;

    @RequestMapping(value = {"/", "/main"}, method = RequestMethod.GET)
    public String printWelcome(ModelMap model) {
        model.addAttribute("list", userServiceDao.GetPageList(1));
        model.addAttribute("numPages", userServiceDao.GetPageNumber());
        return "main";
    }

    @RequestMapping(value = "/main/{p}", method = RequestMethod.GET)
    public String printWelcomePage(@PathVariable Integer p, ModelMap model) {

        log.trace("Page number :::::::::::::::::::   " + String.valueOf(p));

        model.addAttribute("numPages", userServiceDao.GetPageNumber());
        model.addAttribute("list", userServiceDao.GetPageList(p));


        return "main";
    }

    @RequestMapping(value = "/table", method = RequestMethod.POST)
    @ResponseBody

    public ResponseEntity<String> renderTable(HttpServletRequest request) throws JsonProcessingException {
        String name = request.getParameter("nameSearch");
        log.trace("1: " + name);

        List<User> people = userServiceDao.findNameInList(name);
        Gson gson = new Gson();
        Map<String,List<User>> map = new HashMap<String, List<User>>();

        if (people.size()==0) {


            List<User> list = userServiceDao.GetPageList(0);
            map.put("list",list);
            String json = gson.toJson(list);
            log.trace(json);

            return new ResponseEntity<String>(json,HttpStatus.BAD_REQUEST);

        } else {

            map.put("list",people);
            String json = gson.toJson(map);
            log.trace(json);
            return new ResponseEntity<String>(json,HttpStatus.OK);

        }

    }
}
package com.dubovskiy.movc.controller;

import com.dubovskiy.movc.entity.User;
import com.dubovskiy.movc.service.UserServiceDao;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import javax.validation.Valid;

/**
 * Created by mikhail on 25.09.14.
 */
@Controller
public class CrudController {

    private final Logger log = LoggerFactory.getLogger(getClass());

    @Autowired
    UserServiceDao userServiceDao;


    @RequestMapping(value = "/registration", method = RequestMethod.GET)
    public String Register(Model model) {
        model.addAttribute(new User());
        return "registration";
    }

    @RequestMapping(value = "/registration", method = RequestMethod.POST)
    public String Register(@Valid User user, BindingResult result) {
        log.trace("REGSITER:::::::::::::"+ user.getName() + user.getAge());

         if(result.hasErrors()) {
                   return "registration";
         }

            if (!userServiceDao.findBoolean(user)) {
                userServiceDao.create(user);
                return "redirect:/";
            }
        return "error";
    }

    @RequestMapping(value = "/remove/{id}", method = RequestMethod.GET)
    public ModelAndView removeItem(@PathVariable String id) {

        log.trace("data for remove1:::::::::::::::::::::   " + id);
        userServiceDao.delete(id);

        return new ModelAndView("redirect:/");
    }

    @RequestMapping(value = "/update/{name}", method = RequestMethod.GET)
    public ModelAndView UpdateGet(@PathVariable String name) {
        log.info("DAT in Controller" + name);
        ModelAndView modelAndView = new ModelAndView("update");
        User user = userServiceDao.find(name);


        modelAndView.addObject("user", user);
        return modelAndView;
    }

    @RequestMapping(value = "/update/{id}", method = RequestMethod.POST)
    public String UpdateDate(@PathVariable Integer id, @Valid User user,BindingResult result) {
        log.trace("DATA for UPDATE" + user.getName() + " " + user.getAge() + " " + user.getId());
        if(result.hasErrors()){
            return "update";
        }

        userServiceDao.update(user);
        return "redirect:/";
    }

}

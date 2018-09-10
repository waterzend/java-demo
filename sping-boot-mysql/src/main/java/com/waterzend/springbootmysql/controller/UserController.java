package com.waterzend.springbootmysql.controller;

import com.waterzend.springbootmysql.service.UserService;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("user")
public class UserController {
    private final Log logger = LogFactory.getLog(this.getClass());
    @Autowired
    UserService userService;

    @GetMapping("/list")
    public Object userList() {
        try {
            return userService.listUser();
        } catch (Exception e) {
            logger.error(e.getMessage());
            return "error";
        }
    }
}

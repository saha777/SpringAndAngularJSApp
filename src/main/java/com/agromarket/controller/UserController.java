package com.agromarket.controller;

import com.agromarket.components.parsers.ParsDelegate;
import com.agromarket.components.parsers.ParserEntity;
import com.agromarket.model.User;
import com.agromarket.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/users")
public class UserController {
    @Autowired
    UserService userService;

    @GetMapping("/all")
    public List<User> getAllUser(){
        return userService.getAllUsers();
    }

    @GetMapping("/{id}")
    public User getUserById(@PathVariable("id") String id){
        return userService.getUserById(id);
    }


    @GetMapping("/getid/{email}")
    public String getIdByEmail(@PathVariable("email") String email){
        User user = userService.getUserByEmail(email);

        if(user != null)
            return user.getId();

        return null;
    }

    @PostMapping("/login")
    public String login(@RequestBody User user){
        User userData = userService.getUserByEmail(user.getEmail());

        System.out.println(user.toString());

        if(userData != null
                && userData.getPassword()
                .equals(user.getPassword()))
            return userData.getId();

        return null;
    }

    @PostMapping("/save")
    public boolean saveUser(@RequestBody User user){
        userService.save(user);
        return false;
    }

    @PutMapping("/update")
    public boolean updateUser(@RequestBody User user){
        userService.save(user);
        return false;
    }

    @DeleteMapping("/delete")
    public boolean deleteUser(@RequestBody String id){
        userService.delete(id);
        return false;
    }
}

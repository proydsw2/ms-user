package com.cibertec.dsw2.Controller;

import com.cibertec.dsw2.Service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.cibertec.dsw2.Model.User;

@RestController
public class UserController {

    @Autowired
    private UserService userService;

    @GetMapping(path = "/user")
    public ResponseEntity<Object> retriveAll() {
        return userService.getAll();
    }

    @GetMapping(path = "/user/{id}")
    public ResponseEntity<Object> retriveOne(@PathVariable Integer id) {
        return userService.getOne(id);
    }

    @PostMapping(path = "/user")
    public ResponseEntity<Object> create(@RequestBody User user) {
        return userService.insert(user);
    }

    @PutMapping(path = "/user/{id}")
    public ResponseEntity<Object> update(@PathVariable Integer id, @RequestBody User user) {
        return userService.update(id, user);
    }

    @DeleteMapping(path = "/user/{id}")
    public ResponseEntity<Object> delete(@PathVariable Integer id) {
        return userService.delete(id);
    }

}

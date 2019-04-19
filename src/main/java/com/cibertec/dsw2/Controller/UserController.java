package com.cibertec.dsw2.Controller;

import com.cibertec.dsw2.Repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.net.URI;
import java.util.List;
import java.util.Optional;

import com.cibertec.dsw2.Model.User;

@RestController
@RequestMapping(path = "{/dsw2}")
public class UserController {


    @PersistenceContext
    private EntityManager em;


    @Autowired
    private UserRepository repository;

    @GetMapping(path = {"/user", "/user/"})
    public List<User> retriveAll() {
        return repository.findAll();
    }

    @GetMapping(path = {"/user/{id}", "/user/{id}/"})
    public User retriveOne(@PathVariable Integer id) {
        Optional<User> user = repository.findById(id);

        return user.get();
    }

    @PostMapping(path = {"/user", "/user/"})
    public ResponseEntity<Object> create(@RequestBody User user) {
        User entity = repository.save(user);

        URI location = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}")
                .buildAndExpand(entity.getId()).toUri();

        return ResponseEntity.created(location).build();
    }

    @PutMapping(path = {"/user/{id}", "/user/{id}/"})
    public ResponseEntity<Object> update(@PathVariable Integer id, @RequestBody User user) {
        Optional<User> entity = repository.findById(id);

        if (!entity.isPresent()) {
            return ResponseEntity.notFound().build();
        }

        user.setId(id);
        repository.save(user);

        return ResponseEntity.noContent().build();

    }

    @DeleteMapping(path = {"/user/{id}", "/user/{id}/"})
    public void delete(@PathVariable Integer id) {
        repository.deleteById(id);
    }

}

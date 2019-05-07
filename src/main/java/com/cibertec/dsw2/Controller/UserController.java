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
public class UserController {


    @PersistenceContext
    private EntityManager em;


    @Autowired
    private UserRepository repository;

    @GetMapping(path = "/user")
    public List<User> retriveAll() {
        return repository.findAll();
    }

    @GetMapping(path = "/user/{id}")
    public User retriveOne(@PathVariable Long id) {
        Optional<User> user = repository.findById(id);

        return user.get();
    }

    @PostMapping(path = "/user")
    public ResponseEntity<Object> create(@RequestBody User user) {
        User entity = repository.save(user);

        URI location = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}")
                .buildAndExpand(entity.getNum_user_id()).toUri();

        return ResponseEntity.created(location).build();
    }

    @PutMapping(path = "/user/{id}")
    public ResponseEntity<Object> update(@PathVariable Long id, @RequestBody User user) {
        Optional<User> entity = repository.findById(id);

        if (!entity.isPresent()) {
            return ResponseEntity.notFound().build();
        }

        user.setNum_user_id(id);
        repository.save(user);

        return ResponseEntity.noContent().build();

    }

    @DeleteMapping(path = "/user/{id}")
    public void delete(@PathVariable Long id) {
        repository.deleteById(id);
    }

}

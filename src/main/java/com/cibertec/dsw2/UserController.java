package com.cibertec.dsw2;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.net.URI;
import java.util.List;
import java.util.Optional;
import com.cibertec.dsw2.UserRepository;
import com.cibertec.dsw2.user;

@RestController
@RequestMapping(path = "{/dsw2}")
public class UserController {

    @PersistenceContext
    private EntityManager em;

    //    @PreAuthorize("hasAuthority('role_admin')")

    @Autowired
    private UserRepository repository;

    @GetMapping(path = {"/test", "/test/"})
    public List<user> retriveAll() {
        return repository.findAll();
    }

    @GetMapping(path = {"/test/{test_id}", "/test/{test_id}/"})
    public user retriveOne(@PathVariable Integer id) {
        Optional<user> test = repository.findById(id);

        return test.get();
    }

    @PostMapping(path = {"/test", "/test/"})
    public ResponseEntity<Object> create(@RequestBody user test) {
        user entity = repository.save(test);

        URI location = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}")
                .buildAndExpand(entity.getId()).toUri();

        return ResponseEntity.created(location).build();
    }

    @PutMapping(path = {"/test/{test_id}", "/test/{test_id}/"})
    public ResponseEntity<Object> update(@PathVariable Integer id, @RequestBody user test) {
        Optional<user> entity = repository.findById(id);

        if (!entity.isPresent()) {
            return ResponseEntity.notFound().build();
        }

        test.setId(id);
        repository.save(test);

        return ResponseEntity.noContent().build();

    }

    @DeleteMapping(path = {"/test/{test_id}", "/test/{test_id}/"})
    public void delete(@PathVariable Integer id) {
        repository.deleteById(id);
    }

}

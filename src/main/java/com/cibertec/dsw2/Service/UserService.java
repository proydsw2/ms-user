package com.cibertec.dsw2.Service;

import com.cibertec.dsw2.Model.User;
import org.springframework.http.ResponseEntity;

public interface UserService {


   ResponseEntity<Object> getAll();

   ResponseEntity<Object> getOne(Integer id);

   ResponseEntity<Object> insert(User user);

   ResponseEntity<Object> update(Integer id, User user);

   ResponseEntity<Object> delete(Integer id);
}

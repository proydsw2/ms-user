package com.cibertec.dsw2.Service.Implementation;

import com.cibertec.dsw2.Model.User;
import com.cibertec.dsw2.Repository.UserRepository;
import com.cibertec.dsw2.Service.UserService;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.net.URI;
import java.util.List;
import java.util.Optional;

@Service
@Transactional
public class UserServiceImpl implements UserService {

      @PersistenceContext
      private EntityManager em;

      @Autowired
      UserRepository userRepository;

      public ResponseEntity<Object> getAll() {
         try {
            List<User> customers = userRepository.findAll();

            if (customers == null) {
               return ResponseEntity.notFound().build();
            }

            return ResponseEntity.ok().body(customers);
         } catch (Exception e) {
            return ResponseEntity.badRequest().build();
         }
      }

      public ResponseEntity<Object> getOne(Integer id) {
         try {
            Optional<User> customer = userRepository.findById(id);

            if (!customer.isPresent()) {
               return ResponseEntity.notFound().build();
            }

            return ResponseEntity.ok().body(customer);
         } catch (Exception e) {
            e.printStackTrace();
            return ResponseEntity.badRequest().build();
         }
      }

      public ResponseEntity<Object> insert(User user) {
         try {
            User entity = userRepository.save(user);

            URI location = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}")
              .buildAndExpand(entity.getNum_customer_id()).toUri();

            return ResponseEntity.ok().body(entity);

         } catch (Exception e) {
            e.printStackTrace();
            return ResponseEntity.badRequest().build();
         }
      }

      public ResponseEntity<Object> update(Integer id, User user) {
         try {
            Optional<User> entity = userRepository.findById(id);

            if (!entity.isPresent()) {
               return ResponseEntity.notFound().build();
            }

            user.setNum_customer_id(id);
            User cust = userRepository.save(user);
            return ResponseEntity.ok().body(cust);
         } catch (Exception e) {
            e.printStackTrace();
            return ResponseEntity.badRequest().build();
         }
      }

      public ResponseEntity<Object> delete(Integer id) {

         try {
            Optional<User> entity = userRepository.findById(id);
            if (!entity.isPresent()) {
               return ResponseEntity.notFound().build();
            }
            userRepository.deleteById(id);
            return ResponseEntity.ok().build();
         } catch (Exception e) {
            e.printStackTrace();
            return ResponseEntity.badRequest().build();
         }
      }
   }


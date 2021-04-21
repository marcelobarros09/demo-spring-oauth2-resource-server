package com.example.demo.resource;

import com.example.demo.config.security.CheckPermission;
import com.example.demo.model.User;
import lombok.extern.log4j.Log4j2;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Log4j2
@RequestMapping("/users")
@RestController
public class UserResource {

    @CheckPermission.User.Read
    @GetMapping
    public List<User> list() {
        return List.of(new User(1L,"Arya Stark", "arya.stark@test.com"),
                new User(2L,"Jon Snow", "jon.snow@test.com"));
    }

    @CheckPermission.User.Create
    @PostMapping
    public ResponseEntity<User> create(User user){
       return ResponseEntity.ok(user);
    }

    @CheckPermission.User.Update
    @PutMapping("/{id}")
    public ResponseEntity<User> update(@PathVariable Long id, User user) {
       return ResponseEntity.ok(user);
    }

    @CheckPermission.User.Delete
    @ResponseStatus(HttpStatus.NO_CONTENT)
    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id) {
       log.info("User deleted");
    }
}

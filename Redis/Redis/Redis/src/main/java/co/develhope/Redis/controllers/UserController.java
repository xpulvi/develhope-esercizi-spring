package co.develhope.Redis.controllers;

import co.develhope.Redis.entities.jpa.UserJpa;
import co.develhope.Redis.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/users")
public class UserController {
    @Autowired
    private UserService userService;

    @PostMapping()
    public UserJpa create(@RequestBody UserJpa user){
        return userService.create(user);
    }

    @GetMapping()
    public List<UserJpa> readAll(){
        return userService.readAll();
    }

    @GetMapping("/{id}")
    public UserJpa readOne(@PathVariable Long id){
        return userService.readOne(id);
    }


    @PutMapping("/{id}")
    public UserJpa update(@PathVariable Long id, @RequestBody UserJpa user){
        return userService.update(id, user);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id){
        userService.delete(id);
    }

}

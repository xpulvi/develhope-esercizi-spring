package com.noSqlOrm.crud;

import com.noSqlOrm.entity.UserEntity;
import com.noSqlOrm.repository.UserRepository;
import org.apache.catalina.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletResponse;

@RestController
public class CrudApi {

    @Autowired
    private UserRepository userRepository;

    //create
    @PostMapping
    public UserEntity createUser(UserEntity user){
        UserEntity sevedUser = userRepository.save(user);
        return sevedUser;
    }

    //update
    @PutMapping("/{id}")
    public UserEntity carUpdate(@PathVariable Long id, @RequestParam String name){
        UserEntity user;
        if(userRepository.existsById(id)){
            user = userRepository.getId(id);
            user.setName(name);
            user = userRepository.save(user);
        }else{
            user = new UserEntity();
        }
        System.out.println("empty user");
        return user;
    }

    //delate
    @DeleteMapping("/id")
    public void delateUser(@PathVariable Long id, HttpServletResponse response){
        if (userRepository.existsById(id)){
            userRepository.deleteById(id);
            System.out.println("user delete");
        } else {
            response.setStatus(HttpServletResponse.SC_CONFLICT);
        }
    }

}

package com.noSqlOrm.crud;

import com.noSqlOrm.entity.UserEntity;
import com.noSqlOrm.repository.UserRepository;
import org.apache.catalina.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletResponse;
import java.util.List;
import java.util.Optional;

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

    //list user
    @GetMapping
    public List<UserEntity> getUsers(){
        return userRepository.findAll();
    }

    //update
    @PutMapping("/{id}")
    public UserEntity carUpdate(@PathVariable Long id, @RequestParam String name){
        Optional<UserEntity> user;

            user = userRepository.findById(id);
            if (user.isPresent()){
                user.get().setName(name);
                userRepository.save(user.get());
                return user.get();
            }else {
                System.out.println("user is empti");
                return null;
            }



        @DeleteMapping("/{id}")
        public void deleteUser(@PathVariable Long id){
            userRepository.deleteById(id);
        }
         /*
    @DeleteMapping("/id")
    public void deleteUser(@PathVariable Long id)throw Exception {
                if (!userRepository.existsById(id)) throw new Exception("User not found"){
                    userRepository.deleteById(id);
                }else {
                    System.out.println("User not found");
                }
        }  */

    /* @Pasquale non capisco perche non mi pernde response
    //delate
    @DeleteMapping("/id")
    public void delateUser(@PathVariable Long id, HttpServletResponse response){
        if (userRepository.existsById(id)){
            userRepository.deleteById(id);
            System.out.println("user delete");
        } else {
            response.setStatus(HttpServletResponse.SC_CONFLICT);
        }
    } */

    }
}

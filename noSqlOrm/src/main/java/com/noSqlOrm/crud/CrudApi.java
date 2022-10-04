package com.noSqlOrm.crud;

import com.noSqlOrm.entity.UserEntity;
import com.noSqlOrm.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletResponse;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("")
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
    @GetMapping("/list")
    public List<UserEntity> getUsers(){
        return userRepository.findAll();
    }

    //get singol user
    @GetMapping("/{id}")
    public Optional<UserEntity> getSigleUser(@PathVariable Long id){
        //UserEntity user = userRepository.getReferenceById(id);
        /*@Pasquale inteliji mi a consigliato di meterlo Opzionale.
         pero non volevo metere Optional sul metodo. */
        Optional<UserEntity> user = userRepository.findById(id);
        if(!userRepository.existsById(id)){
            return null;
        }else{
            return user;
        }
    }

    //update
    @PutMapping("/{id}")
    public UserEntity carUpdate(@PathVariable Long id, @RequestParam String name) {
        Optional<UserEntity> user;

        user = userRepository.findById(id);
        if (user.isPresent()) {
            user.get().setName(name);
            userRepository.save(user.get());
            return user.get();
        } else {
            System.out.println("user is empti");
            return null;
        }
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


package co.develhope.Redis.services;

import co.develhope.Redis.entities.jpa.UserJpa;
import co.develhope.Redis.entities.redis.UserRedis;
import co.develhope.Redis.repositories.jpa.UserJpaRepository;
import co.develhope.Redis.repositories.redis.UserRedisRepository;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserService {

    @Autowired
    private UserJpaRepository userJpaRepository;

    @Autowired
    private UserRedisRepository userRedisRepository;

    public UserRedis convertData(UserJpa user){
        return new UserRedis(user.getId(), user.getFirstName(), user.getLastName(), user.getProfilePicture(), user.getEmail(),
                user.getPasswordEncrypted(), user.getDomicileAddress(), user.getDomicileCity(), user.getDomicileNumber(),
                user.getDomicileState(), user.getFiscalCode());
    }

    public UserJpa convertData(UserRedis user){
        return new UserJpa(user.getId(), user.getFirstName(), user.getLastName(), user.getProfilePicture(), user.getEmail(),
                user.getPasswordEncrypted(), user.getDomicileAddress(), user.getDomicileCity(), user.getDomicileNumber(),
                user.getDomicileState(), user.getFiscalCode());
    }

    public UserJpa create(UserJpa user) {
        if(user == null) return null;
        user.setId(null);
        userJpaRepository.save(user);
        UserRedis userRedis = userRedisRepository.save(convertData(user));
        return user;
    }

    public List<UserJpa> readAll() {
        List<UserJpa> jpaRepositoryAll = userJpaRepository.findAll();
        jpaRepositoryAll.stream().forEach(e -> userRedisRepository.save(convertData(e)));
        return jpaRepositoryAll;
    }

    public UserJpa readOne(Long id) {
        UserJpa userJpa = userJpaRepository.findById(id).get();
        Optional<UserRedis> userRedis = userRedisRepository.findById(userJpa.getId());
        return userJpa;
    }

    public UserJpa update(Long id, UserJpa user) {
        if(user == null) return null;
        user.setId(id);
        UserJpa newUser = userJpaRepository.save(user);

        Optional<UserRedis> userRedis = userRedisRepository.findById(id);
        if(userRedis.isPresent()) {
            userRedisRepository.deleteById(id);
            userRedisRepository.save(convertData(newUser));
        }
        return user; // newUser??
    }

    public void delete(Long id) {
        userJpaRepository.deleteById(id);
        userRedisRepository.deleteById(id);
    }


}

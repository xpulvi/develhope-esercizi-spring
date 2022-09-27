package co.develhope.Redis.repositories.redis;

import co.develhope.Redis.entities.redis.UserRedis;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRedisRepository extends CrudRepository<UserRedis, Long> {
}

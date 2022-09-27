package co.develhope.Redis.repositories.jpa;

import co.develhope.Redis.entities.jpa.UserJpa;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserJpaRepository extends JpaRepository<UserJpa, Long> {
}

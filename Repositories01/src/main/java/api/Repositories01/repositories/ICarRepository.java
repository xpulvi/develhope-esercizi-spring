package api.Repositories01.repositories;

import api.Repositories01.entitis.Car;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ICarRepository extends JpaRepository<Car, Long> {
}

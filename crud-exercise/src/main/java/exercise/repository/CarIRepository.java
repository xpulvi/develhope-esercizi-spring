package exercise.repository;

import exercise.entitis.Car;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CarIRepository extends JpaRepository<Car,long> {



}

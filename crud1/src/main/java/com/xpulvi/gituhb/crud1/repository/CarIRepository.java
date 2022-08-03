package com.xpulvi.gituhb.crud1.repository;


import com.xpulvi.gituhb.crud1.entitis.Car;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CarIRepository extends JpaRepository<Car,Long> {

}

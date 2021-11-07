package be.condorcet.monprojet2.repositories;

import be.condorcet.monprojet2.entities.Cours;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository

public interface CoursRepository extends JpaRepository<Cours,Integer> {



}

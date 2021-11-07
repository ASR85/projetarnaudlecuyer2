package be.condorcet.monprojet2.repositories;

import be.condorcet.monprojet2.entities.Local;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface LocalRepository extends JpaRepository<Local,Integer> {

}

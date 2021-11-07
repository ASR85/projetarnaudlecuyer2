package be.condorcet.monprojet2.repositories;

import be.condorcet.monprojet2.entities.Maitrise;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository

public interface MaitriseRepository extends JpaRepository<Maitrise,Integer> {

}

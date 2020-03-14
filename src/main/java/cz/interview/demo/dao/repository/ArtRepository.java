package cz.interview.demo.dao.repository;

import cz.interview.demo.service.domain.entity.Art;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ArtRepository extends JpaRepository<Art, Long> {

}
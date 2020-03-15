package cz.interview.demo.dao.repository;

import cz.interview.demo.service.domain.entity.Art;
import java.util.List;
import org.springframework.stereotype.Repository;

@Repository
public interface ArtRepository {

  List<Art> artList();
  void create(Art art);
  Art getById(Long id);
  void delete(Art art);
  void deleteById(long id);
  void update(Art art);
}
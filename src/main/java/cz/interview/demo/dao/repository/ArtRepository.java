package cz.interview.demo.dao.repository;

import cz.interview.demo.service.domain.entity.Art;
import java.util.List;
import org.springframework.stereotype.Repository;

@Repository
public interface ArtRepository {

  List<Art> artList();
  Art create(Art art);
  Art getById(Long id);
  void delete(Art art);
  void deleteById(long id);
  Art update(Art art);
}
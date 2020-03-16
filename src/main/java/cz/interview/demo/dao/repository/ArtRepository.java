package cz.interview.demo.dao.repository;

import cz.interview.demo.service.domain.entity.Art;
import java.util.List;
import org.springframework.stereotype.Repository;

/**
 * Repository interface for persist art entity {@Art}
 */
public interface ArtRepository {

  /**
   * Returns list of all arts.
   *
   * @return list of art entities
   */
  List<Art> list();

  /**
   * Stores new art entity.
   *
   * @param art art entity to store
   * @return created art entity
   */
  Art create(Art art);

  /**
   * Returns art entity by given id.
   * @param id id of art entity to search
   * @return found art entity
   */
  Art getById(Long id);

  /**
   *  Deletes art entity from the storage.
   * @param art art entity to delete
   */
  void delete(Art art);

  /**
   * Deletes art entity with given id.
   * @param id id of art entity to delete
   */
  void deleteById(long id);

  /**
   * Updates art entity in the storage.
   * @param art art entity to update.
   * @return updated art entity
   */
  Art update(Art art);
}
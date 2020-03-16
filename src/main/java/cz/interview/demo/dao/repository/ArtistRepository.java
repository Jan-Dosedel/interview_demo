package cz.interview.demo.dao.repository;

import cz.interview.demo.service.domain.entity.Artist;
import org.springframework.stereotype.Repository;

/**
 * Repository interface for persist artist entity {@Artist}.
 */
public interface ArtistRepository {

  /**
   * Returns artist entity with given name.
   *
   * @param firstName first name of the artist
   * @param surname surname of the artist
   * @return found artist entity
   */
  Artist getByName(String firstName, String surname);
}
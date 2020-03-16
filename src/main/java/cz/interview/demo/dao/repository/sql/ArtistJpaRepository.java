package cz.interview.demo.dao.repository.sql;

import cz.interview.demo.dao.repository.ArtistRepository;
import cz.interview.demo.service.domain.entity.Artist;
import java.util.logging.Logger;
import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.Query;
import org.springframework.stereotype.Repository;

/**
 * JPA implementation of a artist repository interface {@ArtistRepository}.
 */
@Repository
public class ArtistJpaRepository implements ArtistRepository {

  private static final Logger LOG = Logger.getLogger(String.valueOf(ArtistJpaRepository.class));
  private final EntityManager em;

  public ArtistJpaRepository(EntityManager em) {
    this.em = em;
  }


  @Override
  public Artist getByName(String firstName, String surname) {

    Artist artist = null;
    Query query = em.createQuery("select a from Artist as a where a.firstName = ?1 and a.surname = ?2")
        .setParameter(1, firstName)
        .setParameter(2, surname);

    try{
      artist = (Artist) query.getSingleResult();
    }catch(NoResultException e){
      LOG.warning(String.format("Artist with name %s %s not found.", firstName, surname));
    }
    return artist;
  }

}
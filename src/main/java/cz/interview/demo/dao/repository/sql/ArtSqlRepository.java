package cz.interview.demo.dao.repository.sql;

import cz.interview.demo.dao.repository.ArtRepository;
import cz.interview.demo.service.domain.entity.Art;
import java.util.List;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.Query;
import org.springframework.stereotype.Repository;

@Repository
public class ArtSqlRepository implements ArtRepository {

  @Inject
  private EntityManager em;

  @Override
  public List<Art> artList() {
    Query query = em.createQuery("select a from Art a");
    return (List<Art>) query.getResultList();
  }

  @Override
  public void create(Art art) {
    em.persist(art);
  }

  @Override
  public Art getById(Long id) {
    return em.find(Art.class, id);
  }

  @Override
  public void deleteById(long id) {
    Art art = em.find(Art.class, id);
    if (art != null) {
      em.remove(art);
    }
  }

  @Override
  public void update(Art art) {
    em.merge(art);
  }
}
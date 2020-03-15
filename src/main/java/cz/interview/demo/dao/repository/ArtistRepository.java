package cz.interview.demo.dao.repository;

import cz.interview.demo.service.domain.entity.Artist;
import org.springframework.stereotype.Repository;

@Repository
public interface ArtistRepository {

  Artist getByName(String firstName, String surname);
}
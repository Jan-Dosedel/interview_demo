package cz.interview.demo.service;

import cz.interview.demo.dao.repository.ArtRepository;
import cz.interview.demo.service.domain.entity.Art;
import java.util.List;
import javax.inject.Inject;
import org.springframework.stereotype.Service;

@Service
public class ArtService {

  @Inject
  private ArtRepository artRepository;

  public List<Art> list() {
    return artRepository.findAll();
  }


}

package cz.interview.demo.service;

import cz.interview.demo.dao.repository.ArtRepository;
import cz.interview.demo.service.domain.entity.Art;
import cz.interview.demo.service.dto.ArtCreateDtoIn;
import cz.interview.demo.service.dto.ArtGetDtoIn;
import cz.interview.demo.service.dto.ArtUpdateDtoIn;
import java.util.List;
import javax.inject.Inject;
import org.dozer.DozerBeanMapper;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class ArtService {

  private final ArtRepository artRepository;
  private final DozerBeanMapper dozer;

  public ArtService(ArtRepository artRepository, DozerBeanMapper dozer) {
    this.artRepository = artRepository;
    this.dozer = dozer;
  }

  public List<Art> artList() {
    return artRepository.artList();
  }

  public void create(ArtCreateDtoIn dtoIn) {
    Art art = dozer.map(dtoIn, Art.class);
    artRepository.create(art);
  }

  public Art get(ArtGetDtoIn dtoIn) {
    Art art = artRepository.getById(dtoIn.getId());
    // TODO add exception to missing object
    return art;
  }

  public void delete(ArtGetDtoIn dtoIn) {
    artRepository.deleteById(dtoIn.getId());
  }

  public void update(ArtUpdateDtoIn dtoIn) {
    Art art = dozer.map(dtoIn, Art.class);
    // TODO validation on id
    artRepository.update(art);
  }
}

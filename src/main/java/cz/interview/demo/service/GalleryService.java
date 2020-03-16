package cz.interview.demo.service;

import static cz.interview.demo.exception.GalleryServiceRuntimeException.Error.ART_DOES_NOT_EXIST;

import cz.interview.demo.dao.repository.ArtRepository;
import cz.interview.demo.dao.repository.ArtistRepository;
import cz.interview.demo.exception.GalleryServiceRuntimeException;
import cz.interview.demo.helper.SysAttributesHelper;
import cz.interview.demo.service.domain.entity.Art;
import cz.interview.demo.service.domain.entity.Artist;
import cz.interview.demo.service.dto.art.ArtCreateDtoIn;
import cz.interview.demo.service.dto.art.ArtDeleteDtoIn;
import cz.interview.demo.service.dto.art.ArtGetDtoIn;
import cz.interview.demo.service.dto.art.ArtUpdateDtoIn;
import java.util.List;
import org.dozer.DozerBeanMapper;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * Simple service for managing arts.
 */
@Service
@Transactional
public class GalleryService {

  private final ArtRepository artRepository;
  private final ArtistRepository artistRepository;
  private final DozerBeanMapper dozer;

  /**
   * Full constructor for instantiating gallery service.
   *
   * @param artRepository repository for persisting {@Art} entities
   * @param artistRepository repository for persisting {@Artist} entities
   * @param dozer object mapper
   */
  public GalleryService(ArtRepository artRepository, ArtistRepository artistRepository, DozerBeanMapper dozer) {
    this.artRepository = artRepository;
    this.artistRepository = artistRepository;
    this.dozer = dozer;
  }

  public List<Art> list() {
    return artRepository.list();
  }

  public Art create(ArtCreateDtoIn dtoIn) {

    Art art = dozer.map(dtoIn, Art.class);
    Artist artist = artistRepository.getByName(dtoIn.getArtist().getFirstName(), dtoIn.getArtist().getSurname());

    if(artist != null){
      art.setArtist(artist);
    }

    SysAttributesHelper.initSysAttributes(art);
    return artRepository.create(art);
  }

  public Art get(ArtGetDtoIn dtoIn) {

    Art art = artRepository.getById(dtoIn.getId());

    if(art == null){
      throw new GalleryServiceRuntimeException(ART_DOES_NOT_EXIST, dtoIn.getId());
    }

    return art;
  }

  public void delete(ArtDeleteDtoIn dtoIn) {

    Art art = artRepository.getById(dtoIn.getId());

    if(art == null){
      throw new GalleryServiceRuntimeException(ART_DOES_NOT_EXIST, dtoIn.getId());
    }

    artRepository.deleteById(dtoIn.getId());
  }

  public Art update(ArtUpdateDtoIn dtoIn) {

    Art art = artRepository.getById(dtoIn.getId());

    if(art == null){
      throw new GalleryServiceRuntimeException(ART_DOES_NOT_EXIST, dtoIn.getId());
    }

    SysAttributesHelper.updateSysAttributes(art);
    // do shallow copy, update only art attributes
    BeanUtils.copyProperties(dtoIn, art);
    return artRepository.update(art);
  }
}

package cz.interview.demo.service;

import cz.interview.demo.dao.repository.ArtRepository;
import cz.interview.demo.dao.repository.SysRepository;
import cz.interview.demo.helper.SysAttributesHelper;
import cz.interview.demo.service.domain.entity.Art;
import cz.interview.demo.service.dto.ArtCreateDtoIn;
import cz.interview.demo.service.dto.ArtGetDtoIn;
import cz.interview.demo.service.dto.ArtUpdateDtoIn;
import java.util.List;
import org.dozer.DozerBeanMapper;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class ArtService {

  private final ArtRepository artRepository;
  private final SysRepository sysRepository;
  private final DozerBeanMapper dozer;

  public ArtService(ArtRepository artRepository, SysRepository sysRepository, DozerBeanMapper dozer) {
    this.artRepository = artRepository;
    this.sysRepository = sysRepository;
    this.dozer = dozer;
  }

  public List<Art> artList() {
    return artRepository.artList();
  }

  public void create(ArtCreateDtoIn dtoIn) {
    Art art = dozer.map(dtoIn, Art.class);
    art.setSys(SysAttributesHelper.getCreateSysAttributes());
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

    // TODO validation on id
    Art art = artRepository.getById(dtoIn.getId());
    art.setSys(SysAttributesHelper.updateSysAttributes(art.getSys()));
    BeanUtils.copyProperties(dtoIn, art);
    artRepository.update(art);
  }
}

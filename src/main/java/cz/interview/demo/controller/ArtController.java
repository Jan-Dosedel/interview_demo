package cz.interview.demo.controller;

import cz.interview.demo.service.GalleryService;
import cz.interview.demo.service.domain.entity.Art;
import cz.interview.demo.service.dto.art.ArtCreateDtoIn;
import cz.interview.demo.service.dto.art.ArtDeleteDtoIn;
import cz.interview.demo.service.dto.art.ArtGetDtoIn;
import cz.interview.demo.service.dto.art.ArtUpdateDtoIn;
import java.util.List;
import javax.validation.Valid;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Controller with the entry points for operations over arts.
 */
@RestController
@RequestMapping("/art")
public class ArtController {

  private final GalleryService galleryService;

  /**
   * Full constructor.
   *
   * @param galleryService service for managing of the entities related with the gallery
   */
  public ArtController(GalleryService galleryService) {
    this.galleryService = galleryService;
  }

  /**
   *  Returns list of art entities.
   *
   * @return list of all arts.
   */
  @GetMapping("/list")
  public List<Art> artList() {
    return galleryService.list();
  }

  /**
   * Creates new art entity with passed parameters.
   *
   * @param dtoIn DTO {@ArtCreateDtoIn} with input parameters get requests.
   * @return created art
   */
  @PostMapping("/create")
  public Art create(@Valid @RequestBody ArtCreateDtoIn dtoIn) {
    return galleryService.create(dtoIn);
  }

  /**
   *  Returns art entity by given id.
   *
   * @param dtoIn DTO {@ArtGetDtoIn} with input parameters get requests.
   * @return found art
   */
  @GetMapping("/get")
  public Art get(@Valid @RequestBody ArtGetDtoIn dtoIn) {
    return galleryService.get(dtoIn);
  }

  /**
   *  Deletes art entity by given id.
   *
   * @param dtoIn DTO {@ArtDeleteDtoIn} with input parameters for delete requests.
   */
  @DeleteMapping("/delete")
  public void delete(@Valid @RequestBody ArtDeleteDtoIn dtoIn) {
    galleryService.delete(dtoIn);
  }

  /**
   *  Updates art entity found by by id to passed parameters.
   *
   * @param dtoIn DTO {@ArtUpdateDtoIn} with input parameters for update requests.
   * @return updated art.
   */
  @PutMapping("/update")
  public Art update(@Valid @RequestBody ArtUpdateDtoIn dtoIn) {
    return galleryService.update(dtoIn);
  }

}


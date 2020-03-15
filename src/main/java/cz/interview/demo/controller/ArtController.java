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

@RestController
@RequestMapping("/art")
public class ArtController {

  private final GalleryService galleryService;

  public ArtController(GalleryService galleryService) {
    this.galleryService = galleryService;
  }

  @GetMapping("/list")
  public List<Art> artList() {
    return galleryService.artList();
  }

  @PostMapping("/create")
  public Art create(@Valid @RequestBody ArtCreateDtoIn dtoIn) {
    return galleryService.create(dtoIn);
  }

  @GetMapping("/get")
  public Art get(@Valid @RequestBody ArtGetDtoIn dtoIn) {
    return galleryService.get(dtoIn);
  }

  @DeleteMapping("/delete")
  public void delete(@Valid @RequestBody ArtDeleteDtoIn dtoIn) {
    galleryService.delete(dtoIn);
  }

  @PutMapping("/update")
  public Art update(@Valid @RequestBody ArtUpdateDtoIn dtoIn) {
    return galleryService.update(dtoIn);
  }

}


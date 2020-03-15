package cz.interview.demo.controller;

import cz.interview.demo.service.ArtService;
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

  private final ArtService artService;

  public ArtController(ArtService artService) {
    this.artService = artService;
  }

  @GetMapping("/list")
  public List<Art> artList() {
    return artService.artList();
  }

  @PostMapping("/create")
  public void create(@Valid @RequestBody ArtCreateDtoIn dtoIn) {
    artService.create(dtoIn);
  }

  @GetMapping("/get")
  public Art get(@Valid @RequestBody ArtGetDtoIn dtoIn) {
    return artService.get(dtoIn);
  }

  @DeleteMapping("/delete")
  public void delete(@Valid @RequestBody ArtDeleteDtoIn dtoIn) {
    artService.delete(dtoIn);
  }

  @PutMapping("/update")
  public void update(@Valid @RequestBody ArtUpdateDtoIn dtoIn) {
    artService.update(dtoIn);
  }

}


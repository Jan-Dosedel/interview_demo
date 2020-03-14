package cz.interview.demo.controller;

import cz.interview.demo.service.ArtService;
import cz.interview.demo.service.domain.entity.Art;
import java.util.List;
import javax.inject.Inject;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/art")
public class ArtController {

  @Inject
  private ArtService artService;

  @GetMapping("/list")
  public List<Art> getAllNotes() {
    return artService.list();
  }

}


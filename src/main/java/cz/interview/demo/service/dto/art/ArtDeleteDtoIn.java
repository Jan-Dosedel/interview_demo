package cz.interview.demo.service.dto.art;

import javax.validation.constraints.NotNull;

public class ArtDeleteDtoIn {

  @NotNull
  private Long id;

  public Long getId() {
    return id;
  }

  public void setId(Long id) {
    this.id = id;
  }
}

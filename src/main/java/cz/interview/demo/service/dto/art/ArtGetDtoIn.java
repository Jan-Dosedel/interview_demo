package cz.interview.demo.service.dto.art;

import java.util.Objects;
import javax.validation.constraints.NotNull;

/**
 * DTO for obtaining a art entity {@Art}.
 */
public class ArtGetDtoIn {

  @NotNull
  private Long id;

  public Long getId() {
    return id;
  }

  public void setId(Long id) {
    this.id = id;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    ArtGetDtoIn that = (ArtGetDtoIn) o;
    return id.equals(that.id);
  }

  @Override
  public int hashCode() {
    return Objects.hash(id);
  }

  @Override
  public String toString() {
    return "ArtGetDtoIn{" +
        "id=" + id +
        '}';
  }
}

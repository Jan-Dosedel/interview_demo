package cz.interview.demo.service.dto.art;

import java.util.Objects;
import javax.validation.constraints.NotNull;

/**
 * DTO for creating a new art entity {@Art}.
 */
public class ArtDeleteDtoIn {

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
    ArtDeleteDtoIn that = (ArtDeleteDtoIn) o;
    return id.equals(that.id);
  }

  @Override
  public int hashCode() {
    return Objects.hash(id);
  }

  @Override
  public String toString() {
    return "ArtDeleteDtoIn{" +
        "id=" + id +
        '}';
  }
}

package cz.interview.demo.service.dto.art;

import java.util.Objects;

public class ArtGetDtoIn {

  private long id;

  public long getId() {
    return id;
  }

  public void setId(long id) {
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
    return id == that.id;
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

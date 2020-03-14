package cz.interview.demo.service.dto;

import java.util.Objects;

public class ArtDeleteDtoIn {

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
    ArtDeleteDtoIn that = (ArtDeleteDtoIn) o;
    return id == that.id;
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

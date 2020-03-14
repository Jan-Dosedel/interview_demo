package cz.interview.demo.service.dto;

import java.util.Objects;

public class ArtCreateDtoIn {

  private String title;

  public String getTitle() {
    return title;
  }

  public void setTitle(String title) {
    this.title = title;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    ArtCreateDtoIn that = (ArtCreateDtoIn) o;
    return Objects.equals(title, that.title);
  }

  @Override
  public int hashCode() {
    return Objects.hash(title);
  }

  @Override
  public String toString() {
    return "ArtCreateDtoIn{" +
        "title='" + title + '\'' +
        '}';
  }
}

package cz.interview.demo.service.dto.artist;

import java.util.Objects;
import javax.validation.constraints.NotEmpty;

/**
 * DTO representing artist entity {@Artist}.
 */
public class ArtistDto {

  @NotEmpty
  private String firstName;
  @NotEmpty
  private String surname;

  public String getFirstName() {
    return firstName;
  }

  public void setFirstName(String firstName) {
    this.firstName = firstName;
  }

  public String getSurname() {
    return surname;
  }

  public void setSurname(String surname) {
    this.surname = surname;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    ArtistDto artistDto = (ArtistDto) o;
    return Objects.equals(firstName, artistDto.firstName) &&
        Objects.equals(surname, artistDto.surname);
  }

  @Override
  public int hashCode() {
    return Objects.hash(firstName, surname);
  }

  @Override
  public String toString() {
    return "ArtistDto{" +
        "firstName='" + firstName + '\'' +
        ", surname='" + surname + '\'' +
        '}';
  }
}

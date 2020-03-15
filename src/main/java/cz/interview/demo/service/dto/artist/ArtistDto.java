package cz.interview.demo.service.dto.artist;

import javax.validation.constraints.NotEmpty;

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
}

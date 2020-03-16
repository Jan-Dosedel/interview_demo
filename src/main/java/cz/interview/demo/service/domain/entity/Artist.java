package cz.interview.demo.service.domain.entity;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import cz.interview.demo.service.domain.entity.basic.AbstractEntity;
import java.util.Objects;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

/**
 * Managed POJO bean that represents artist.
 */
@Entity
@Table(name = "artists")
@JsonIgnoreProperties(value = { "id" })
public class Artist extends AbstractEntity {

  @Column(name="first_name")
  private String firstName;
  @Column(name="surname")
  private String surname;

  public String getSurname() {
    return surname;
  }

  public void setSurname(String surname) {
    this.surname = surname;
  }

  public String getFirstName() {
    return firstName;
  }

  public void setFirstName(String firstName) {
    this.firstName = firstName;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    Artist artist = (Artist) o;
    return Objects.equals(firstName, artist.firstName) &&
        Objects.equals(surname, artist.surname);
  }

  @Override
  public int hashCode() {
    return Objects.hash(firstName, surname);
  }

  @Override
  public String toString() {
    return "Artist{" +
        "firstName='" + firstName + '\'' +
        ", surname='" + surname + '\'' +
        '}';
  }
}

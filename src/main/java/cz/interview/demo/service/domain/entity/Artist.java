package cz.interview.demo.service.domain.entity;

import cz.interview.demo.service.domain.entity.basic.AbstractEntity;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "artists")
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
}

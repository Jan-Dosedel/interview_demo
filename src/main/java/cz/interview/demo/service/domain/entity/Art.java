package cz.interview.demo.service.domain.entity;

import cz.interview.demo.service.domain.entity.basic.AbstractEntity;
import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;


@Entity
@Table(name = "arts")
public class Art extends AbstractEntity {

  @NotBlank
  private String title;

  private int year;

  @OneToOne(cascade = CascadeType.ALL)
  @JoinColumn(name = "artist_id", referencedColumnName = "id")
  private Artist artist;

  public String getTitle() {
    return title;
  }

  public void setTitle(String title) {
    this.title = title;
  }

  public Artist getArtist() {
    return artist;
  }

  public void setArtist(Artist artist) {
    this.artist = artist;
  }

  public int getYear() {
    return year;
  }

  public void setYear(int year) {
    this.year = year;
  }
}
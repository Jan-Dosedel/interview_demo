package cz.interview.demo.service.domain.entity;

import cz.interview.demo.service.domain.entity.basic.AbstractEntity;
import java.util.Objects;
import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;

/**
 * Managed POJO bean that represents art.
 */
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

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    Art art = (Art) o;
    return year == art.year &&
        Objects.equals(title, art.title) &&
        Objects.equals(artist, art.artist);
  }

  @Override
  public int hashCode() {
    return Objects.hash(title, year, artist);
  }

  @Override
  public String toString() {
    return "Art{" +
        "title='" + title + '\'' +
        ", year=" + year +
        ", artist=" + artist +
        '}';
  }
}
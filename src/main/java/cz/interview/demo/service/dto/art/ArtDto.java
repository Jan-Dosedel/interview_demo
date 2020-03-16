package cz.interview.demo.service.dto.art;

import cz.interview.demo.service.dto.artist.ArtistDto;
import java.util.Objects;
import javax.validation.constraints.NotEmpty;

/**
 * DTO representing art entity {@Art}.
 */
public class ArtDto {

  @NotEmpty
  private String title;
  private int year;
  private ArtistDto artist;

  public String getTitle() {
    return title;
  }

  public void setTitle(String title) {
    this.title = title;
  }

  public int getYear() {
    return year;
  }

  public void setYear(int year) {
    this.year = year;
  }

  public ArtistDto getArtist() {
    return artist;
  }

  public void setArtist(ArtistDto artist) {
    this.artist = artist;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    ArtDto artDto = (ArtDto) o;
    return year == artDto.year &&
        title.equals(artDto.title) &&
        artist.equals(artDto.artist);
  }

  @Override
  public int hashCode() {
    return Objects.hash(title, year, artist);
  }

  @Override
  public String toString() {
    return "ArtDto{" +
        "title='" + title + '\'' +
        ", year=" + year +
        ", artist=" + artist +
        '}';
  }
}

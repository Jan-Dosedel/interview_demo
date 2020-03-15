package cz.interview.demo.service.dto.art;

import cz.interview.demo.service.dto.artist.ArtistDto;
import javax.validation.constraints.NotEmpty;

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
}

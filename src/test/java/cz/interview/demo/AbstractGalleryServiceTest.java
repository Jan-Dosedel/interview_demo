package cz.interview.demo;

import cz.interview.demo.config.TestConfiguration;
import cz.interview.demo.dao.repository.ArtRepository;
import cz.interview.demo.dao.repository.ArtistRepository;
import cz.interview.demo.service.GalleryService;
import cz.interview.demo.service.dto.art.ArtCreateDtoIn;
import cz.interview.demo.service.dto.artist.ArtistDto;
import javax.inject.Inject;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(
    classes = { TestConfiguration.class }
    )
abstract class AbstractGalleryServiceTest {

  protected static final String ART_TITLE = "Test art";
  protected static final int ART_YEAR = 3000;
  protected static final String ARTIST_FIRST_NAME = "Samuel";
  protected static final String ARTIST_SURNAME = "Leumas";

  @Inject
  protected ArtRepository artRepository;

  @Inject
  protected ArtistRepository artistRepository;

  @Inject
  protected GalleryService galleryService;

  protected ArtCreateDtoIn prepareCreateArtDtoIn(){
    ArtCreateDtoIn dtoIn =  new ArtCreateDtoIn();
    dtoIn.setTitle(ART_TITLE);
    dtoIn.setYear(ART_YEAR);
    ArtistDto artistDto = new ArtistDto();
    artistDto.setFirstName(ARTIST_FIRST_NAME);
    artistDto.setSurname(ARTIST_SURNAME);
    dtoIn.setArtist(artistDto);
    return dtoIn;
  }
}

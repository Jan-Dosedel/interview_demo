package cz.interview.demo;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;

import cz.interview.demo.dao.repository.ArtRepository;
import cz.interview.demo.dao.repository.ArtistRepository;
import cz.interview.demo.service.GalleryService;
import cz.interview.demo.service.domain.entity.Art;
import cz.interview.demo.service.dto.art.ArtCreateDtoIn;
import java.util.List;
import javax.inject.Inject;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;
import org.springframework.test.context.jdbc.Sql;

// @Sql({"/scripts/test-data.sql"})
public class GalleryServiceTests extends AbstractGalleryServiceTest {

  @Rule
  public ExpectedException expectedException = ExpectedException.none();

  @Test
  public void createArtTest() {

    ArtCreateDtoIn dtoIn = prepareCreateArtDtoIn();
    Art art = galleryService.create(dtoIn);
    art =  artRepository.getById(art.getId());
    assertEquals(ART_TITLE ,art.getTitle());
    assertEquals(ART_YEAR ,art.getYear());
    assertEquals(ARTIST_FIRST_NAME , art.getArtist().getFirstName());
    assertEquals(ARTIST_SURNAME , art.getArtist().getSurname());
    assertNotNull(art.getArtist().getSys().getCts());
    assertNull(art.getArtist().getSys().getMts());
  }

}

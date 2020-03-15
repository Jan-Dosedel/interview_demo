package cz.interview.demo;

import static cz.interview.demo.exception.GalleryServiceRuntimeException.Error.ART_DOES_NOT_EXIST;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;

import cz.interview.demo.exception.GalleryServiceRuntimeException;
import cz.interview.demo.service.domain.entity.Art;
import cz.interview.demo.service.dto.art.ArtCreateDtoIn;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.annotation.DirtiesContext.ClassMode;

@DirtiesContext(classMode = ClassMode.BEFORE_EACH_TEST_METHOD)
public class GalleryServiceTests extends AbstractGalleryServiceTest {

  @Rule
  public ExpectedException expectedException = ExpectedException.none();

  @Test
  public void createArtHDSTest() {

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

  @Test
  public void deleteArtHDSTest() {
    Long id = 1L;
    Art art =  artRepository.getById(id);
    assertEquals("Mona Lisa" ,art.getTitle());
    galleryService.delete(prepareDeleteArtDtoIn(id));
    art = artRepository.getById(id);
    assertNull(art);
  }

  @Test
  public void deleteArtNotExistTest() {
    Long id = 50L;
    expectedException.expect(GalleryServiceRuntimeException.class);
    expectedException.expectMessage(String.format(ART_DOES_NOT_EXIST.getMessage(), id));
    galleryService.delete(prepareDeleteArtDtoIn(id));
  }

  @Test
  public void getArtHDSTest() {
    Long id = 1L;
    artRepository.getById(id);
    Art art = galleryService.get(prepareGetArtDtoIn(id));
    assertEquals("Mona Lisa" ,art.getTitle());
    assertEquals(1503 ,art.getYear());
    assertEquals("Leonardo" , art.getArtist().getFirstName());
    assertEquals("da Vinci" , art.getArtist().getSurname());
    assertNotNull(art.getArtist().getSys().getCts());
    assertNull(art.getArtist().getSys().getMts());
  }

  @Test
  public void getArtNotExistTest() {
    Long id = 50L;
    expectedException.expect(GalleryServiceRuntimeException.class);
    expectedException.expectMessage(String.format(ART_DOES_NOT_EXIST.getMessage(), id));
    galleryService.get(prepareGetArtDtoIn(id));
  }

}

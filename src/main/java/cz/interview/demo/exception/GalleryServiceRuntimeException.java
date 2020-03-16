package cz.interview.demo.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

/**
 * Basic runtime exception used in gallery service.
 */
@ResponseStatus(value = HttpStatus.BAD_REQUEST)
public class GalleryServiceRuntimeException extends RuntimeException {

  public enum Error {
    ART_DOES_NOT_EXIST("Art (id %s) does not exist.");

    private String message;

    Error(String message) {
      this.message = message;
    }
    public String getMessage() {
      return message;
    }
  }

  public GalleryServiceRuntimeException(Error error, Long id) {
    super(String.format(error.getMessage(), id));
  }

}

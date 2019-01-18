package es.upm.miw.api;

import es.upm.miw.api.apiControllers.PublicationApiController;
import es.upm.miw.api.dtos.PublicationDto;
import es.upm.miw.api.entities.Genre;
import es.upm.miw.http.Client;
import es.upm.miw.http.HttpException;
import es.upm.miw.http.HttpRequest;
import es.upm.miw.http.HttpStatus;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class PublicationIT {

    private HttpRequest.Builder requestURL = HttpRequest.builder(PublicationApiController.PUBLICATION);
    private PublicationDto publicationDto = new PublicationDto(true, Genre.DESIGN, "Design as art");
    private PublicationDto publicationDto2 = new PublicationDto(false, "El principito");

    @Test
    void testCreateReader(){
        new Client().submit(requestURL.body(publicationDto).post()).getBody();
        new Client().submit(requestURL.body(publicationDto2).post()).getBody();
    }

    @Test
    void testCreateNullBody(){
        HttpException exception = assertThrows(HttpException.class, () -> new Client().submit(requestURL.body(null).post()));
        assertEquals(HttpStatus.BAD_REQUEST, exception.getHttpStatus());
    }
}

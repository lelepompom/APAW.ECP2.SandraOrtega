package es.upm.miw.api;

import es.upm.miw.api.dtos.PublicationDto;
import es.upm.miw.api.dtos.ReaderDto;
import es.upm.miw.api.entities.Genre;
import es.upm.miw.http.Client;
import es.upm.miw.http.HttpException;
import es.upm.miw.http.HttpRequest;
import es.upm.miw.http.HttpStatus;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class PublicationIT {

    private HttpRequest.Builder requestURL = HttpRequest.builder(Routes.PUBLICATION);

    private PublicationDto publicationDto = new PublicationDto(true, Genre.DESIGN, "Design as art");
    private PublicationDto publicationDto2 = new PublicationDto(false, "Yerma");
    private PublicationDto publicationDto3 = new PublicationDto(false, Genre.MATHS, "El principito");
    private PublicationDto publicationDto4 = new PublicationDto(true, Genre.ART, "¿Cómo nacen los objetos?");
    private PublicationDto publicationDto5 = new PublicationDto(true, Genre.ART, "Picasso");

    @Test
    void testCreatePublication(){
        new Client().submit(requestURL
                .body(publicationDto)
                .post()
        );
    }

    @Test
    void testCreateNullBody(){
        HttpException exception = assertThrows(HttpException.class, () ->
                new Client().submit(requestURL
                        .body(null).post())
        );
        assertEquals(HttpStatus.BAD_REQUEST, exception.getHttpStatus());
    }

    @Test
    void createAuthor(){
        String id = (String) new Client().submit(requestURL
                .body(publicationDto2)
                .post())
                .getBody()
        ;
        new Client().submit(requestURL
                .path(Routes.ID_ID).expandPath(id)
                .path(Routes.AUTHOR)
                .body("Bruno Munari")
                .post()
        );
    }

    @Test
    void createAuthorPublicationNotFound(){
        HttpException exception = assertThrows(HttpException.class, () ->
                new Client().submit(requestURL
                        .path(Routes.ID_ID).expandPath("734")
                        .path(Routes.AUTHOR)
                        .body("Bruno Munari")
                        .post())
        );
        assertEquals(HttpStatus.NOT_FOUND, exception.getHttpStatus());
    }

    @Test
    void createAuthorBadRequest(){
        String id = (String) new Client().submit(requestURL.body(publicationDto3).post()).getBody();
        HttpException exception = assertThrows(HttpException.class, () ->
                new Client().submit(requestURL
                        .path(Routes.ID_ID).expandPath(id)
                        .path(Routes.AUTHOR)
                        .body(null)
                        .post())
        );
        assertEquals(HttpStatus.BAD_REQUEST, exception.getHttpStatus());
    }

    @Test
    void readTitle(){
        new Client().submit(requestURL
                .body(publicationDto4)
                .post()
        );

        new Client().submit(requestURL
                .path(Routes.TITLE).expandPath("¿Cómo nacen los objetos?")
                .get()
        ).getBody();
    }

    @Test
    void readTitleNotFound(){
        HttpException exception = assertThrows(HttpException.class, () ->
                new Client().submit(requestURL
                        .path(Routes.TITLE).expandPath("734")
                        .get()
            ).getBody()
        );
        assertEquals(HttpStatus.NOT_FOUND, exception.getHttpStatus());
    }

    @Test
    void testCreateSamePublication(){
        new Client().submit(requestURL
                .body(publicationDto5)
                .post()
        );
        HttpException exception = assertThrows(HttpException.class, () ->
                new Client().submit(requestURL
                        .body(publicationDto5)
                        .post()
                ).getBody()
        );
        assertEquals(HttpStatus.BAD_REQUEST, exception.getHttpStatus());

    }

    @Test
    void testUpdateReader(){
        String readerId = (String) new Client().submit(HttpRequest.builder(Routes.READER)
                .body(new ReaderDto("Pedro", 48))
                .post()
        ).getBody();

        String publicationId = (String) new Client().submit(requestURL
                .body(new PublicationDto(true, Genre.ART, "Quijote"))
                .post()
        ).getBody();

        new Client().submit(requestURL
                .path(Routes.ID_ID)
                .expandPath(publicationId)
                .body(readerId)
                .patch()
        ).getBody();

    }

}

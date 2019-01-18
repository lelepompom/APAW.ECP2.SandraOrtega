package es.upm.miw.api;

import es.upm.miw.api.apiControllers.ReaderApiController;
import es.upm.miw.api.dtos.ReaderDto;
import es.upm.miw.http.Client;
import es.upm.miw.http.HttpException;
import es.upm.miw.http.HttpRequest;
import es.upm.miw.http.HttpStatus;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class ReaderIT {

    private HttpRequest.Builder requestURL = HttpRequest.builder(ReaderApiController.READER);

    private ReaderDto readerDto = new ReaderDto("Pedro", 48);

    @Test
    void testCreateReader(){
        new Client().submit(requestURL.body(readerDto).post()).getBody();
    }

    @Test
    void testCreateInvalidReader(){
        HttpException exception = assertThrows(HttpException.class, () -> new Client().submit(requestURL.body(null).post()));
        assertEquals(HttpStatus.BAD_REQUEST, exception.getHttpStatus());
    }


}

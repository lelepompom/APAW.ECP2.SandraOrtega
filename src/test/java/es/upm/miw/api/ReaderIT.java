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

    @Test
    void testCreateReader(){
        HttpRequest request = requestURL.body(new ReaderDto("Pedro", 43)).post();
        new Client().submit(request).getBody();
    }

    @Test
    void testCreateInvalidReader(){
        HttpRequest request = requestURL.body(null).post();
        HttpException exception = assertThrows(HttpException.class, () -> new Client().submit(request));
        assertEquals(HttpStatus.BAD_REQUEST, exception.getHttpStatus());
    }


}

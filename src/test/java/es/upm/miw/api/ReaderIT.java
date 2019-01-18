package es.upm.miw.api;

import es.upm.miw.api.apiControllers.ReaderApiController;
import es.upm.miw.api.dtos.ReaderDto;
import es.upm.miw.api.dtos.ReaderIdNameDto;
import es.upm.miw.http.Client;
import es.upm.miw.http.HttpException;
import es.upm.miw.http.HttpRequest;
import es.upm.miw.http.HttpStatus;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class ReaderIT {

    private HttpRequest.Builder requestURL = HttpRequest.builder(ReaderApiController.READER);

    private ReaderDto readerDto = new ReaderDto("Pedro", 48);
    private ReaderDto readerDto2 = new ReaderDto("Paula", 48);

    @Test
    void testCreateReader(){
        new Client().submit(requestURL.body(readerDto).post()).getBody();
        new Client().submit(requestURL.body(readerDto2).post()).getBody();
    }

    @Test
    void testCreateInvalidReader(){
        HttpException exception = assertThrows(HttpException.class, () -> new Client().submit(requestURL.body(null).post()));
        assertEquals(HttpStatus.BAD_REQUEST, exception.getHttpStatus());
    }

    @Test
    void testGetAllReaders(){
        new Client().submit(requestURL.body(readerDto).post()).getBody();
        new Client().submit(requestURL.body(readerDto2).post()).getBody();
        assertEquals(2, ((List<ReaderIdNameDto>) new Client().submit(requestURL.get()).getBody()).size());
    }

    @Test
    void testDeleteReader(){
        new Client().submit(requestURL.body(readerDto).post()).getBody();
        new Client().submit(requestURL.body(readerDto2).post()).getBody();
        requestURL.path(ReaderApiController.ID_ID).expandPath("2").delete();
        assertEquals(1, ((List<ReaderIdNameDto>) new Client().submit(requestURL.get()).getBody()).size());
    }


}

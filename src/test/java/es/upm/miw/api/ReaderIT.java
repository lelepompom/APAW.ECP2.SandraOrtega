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
import static org.junit.jupiter.api.Assertions.assertTrue;

public class ReaderIT {

    private HttpRequest.Builder requestURL = HttpRequest.builder(ReaderApiController.READER);

    private ReaderDto readerDto = new ReaderDto("Pedro", 48);
    private ReaderDto readerDto2 = new ReaderDto("Paula");

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
        int readerStartList = ((List<ReaderIdNameDto>) new Client().submit(requestURL.get()).getBody()).size();

        new Client().submit(requestURL.body(readerDto).post()).getBody();
        new Client().submit(requestURL.body(readerDto2).post()).getBody();

        int readerEndList = ((List<ReaderIdNameDto>) new Client().submit(requestURL.get()).getBody()).size();
        assertTrue(readerStartList < readerEndList);
    }

    @Test
    void testDeleteReader(){
        int readerStartList = ((List<ReaderIdNameDto>) new Client().submit(requestURL.get()).getBody()).size();

        new Client().submit(requestURL.body(readerDto).post()).getBody();

        new Client().submit(requestURL.path(ReaderApiController.ID_ID).expandPath("1").delete());

        int readerEndList = ((List<ReaderIdNameDto>) new Client().submit(requestURL.get()).getBody()).size();
        assertEquals(readerStartList, readerEndList);
    }

}

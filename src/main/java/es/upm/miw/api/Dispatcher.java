package es.upm.miw.api;

import es.upm.miw.api.apiControllers.PublicationApiController;
import es.upm.miw.api.apiControllers.ReaderApiController;
import es.upm.miw.api.daos.DaoFactory;
import es.upm.miw.api.daos.memory.DaoMemoryFactory;
import es.upm.miw.api.dtos.PublicationDto;
import es.upm.miw.api.dtos.ReaderDto;
import es.upm.miw.api.entities.Reader;
import es.upm.miw.api.exceptions.ArgumentNotValidException;
import es.upm.miw.api.exceptions.NotFoundException;
import es.upm.miw.api.exceptions.RequestInvalidException;
import es.upm.miw.http.HttpRequest;
import es.upm.miw.http.HttpResponse;
import es.upm.miw.http.HttpStatus;

public class Dispatcher {

    static {
        DaoFactory.setFactory(new DaoMemoryFactory());
    }

    private ReaderApiController readerApiController = new ReaderApiController();
    private PublicationApiController publicationApiController = new PublicationApiController();

    public void submit(HttpRequest request, HttpResponse response) {
        String ERROR_MESSAGE = "{'error':'%S'}";
        try {
            switch (request.getMethod()) {
                case POST:
                    this.doPost(request, response);
                    break;
                case GET:
                    this.doGet(request, response);
                    break;
                case PUT:
                    this.doPut(request);
                    break;
                case PATCH:
                    this.doPatch(request);
                    break;
                case DELETE:
                    this.doDelete(request);
                    break;
                default: // Unexpected
                    throw new RequestInvalidException("method error: " + request.getMethod());
            }
        } catch (ArgumentNotValidException | RequestInvalidException exception) {
            response.setBody(String.format(ERROR_MESSAGE, exception.getMessage()));
            response.setStatus(HttpStatus.BAD_REQUEST);
        } catch (NotFoundException exception) {
            response.setBody(String.format(ERROR_MESSAGE, exception.getMessage()));
            response.setStatus(HttpStatus.NOT_FOUND);
        } catch (Exception exception) {  // Unexpected
            exception.printStackTrace();
            response.setBody(String.format(ERROR_MESSAGE, exception));
            response.setStatus(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    private void doPost(HttpRequest request, HttpResponse response) {
        if (request.isEqualsPath(Routes.READER)) {
            response.setBody(this.readerApiController.create((ReaderDto) request.getBody()));
        } else if(request.isEqualsPath(Routes.PUBLICATION)){
            response.setBody(this.publicationApiController.create((PublicationDto) request.getBody()));
        } else if (request.isEqualsPath(Routes.PUBLICATION + Routes.ID_ID + Routes.AUTHOR)) {
            this.publicationApiController.createAuthor(request.getPath(1), (String) request.getBody());
        } else {
            throw new RequestInvalidException("request error: " + request.getMethod() + ' ' + request.getPath());
        }
    }

    private void doGet(HttpRequest request, HttpResponse response) {
        if (request.isEqualsPath(Routes.READER)) {
            response.setBody(this.readerApiController.readAll());
        } else if (request.isEqualsPath(Routes.READER + Routes.ID_ID)) {
            response.setBody(this.readerApiController.readAll());
        } else if (request.isEqualsPath(Routes.PUBLICATION + Routes.TITLE)) {
            response.setBody(this.publicationApiController.readPublication(request.getPath(1)));
        } else {
            throw new RequestInvalidException("request error: " + request.getMethod() + ' ' + request.getPath());
        }
    }

    private void doPut(HttpRequest request) {
        if (request.isEqualsPath(Routes.READER + Routes.ID_ID)) {
            this.readerApiController.update(request.getPath(1), (ReaderDto) request.getBody());
        } else {
            throw new RequestInvalidException("request error: " + request.getMethod() + ' ' + request.getPath());
        }
    }

    private void doPatch(HttpRequest request) {
        if (request.isEqualsPath(Routes.PUBLICATION + Routes.ID_ID)) {
            this.publicationApiController.updateReader(request.getPath(1), (String) request.getBody());
        } else {
            throw new RequestInvalidException("request error: " + request.getMethod() + ' ' + request.getPath());
        }
    }

    private void doDelete(HttpRequest request) {
        if (request.isEqualsPath(Routes.READER + Routes.ID_ID)) {
            this.readerApiController.delete(request.getPath(1));
        } else {
            throw new RequestInvalidException("request error: " + request.getMethod() + ' ' + request.getPath());
        }
    }

}

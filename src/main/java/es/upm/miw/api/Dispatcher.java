package es.upm.miw.api;

import es.upm.miw.api.daos.DaoFactory;
import es.upm.miw.api.daos.memory.DaoMemoryFactory;
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

    }

    private void doGet(HttpRequest request, HttpResponse response) {

    }

    private void doPut(HttpRequest request) {

    }

    private void doPatch(HttpRequest request) {

    }

    private void doDelete(HttpRequest request) {

    }

}

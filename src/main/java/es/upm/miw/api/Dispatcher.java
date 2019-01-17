package es.upm.miw.api;

import es.upm.miw.http.HttpRequest;
import es.upm.miw.http.HttpResponse;
import es.upm.miw.http.HttpStatus;
import es.upm.miw.http.Server;

public class Dispatcher implements Server {

    private static final String PATH_ERROR = "Path Error";

    private static final String METHOD_ERROR = "Method Error";

    private static final String INTEGER_ERROR = "Integer Error";

    public Dispatcher() {
    }

    private void responseError(HttpResponse response, String msg) {
        response.setBody("{\"error\":\"" + msg + "\"}");
        response.setStatus(HttpStatus.BAD_REQUEST);
    }

    private void doGet(HttpRequest request, HttpResponse response) {
        String result;
        switch (request.getPath()) {
            case "/path1":
                // Injectar parámetros...
                try {

                } catch (Exception e) {
                    responseError(response, INTEGER_ERROR);
                }
                break;
            case "/path2":

                break;
            default:
                responseError(response, PATH_ERROR);
                break;
        }
    }

    private void doPost(HttpRequest request, HttpResponse response) {
        String result;
        switch (request.getPath()) {
            case "/path1":

                break;
            case "/path1/sub":

                break;
            default:
                responseError(response, PATH_ERROR);
                break;
        }
    }

    private void doPut(HttpRequest request, HttpResponse response) {
        responseError(response, METHOD_ERROR);
    }

    private void doPatch(HttpRequest request, HttpResponse response) {
        responseError(response, METHOD_ERROR);
    }

    private void doDelete(HttpRequest request, HttpResponse response) {
        responseError(response, METHOD_ERROR);
    }

    @Override
    public HttpResponse submit(HttpRequest request) {
        HttpResponse response = new HttpResponse();
        switch (request.getMethod()) {
            case POST:
                doPost(request, response);
                break;
            case GET:
                doGet(request, response);
                break;
            case PUT:
                doPut(request, response);
                break;
            case PATCH:
                doPatch(request, response);
                break;
            case DELETE:
                doDelete(request, response);
                break;
            default:
        }
        return response;
    }

}

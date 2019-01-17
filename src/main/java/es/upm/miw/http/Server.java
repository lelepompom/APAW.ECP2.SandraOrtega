package es.upm.miw.http;

import es.upm.miw.api.Dispatcher;

public class Server {
    private Dispatcher dispatcher = new Dispatcher();

    public HttpResponse submit(HttpRequest request) {
        HttpResponse response = new HttpResponse();
        dispatcher.submit(request, response);
        return response;
    }

}

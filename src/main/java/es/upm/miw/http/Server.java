package es.upm.miw.http;

public interface Server {
    HttpResponse submit(HttpRequest request);
}

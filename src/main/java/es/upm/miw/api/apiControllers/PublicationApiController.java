package es.upm.miw.api.apiControllers;

import es.upm.miw.api.dtos.PublicationDto;
import es.upm.miw.api.exceptions.ArgumentNotValidException;

public class PublicationApiController {
    public static final String PUBLICATION = "/publication";

    private PublicationApiController publicationApiController = new PublicationApiController();

    private void validate(PublicationDto publicationDto){
        if (publicationDto == null){
            throw new ArgumentNotValidException("Name is required");
        }
    }


}

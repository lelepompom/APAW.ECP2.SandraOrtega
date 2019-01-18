package es.upm.miw.api.apiControllers;

import es.upm.miw.api.businessController.PublicationBusinessController;
import es.upm.miw.api.dtos.PublicationDto;
import es.upm.miw.api.exceptions.ArgumentNotValidException;

public class PublicationApiController {
    public static final String PUBLICATION = "/publication";

    private PublicationBusinessController publicationBusinessController = new PublicationBusinessController();

    private void validate(PublicationDto publicationDto){
        if (publicationDto == null){
            throw new ArgumentNotValidException("Name is required");
        }
    }

    public String create(PublicationDto readerDto){
        this.validate(readerDto);
        return this.publicationBusinessController.create(readerDto);
    }


}

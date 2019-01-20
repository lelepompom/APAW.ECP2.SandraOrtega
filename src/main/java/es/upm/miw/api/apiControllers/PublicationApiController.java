package es.upm.miw.api.apiControllers;

import es.upm.miw.api.businessController.PublicationBusinessController;
import es.upm.miw.api.dtos.PublicationDto;
import es.upm.miw.api.exceptions.ArgumentNotValidException;

public class PublicationApiController {
    public static final String PUBLICATION = "/publication";
    public static final String ID_ID = "/{id}";
    public static final String AUTHOR = "/author";

    private PublicationBusinessController publicationBusinessController = new PublicationBusinessController();

    private void validate(Object obj){
        if (obj == null){
            throw new ArgumentNotValidException("Title and Signed are required");
        }
    }

    public String create(PublicationDto readerDto){
        this.validate(readerDto);
        return this.publicationBusinessController.create(readerDto);
    }

    public void createAuthor(String publicationId, String author){
        this.validate(author);
        this.publicationBusinessController.createAuthor(publicationId, author);
    }


}

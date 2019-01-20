package es.upm.miw.api.apiControllers;

import es.upm.miw.api.businessController.PublicationBusinessController;
import es.upm.miw.api.dtos.PublicationDto;
import es.upm.miw.api.entities.Publication;
import es.upm.miw.api.exceptions.ArgumentNotValidException;

public class PublicationApiController {

    private PublicationBusinessController publicationBusinessController = new PublicationBusinessController();

    private void validate(Object obj){
        if (obj == null){
            throw new ArgumentNotValidException("Title and Signed are required");
        }
    }

    private void validateNewTitle(String title){
        if (this.publicationBusinessController.getTitlesMap().containsKey(title)){
            throw new ArgumentNotValidException("Title already exists");
        }
    }

    public String create(PublicationDto publicationDto){
        this.validate(publicationDto);
        this.validateNewTitle(publicationDto.getTitle());
        return this.publicationBusinessController.create(publicationDto);
    }

    public void createAuthor(String publicationId, String author){
        this.validate(author);
        this.publicationBusinessController.createAuthor(publicationId, author);
    }

    public Publication readPublication(String title){
        this.validate(title);
        return this.publicationBusinessController.readPublication(title);
    }
}

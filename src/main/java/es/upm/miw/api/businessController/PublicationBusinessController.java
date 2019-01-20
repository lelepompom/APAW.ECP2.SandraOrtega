package es.upm.miw.api.businessController;

import es.upm.miw.api.daos.DaoFactory;
import es.upm.miw.api.dtos.PublicationDto;
import es.upm.miw.api.entities.Publication;
import es.upm.miw.api.exceptions.NotFoundException;

public class PublicationBusinessController {
    public String create(PublicationDto publicationDto){
        Publication publication = new Publication(publicationDto.getSigned(), publicationDto.getGenre(), publicationDto.getTitle());
        DaoFactory.getFactory().getPublicationDao().save(publication);
        return publication.getId();
    }

    public void createAuthor(String publicationId, String author){
        Publication publication = DaoFactory.getFactory().getPublicationDao().read(publicationId)
                .orElseThrow(()-> new NotFoundException("Publication (" + publicationId + ")"));
        publication.getBook().setAuthor(author);
        DaoFactory.getFactory().getPublicationDao().save(publication);
    }
}

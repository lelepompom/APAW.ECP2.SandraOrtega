package es.upm.miw.api.businessController;

import es.upm.miw.api.daos.DaoFactory;
import es.upm.miw.api.dtos.PublicationDto;
import es.upm.miw.api.entities.Publication;

public class PublicationBusinessController {
    public String create(PublicationDto publicationDto){
        Publication publication = new Publication(publicationDto.getSigned(), publicationDto.getGenre(), publicationDto.getTitle());
        DaoFactory.getFactory().getPublicationDao().save(publication);
        return publication.getId();
    }
}

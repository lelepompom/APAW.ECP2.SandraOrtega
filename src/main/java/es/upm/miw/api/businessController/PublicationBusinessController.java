package es.upm.miw.api.businessController;

import es.upm.miw.api.daos.DaoFactory;
import es.upm.miw.api.dtos.PublicationDto;
import es.upm.miw.api.dtos.PublicationIdTitleDto;
import es.upm.miw.api.entities.Publication;
import es.upm.miw.api.exceptions.NotFoundException;

import java.util.Map;
import java.util.stream.Collectors;

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

    public Publication readPublication(String title){
        String publicationId = this.getTitlesMap().get(title);

        return DaoFactory.getFactory().getPublicationDao().read(publicationId)
                .orElseThrow(()-> new NotFoundException("Publication (" + publicationId + ")"));
    }

    public Map<String, String> getTitlesMap(){
        return DaoFactory.getFactory().getPublicationDao().findAll()
                .stream().map(PublicationIdTitleDto::new)
                .collect(Collectors.toMap(publication -> publication.getTitle(), publication -> publication.getId()));
    }
}

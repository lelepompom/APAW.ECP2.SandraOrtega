package es.upm.miw.api.daos.memory;

import es.upm.miw.api.daos.PublicationDao;
import es.upm.miw.api.entities.Publication;

public class PublicationDaoMemory extends GenericDaoMemory<Publication> implements PublicationDao {

    @Override
    public String getId(Publication publication) {
        return publication.getId();
    }

    @Override
    public void setId(Publication publication, String id) {
        publication.setId(id);
    }
}

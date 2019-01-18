package es.upm.miw.api.daos.memory;

import es.upm.miw.api.daos.ReaderDao;
import es.upm.miw.api.entities.Reader;

public class ReaderDaoMemory extends GenericDaoMemory<Reader> implements ReaderDao {

    @Override
    public String getId(Reader reader) {
        return reader.getId();
    }

    @Override
    public void setId(Reader reader, String id) {
        reader.setId(id);
    }
}

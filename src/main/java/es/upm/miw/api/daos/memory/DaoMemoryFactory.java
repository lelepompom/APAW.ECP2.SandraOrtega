package es.upm.miw.api.daos.memory;

import es.upm.miw.api.daos.DaoFactory;
import es.upm.miw.api.daos.PublicationDao;
import es.upm.miw.api.daos.ReaderDao;

public class DaoMemoryFactory extends DaoFactory {

    private ReaderDao readerDao;
    private PublicationDao publicationDao;

    @Override
    public ReaderDao getReaderDao() {
        if (this.readerDao == null) {
            this.readerDao = new ReaderDaoMemory();
        }
        return this.readerDao;
    }

    @Override
    public PublicationDao getPublicationDao() {
        if (this.publicationDao == null) {
            this.publicationDao = new PublicationDaoMemory();
        }
        return this.publicationDao;
    }
}

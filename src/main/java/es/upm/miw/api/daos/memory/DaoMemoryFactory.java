package es.upm.miw.api.daos.memory;

import es.upm.miw.api.daos.DaoFactory;
import es.upm.miw.api.daos.ReaderDao;

public class DaoMemoryFactory extends DaoFactory {

    private ReaderDao readerDao;

    @Override
    public ReaderDao getReaderDao() {
        if (this.readerDao == null) {
            this.readerDao = new ReaderDaoMemory();
        }
        return this.readerDao;
    }
}

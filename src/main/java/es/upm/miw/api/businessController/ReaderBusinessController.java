package es.upm.miw.api.businessController;

import es.upm.miw.api.daos.DaoFactory;
import es.upm.miw.api.dtos.ReaderDto;
import es.upm.miw.api.entities.Reader;

public class ReaderBusinessController {
    public String create(ReaderDto readerDto){
        Reader reader = new Reader(readerDto.getName(), readerDto.getAge());
        DaoFactory.getFactory().getReaderDao().save(reader);
        return reader.getId();
    }
}

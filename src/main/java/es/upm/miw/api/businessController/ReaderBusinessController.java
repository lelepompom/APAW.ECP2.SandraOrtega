package es.upm.miw.api.businessController;

import es.upm.miw.api.daos.DaoFactory;
import es.upm.miw.api.dtos.ReaderDto;
import es.upm.miw.api.dtos.ReaderIdNameDto;
import es.upm.miw.api.entities.Reader;

import java.util.List;
import java.util.stream.Collectors;

public class ReaderBusinessController {
    public String create(ReaderDto readerDto){
        Reader reader = new Reader(readerDto.getName(), readerDto.getAge());
        DaoFactory.getFactory().getReaderDao().save(reader);
        return reader.getId();
    }

    public List<ReaderIdNameDto> readAll(){
        return DaoFactory.getFactory().getReaderDao().findAll()
                .stream().map(ReaderIdNameDto::new)
                .collect(Collectors.toList());
    }

    public void delete(String id) {
        DaoFactory.getFactory().getReaderDao().deleteById(id);
    }
}

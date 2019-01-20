package es.upm.miw.api.apiControllers;

import es.upm.miw.api.businessController.ReaderBusinessController;
import es.upm.miw.api.dtos.ReaderDto;
import es.upm.miw.api.dtos.ReaderIdNameDto;
import es.upm.miw.api.exceptions.ArgumentNotValidException;

import java.util.List;

public class ReaderApiController {

    private ReaderBusinessController readerBusinessController = new ReaderBusinessController();

    private void validate(ReaderDto readerDto){
        if (readerDto == null){
            throw new ArgumentNotValidException("Name is required");
        }
    }

    public String create(ReaderDto readerDto){
        this.validate(readerDto);
        return this.readerBusinessController.create(readerDto);
    }

    public List<ReaderIdNameDto> readAll(){
        return this.readerBusinessController.readAll();
    }

    public void delete(String id){
        this.readerBusinessController.delete(id);
    }

    public void update(String id, ReaderDto readerDto){
        this.validate(readerDto);
        this.readerBusinessController.update(id, readerDto);
    }
}

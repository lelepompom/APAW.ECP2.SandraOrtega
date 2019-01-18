package es.upm.miw.api.apiControllers;

import es.upm.miw.api.businessController.ReaderBusinessController;
import es.upm.miw.api.dtos.ReaderDto;
import es.upm.miw.api.exceptions.ArgumentNotValidException;

public class ReaderApiController {
    public static final String READER = "/reader";
    public static final String ID_ID = "/{id}";

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

    public void delete(String id){
        this.readerBusinessController.delete(id);
    }
}

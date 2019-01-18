package es.upm.miw.api.apiControllers;

import es.upm.miw.api.dtos.ReaderDto;
import es.upm.miw.api.exceptions.ArgumentNotValidException;

public class ReaderApiController {
    public static final String READER = "/reader";

    private void validate(ReaderDto readerDto){
        if (readerDto.getName() == null){
            throw new ArgumentNotValidException("Name is required");
        }
    }
}

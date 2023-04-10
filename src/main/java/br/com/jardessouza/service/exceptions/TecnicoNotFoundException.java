package br.com.jardessouza.service.exceptions;

import javax.persistence.EntityNotFoundException;

public class TecnicoNotFoundException extends EntityNotFoundException {
    public TecnicoNotFoundException(Integer id) {
        super(String.format("Tecnico com id %d, não encontrado!", id));
    }
}

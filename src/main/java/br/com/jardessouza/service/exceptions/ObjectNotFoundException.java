package br.com.jardessouza.service.exceptions;

public class ObjectNotFoundException extends RuntimeException {
    public ObjectNotFoundException(Integer id) {
        super(String.format("Objeto com id %d não encontrado", id));
    }

    public ObjectNotFoundException(Throwable cause) {
        super(cause);
    }
}

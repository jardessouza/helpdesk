package br.com.jardessouza.service.exceptions;

import javax.persistence.EntityNotFoundException;

public class ClienteNotFound extends EntityNotFoundException {
    public ClienteNotFound(Integer id) {
        super(String.format("Cliente com %d não encontrado", id));
    }
}

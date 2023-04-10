package br.com.jardessouza.service;

import br.com.jardessouza.domain.Chamado;
import br.com.jardessouza.domain.Cliente;
import br.com.jardessouza.domain.Tecnico;
import br.com.jardessouza.domain.enums.Prioridade;
import br.com.jardessouza.domain.enums.Status;
import br.com.jardessouza.repository.ChamadoRepository;
import br.com.jardessouza.repository.ClienteRepository;
import br.com.jardessouza.repository.TecnicoRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class DBService {
    private final TecnicoRepository tecnicoRepository;
    private final  ClienteRepository clienteRepository;
    private final ChamadoRepository chamadoRepository;

    public void instanciaDB(){

        Tecnico tec1 = new Tecnico(
                "Validr Cezar",
                "04184426301",
                "validir@mail.com",
                "123");

        Cliente cli1 = new Cliente(
                "Linus Torvalds",
                "13687731090",
                "teste@mail.com",
                "123"
        );

        Chamado c1 = new Chamado(
                Prioridade.MEDIA,
                Status.ANDAMENTO,
                "Chamado 01",
                "Primeiro chamado",
                tec1,
                cli1
        );

        this.clienteRepository.save(cli1);
        this.tecnicoRepository.save(tec1);
        this.chamadoRepository.save(c1);
    }
}

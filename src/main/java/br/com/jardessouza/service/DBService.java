package br.com.jardessouza.service;

import br.com.jardessouza.domain.Chamado;
import br.com.jardessouza.domain.Cliente;
import br.com.jardessouza.domain.Tecnico;
import br.com.jardessouza.domain.enums.Perfil;
import br.com.jardessouza.domain.enums.Prioridade;
import br.com.jardessouza.domain.enums.Status;
import br.com.jardessouza.repository.ChamadoRepository;
import br.com.jardessouza.repository.ClienteRepository;
import br.com.jardessouza.repository.TecnicoRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class DBService {
    private final TecnicoRepository tecnicoRepository;
    private final  ClienteRepository clienteRepository;
    private final ChamadoRepository chamadoRepository;

    private final BCryptPasswordEncoder encoder;

    public void instanciaDB(){

        Tecnico tec1 = new Tecnico(
                "Thomas Withlock",
                "88662444067",
                "thomas@mail.com",
                encoder.encode("123"),
                Perfil.ADMIN);

        Tecnico tec2 = new Tecnico(
                "Hernandes Singer",
                "62612186336",
                "hernandes@mail.com",
                encoder.encode("123"),
                Perfil.ADMIN);

        Cliente cli1 = new Cliente(
                "Linus Torvalds",
                "13687731090",
                "teste@mail.com",
                encoder.encode("123")
        );

        Cliente cli2 = new Cliente(
                "Dorsey Daniels",
                "13583212304",
                "dorsey@mail.com",
                encoder.encode("123")
        );

        Chamado c1 = new Chamado(
                Prioridade.MEDIA,
                Status.ANDAMENTO,
                "Chamado 01",
                "Primeiro chamado",
                tec1,
                cli1
        );

        Chamado c2 = new Chamado(
                Prioridade.MEDIA,
                Status.ANDAMENTO,
                "Chamado 02",
                "Segundo chamado",
                tec2,
                cli2
        );

        this.clienteRepository.save(cli1);
        this.tecnicoRepository.save(tec1);
        this.chamadoRepository.save(c1);
    }
}

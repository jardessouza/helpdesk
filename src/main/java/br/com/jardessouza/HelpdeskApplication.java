package br.com.jardessouza;

import br.com.jardessouza.domain.Chamado;
import br.com.jardessouza.domain.Cliente;
import br.com.jardessouza.domain.Tecnico;
import br.com.jardessouza.domain.enums.Perfil;
import br.com.jardessouza.domain.enums.Prioridade;
import br.com.jardessouza.domain.enums.Status;
import br.com.jardessouza.repository.ChamadoRepository;
import br.com.jardessouza.repository.ClienteRepository;
import br.com.jardessouza.repository.TecnicoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class HelpdeskApplication {


    public static void main(String[] args) {
        SpringApplication.run(HelpdeskApplication.class, args);
    }
}

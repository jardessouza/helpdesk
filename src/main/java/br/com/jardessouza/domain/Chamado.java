package br.com.jardessouza.domain;

import br.com.jardessouza.domain.dtos.ChamadoRequest;
import br.com.jardessouza.domain.enums.Prioridade;
import br.com.jardessouza.domain.enums.Status;
import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.io.Serializable;
import java.time.LocalDate;
import java.util.Objects;

@Entity
@Getter
@Setter
public class Chamado implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @JsonFormat(pattern = "dd/MM/yyyy")
    private LocalDate dataAbertura = LocalDate.now();
    @JsonFormat(pattern = "dd/MM/yyyy")
    private LocalDate dataFechamento;
    private Prioridade prioridade;
    private Status status;
    private String titulo;
    private String observacoes;
    @ManyToOne
    @JoinColumn(name = "tecnico_id")
    private Tecnico tecnico;
    @ManyToOne
    @JoinColumn(name = "cliente_id")
    private Cliente cliente;

    public Chamado() {
        super();
    }

    public Chamado(Integer id, Prioridade prioridade, Status status, String titulo, String observacoes, Tecnico tecnico, Cliente cliente) {
        this.id = id;
        this.prioridade = prioridade;
        this.status = status;
        this.titulo = titulo;
        this.observacoes = observacoes;
        this.tecnico = tecnico;
        this.cliente = cliente;
    }

    public Chamado(Prioridade prioridade, Status status, String titulo, String observacoes, Tecnico tecnico, Cliente cliente) {
        this.prioridade = prioridade;
        this.status = status;
        this.titulo = titulo;
        this.observacoes = observacoes;
        this.tecnico = tecnico;
        this.cliente = cliente;
    }

    public static Chamado toModel(ChamadoRequest request){
        Tecnico tecnico = getTecnico(request);

        Cliente cliente = getCliente(request);

        return new Chamado(
                Prioridade.toEnum(request.getPrioridade()),
                Status.toEnum(request.getStatus()),
                request.getTitulo(),
                request.getObservacoes(),
                tecnico,
                cliente
        );
    }

    private static Cliente getCliente(ChamadoRequest request) {
        Cliente cliente = new Cliente();
        cliente.setId(request.getCliente());
        return cliente;
    }

    private static Tecnico getTecnico(ChamadoRequest request) {
        Tecnico tecnico = new Tecnico();
        tecnico.setId(request.getTecnico());
        return tecnico;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Chamado chamado = (Chamado) o;
        return Objects.equals(id, chamado.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }
}

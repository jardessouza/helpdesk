package br.com.jardessouza.domain.dtos;

import br.com.jardessouza.domain.Chamado;
import br.com.jardessouza.domain.enums.Prioridade;
import br.com.jardessouza.domain.enums.Status;
import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.time.LocalDate;
@Data
@AllArgsConstructor
@NoArgsConstructor
public class ChamadoResponse implements Serializable {
    private Integer id;
    @JsonFormat(pattern = "dd/MM/yyyy")
    private LocalDate dataAbertura = LocalDate.now();
    @JsonFormat(pattern = "dd/MM/yyyy")
    private LocalDate dataFechamento;
    private Prioridade prioridade;
    private Status status;
    private String titulo;
    private String observacoes;
    private String tecnico;
    private String cliente;


    public static ChamadoResponse toDTO(Chamado chamado){
        return new ChamadoResponse(
                chamado.getId(),
                chamado.getDataAbertura(),
                chamado.getDataFechamento(),
                chamado.getPrioridade(),
                chamado.getStatus(),
                chamado.getTitulo(),
                chamado.getObservacoes(),
                chamado.getTecnico().getNome(),
                chamado.getCliente().getNome()
        );
    }
}

package br.com.jardessouza.domain.dtos;

import br.com.jardessouza.domain.Tecnico;
import br.com.jardessouza.domain.enums.Perfil;
import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import java.io.Serializable;
import java.time.LocalDate;
import java.util.HashSet;
import java.util.Set;
@Data
@AllArgsConstructor
@NoArgsConstructor
public class TecnicoResponse implements Serializable {
    protected Integer id;
    protected String nome;
    protected String cpf;
    protected String email;
    protected String senha;
    @Enumerated(value = EnumType.STRING)
    protected Set<Perfil> perfis = new HashSet<>();
    @JsonFormat(pattern = "dd/MM/yyyy")
    protected LocalDate dataCriacao = LocalDate.now();

    public static TecnicoResponse toDTO(Tecnico tecnico){
        return new TecnicoResponse(
                tecnico.getId(),
                tecnico.getNome(),
                tecnico.getCpf(),
                tecnico.getEmail(),
                tecnico.getSenha(),
                tecnico.getPerfis(),
                tecnico.getDataCriacao()
        );
    }
}

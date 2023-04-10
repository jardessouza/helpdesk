package br.com.jardessouza.domain.dtos;

import br.com.jardessouza.domain.Cliente;
import br.com.jardessouza.domain.enums.Perfil;
import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import java.time.LocalDate;
import java.util.HashSet;
import java.util.Set;
@Data
@AllArgsConstructor
@NoArgsConstructor

public class ClienteResponse {
    protected Integer id;
    protected String nome;
    protected String cpf;
    protected String email;
    protected String senha;
    @Enumerated(value = EnumType.STRING)
    protected Set<Perfil> perfis = new HashSet<>();
    @JsonFormat(pattern = "dd/MM/yyyy")
    protected LocalDate dataCriacao = LocalDate.now();

    public static ClienteResponse toDTO(Cliente cliente){
        return new ClienteResponse(
                cliente.getId(),
                cliente.getNome(),
                cliente.getCpf(),
                cliente.getEmail(),
                cliente.getSenha(),
                cliente.getPerfis(),
                cliente.getDataCriacao()
        );
    }
}

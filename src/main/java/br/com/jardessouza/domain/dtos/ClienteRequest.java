package br.com.jardessouza.domain.dtos;

import br.com.jardessouza.domain.enums.Perfil;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotBlank;
import java.io.Serializable;

@Data
@AllArgsConstructor
@NoArgsConstructor

public class ClienteRequest implements Serializable {
    @NotBlank(message = "O campo NOME é requerido.")
    protected String nome;
    @NotBlank(message = "O campo CPF é requerido.")
    protected String cpf;
    @NotBlank(message = "O campo EMAIL é requerido.")
    protected String email;
    @NotBlank(message = "O campo SENHA é requerido.")
    protected String senha;
    protected Integer perfil;

}

package br.com.jardessouza.domain.dtos;

import br.com.jardessouza.domain.enums.Perfil;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class TecnicoRequest {
    @NotBlank(message = "O campo NOME é requerido")
    protected String nome;
    @NotBlank(message = "O campo CPF é requerido")
    protected String cpf;
    @NotBlank(message = "O campo EMAIL é requerido")
    protected String email;
    @NotBlank(message = "O campo SENHA é requerido")
    protected String senha;
    protected Perfil perfil;
}

package br.com.jardessouza.domain;

import br.com.jardessouza.domain.enums.Perfil;
import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.OneToMany;
import java.util.ArrayList;
import java.util.List;
@Entity
@Getter
@Setter
public class Cliente extends Pessoa {
    @JsonIgnore
    @OneToMany(mappedBy = "cliente")
    private List<Chamado> chamados = new ArrayList<>();

    public Cliente() {
        super();
        addPerfil(Perfil.CLIENTE);
    }

    public Cliente(String nome, String cpf, String email, String senha) {
        super(nome, cpf, email, senha);
        addPerfil(Perfil.CLIENTE);
    }
}

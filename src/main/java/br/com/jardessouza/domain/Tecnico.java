package br.com.jardessouza.domain;

import br.com.jardessouza.domain.dtos.TecnicoRequest;
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
public class Tecnico extends Pessoa {
    @JsonIgnore
    @OneToMany(mappedBy = "tecnico")
    private List<Chamado> chamados = new ArrayList<>();

    public Tecnico() {
        super();
        addPerfil(Perfil.CLIENTE);
    }

    public Tecnico(String nome, String cpf, String email, String senha) {
        super(nome, cpf, email, senha);
        addPerfil(Perfil.CLIENTE);
    }

    public Tecnico(String nome, String cpf, String email, String senha, Perfil perfil) {
        super(nome, cpf, email, senha);
        addPerfil(perfil);
    }

    public static Tecnico toModel(TecnicoRequest request){
        return new Tecnico(
                request.getNome(),
                request.getCpf(),
                request.getEmail(),
                request.getSenha(),
                Perfil.toEnum(request.getPerfil())
        );

    }
}

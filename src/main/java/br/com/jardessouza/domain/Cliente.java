package br.com.jardessouza.domain;

import br.com.jardessouza.domain.dtos.ClienteRequest;
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

    public Cliente(String nome, String cpf, String email, String senha, Perfil perfil) {
        super(nome, cpf, email, senha);
        addPerfil(perfil);
    }

    public static Cliente toModel(ClienteRequest clienteRequest){
        return new Cliente(
                clienteRequest.getNome(),
                clienteRequest.getCpf(),
                clienteRequest.getEmail(),
                clienteRequest.getSenha(),
                Perfil.toEnum(clienteRequest.getPerfil())
        );
    }


}

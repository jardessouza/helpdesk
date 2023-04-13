package br.com.jardessouza.service;

import br.com.jardessouza.domain.Tecnico;
import br.com.jardessouza.repository.PessoaRepository;
import br.com.jardessouza.repository.TecnicoRepository;
import br.com.jardessouza.service.exceptions.ObjectNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class TecnicoService {
    private final TecnicoRepository tecnicoRepository;
    private final PessoaRepository pessoaRepository;

    private final BCryptPasswordEncoder encoder;

    public Tecnico findById(Integer id) {
        return this.tecnicoRepository.findById(id)
                .orElseThrow(() -> new ObjectNotFoundException(id));
    }

    public List<Tecnico> listAll() {
        return this.tecnicoRepository.findAll();
    }

    public Tecnico create(Tecnico obj) {
        validaPorCpfEEmail(obj);
        obj.setSenha(encoder.encode(obj.getSenha()));
        return this.tecnicoRepository.save(obj);
    }

    public void update(Integer id, Tecnico obj) {
        var oldObj = findById(id);
        obj.setId(id);
        validaPorCpfEEmail(obj);

        if (!obj.getSenha().equals(oldObj.getSenha())){
            obj.setSenha(encoder.encode(obj.getSenha()));
        }
        this.tecnicoRepository.save(obj);
    }

    public void delete(Integer id) {
        var obj = findById(id);

        if (obj.getChamados().size() > 0) {
            throw new DataIntegrityViolationException("Técnico possui ordens de serviço e não pode ser deletado!");
        }
        this.tecnicoRepository.delete(obj);
    }

    private void validaPorCpfEEmail(Tecnico tecnico) {
        var obj = this.pessoaRepository.findByCpf(tecnico.getCpf());
        if (obj.isPresent() && obj.get().getId() != tecnico.getId()) {
            throw new DataIntegrityViolationException("CPF já cadastrado no sistema");
        }

        obj = this.pessoaRepository.findByEmail(tecnico.getEmail());
        if (obj.isPresent() && obj.get().getId() != tecnico.getId()) {
            throw new DataIntegrityViolationException("E-mail já cadastrado no sistema");
        }

    }
}

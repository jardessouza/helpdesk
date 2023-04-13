package br.com.jardessouza.service;

import br.com.jardessouza.domain.Cliente;
import br.com.jardessouza.repository.ClienteRepository;
import br.com.jardessouza.repository.PessoaRepository;
import br.com.jardessouza.service.exceptions.ObjectNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ClienteService {
    private final ClienteRepository clienteRepository;
    private final PessoaRepository pessoaRepository;

    private final BCryptPasswordEncoder encoder;

    public Cliente findById(Integer id){
        return this.clienteRepository.findById(id)
                .orElseThrow(() -> new ObjectNotFoundException(id));
    }

    public List<Cliente> findAll(){
        return this.clienteRepository.findAll();
    }

    public Cliente create(Cliente obj){
        validationCpfAndEmail(obj);
        obj.setSenha(encoder.encode(obj.getSenha()));
        return this.clienteRepository.save(obj);
    }

    public void update(Integer id, Cliente obj){
        var oldObj = findById(id);
        obj.setId(id);
        validationCpfAndEmail(obj);

        if (!obj.getSenha().equals(oldObj.getSenha())){
            obj.setSenha(encoder.encode(obj.getSenha()));
        }

        this.clienteRepository.save(obj);
    }

    public void delete(Integer id){
        var cliente = findById(id);
        this.clienteRepository.delete(cliente);
    }

    private void validationCpfAndEmail(Cliente cliente){
        var obj = this.pessoaRepository.findByCpf(cliente.getCpf());
        if (obj.isPresent() && cliente.getId() != obj.get().getId()){
            throw new DataIntegrityViolationException("CPF já cadastrado no sistema!");
        }

        obj = this.pessoaRepository.findByEmail(cliente.getEmail());
        if (obj.isPresent() && cliente.getId() != obj.get().getId()){
            throw new DataIntegrityViolationException("E-mail já cadastrado no sistema!");
        }
    }
}

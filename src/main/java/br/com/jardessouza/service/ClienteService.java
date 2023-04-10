package br.com.jardessouza.service;

import br.com.jardessouza.domain.Cliente;
import br.com.jardessouza.repository.ClienteRepository;
import br.com.jardessouza.repository.PessoaRepository;
import br.com.jardessouza.service.exceptions.ClienteNotFound;
import lombok.RequiredArgsConstructor;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ClienteService {
    private final ClienteRepository clienteRepository;
    private final PessoaRepository pessoaRepository;

    public Cliente findById(Integer id){
        return this.clienteRepository.findById(id)
                .orElseThrow(() -> new ClienteNotFound(id));
    }

    public List<Cliente> findAll(){
        return this.clienteRepository.findAll();
    }

    public Cliente create(Cliente cliente){
        validationCpfAndEmail(cliente);
        return this.clienteRepository.save(cliente);
    }

    public void update(Integer id, Cliente cliente){
        findById(id);
        cliente.setId(id);
        this.clienteRepository.save(cliente);
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

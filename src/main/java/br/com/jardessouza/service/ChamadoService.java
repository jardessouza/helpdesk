package br.com.jardessouza.service;

import br.com.jardessouza.domain.Chamado;
import br.com.jardessouza.domain.enums.Status;
import br.com.jardessouza.repository.ChamadoRepository;
import br.com.jardessouza.service.exceptions.ObjectNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;

@Service
@RequiredArgsConstructor
public class ChamadoService {
    private final ChamadoRepository chamadoRepository;
    private final TecnicoService tecnicoService;
    private final ClienteService clienteService;

    public Chamado findById(Integer id) {
        return this.chamadoRepository.findById(id)
                .orElseThrow(() -> new ObjectNotFoundException(id));
    }

    public List<Chamado> findAll() {
        return this.chamadoRepository.findAll();
    }

    public Chamado create(Chamado obj) {
        return this.chamadoRepository.save(newChamado(obj));
    }

    public void update(Integer id, Chamado obj) {
        findById(id);
        obj.setId(id);
        this.chamadoRepository.save(newChamado(obj));
    }

    public void delete(Integer id) {
        var obj = findById(id);
        this.chamadoRepository.delete(obj);
    }

    private Chamado newChamado(Chamado obj) {
        var tecnico = this.tecnicoService.findById(obj.getTecnico().getId());
        var cliente = this.clienteService.findById(obj.getCliente().getId());

        Chamado chamado = new Chamado();

        if (obj.getId() != null) {
            chamado.setId(obj.getId());
        }

        if (obj.getStatus().equals(Status.ENCERRADO)){
            chamado.setDataFechamento(LocalDate.now());
        }
        chamado.setTecnico(tecnico);
        chamado.setCliente(cliente);
        chamado.setPrioridade(obj.getPrioridade());
        chamado.setStatus(obj.getStatus());
        chamado.setTitulo(obj.getTitulo());
        chamado.setObservacoes(obj.getObservacoes());

        return chamado;

    }
}

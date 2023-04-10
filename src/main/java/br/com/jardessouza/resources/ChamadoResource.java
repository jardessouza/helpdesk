package br.com.jardessouza.resources;

import br.com.jardessouza.domain.Chamado;
import br.com.jardessouza.domain.dtos.ChamadoRequest;
import br.com.jardessouza.domain.dtos.ChamadoResponse;
import br.com.jardessouza.service.ChamadoService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import javax.validation.Valid;
import java.net.URI;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/chamados")
@RequiredArgsConstructor
public class ChamadoResource {
    private final ChamadoService chamadoService;

    @GetMapping(path = "/{id}")
    public ResponseEntity<ChamadoResponse> findById(@PathVariable Integer id){
        var obj = ChamadoResponse.toDTO(this.chamadoService.findById(id));
        return ResponseEntity.ok().body(obj);
    }

    @GetMapping
    public ResponseEntity<List<ChamadoResponse>> listAll(){
        var obj = this.chamadoService.findAll().stream()
                .map(ChamadoResponse::toDTO)
                .collect(Collectors.toList());

        return ResponseEntity.ok().body(obj);
    }

    @PostMapping
    public ResponseEntity<ChamadoResponse> create(@RequestBody @Valid ChamadoRequest request){
       var obj = this.chamadoService.create(Chamado.toModel(request));

       URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("{id}").buildAndExpand(obj.getId()).toUri();

       return ResponseEntity.created(uri).build();
    }

    @PutMapping(path = "/{id}")
    public ResponseEntity<Void> update(@PathVariable Integer id, @RequestBody @Valid ChamadoRequest request){
        this.chamadoService.update(id, Chamado.toModel(request));
        return ResponseEntity.noContent().build();
    }

    @DeleteMapping(path = "/{id}")
    public ResponseEntity<Void> delete(@PathVariable Integer id){
        this.chamadoService.delete(id);
        return ResponseEntity.noContent().build();
    }

}

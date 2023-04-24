package br.com.jardessouza.resources;

import br.com.jardessouza.domain.Cliente;
import br.com.jardessouza.domain.dtos.ClienteRequest;
import br.com.jardessouza.domain.dtos.ClienteResponse;
import br.com.jardessouza.resources.documentation.ClienteResourceDocs;
import br.com.jardessouza.service.ClienteService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import javax.validation.Valid;
import java.net.URI;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/clientes")
@RequiredArgsConstructor
public class ClienteResource implements ClienteResourceDocs {
    private final ClienteService clienteService;

    @GetMapping(path = "/{id}")
    public ResponseEntity<ClienteResponse> findById(@PathVariable Integer id) {
        var obj = ClienteResponse.toDTO(this.clienteService.findById(id));
        return ResponseEntity.ok().body(obj);
    }
    @GetMapping
    public ResponseEntity<List<ClienteResponse>> findAll() {
        var obj = this.clienteService.findAll().stream()
                .map(ClienteResponse::toDTO)
                .collect(Collectors.toList());

        return ResponseEntity.ok().body(obj);
    }
    @PostMapping
    public ResponseEntity<ClienteResponse> create(@RequestBody @Valid ClienteRequest request) {
       var obj = this.clienteService.create(Cliente.toModel(request));
        URI uri = ServletUriComponentsBuilder.fromCurrentRequest()
                .path("{id}").buildAndExpand(obj.getId()).toUri();

       return ResponseEntity.created(uri).build();
    }

    @PutMapping(path = "/{id}")
    public ResponseEntity<Void> update(@PathVariable Integer id, @RequestBody @Valid ClienteRequest request) {
        clienteService.update(id, Cliente.toModel(request));

        return ResponseEntity.noContent().build();
    }
    @DeleteMapping(path = "/{id}")
    public ResponseEntity<Void> delete(@PathVariable Integer id) {
        this.clienteService.delete(id);

        return ResponseEntity.noContent().build();
    }
}

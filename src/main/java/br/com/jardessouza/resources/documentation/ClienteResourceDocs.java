package br.com.jardessouza.resources.documentation;

import br.com.jardessouza.domain.dtos.ChamadoRequest;
import br.com.jardessouza.domain.dtos.ChamadoResponse;
import br.com.jardessouza.domain.dtos.ClienteRequest;
import br.com.jardessouza.domain.dtos.ClienteResponse;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import org.springframework.http.ResponseEntity;

import java.util.List;

public interface ClienteResourceDocs {
    @Operation(summary = "Operacao de buscar cliente por id")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Cliente encontrado com sucesso"),
            @ApiResponse(responseCode = "403", description = "Cliente nao encontrado")})
    ResponseEntity<ClienteResponse> findById(Integer id);

    @Operation(summary = "Operacao para listar todos os clientes")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Clientes listados com sucesso")})
    ResponseEntity<List<ClienteResponse>> findAll();

    @Operation(summary = "Operacao para criar cliente")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Cliente criado com sucesso"),
            @ApiResponse(responseCode = "400", description = "Campos obrigatorios ausentes")})
    ResponseEntity<ClienteResponse> create(ClienteRequest request);

    @Operation(summary = "Operacao para atualizar cliente")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Cliente atualizado com sucesso"),
            @ApiResponse(responseCode = "400", description = "Campos obrigatorios ausentes"),
            @ApiResponse(responseCode = "403", description = "Cliente nao encontrado")

    })
    ResponseEntity<Void> update(Integer id, ClienteRequest request);

    @Operation(summary = "Operacao para deletar cliente")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Cliente deletado com sucesso"),
            @ApiResponse(responseCode = "403", description = "Cliente nao encontrado")})
    ResponseEntity<Void> delete(Integer id);
}
